package finance.invoice.view;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class MainPage implements Initializable {

	@FXML
	private BorderPane bp;
	@FXML
	private AnchorPane ap;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		buy(null);
	}

	@FXML
	private void buy(MouseEvent event) {
		bp.setCenter(ap);
		loadPage("MainView");
	}

	@FXML
	private void sell(MouseEvent event) {

	}

	@FXML
	private void about(MouseEvent event) {

	}

	private void loadPage(String page) {
		Parent root = null;
		try {
			root = FXMLLoader.load(getClass().getResource(page + ".fxml"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			Logger.getLogger(MainPage.class.getName()).log(null);
		}
		bp.setCenter(root);
	}

}
