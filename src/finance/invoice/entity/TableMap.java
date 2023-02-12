package finance.invoice.entity;

import java.util.HashMap;
import java.util.Map;

public class TableMap {
	private Map<Customer, Chicken> map = new HashMap<>();

	public void add(Customer customer, Chicken chicken) {
		map.put(customer, chicken);
	}
}
