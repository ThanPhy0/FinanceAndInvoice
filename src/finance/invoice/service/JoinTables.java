package finance.invoice.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;
import finance.invoice.entity.TableMap;

public class JoinTables {

	static final String bothTable = "SELECT i_date, i_name, burma, cmee, cp, rate, total, paid FROM finance INNER JOIN chicken ON finance.id = chicken.id";

	public TableMap joinBoth(Connection con) {
		Customer ct = new Customer();
		Chicken ck = new Chicken();
		TableMap tMap = new TableMap();
		try {
			PreparedStatement prepStmt = con.prepareStatement(bothTable);
			ResultSet rs = prepStmt.executeQuery();
			while (rs.next()) {
				ct.setDate(rs.getDate("i_date").toLocalDate());
				ct.setName(rs.getString("i_name"));
				ck.setBurma(rs.getInt("burma"));
				ck.setCmee(rs.getInt("cmee"));
				ck.setCp(rs.getInt("cp"));
				ct.setRate(rs.getInt("rate"));
				ct.setTotal(rs.getInt("total"));
				ct.setPaid(rs.getInt("total"));

				tMap.add(ct, ck);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return tMap;
	}

	public void getBothTables(ResultSet rs) throws SQLException {
		Customer ct = new Customer();
		Chicken ck = new Chicken();

		ct.setDate(rs.getDate("i_date").toLocalDate());
		ct.setName(rs.getString("i_name"));
		ck.setBurma(rs.getInt("burma"));
		ck.setCmee(rs.getInt("cmee"));
		ck.setCp(rs.getInt("cp"));
		ct.setRate(rs.getInt("rate"));
		ct.setTotal(rs.getInt("total"));
		ct.setPaid(rs.getInt("total"));
	}
}
