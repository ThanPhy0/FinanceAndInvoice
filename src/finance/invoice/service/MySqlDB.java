package finance.invoice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;

public class MySqlDB implements Repository {

	static final String URL = "jdbc:mysql://localhost:3306/test";
	static final String User = "thanphyo";
	static final String Pass = "271999than";

	private static Repository Repo = new MySqlDB();

	Connection con;

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
	public void getBothTable() {
		// TODO Auto-generated method stub
		JoinTables joinTable = new JoinTables();
		try {
			con = getConnection();
			System.out.println(joinTable.joinBoth(con));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
