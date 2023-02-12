package finance.invoice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;
import finance.invoice.entity.TableConstructor;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MySqlDB implements Repository {

	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String User = "thanphyo";
	static final String Pass = "271999than";

	private static Repository Repo = new MySqlDB();

	Connection con;
	TableConstructor tcConstructor;

	public static Repository getInstance() {
		return Repo;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, User, Pass);
	}

	@Override
	public void addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		CustomerService cs = new CustomerService();
		try {
			con = getConnection();
			cs.add(con, customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addChicken(Chicken chicken) {
		// TODO Auto-generated method stub
		ChickenService ck = new ChickenService();
		try {
			con = getConnection();
			ck.add(con, chicken);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}


	@Override
	public ObservableList<TableConstructor> joinTable() {
		// TODO Auto-generated method stub
		String bothTable = "SELECT finance.id AS id, i_date, i_name, burma, cmee, cp, rate, total, paid FROM finance INNER JOIN chicken ON finance.id = chicken.id;";
		ObservableList<TableConstructor> obList = FXCollections.observableArrayList();

		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(bothTable);
			while (rs.next()) {
				tcConstructor = new TableConstructor(rs.getInt("id"), rs.getDate("i_date").toLocalDate(), rs.getString("i_name"),
						rs.getInt("burma"), rs.getInt("cmee"), rs.getInt("cp"), rs.getInt("rate"), rs.getInt("total"),
						rs.getInt("paid"));

				obList.add(tcConstructor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obList;
	}

}
