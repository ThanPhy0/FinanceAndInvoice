package finance.invoice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import finance.invoice.entity.Chicken;

public class ChickenService extends MySqlDB {

	final String cInsert = "INSERT INTO chicken(burma, cmee, cp, finance_id) VALUES (?,?,?,?)";

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
}
