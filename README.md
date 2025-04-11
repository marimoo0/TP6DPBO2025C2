# TP 6 DPBO 2025

## -- Janji --

Saya Khana Yusdiana NIM 2100991 mengerjakan soal TP 6 dalam mata kuliah Desain dan Pemrograman Berorientasi Objek untuk keberkahanNya maka saya tidak melakukan kecurangan seperti yang telah dispesifikasikan. Aamiin.

## -- Desain Program --

![1]()

## -- Penjelasan Alur --

Menu Awal:

- Saat program pertama kali dijalankan, akan muncul jendela menu (Menu.java).
- Menu menampilkan judul "FlappyBird", gambar burung, dan tombol "PLAY".
- Ketika tombol "PLAY" ditekan, menu akan tertutup dan jendela permainan akan dibuka.

Memulai Permainan:

- Permainan dimulai dengan membuka panel game (FlappyBird.java) di dalam JFrame.
- Objek pemain (Player.java) ditampilkan sebagai burung yang bisa dikendalikan dengan tombol Spasi.
- Timer dijalankan untuk mengatur pergerakan pipa dan burung.

Mengontrol Burung:

- Tombol Spasi ditekan untuk membuat burung terbang ke atas.
- Secara default, burung akan terus jatuh ke bawah karena gravitasi (logika diatur di Timer).

Melewati Pipa:

- Pipa bergerak dari kanan ke kiri.
- Jika burung berhasil melewati sepasang pipa tanpa menabrak, skor akan bertambah 1.

Game Over:

- Jika burung menyentuh pipa atau menyentuh batas bawah JFrame, permainan akan berakhir.
- Tulisan "Game Over" ditampilkan di layar.
- Pemain dapat menekan tombol "R" untuk merestart permainan dari awal.

Menampilkan Skor:

- Skor ditampilkan menggunakan JLabel di sudut layar.
- Skor diperbarui setiap kali burung berhasil melewati pipa secara penuh.

## -- Dokumentasi saat Program di Jalankan --

### Menu Awal

![1](https://github.com/marimoo0/TP6DPBO2025C2/blob/2b530785c8f48aaf92f45330a4c7736c926687c8/SS/Screenshot_3.png)

### Game Over

![1](https://github.com/marimoo0/TP6DPBO2025C2/blob/2b530785c8f48aaf92f45330a4c7736c926687c8/SS/Screenshot_1.png)

### Tampilan Score

![1](https://github.com/marimoo0/TP6DPBO2025C2/blob/2b530785c8f48aaf92f45330a4c7736c926687c8/SS/Screenshot_2.png)
