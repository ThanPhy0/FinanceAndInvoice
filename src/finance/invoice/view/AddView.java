package finance.invoice.view;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import java.util.function.Consumer;

import finance.invoice.entity.Items;
import finance.invoice.service.MySqlDB;
import finance.invoice.service.Repository;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

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

	private Consumer<Items> saveHandler;
	private Items items;
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
		if (items == null)
			items = new Items();

		items.setDate(LocalDate.now());
		items.setName(cusName.getText());
		items.setRate(Integer.parseInt(rate.getText()));
		items.setTotal(300);
		items.setPaid(Integer.parseInt(custPaid.getText()));
		repo.add(items);
//		saveHandler.accept(items);

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

	public void showForm(Consumer<Items> saveHandler) {
		try {
			FXMLLoader loader = new FXMLLoader(AddView.class.getResource("AddView.fxml"));
			Parent root = loader.load();

			AddView controller = loader.getController();
			controller.saveHandler = saveHandler;
			Stage stage = new Stage();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
