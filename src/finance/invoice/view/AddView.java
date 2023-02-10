package finance.invoice.view;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;
import finance.invoice.service.MySqlDB;
import finance.invoice.service.Repository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddView implements Initializable {

	ConfigView configView;
	MySqlDB mysqlDB;

	@FXML
	public Label datetime;
	@FXML
	public Label totalAmo;
	@FXML
	private TextField cusName;
	@FXML
	private TextField cBM;
	@FXML
	private TextField cCmee;
	@FXML
	private TextField cCp;
	@FXML
	private TextField rate;
	@FXML
	private TextField custPaid;

	private Customer customer;
	private Chicken chicken;
	private Repository repo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		configView = new ConfigView();
		configView.setDateTime(datetime);
		repo = Repository.getInstance();
	}

	public void addNew() {
		validation();
		if (customer == null)
			customer = new Customer();

		if (chicken == null) {
			chicken = new Chicken();
		}

		customer.setDate(LocalDate.now());
		customer.setName(cusName.getText());

		chicken.setBurma(Integer.parseInt(cBM.getText()));
		chicken.setCmee(Integer.parseInt(cCmee.getText()));
		chicken.setCp(Integer.parseInt(cCp.getText()));

		customer.setRate(Integer.parseInt(rate.getText()));
		customer.setTotal(300);
		customer.setPaid(Integer.parseInt(custPaid.getText()));
		repo.addCustomer(customer);
		repo.addChicken(chicken);

	}

	public void validation() {
		if (cusName.getText().isEmpty() || rate.getText().isEmpty() || custPaid.getText().isEmpty()) {
			System.out.println("No data insert!");
		} else if (cusName.getText().isEmpty()) {
			System.out.println("insert customer name");
		} else if (rate.getText().isEmpty()) {
			System.out.println("insert rate");
		} else if (custPaid.getText().isEmpty()) {
			System.out.println("insert customer paid ammount");
		}
	}
}
