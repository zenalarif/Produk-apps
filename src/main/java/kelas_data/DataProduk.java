/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package kelas_data;

import java.util.ArrayList;
import java.util.List;
import model.Produk;

/**
 *
 * @author Zennf
 */
public class DataProduk {

    private static final List<Produk> daftar = new ArrayList<>();

    private DataProduk() {
    }

    public static List<Produk> getSemua() {
        return new ArrayList<>(daftar);
    }

    /**
     * @throws IllegalArgumentException jika kode produk sudah dipakai
     */
    public static void tambah(Produk produk) {
        if (kodeSudahAda(produk.getKode())) {
            throw new IllegalArgumentException("Kode produk " + produk.getKode() + " sudah digunakan.");
        }
        daftar.add(produk);
    }

    /** Mencari produk yang namanya mengandung kata kunci (tidak peka huruf besar/kecil). */
    public static List<Produk> cari(String kataKunci) {
        if (kataKunci == null || kataKunci.isBlank()) {
            return getSemua();
        }
        String kunci = kataKunci.trim().toLowerCase();
        List<Produk> hasil = new ArrayList<>();
        for (Produk p : daftar) {
            if (p.getNama().toLowerCase().contains(kunci)) {
                hasil.add(p);
            }
        }
        return hasil;
    }

    /** Saran kode berikutnya, misalnya PRD-001, PRD-002, ... */
    public static String kodeBerikutnya() {
        int n = daftar.size() + 1;
        String kode;
        do {
            kode = String.format("PRD-%03d", n++);
        } while (kodeSudahAda(kode));
        return kode;
    }

    private static boolean kodeSudahAda(String kode) {
        for (Produk p : daftar) {
            if (p.getKode().equalsIgnoreCase(kode.trim())) {
                return true;
            }
        }
        return false;
    }
}
