package finance.invoice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;

public class ChickenService extends MySqlDB {
	public void add(Connection con, Chicken chicken) {
		Customer c = new Customer();
		try {
			PreparedStatement prep = con.prepareStatement(Queries.cInsert, Statement.RETURN_GENERATED_KEYS);
			prep.setInt(1, chicken.getBurma());
			prep.setInt(2, chicken.getCmee());
			prep.setInt(3, chicken.getCp());
			prep.setInt(4, 4);
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
