package finance.invoice.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import finance.invoice.entity.Items;

public class MySqlDB implements Repository {

	private static Repository Repo = new MySqlDB();

	public static Repository getInstance() {
		return Repo;
	}

	private Connection getConnection() throws SQLException {
		return DriverManager.getConnection(Queries.URL, Queries.User, Queries.Pass);
	}

	@Override
	public void addTableFinance(Items items) {
		// TODO Auto-generated method stub
		Connection con;
		AddTables addTables = new AddTables();
		try {
			con = getConnection();
			addTables.addFinance(con, items);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void addTableType() {
		// TODO Auto-generated method stub

	}

}
