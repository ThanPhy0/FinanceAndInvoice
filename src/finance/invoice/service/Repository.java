package finance.invoice.service;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;

public interface Repository {

	public static Repository getInstance() {
		return MySqlDB.getInstance();
	}

	// CustomerService
	void addCustomer(Customer customer);

	// ChickenService
	void addChicken(Chicken chicken);

	// Join CustomerServiceTable & ChickenServiceTable
	void getBothTable();

}
