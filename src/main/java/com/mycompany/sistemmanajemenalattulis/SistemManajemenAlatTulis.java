package com.mycompany.sistemmanajemenalattulis;

import java.util.Scanner;

public class SistemManajemenAlatTulis {

    private static Scanner scanner = new Scanner(System.in);
    private static AlatTulis[] daftarAlatTulis = new AlatTulis[10];
    private static int jumlahAlatTulis = 0;
    private static boolean isRunning = true;

    public static void main(String[] args) {

        System.out.println("==============================================");
        System.out.println("       SISTEM MANAJEMEN ALAT TULIS");
        System.out.println("==============================================");

        while (isRunning) {

            System.out.println();
            System.out.println("Menu:");
            System.out.println("1. Tambah Data Baru");
            System.out.println("2. Tampilkan Seluruh Data");
            System.out.println("3. Pencarian / Aksi Khusus");
            System.out.println("4. Keluar");
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
                    isRunning = false;
                    System.out.println();
                    System.out.println("Terima kasih telah menggunakan program.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }
        }

        scanner.close();
    }

    public static void tambahData() {

        if (jumlahAlatTulis < daftarAlatTulis.length) {

            System.out.println();
            System.out.println("=== TAMBAH DATA ALAT TULIS ===");

            System.out.println("1. Alat Tulis Sekolah");
            System.out.println("2. Alat Tulis Kantor");
            System.out.print("Pilih jenis: ");

            int jenis = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Kode: ");
            String kode = scanner.nextLine();

            System.out.print("Nama: ");
            String nama = scanner.nextLine();

            System.out.print("Harga: ");
            double harga = scanner.nextDouble();

            System.out.print("Stok: ");
            int stok = scanner.nextInt();
            scanner.nextLine();

            if (jenis == 1) {

                System.out.print("Jenis alat tulis: ");
                String jenisAlat = scanner.nextLine();

                System.out.print("Merek: ");
                String merek = scanner.nextLine();

                daftarAlatTulis[jumlahAlatTulis] =
                        new AlatTulisSekolah(
                                kode, nama, harga, stok,
                                jenisAlat, merek);

                jumlahAlatTulis++;

                System.out.println("Data berhasil ditambahkan.");

            } else if (jenis == 2) {

                System.out.print("Bahan: ");
                String bahan = scanner.nextLine();

                System.out.print("Ukuran: ");
                String ukuran = scanner.nextLine();

                daftarAlatTulis[jumlahAlatTulis] =
                        new AlatTulisKantor(
                                kode, nama, harga, stok,
                                bahan, ukuran);

                jumlahAlatTulis++;

                System.out.println("Data berhasil ditambahkan.");

            } else {

                System.out.println("Jenis alat tulis tidak tersedia.");
            }

        } else {

            System.out.println("Data alat tulis sudah penuh.");
        }
    }

    public static void tampilkanData() {

        System.out.println();
        System.out.println("=== DAFTAR ALAT TULIS ===");

        if (jumlahAlatTulis == 0) {

            System.out.println("Belum ada data alat tulis.");

        } else {

            for (int i = 0; i < jumlahAlatTulis; i++) {

                System.out.println();
                daftarAlatTulis[i].tampilkanInfo();
            }

            System.out.println("---------------------------------------------");
            System.out.println("Total objek dibuat: "
                    + AlatTulis.getTotalAlatTulis());
        }
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

            System.out.print("Masukkan nama alat tulis: ");
            String nama = scanner.nextLine();

            cariAlatTulis(nama);

        } else if (pilihan == 2) {

            System.out.print("Masukkan kode alat tulis: ");
            String kode = scanner.nextLine();

            cariAlatTulis(kode, true);

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
                System.out.println("Data ditemukan:");
                daftarAlatTulis[i].tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println("Data tidak ditemukan.");
        }
    }

    public static void cariAlatTulis(String kode,
            boolean berdasarkanKode) {

        boolean ditemukan = false;

        for (int i = 0; i < jumlahAlatTulis; i++) {

            if (daftarAlatTulis[i].getKode()
                    .equalsIgnoreCase(kode)) {

                System.out.println();
                System.out.println("Data ditemukan:");
                daftarAlatTulis[i].tampilkanInfo();

                ditemukan = true;
            }
        }

        if (!ditemukan) {

            System.out.println("Data tidak ditemukan.");
        }
    }
}