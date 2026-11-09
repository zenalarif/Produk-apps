/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas;

/**
 *
 * @author Zennf
 */



import kelas_controller.DetailController;
import model.Produk;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Navigator {

    private static Stage stage;
    private static Scene scene;

    private Navigator() {
    }

    public static void init(Stage stage, double lebar, double tinggi) {
        Navigator.stage = stage;
        scene = new Scene(new Pane(), lebar, tinggi);
        scene.getStylesheets().add(
                Navigator.class.getResource("/style/app.css").toExternalForm());
        stage.setScene(scene);
    }

    public static void keDaftar() {
        muat("/src/store/daftar.fxml", 920, 600);
    }

    public static void keForm() {
        muat("/src/store/form.fxml", 540, 650);
    }

    public static void keDetail(Produk produk) {
        DetailController controller = muat("/src/store/detail.fxml", 700, 440);
        controller.setProduk(produk);
    }

    /** Memuat halaman dan menyesuaikan ukuran jendela dengan halaman tersebut. */
    private static <T> T muat(String lokasiFxml, double lebar, double tinggi) {
        try {
            FXMLLoader loader = new FXMLLoader(Navigator.class.getResource(lokasiFxml));
            Parent root = loader.load();
            // Scene baru dengan ukuran khusus halaman ini, lalu jendela menyesuaikan
            scene = new Scene(root, lebar, tinggi);
            scene.getStylesheets().add(
                    Navigator.class.getResource("/style/app.css").toExternalForm());
            stage.setScene(scene);
            stage.sizeToScene();
            stage.centerOnScreen();
            return loader.getController();
        } catch (IOException e) {
            throw new RuntimeException("Gagal memuat " + lokasiFxml, e);
        }
    }
}

