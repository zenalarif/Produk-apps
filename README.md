#Produk "Aplikasi Daftar Produk Toko"

Aplikasi desktop sederhana untuk mencatat produk toko, dibuat dengan Java dan JavaFX. Pengguna menambahkan produk lewat form, melihatnya dalam tabel, mencari berdasarkan nama, dan membuka halaman detail dari produk yang dipilih.

Proyek ini adalah tugas individu: modifikasi aplikasi hasil praktikum menjadi aplikasi pencatatan produk toko, dengan struktur dan pola kode (FXML + controller + navigator) yang sama.

#Tampilan 
Tambah produk
<img width="540" height="679" alt="image" src="https://github.com/user-attachments/assets/abcb40a4-9503-479d-ae31-108ab2d68d2d" />
Daftar Produk
<img width="697" height="465" alt="image" src="https://github.com/user-attachments/assets/629d4b53-26db-4bf5-b42c-cf2fdc303b6e" />
Detail Produk
<img width="918" height="625" alt="image" src="https://github.com/user-attachments/assets/121d16a2-135f-450a-b511-f0c9eef8ea04" />
Fitur

Form tambah produk — kode produk (terisi otomatis PRD-001, PRD-002, … dan masih bisa diubah), nama, kategori (Makanan / Minuman), harga, serta foto produk .
Tabel produk — menampilkan nomor, kode, nama, kategori, dan harga (format Rp 18.000).
Pencarian — mencari berdasarkan nama produk lewat tombol Cari (tidak peka huruf besar/kecil). Kolom pencarian yang kosong menampilkan semua produk.
Lihat Detail — tombol di setiap baris membuka halaman detail dari produk yang dipilih.
Validasi input — data yang tidak valid ditolak dengan pesan kesalahan (lihat bagian Validasi).
Penyimpanan di memori — data hanya disimpan selama aplikasi berjalan (tanpa database).
Alur Penggunaan
Aplikasi dibuka pada halaman form, sehingga pengguna memasukkan produk terlebih dahulu.
Setelah menekan Simpan, aplikasi berpindah ke halaman daftar produk.
Di halaman daftar:
Tambah membuka form lagi untuk menambah produk berikutnya,
Cari menyaring tabel berdasarkan nama,
Lihat Detail membuka halaman detail produk pada baris tersebut.
Di halaman detail, Tutup kembali ke daftar. Di form, Batal juga kembali ke daftar.
Validasi
Kondisi	Hasil
Nama produk kosong	Ditolak: "Nama produk tidak boleh kosong."
Harga kosong, bukan angka, atau ≤ 0	Ditolak dengan pesan yang sesuai
Kategori belum dipilih	Ditolak: "Kategori harus dipilih."
Kode produk kosong atau sudah dipakai	Ditolak

Validasi nama, harga, kode, dan kategori dilakukan di constructor kelas Produk, sehingga objek Produk yang berhasil dibuat selalu valid.

Teknologi
Java (JDK 17 atau lebih baru)
JavaFX 21 (javafx-controls, javafx-fxml)
Maven (javafx-maven-plugin)
Dikembangkan dengan NetBeans
Struktur Proyek
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

Cara Menjalankan
Prasyarat
JDK 17 atau lebih baru (JavaFX 21 tidak dapat berjalan di bawah JDK 17)
Maven 3.6+
Lewat terminal
bash
git clone https://github.com/<username>/Produk.git
cd Produk
mvn clean javafx:run
Lewat NetBeans
Buka File → Open Project, lalu pilih folder Produk.
Pastikan proyek memakai JDK 17 atau lebih baru.
Klik kanan proyek → Run (atau tekan F6).
Pengujian Manual
Jalankan aplikasi, lalu tambahkan minimal tiga produk, misalnya:
Kode	Nama	Kategori	Harga
PRD-001	Nasi Goreng Spesial	Makanan	25000
PRD-002	Es Teh Manis	Minuman	5000
PRD-003	Kopi Susu Gula Aren	Minuman	18000
Pastikan ketiga produk muncul pada tabel.
Ketik kopi pada kolom pencarian, tekan Cari, lalu pastikan hanya produk yang sesuai yang tampil.
Klik Lihat Detail pada salah satu baris dan pastikan detail yang tampil adalah produk yang dipilih.
Coba simpan dengan nama kosong atau harga 0 / abc, lalu pastikan data ditolak.
Catatan
Data tidak disimpan permanen; semua produk hilang saat aplikasi ditutup.
Foto produk hanya menyimpan lokasi file di komputer. Jika file dipindah atau dihapus, halaman detail menampilkan placeholder "Foto Produk".
Pembuat
Nama: Zainal Arifin



