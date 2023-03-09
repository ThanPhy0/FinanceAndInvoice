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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class AddView implements Initializable {

	MySqlDB mysqlDB;

	@FXML
	public Label date;
	@FXML
	public Label ID;
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
	private TextField total;
	@FXML
	private TextField custPaid;
	@FXML
	private Button saveupdate;

	private ConfigView configView;
	private Customer customer;
	private Chicken chicken;
	private Repository repo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		configView = new ConfigView();
		configView.setDateTime(date);
		repo = Repository.getInstance();
	}

	public void SaveAndUpdate() {
		validation();
		if (customer == null)
			customer = new Customer();

		if (chicken == null) {
			chicken = new Chicken();
		}

		if (saveupdate.getText().equals("Save")) {
			customer.setDate(LocalDate.now());
			customer.setName(cusName.getText());

			chicken.setBurma(Integer.parseInt(cBM.getText()));
			chicken.setCmee(Integer.parseInt(cCmee.getText()));
			chicken.setCp(Integer.parseInt(cCp.getText()));

			customer.setRate(Integer.parseInt(total.getText()));
			customer.setTotal(300);
			customer.setPaid(Integer.parseInt(custPaid.getText()));

			repo.addCustomer(customer);
			repo.addChicken(chicken);
		} else if (saveupdate.getText().equals("Update")) {
			System.out.println("Update");
			customer.setDate(LocalDate.now());
			customer.setName(cusName.getText());

			chicken.setBurma(Integer.parseInt(cBM.getText()));
			chicken.setCmee(Integer.parseInt(cCmee.getText()));
			chicken.setCp(Integer.parseInt(cCp.getText()));
			chicken.setId(Integer.parseInt(ID.getText()));
			
			customer.setTotal(Integer.parseInt(total.getText()));
			customer.setPaid(Integer.parseInt(custPaid.getText()));
			customer.setId(Integer.valueOf(ID.getText()));

			System.out.println(ID.getText());
			repo.updateCustomer(customer);
			repo.updateChicken(chicken);
		}

	}

	public void setForEdit(int id, LocalDate lDate, String custName, int cBur, int cmee, int cp, int custTotal,
			int cusPaid, String update) {
		ID.setText(String.valueOf(id));
		date.setText(String.valueOf(lDate));
		cusName.setText(custName);
		cBM.setText(String.valueOf(cBur));
		cCmee.setText(String.valueOf(cmee));
		cCp.setText(String.valueOf(cp));
		total.setText(String.valueOf(custTotal));
		custPaid.setText(String.valueOf(cusPaid));
		saveupdate.setText(update);
	}

	public void validation() {
		if (cusName.getText().isEmpty() || total.getText().isEmpty() || custPaid.getText().isEmpty()) {
			System.out.println("No data insert!");
		} else if (cusName.getText().isEmpty()) {
			System.out.println("insert customer name");
		} else if (total.getText().isEmpty()) {
			System.out.println("insert rate");
		} else if (custPaid.getText().isEmpty()) {
			System.out.println("insert customer paid ammount");
		}
	}

}
