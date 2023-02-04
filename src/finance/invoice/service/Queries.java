package finance.invoice.service;

public class Queries {
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String User = "thanphyo";
	public static final String Pass = "271999than";

	public static final String Insert = "INSERT INTO finance(i_date, i_name, rate, total, paid) VALUES (?,?,?,?,?)";
}
