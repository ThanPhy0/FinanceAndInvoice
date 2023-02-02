package finance.invoice.view;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;

public class AddView implements Initializable {

	ConfigView configView;

	@FXML
	public Label datetime;
	@FXML
	private ComboBox<String> comboBox;
	

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		configView = new ConfigView();
		configView.setDateTime(datetime);
		configView.setComboBox(comboBox);
	}
	
	public void comboBoxChanged() {
		System.out.println(comboBox.getValue());
	}

}
