package finance.invoice.view;

import java.net.URL;
import java.util.ResourceBundle;

import finance.invoice.service.Repository;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class MainView implements Initializable {

	ConfigView configView;

	@FXML
	public Label datetime;

	private Repository repo;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		configView = new ConfigView();
		configView.setDateTime(datetime);
		repo = Repository.getInstance();
	}

	@FXML
	public void addNew() {
		configView = new ConfigView();
		configView.showForm("AddView.fxml", "application.css");
		
	}

//	private void save(Items items) {
//		repo.add(items);
//	}

}
