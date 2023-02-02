package finance.invoice.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

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
	public void add(Items items) {
		// TODO Auto-generated method stub
		try {
			Connection con = getConnection();
			PreparedStatement prep = con.prepareStatement(Queries.Insert, Statement.RETURN_GENERATED_KEYS);
			prep.setDate(1, Date.valueOf(items.getDate()));
			prep.setString(2, items.getName());
			prep.setInt(3, items.getBurma());
			prep.setInt(4, items.getCmee());
			prep.setInt(5, items.getCp());
			prep.setInt(6, items.getRate());
			prep.setInt(7, items.getTotal());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
