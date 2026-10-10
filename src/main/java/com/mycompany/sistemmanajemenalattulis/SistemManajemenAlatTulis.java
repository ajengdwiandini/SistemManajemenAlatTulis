package com.mycompany.sistemmanajemenalattulis;

import java.util.Scanner;

public class SistemManajemenAlatTulis {

    private static Scanner scanner = new Scanner(System.in);
    private static AlatTulis[] daftarAlatTulis = new AlatTulis[10];
    private static int jumlahAlatTulis = 0;
    private static boolean isRunning = true;

    public static void main(String[] args) {

        isiDataAwal();

        while (isRunning) {

            System.out.println();
            System.out.println("==================================");
            System.out.println("    SISTEM MANAJEMEN ALAT TULIS");
            System.out.println("==================================");
            System.out.println("1. Tambah Data Baru");
            System.out.println("2. Tampilkan Seluruh Data");
            System.out.println("3. Pencarian / Aksi Khusus");
            System.out.println("4. Proses Alat Tulis");
            System.out.println("5. Layanan Alat Tulis");
            System.out.println("6. Keluar");
            System.out.print("Pilih menu: ");

            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahData();
                    break;
                case 2:
                    tampilkanData();
                    break;
                case 3:
                    menuPencarian();
                    break;
                case 4:
                    prosesData();
                    break;
                case 5:
                    menuLayananAlatTulis();
                    break;
                case 6:
                    isRunning = false;
                    System.out.println("Terima kasih telah menggunakan program.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        }

        scanner.close();
    }

    public static void isiDataAwal() {

        daftarAlatTulis[jumlahAlatTulis++] =
                new AlatTulisSekolah(
                        "S001", "Pulpen", 5000, 20,
                        "Pulpen Gel", "Snowman");

        daftarAlatTulis[jumlahAlatTulis++] =
                new AlatTulisSekolah(
                        "S002", "Pensil", 3000, 15,
                        "Pensil 2B", "Faber-Castell");

        daftarAlatTulis[jumlahAlatTulis++] =
                new AlatTulisKantor(
                        "K001", "Map", 4000, 10,
                        "Plastik", "F4");

        daftarAlatTulis[jumlahAlatTulis++] =
                new AlatTulisKantor(
                        "K002", "Stapler", 15000, 8,
                        "Plastik dan Besi", "Sedang");

        daftarAlatTulis[jumlahAlatTulis++] =
                new AlatTulisGambar(
                        "G001", "Pensil Warna", 12000, 15,
                        "Pensil Warna", "Merah");
    }

    public static void tambahData() {

        if (jumlahAlatTulis >= daftarAlatTulis.length) {
            System.out.println("Data alat tulis sudah penuh.");
            return;
        }

        System.out.println();
        System.out.println("=== TAMBAH DATA ALAT TULIS ===");
        System.out.println("1. Alat Tulis Sekolah");
        System.out.println("2. Alat Tulis Kantor");
        System.out.println("3. Alat Tulis Gambar");
        System.out.print("Pilih jenis: ");

        int jenis = scanner.nextInt();
        scanner.nextLine();

        if (jenis < 1 || jenis > 3) {
            System.out.println("Jenis tidak tersedia.");
            return;
        }

        System.out.print("Kode: ");
        String kode = scanner.nextLine();

        System.out.print("Nama: ");
        String nama = scanner.nextLine();

        System.out.print("Harga: ");
        double harga = scanner.nextDouble();

        System.out.print("Stok: ");
        int stok = scanner.nextInt();
        scanner.nextLine();

        if (harga < 0 || stok < 0) {
            System.out.println("Harga dan stok tidak boleh negatif.");
            return;
        }

        if (jenis == 1) {

            System.out.print("Jenis alat tulis: ");
            String jenisAlat = scanner.nextLine();

            System.out.print("Merek: ");
            String merek = scanner.nextLine();

            daftarAlatTulis[jumlahAlatTulis++] =
                    new AlatTulisSekolah(
                            kode, nama, harga, stok, jenisAlat, merek);

        } else if (jenis == 2) {

            System.out.print("Bahan: ");
            String bahan = scanner.nextLine();

            System.out.print("Ukuran: ");
            String ukuran = scanner.nextLine();

            daftarAlatTulis[jumlahAlatTulis++] =
                    new AlatTulisKantor(
                            kode, nama, harga, stok, bahan, ukuran);

        } else {

            System.out.print("Jenis alat gambar: ");
            String jenisGambar = scanner.nextLine();

            System.out.print("Warna: ");
            String warna = scanner.nextLine();

            daftarAlatTulis[jumlahAlatTulis++] =
                    new AlatTulisGambar(
                            kode, nama, harga, stok, jenisGambar, warna);
        }

        System.out.println("Data berhasil ditambahkan.");
    }

    public static void tampilkanData() {

        System.out.println();
        System.out.println("=== DAFTAR ALAT TULIS ===");

        for (int i = 0; i < jumlahAlatTulis; i++) {
            System.out.println();
            daftarAlatTulis[i].tampilkanInfo();
        }

        System.out.println("Total objek dibuat: "
                + AlatTulis.getTotalAlatTulis());
    }

    public static void menuPencarian() {

        System.out.println();
        System.out.println("=== PENCARIAN ALAT TULIS ===");
        System.out.println("1. Cari berdasarkan nama");
        System.out.println("2. Cari berdasarkan kode");
        System.out.print("Pilih: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        if (pilihan == 1) {
            System.out.print("Masukkan nama: ");
            cariAlatTulis(scanner.nextLine());

        } else if (pilihan == 2) {
            System.out.print("Masukkan kode: ");
            cariAlatTulis(scanner.nextLine(), true);

        } else {
            System.out.println("Pilihan tidak tersedia.");
        }
    }

    public static void cariAlatTulis(String nama) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahAlatTulis; i++) {

            if (daftarAlatTulis[i].getNama()
                    .equalsIgnoreCase(nama)) {

                System.out.println();
                daftarAlatTulis[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    public static void cariAlatTulis(
            String kode, boolean berdasarkanKode) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahAlatTulis; i++) {

            if (daftarAlatTulis[i].getKode()
                    .equalsIgnoreCase(kode)) {

                System.out.println();
                daftarAlatTulis[i].tampilkanInfo();
                ditemukan = true;
            }
        }

        if (!ditemukan) {
            System.out.println("Data tidak ditemukan.");
        }
    }

    public static void prosesAlatTulis(AlatTulis alat) {
        alat.tampilkanInfo();
    }

    public static void prosesData() {

        System.out.println();
        System.out.println("=== PROSES DATA ALAT TULIS ===");

        for (int i = 0; i < jumlahAlatTulis; i++) {
            System.out.println();
            System.out.println("Data ke-" + (i + 1));
            prosesAlatTulis(daftarAlatTulis[i]);
        }
    }

    public static void menuLayananAlatTulis() {

        System.out.println();
        System.out.println("=== LAYANAN ALAT TULIS ===");
        System.out.println("1. Hitung Nilai Stok");
        System.out.println("2. Pinjam Alat Tulis");
        System.out.println("3. Beri Rating");
        System.out.println("4. Kembali");
        System.out.print("Pilih menu: ");

        int pilihan = scanner.nextInt();
        scanner.nextLine();

        switch (pilihan) {
            case 1:
                hitungNilaiStok();
                break;
            case 2:
                pinjamAlatTulis();
                break;
            case 3:
                beriRatingAlatTulis();
                break;
            case 4:
                break;
            default:
                System.out.println("Pilihan tidak tersedia.");
        }
    }

    public static void hitungNilaiStok() {

        System.out.println();
        System.out.println("=== NILAI STOK ALAT TULIS ===");

        for (int i = 0; i < jumlahAlatTulis; i++) {

            AlatTulis alat = daftarAlatTulis[i];

            System.out.println("Nama: " + alat.getNama());
            System.out.println("Nilai stok: Rp"
                    + alat.hitungNilaiStok());
            System.out.println("--------------------------");
        }
    }

    public static void pinjamAlatTulis() {

        System.out.print("Masukkan kode alat tulis: ");
        String kode = scanner.nextLine();

        for (int i = 0; i < jumlahAlatTulis; i++) {

            if (daftarAlatTulis[i].getKode()
                    .equalsIgnoreCase(kode)) {

                if (daftarAlatTulis[i] instanceof DapatDipinjam) {

                    DapatDipinjam alat =
                            (DapatDipinjam) daftarAlatTulis[i];

                    alat.prosesPinjamFisik();

                } else {
                    System.out.println(
                            "Alat tulis ini tidak dapat dipinjam.");
                }

                return;
            }
        }

        System.out.println("Kode alat tulis tidak ditemukan.");
    }

    public static void beriRatingAlatTulis() {

        System.out.print("Masukkan kode alat tulis: ");
        String kode = scanner.nextLine();

        for (int i = 0; i < jumlahAlatTulis; i++) {

            if (daftarAlatTulis[i].getKode()
                    .equalsIgnoreCase(kode)) {

                if (daftarAlatTulis[i] instanceof DapatDinilai) {

                    System.out.print("Masukkan rating (1-5): ");
                    int bintang = scanner.nextInt();
                    scanner.nextLine();

                    DapatDinilai alat =
                            (DapatDinilai) daftarAlatTulis[i];

                    alat.beriRating(bintang);

                } else {
                    System.out.println(
                            "Alat tulis ini tidak mendukung rating.");
                }

                return;
            }
        }

        System.out.println("Kode alat tulis tidak ditemukan.");
    }
}