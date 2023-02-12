package finance.invoice.view;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import finance.invoice.entity.TableConstructor;
import finance.invoice.service.MySqlDB;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class MainView implements Initializable {

	ConfigView configView;
	MySqlDB mySqlDb;

	@FXML
	private Label datetime;

	@FXML
	private TableView<TableConstructor> tableView;

	@FXML
	private TableColumn<TableConstructor, Integer> colID;

	@FXML
	private TableColumn<TableConstructor, LocalDateTime> colDate;

	@FXML
	private TableColumn<TableConstructor, String> colName;

	@FXML
	private TableColumn<TableConstructor, Integer> colBurm;

	@FXML
	private TableColumn<TableConstructor, Integer> colCmee;

	@FXML
	private TableColumn<TableConstructor, Integer> colCp;

	@FXML
	private TableColumn<TableConstructor, Integer> colRate;

	@FXML
	private TableColumn<TableConstructor, Integer> colTotal;

	@FXML
	private TableColumn<TableConstructor, Integer> colPaid;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		configView = new ConfigView();
		configView.setDateTime(datetime);
		setUI();
	}

	private void setUI() {
		tableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
		MySqlDB mysqlDb = new MySqlDB();
		ObservableList<TableConstructor> list = mysqlDb.joinTable();

		colID.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("id"));
		colDate.setCellValueFactory(new PropertyValueFactory<TableConstructor, LocalDateTime>("i_date"));
		colName.setCellValueFactory(new PropertyValueFactory<TableConstructor, String>("i_name"));
		colBurm.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("burma"));
		colCmee.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("cmee"));
		colCp.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("cp"));
		colRate.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("rate"));
		colTotal.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("total"));
		colPaid.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("paid"));

		tableView.setItems(list);
	}

	public void addNew() {
		configView = new ConfigView();
		configView.showForm("AddView.fxml", "application.css");

	}

	public void edit() {

	}

	public void delete() {
		ObservableList<TableConstructor> selectItem = tableView.getSelectionModel().getSelectedItems();
		mySqlDb = new MySqlDB();
		ArrayList<Integer> data = new ArrayList<>();
		for (TableConstructor out : selectItem) {
			data.add(out.getId());
		}
		for (int out : data) {
			mySqlDb.delete(out);
		}
	}
}
