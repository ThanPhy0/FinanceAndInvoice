package finance.invoice.service;

import finance.invoice.entity.Items;

public interface Repository {

	public static Repository getInstance() {
		return MySqlDB.getInstance();
	}

	void add(Items items);

}
