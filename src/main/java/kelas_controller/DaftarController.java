/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */


/**
 * FXML Controller class
 *
 * @author Zennf
 */

package kelas_controller;

import java.util.List;
import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import kelas.Navigator;
import kelas_data.DataProduk;
import model.Produk;

public class DaftarController {

    @FXML private TextField txtCari;
    @FXML private TableView<Produk> tabel;
    @FXML private TableColumn<Produk, Void> kolNo;
    @FXML private TableColumn<Produk, String> kolKode;
    @FXML private TableColumn<Produk, String> kolNama;
    @FXML private TableColumn<Produk, String> kolKategori;
    @FXML private TableColumn<Produk, String> kolHarga;
    @FXML private TableColumn<Produk, Void> kolAksi;

    @FXML
    private void initialize() {
        tabel.setPlaceholder(new Label("Belum ada produk."));

        // Kolom nomor urut
        kolNo.setCellFactory(kolom -> new TableCell<>() {
            @Override
            protected void updateItem(Void item, boolean kosong) {
                super.updateItem(item, kosong);
                if (kosong || getTableRow() == null || getTableRow().getItem() == null) {
                    setText(null);
                } else {
                    setText(String.valueOf(getIndex() + 1));
                }
            }
        });

        kolKode.setCellValueFactory(c -> new ReadOnlyStringWrapper(
                c.getValue() != null ? c.getValue().getKode() : ""));
                
        kolNama.setCellValueFactory(c -> new ReadOnlyStringWrapper(
                c.getValue() != null ? c.getValue().getNama() : ""));
                
        kolHarga.setCellValueFactory(c -> new ReadOnlyStringWrapper(
                c.getValue() != null ? c.getValue().getHargaRupiah() : ""));

        // Aman dari NullPointerException jika getKategori() null
        kolKategori.setCellValueFactory(c -> {
            if (c.getValue() != null && c.getValue().getKategori() != null) {
                return new ReadOnlyStringWrapper(c.getValue().getKategori().getLabel());
            }
            return new ReadOnlyStringWrapper("-");
        });

        // Kolom aksi tombol dengan penanganan index aman
        kolAksi.setCellFactory(kolom -> new TableCell<>() {
            private final Button btnDetail = new Button("Lihat Detail");

            {
                btnDetail.getStyleClass().add("button-primary");
                btnDetail.setOnAction(e -> {
                    Produk p = getTableRow() != null ? getTableRow().getItem() : null;
                    if (p != null) {
                        Navigator.keDetail(p);
                    }
                });
            }

            @Override
            protected void updateItem(Void item, boolean kosong) {
                super.updateItem(item, kosong);
                if (kosong || getTableRow() == null || getTableRow().getItem() == null) {
                    setGraphic(null);
                } else {
                    setGraphic(btnDetail);
                }
            }
        });

        tampilkan(DataProduk.getSemua());
    }

    @FXML
    private void onCari() {
        tampilkan(DataProduk.cari(txtCari.getText()));
    }

    @FXML
    private void onTambah() {
        Navigator.keForm();
    }

    private void tampilkan(List<Produk> data) {
        if (data != null) {
            tabel.setItems(FXCollections.observableArrayList(data));
        } else {
            tabel.setItems(FXCollections.observableArrayList());
        }
    }
}