package kelas;

import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Produkter - Toko");
        Navigator.init(stage, 1000, 700);
        Navigator.keForm(); // pengguna mengisi produk dulu, baru masuk ke daftar
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
