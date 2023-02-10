package finance.invoice.service;

public class Queries {
	public static final String URL = "jdbc:mysql://localhost:3306/test";
	public static final String User = "thanphyo";
	public static final String Pass = "271999than";

	// Table Union & Right Join
	public static final String join = "\r\n"
			+ "	SELECT * FROM finance LEFT JOIN chicken on finance.id = chicken.id UNION ALL SELECT * FROM finance RIGHT JOIN chicken on finance.id = chicken.id";

	// CustomerService
	public static final String tInsert = "INSERT INTO finance(i_date, i_name, rate, total, paid) VALUES (?,?,?,?,?)";

	// ChickenService
	public static final String cInsert = "INSERT INTO chicken(burma, cmee, cp, finance_id) VALUES (?,?,?,?)";
}
