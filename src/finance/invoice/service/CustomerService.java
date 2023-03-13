package finance.invoice.service;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import finance.invoice.entity.Customer;

public class CustomerService extends MySqlDB {

	static final String tInsert = "INSERT INTO finance(i_date, i_name, total, paid) VALUES (?,?,?,?)";

	static final String tUpdate = "UPDATE FINANCE SET i_date=?, i_name=?, total=?, paid=? WHERE id=?";

	public void add(Connection con, Customer customer) {
		PreparedStatement prep;
		try {
			prep = con.prepareStatement(tInsert, Statement.RETURN_GENERATED_KEYS);
			prep.setDate(1, Date.valueOf(customer.getDate()));
			prep.setString(2, customer.getName());
			prep.setInt(3, customer.getTotal());
			prep.setInt(4, customer.getPaid());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void update(Connection con, Customer customer) {
		PreparedStatement prep;
		try {
			prep = con.prepareStatement(tUpdate);
			prep.setDate(1, Date.valueOf(customer.getDate()));
			prep.setString(2, customer.getName());
			prep.setInt(3, customer.getTotal());
			prep.setInt(4, customer.getPaid());
			prep.setInt(5, customer.getId());
			prep.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
