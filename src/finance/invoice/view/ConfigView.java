package finance.invoice.view;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ConfigView {

	private final ObservableList<String> list = FXCollections.observableArrayList("Burma", "Cmee", "CP");

	public void setDateTime(Label label) {
		LocalDateTime datetime = LocalDateTime.now();
		label.setText(datetime.format(DateTimeFormatter.ofPattern("dd MMM uuuu - hh:mm a")));
	}

	public void setComboBox(ComboBox<String> cBox) {
		cBox.setItems(list);
	}
	
	public void showForm(String fxml, String css) {
		Stage stage = new Stage();
		try {
			VBox root = (VBox)FXMLLoader.load(getClass().getResource(fxml));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource(css).toExternalForm());
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
