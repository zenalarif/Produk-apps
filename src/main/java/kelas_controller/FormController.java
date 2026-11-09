package kelas_controller;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import kelas.Navigator;
import kelas_data.DataProduk;
import model.Produk;

public class FormController {

    private static final String TEKS_BELUM_ADA_GAMBAR = "Belum ada gambar";

    @FXML private TextField txtKode;
    @FXML private TextField txtNama;
    @FXML private ComboBox<Produk.Kategori> cmbKategori;
    @FXML private TextField txtHarga;
    @FXML private ImageView imgPreview;
    @FXML private Label lblNamaFile;
    @FXML private Label lblError;

    private File fileGambar; // null jika belum memilih gambar

    @FXML
    private void initialize() {
        txtKode.setText(DataProduk.kodeBerikutnya());
        cmbKategori.getItems().setAll(Produk.Kategori.values());
        lblNamaFile.setText(TEKS_BELUM_ADA_GAMBAR);
    }

    @FXML
    private void onPilihGambar() {
        FileChooser chooser = new FileChooser();
        chooser.setTitle("Pilih Gambar Produk");
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter(
                "Gambar (*.png, *.jpg, *.jpeg, *.gif, *.bmp)",
                "*.png", "*.jpg", "*.jpeg", "*.gif", "*.bmp"));

        File file = chooser.showOpenDialog(txtNama.getScene().getWindow());
        if (file == null) {
            return; // pengguna membatalkan
        }

        Image gambar = new Image(file.toURI().toString(), 110, 110, true, true);
        if (gambar.isError()) {
            lblError.setText("File yang dipilih tidak dapat dibaca sebagai gambar.");
            return;
        }
        lblError.setText("");
        fileGambar = file;
        imgPreview.setImage(gambar);
        lblNamaFile.setText(file.getName());
    }

    @FXML
    private void onHapusGambar() {
        fileGambar = null;
        imgPreview.setImage(null);
        lblNamaFile.setText(TEKS_BELUM_ADA_GAMBAR);
    }

    @FXML
    private void onSimpan() {
        lblError.setText("");
        try {
            int harga = parseHarga(txtHarga.getText());
            String pathGambar = (fileGambar == null) ? null : fileGambar.toURI().toString();
            Produk produk = new Produk(txtKode.getText(), txtNama.getText(),
                    cmbKategori.getValue(), harga, pathGambar);
            DataProduk.tambah(produk);
            Navigator.keDaftar();
        } catch (IllegalArgumentException e) {
            lblError.setText(e.getMessage());
        }
    }

    @FXML
    private void onLihatDaftar() {
        Navigator.keDaftar();
    }

    /** Mengubah teks harga menjadi angka. Titik pemisah ribuan (18.000) diabaikan. */
    private int parseHarga(String teks) {
        if (teks == null || teks.isBlank()) {
            throw new IllegalArgumentException("Harga tidak boleh kosong.");
        }
        try {
            return Integer.parseInt(teks.trim().replace(".", ""));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Harga harus berupa angka bulat.");
        }
    }
}
