package finance.invoice.service;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;
import finance.invoice.entity.TableConstructor;
import javafx.collections.ObservableList;

public interface Repository {

	public static Repository getInstance() {
		return MySqlDB.getInstance();
	}

	// CustomerService
	void addCustomer(Customer customer);

	// ChickenService
	void addChicken(Chicken chicken);

	// Join CustomerServiceTable & ChickenServiceTable
	ObservableList<TableConstructor> joinTable();

	// CustomerService_Update
	void updateCustomer(Customer custormer);

	// ChickenService_Update
	void updateChicken(Chicken chicken);

	// edit
	void edit(int id);

	// delete
	void delete(int id);
}
