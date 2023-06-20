# K-SHOP
ni adalah repository untuk aplikasi kasir sederhana yang dibuat dengan Java Swing dan terhubung ke database MySQL. Aplikasi ini memungkinkan pengguna untuk menambahkan, mengedit, dan menghapus data produk serta melihat histori transaksi dalam tabel list produk di dalam aplikasi.

# Fitur Utama
1. Menambahkan produk baru dengan nama produk, jumlah stok, dan harga.
2. Mengedit data produk yang ada.
3. Menghapus produk dari database.
4. Menampilkan daftar produk dalam tabel list produk di dalam aplikasi.
5. Merekam histori transaksi termasuk waktu transaksi, nama produk, dan kembalian.

# Struktur Direktori
## 1. com.config
MyConfig : untuk menghubungkan code dengan localhost.

## 2. com.controllers
DbController : berfungsi sebagai pengontrol akses ke database.

## 3. com.models
Produk : sebuah class untuk merepresentasikan data produk.

## 4. App.java
Memuat seluruh komponen aplikasi yang berkaitan dengan antarmuka pengguna.
