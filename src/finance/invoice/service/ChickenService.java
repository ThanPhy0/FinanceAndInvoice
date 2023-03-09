package finance.invoice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import finance.invoice.entity.Chicken;

public class ChickenService extends MySqlDB {

	static final String cInsert = "INSERT INTO chicken(burma, cmee, cp, finance_id) VALUES (?,?,?,?)";

	static final String cUpdate = "UPDATE CHICKEN SET burma=?, cmee=?, cp=? where id=?";

	public void get(Connection con) {
		try {
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM chicken");
			while (rs.next()) {
				rs.getInt("burma");
				rs.getInt("cmee");
				rs.getInt("cp");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void add(Connection con, Chicken chicken) {
		try {
			PreparedStatement prep = con.prepareStatement(cInsert, Statement.RETURN_GENERATED_KEYS);
			prep.setInt(1, chicken.getBurma());
			prep.setInt(2, chicken.getCmee());
			prep.setInt(3, chicken.getCp());
			prep.setInt(4, 1);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Connection con, Chicken chicken) {
		PreparedStatement prep;
		try {
			prep = con.prepareStatement(cUpdate);
			prep.setInt(1, chicken.getBurma());
			prep.setInt(2, chicken.getCmee());
			prep.setInt(3, chicken.getCp());
			prep.setInt(4, chicken.getId());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
