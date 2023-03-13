package finance.invoice.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

import finance.invoice.entity.TableConstructor;
import finance.invoice.service.MySqlDB;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

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
	private TableColumn<TableConstructor, Float> colBurm;

	@FXML
	private TableColumn<TableConstructor, Float> colCmee;

	@FXML
	private TableColumn<TableConstructor, Float> colCp;

	@FXML
	private TableColumn<TableConstructor, Integer> amBurma;

	@FXML
	private TableColumn<TableConstructor, Integer> amCmee;

	@FXML
	private TableColumn<TableConstructor, Integer> amCp;

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

//		TableConstructor tc = new TableConstructor();
		System.out.println();

		colID.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("id"));
		colDate.setCellValueFactory(new PropertyValueFactory<TableConstructor, LocalDateTime>("i_date"));
		colName.setCellValueFactory(new PropertyValueFactory<TableConstructor, String>("i_name"));
		colBurm.setCellValueFactory(new PropertyValueFactory<TableConstructor, Float>("burma"));
		colCmee.setCellValueFactory(new PropertyValueFactory<TableConstructor, Float>("cmee"));
		colCp.setCellValueFactory(new PropertyValueFactory<TableConstructor, Float>("cp"));
		amBurma.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("multBurma"));
		amCmee.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("multCmee"));
		amCp.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("multCp"));
		colTotal.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("total"));
		colPaid.setCellValueFactory(new PropertyValueFactory<TableConstructor, Integer>("paid"));

		tableView.setItems(list);
	}

	public void addNew() {
		configView = new ConfigView();
		configView.showForm("AddView.fxml", "application.css");

	}

	public void edit() {
		if (tableView.getSelectionModel().getSelectedItem() == null) {
			System.out.println("You need to select which item want edit!");
		} else {
			Stage stage = new Stage();
			Parent root;
			FXMLLoader loader = new FXMLLoader(getClass().getResource("AddView.fxml"));
			try {
				root = loader.load();
				AddView av = loader.getController();
				av.setForEdit(tableView.getSelectionModel().getSelectedItem().getId(),
						tableView.getSelectionModel().getSelectedItem().getI_date(),
						tableView.getSelectionModel().getSelectedItem().getI_name(),
						tableView.getSelectionModel().getSelectedItem().getBurma(),
						tableView.getSelectionModel().getSelectedItem().getCmee(),
						tableView.getSelectionModel().getSelectedItem().getCp(),
						tableView.getSelectionModel().getSelectedItem().getTotal(),
						tableView.getSelectionModel().getSelectedItem().getPaid(), "Update");

				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
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
