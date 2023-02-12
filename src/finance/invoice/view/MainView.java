package finance.invoice.view;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;

import finance.invoice.entity.Chicken;
import finance.invoice.entity.Customer;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainView implements Initializable {

	ConfigView configView;

	@FXML
	private Label datetime;

	@FXML
	private TableView<Customer, Chicken> tableView;

	@FXML
	private TableColumn<Customer, Integer> colID;

	@FXML
	private TableColumn<Customer, LocalDateTime> colDate;

	@FXML
	private TableColumn<Customer, String> colName;

	@FXML
	private TableColumn<Chicken, Integer> colBurm;

	@FXML
	private TableColumn<Chicken, Integer> colCmee;

	@FXML
	private TableColumn<Chicken, Integer> colCp;

	@FXML
	private TableColumn<Customer, Integer> colRate;

	@FXML
	private TableColumn<Customer, Integer> colTotal;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		configView = new ConfigView();
		configView.setDateTime(datetime);
		setUI();
	}

	@FXML
	public void addNew() {
		configView = new ConfigView();
		configView.showForm("AddView.fxml", "application.css");

	}

	private void setUI() {
		colDate.setCellValueFactory(new PropertyValueFactory<Customer, LocalDateTime>("i_date"));
		colName.setCellValueFactory(new PropertyValueFactory<Customer, String>("i_name"));
		colBurm.setCellValueFactory(new PropertyValueFactory<Chicken, Integer>("burma"));
		colCmee.setCellValueFactory(new PropertyValueFactory<Chicken, Integer>("cmee"));
		colCp.setCellValueFactory(new PropertyValueFactory<Chicken, Integer>("cp"));
		colRate.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("rate"));
		colTotal.setCellValueFactory(new PropertyValueFactory<Customer, Integer>("total"));
		
		tableView.
	}

}
