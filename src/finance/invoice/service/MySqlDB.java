package finance.invoice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;
import finance.invoice.entity.TableConstructor;
import finance.invoice.operations.Operate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class MySqlDB implements Repository {

	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String User = "thanphyo";
	static final String Pass = "271999than";

	private static Repository Repo = new MySqlDB();

	Connection con;
	PreparedStatement prepStmt;
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
	public void updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		CustomerService cs = new CustomerService();
		try {
			con = getConnection();
			cs.update(con, customer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void updateChicken(Chicken chicken) {
		// TODO Auto-generated method stub
		ChickenService ck = new ChickenService();
		try {
			con = getConnection();
			ck.update(con, chicken);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public ObservableList<TableConstructor> joinTable() {
		// TODO Auto-generated method stub
		String bothTable = "SELECT finance.id AS id, i_date, i_name, burma, cmee, cp, total, paid FROM finance INNER JOIN chicken ON finance.id = chicken.id;";
		ObservableList<TableConstructor> obList = FXCollections.observableArrayList();

		Operate op = new Operate();

		try {
			con = getConnection();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery(bothTable);
			while (rs.next()) {
				int multi = rs.getInt("burma") * 200;
				System.out.println(multi);
				tcConstructor = new TableConstructor(rs.getInt("id"), rs.getDate("i_date").toLocalDate(),
						rs.getString("i_name"), rs.getFloat("burma"), rs.getFloat("cmee"), rs.getFloat("cp"),
						op.multipile(rs.getFloat("burma")), op.multipile(rs.getFloat("cmee")),
						op.multipile(rs.getFloat("cp")), rs.getInt("total"), rs.getInt("paid"));

				obList.add(tcConstructor);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obList;
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		String delete = "DELETE FROM finance WHERE id = ?;";
		try {
			con = getConnection();
			prepStmt = con.prepareStatement(delete);
			prepStmt.setInt(1, id);
			prepStmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
