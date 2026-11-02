**Tugas Praktikum 6 DPBO 2026 - Kelas C1**

Nama: Muh. Adib Al-Fathi
NIM: 2500418
Kelas: C1

**Janji**

Saya Muh. Adib Al-Fathi dengan NIM 2500418 mengerjakan Tugas Praktikum 6 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahan-Nya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## Struktur Program & Penjelasan Class
Project ini dibagi menjadi beberapa class agar kodenya lebih terstruktur dan menerapkan konsep OOP (*Object-Oriented Programming*):

1. **`App.java`**
   * Berfungsi sebagai *entry point* utama program.
   * Menginisialisasi `JFrame` dengan ukuran jendela 360x640 piksel serta mengatur properti dasar jendela game.
2. **`View.java`**
   * Merupakan turunan dari `JPanel` yang bertugas untuk menangani seluruh tampilan grafis (*rendering*).
   * Menggambar background, burung (*player*), pipa rintangan, teks menu awal, tampilan *Game Over*, dan label skor di layar menggunakan method `paintComponent`.
3. **`Logic.java`**
   * Berisi inti dari alur permainan (*game mechanics*).
   * Mengatur gravitasi burung, kecepatan gerak pipa, logika penambahan skor, deteksi tabrakan (*collision box*), hingga fungsi *restart* game.
   * Mengimplementasikan `KeyListener` untuk membaca input tombol keyboard (Spasi dan 'R').
4. **`Player.java`**
   * Sebagai model data untuk objek burung (menyimpan posisi koordinat X dan Y, ukuran lebar dan tinggi, gambar, serta kecepatan vertikal/`velocityY`).
5. **`Pipe.java`**
   * Sebagai model data untuk objek pipa rintangan atas dan bawah (menyimpan posisi, ukuran, gambar, serta status pengecekan skor `passed`).
6. **`SoundEffect.java`**
   * Utility tambahan untuk memutar musik latar (*BGM*) berformat `.wav` secara *looping* otomatis menggunakan library `javax.sound.sampled` bawaan Java.
  

## Fitur & Alur Permainan
* **Main Menu**: Saat program pertama kali dijalankan, game akan berada di menu utama menampilkan judul dan instruksi *"Tekan SPASI untuk Mulai"*.
* **Gameplay**: 
  * Tekan tombol **Spasi** untuk membuat burung melompat ke atas. Musik latar (*BGM*) akan langsung berputar secara otomatis.
  * Burung akan terus ditarik ke bawah oleh gravitasi jika tombol Spasi tidak ditekan.
  * Pipa atas dan bawah akan muncul secara periodik dengan celah acak dari arah kanan ke kiri.
* **Sistem Skor**: Skor akan bertambah setiap kali burung berhasil melewati rintangan pipa.
* **Game Over & Restart**: 
  * Permainan berakhir jika burung menabrak pipa atau jatuh ke bawah layar. Musik akan berhenti dan layar menampilkan tulisan *Game Over* beserta skor akhir.
  * Pemain dapat menekan tombol **'R'** di keyboard untuk mengulang permainan dari awal.

## Cara Menjalankan Program
1. Pastikan komputer kamu sudah terinstal **Java Development Kit (JDK)**.
2. Clone atau download repository ini, pastikan folder **`assets`** (berisi gambar dan file `bgm.wav`) berada di dalam satu folder yang sama dengan file-file `.java`.
3. Buka terminal/command prompt di direktori folder project, lalu jalankan perintah berikut:
   ```cmd
   javac *.java
   java App

## Dokumentasi RUN
<img width="877" height="519" alt="Screenshot 2026-11-02 135848" src="https://github.com/user-attachments/assets/3c421e1e-77a0-4bbc-b76c-a6419aebed91" />
<img width="821" height="534" alt="Screenshot 2026-11-02 135920" src="https://github.com/user-attachments/assets/176dde48-4a82-4a07-a51c-513f9fa317d6" />






