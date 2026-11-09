# Produk "Aplikasi Daftar Produk Toko"

Aplikasi desktop sederhana untuk mencatat produk toko, dibuat dengan Java dan JavaFX. Pengguna menambahkan produk lewat form, melihatnya dalam tabel, mencari berdasarkan nama, dan membuka halaman detail dari produk yang dipilih.

Proyek ini adalah tugas individu: modifikasi aplikasi hasil praktikum menjadi aplikasi pencatatan produk toko, dengan struktur dan pola kode (FXML + controller + navigator) yang sama.

# Tampilan 

<img width="540" height="679" alt="image" src="https://github.com/user-attachments/assets/abcb40a4-9503-479d-ae31-108ab2d68d2d" />

<img width="697" height="465" alt="image" src="https://github.com/user-attachments/assets/629d4b53-26db-4bf5-b42c-cf2fdc303b6e" />

<img width="918" height="625" alt="image" src="https://github.com/user-attachments/assets/121d16a2-135f-450a-b511-f0c9eef8ea04" />


# Fitur
1. Form tambah produk — kode produk (terisi otomatis PRD-001, PRD-002, … dan masih bisa diubah), nama, kategori (Makanan / Minuman), harga, serta foto produk.
2. Tabel produk — menampilkan nomor, kode, nama, kategori, dan harga (format Rp 18.000).
3. Pencarian — mencari berdasarkan nama produk lewat tombol Cari (tidak peka huruf besar/kecil). Kolom pencarian yang kosong menampilkan semua produk.
4. Lihat Detail — tombol di setiap baris membuka halaman detail dari produk yang dipilih.
5. Validasi input — data yang tidak valid ditolak dengan pesan kesalahan (lihat bagian Validasi).
6. Penyimpanan di memori — data hanya disimpan selama aplikasi berjalan (tanpa database).

# Alur Penggunaan
Aplikasi dibuka pada halaman form, sehingga pengguna memasukkan produk terlebih dahulu.
Setelah menekan Simpan, aplikasi berpindah ke halaman daftar produk.
Di halaman daftar:
- Tambah membuka form lagi untuk menambah produk berikutnya,
- Cari menyaring tabel berdasarkan nama,
- Lihat Detail membuka halaman detail produk pada baris tersebut.
Di halaman detail, Tutup kembali ke daftar. Di form, Batal juga kembali ke daftar.

# Struktur Proyek
Produk
├── pom.xml
├── nbactions.xml
├── docs/                           # tangkapan layar untuk README
└── src/main
    ├── java
    │   ├── kelas
    │   │   ├── MainApp.java        # titik masuk aplikasi
    │   │   └── Navigator.java      # perpindahan halaman + ukuran jendela
    │   ├── kelas_controller
    │   │   ├── DaftarController.java
    │   │   ├── FormController.java
    │   │   └── DetailController.java
    │   ├── kelas_data
    │   │   └── DataProduk.java     # penyimpanan data di memori
    │   └── model
    │       └── Produk.java         # model produk (atribut private, constructor, getter)
    └── resources
        ├── src/store
        │   ├── daftar.fxml
        │   ├── form.fxml
        │   └── detail.fxml
        └── style
            └── app.css
Halaman detail menerima objek Produk yang dipilih (DetailController.setProduk(...)), bukan data yang ditulis langsung di kode.

# Cara Menjalankan
Prasyarat
JDK 17 atau lebih baru (JavaFX 21 tidak dapat berjalan di bawah JDK 17)
Maven 3.6+

Lewat terminal
bash
git clone https://github.com/<username>/Produk.git
cd Produk
mvn clean javafx:run

Lewat NetBeans
1. Buka File → Open Project, lalu pilih folder Produk.
2. Pastikan proyek memakai JDK 17 atau lebih baru.
3. Klik kanan proyek → Run (atau tekan F6).
   
# Catatan
Data tidak disimpan permanen; semua produk hilang saat aplikasi ditutup.
Foto produk hanya menyimpan lokasi file di komputer. Jika file dipindah atau dihapus, halaman detail menampilkan placeholder "Foto Produk".

# pembuat : Zainal Arifin

