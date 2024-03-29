package finance.invoice.view;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			BorderPane root = (BorderPane) FXMLLoader.load(MainView.class.getResource("MainPage.fxml"));
			Scene scene = new Scene(root);
			primaryStage.setScene(scene);
//			primaryStage.getIcons().add(new Image("com/coder/balance/resource/sing.jpg"));
//			primaryStage.setResizable(false);
			primaryStage.setTitle("Finance & Invoice");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
