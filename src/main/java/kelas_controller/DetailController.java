/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package kelas_controller;

/**
 * FXML Controller class
 *
 * @author Zennf
 */

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import kelas.Navigator;
import model.Produk;

public class DetailController {

    @FXML private Label lblKode;
    @FXML private Label lblNama;
    @FXML private Label lblKategori;
    @FXML private Label lblHarga;
    @FXML private ImageView imgProduk;
    @FXML private Label lblFoto;

    public void setProduk(Produk produk) {
        lblKode.setText(produk.getKode());
        lblNama.setText(produk.getNama());
        lblHarga.setText(produk.getHargaRupiah());

        lblKategori.setText(produk.getKategori().getLabel());

        tampilkanGambar(produk.getPathGambar());
    }

    private void tampilkanGambar(String pathGambar) {
        imgProduk.setImage(null);
        lblFoto.setVisible(true);
        if (pathGambar == null) {
            return;
        }
        Image gambar = new Image(pathGambar, 190, 190, true, true);
        if (!gambar.isError()) { // jika file sudah dipindah/dihapus, tetap tampil placeholder
            imgProduk.setImage(gambar);
            lblFoto.setVisible(false);
        }
    }

    @FXML
    private void onTutup() {
        Navigator.keDaftar();
    }
}
