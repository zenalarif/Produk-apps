package model;

import java.text.NumberFormat;
import java.util.Locale;


public class Produk {

    public enum Kategori {
        MAKANAN("Makanan"),
        MINUMAN("Minuman");

        private final String label;

        Kategori(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        @Override
        public String toString() {
            return label; 
        }
    }

    private final String kode;
    private final String nama;
    private final Kategori kategori;
    private final int harga;
    private final String pathGambar; 

    public Produk(String kode, String nama, Kategori kategori, int harga) {
        this(kode, nama, kategori, harga, null);
    }


    public Produk(String kode, String nama, Kategori kategori, int harga, String pathGambar) {
        if (nama == null || nama.isBlank()) {
            throw new IllegalArgumentException("Nama produk tidak boleh kosong.");
        }
        if (harga <= 0) {
            throw new IllegalArgumentException("Harga harus lebih dari nol.");
        }
        if (kode == null || kode.isBlank()) {
            throw new IllegalArgumentException("Kode produk tidak boleh kosong.");
        }
        if (kategori == null) {
            throw new IllegalArgumentException("Kategori harus dipilih.");
        }
        this.kode = kode.trim();
        this.nama = nama.trim();
        this.kategori = kategori;
        this.harga = harga;
        this.pathGambar = (pathGambar == null || pathGambar.isBlank()) ? null : pathGambar;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public Kategori getKategori() {
        return kategori;
    }

    public int getHarga() {
        return harga;
    }

    public String getPathGambar() {
        return pathGambar;
    }

    public String getHargaRupiah() {
        NumberFormat nf = NumberFormat.getInstance(Locale.forLanguageTag("id-ID"));
        return "Rp " + nf.format(harga);
    }
}
