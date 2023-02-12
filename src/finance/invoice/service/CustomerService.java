package finance.invoice.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import finance.invoice.entity.Customer;

public class CustomerService extends MySqlDB {
	
	static final String tInsert = "INSERT INTO finance(i_date, i_name, rate, total, paid) VALUES (?,?,?,?,?)";

	public void add(Connection con, Customer customer) {
		try {
			PreparedStatement prep = con.prepareStatement(tInsert, Statement.RETURN_GENERATED_KEYS);
			prep.setDate(1, Date.valueOf(customer.getDate()));
			prep.setString(2, customer.getName());
			prep.setInt(3, customer.getRate());
			prep.setInt(4, customer.getTotal());
			prep.setInt(5, customer.getPaid());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
