package finance.invoice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;

public class MySqlDB implements Repository {

	private static Repository Repo = new MySqlDB();

	Connection con;

	public static Repository getInstance() {
		return Repo;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Queries.URL, Queries.User, Queries.Pass);
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
	public void getBothTable(ResultSet rs) {
		// TODO Auto-generated method stub

	}
}
