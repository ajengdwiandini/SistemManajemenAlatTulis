
package com.mycompany.sistemmanajemenalattulis;

import java.util.Scanner;
import java.util.InputMismatchException;

public class SistemManajemenAlatTulis {

    private static final Scanner input = new Scanner(System.in);

    private static final TokoAlatTulis toko = new TokoAlatTulis();

    private static final TransaksiPeminjaman transaksi =
        new TransaksiPeminjaman();

    public static void main(String[] args) {

        toko.tambahAlatTulis(
            new AlatTulisSekolah("S001", "Pensil", 3000, "SD")
        );

        toko.tambahAlatTulis(
            new AlatTulisSekolah("S002", "Buku Tulis", 5000, "SMP")
        );

        toko.tambahAlatTulis(
            new AlatTulisKantor("K001", "Pulpen Kantor", 4000, "Administrasi")
        );

        toko.tambahAlatTulis(
            new AlatTulisKantor("K002", "Map Folder", 7000, "Arsip")
        );

        toko.tambahAlatTulis(
            new AlatTulisGambar("G001", "Pensil Warna", 15000, "Mewarnai")
        );

        toko.tambahAnggota(new Anggota("A001", "Andi"));
        toko.tambahAnggota(new Anggota("A002", "Siti"));
        toko.tambahAnggota(new Anggota("A003", "Budi"));

        int pilihan = -1;

        do {
            System.out.println("\n================================");
            System.out.println(" SISTEM MANAJEMEN ALAT TULIS");
            System.out.println("================================");
            System.out.println("1. Tampilkan seluruh data");
            System.out.println("2. Cari alat tulis");
            System.out.println("3. Proses interface");
            System.out.println("4. Proses polymorphism");
            System.out.println("5. Kelola data anggota");
            System.out.println("6. Proses transaksi peminjaman");
            System.out.println("7. Informasi ruang penyimpanan");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            try {
                pilihan = input.nextInt();
                input.nextLine();

            } catch (InputMismatchException e) {
                System.out.println("Input salah! Masukkan angka menu.");
                input.nextLine();
                pilihan = -1;

            } finally {
                System.out.println("Pemeriksaan input menu selesai.");
            }

            switch (pilihan) {
                case 1:
                    toko.tampilkanSemuaAlatTulis();
                    break;

                case 2:
                    menuPencarian();
                    break;

                case 3:
                    prosesInterface();
                    break;

                case 4:
                    prosesPolymorphism();
                    break;

                case 5:
                    menuAnggota();
                    break;

                case 6:
                    menuTransaksi();
                    break;

                case 7:
                    toko.tampilkanRuangPenyimpanan();
                    break;

                case 0:
                    System.out.println("Program selesai.");
                    break;

                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

        } while (pilihan != 0);
    }

    private static void menuPencarian() {
        try {
            System.out.print("Masukkan kode alat tulis: ");
            String kode = input.nextLine();

            AlatTulis hasil = toko.cariAlatTulis(kode);

            System.out.println("Data ditemukan:");
            hasil.tampilkanInfo();

        } catch (AlatTulisTidakDitemukanException e) {
            System.out.println("Kesalahan pencarian: " + e.getMessage());

        } finally {
            System.out.println("Proses pencarian selesai.");
        }
    }

    private static void prosesInterface() {
        System.out.println("\n--- PROSES INTERFACE ---");

        for (AlatTulis alat : toko.getDaftarAlatTulis()) {
            alat.tampilkanInfo();

            if (alat instanceof DapatDipinjam) {
                ((DapatDipinjam) alat).pinjam();
            }

            if (alat instanceof DapatDinilai) {
                ((DapatDinilai) alat).beriNilai();
            }

            System.out.println("-------------------------------");
        }
    }

    private static void prosesPolymorphism() {
        System.out.println("\n--- PROSES POLYMORPHISM ---");

        for (AlatTulis alat : toko.getDaftarAlatTulis()) {
            alat.tampilkanInfo();
            System.out.println("-------------------------------");
        }
    }

    private static void menuAnggota() {
        int pilihanAnggota = -1;

        do {
            System.out.println("\n=== MENU DATA ANGGOTA ===");
            System.out.println("1. Tambah anggota");
            System.out.println("2. Cari anggota");
            System.out.println("3. Tampilkan semua anggota");
            System.out.println("0. Kembali");
            System.out.print("Pilih menu: ");

            try {
                pilihanAnggota = Integer.parseInt(input.nextLine());

                switch (pilihanAnggota) {
                    case 1:
                        System.out.print("Masukkan kode anggota: ");
                        String kode = input.nextLine().trim();

                        System.out.print("Masukkan nama anggota: ");
                        String nama = input.nextLine().trim();

                        if (kode.isEmpty() || nama.isEmpty()) {
                            throw new IllegalArgumentException(
                                "Kode dan nama tidak boleh kosong!"
                            );
                        }

                        if (toko.cariAnggota(kode) != null) {
                            System.out.println("Kode anggota sudah digunakan.");
                        } else {
                            toko.tambahAnggota(new Anggota(kode, nama));
                        }
                        break;

                    case 2:
                        System.out.print("Masukkan kode anggota: ");
                        String cariKode = input.nextLine().trim();

                        Anggota anggota = toko.cariAnggota(cariKode);

                        if (anggota != null) {
                            System.out.println("Data anggota ditemukan:");
                            anggota.tampilkanInformasi();
                        } else {
                            System.out.println("Anggota tidak ditemukan.");
                        }
                        break;

                    case 3:
                        toko.tampilkanSemuaAnggota();
                        break;

                    case 0:
                        System.out.println("Kembali ke menu utama.");
                        break;

                    default:
                        System.out.println("Pilihan menu tidak tersedia.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Input harus berupa angka!");

            } catch (IllegalArgumentException e) {
                System.out.println("Kesalahan: " + e.getMessage());

            } finally {
                System.out.println("Pemeriksaan menu anggota selesai.");
            }

        } while (pilihanAnggota != 0);
    }

    private static void menuTransaksi() {
        try {
            System.out.println("\n=== TRANSAKSI PEMINJAMAN ===");

            System.out.print("Masukkan ID anggota: ");
            String idAnggota = input.nextLine().trim();

            Anggota anggota = toko.cariAnggota(idAnggota);

            if (anggota == null) {
                System.out.println("Anggota tidak ditemukan.");
                return;
            }

            System.out.print("Masukkan kode alat tulis: ");
            String kodeAlat = input.nextLine().trim();

            AlatTulis alat = toko.cariAlatTulis(kodeAlat);

            transaksi.prosesPeminjaman(anggota, alat);

        } catch (AlatTulisTidakDitemukanException e) {
            System.out.println("Transaksi gagal: " + e.getMessage());

        } finally {
            System.out.println("Proses transaksi selesai.");
        }
    }
}
