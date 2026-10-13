
package com.mycompany.sistemmanajemenalattulis;

import java.util.Scanner;

public class SistemManajemenAlatTulis {

    private static final Scanner input = new Scanner(System.in);

    private static final AlatTulis[] daftarAlatTulis = {
        new AlatTulisSekolah("S001", "Pensil", 3000, "SD"),
        new AlatTulisSekolah("S002", "Buku Tulis", 5000, "SMP"),
        new AlatTulisKantor("K001", "Pulpen Kantor", 4000, "Administrasi"),
        new AlatTulisKantor("K002", "Map Folder", 7000, "Arsip"),
        new AlatTulisGambar("G001", "Pensil Warna", 15000, "Mewarnai")
    };

    public static void main(String[] args) {
        int pilihan;

        do {
            System.out.println("================================");
            System.out.println(" SISTEM MANAJEMEN ALAT TULIS");
            System.out.println("================================");
            System.out.println("1. Tampilkan seluruh data");
            System.out.println("2. Cari alat tulis");
            System.out.println("3. Proses interface");
            System.out.println("4. Proses polymorphism");
            System.out.println("0. Keluar");
            System.out.print("Pilih menu: ");

            while (!input.hasNextInt()) {
                System.out.print("Masukkan angka: ");
                input.next();
            }

            pilihan = input.nextInt();
            input.nextLine();

            switch (pilihan) {
                case 1:
                    tampilkanSemuaData();
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
                case 0:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Pilihan tidak tersedia.");
            }

            System.out.println();
        } while (pilihan != 0);
    }

    private static void tampilkanSemuaData() {
        System.out.println("--- SELURUH DATA ALAT TULIS ---");

        for (AlatTulis alat : daftarAlatTulis) {
            alat.tampilkanInfo();
            System.out.println("-------------------------------");
        }
    }

    // Pencarian berdasarkan kode.
    private static AlatTulis cariAlatTulis(String kode) {
        for (AlatTulis alat : daftarAlatTulis) {
            if (alat.getKode().equalsIgnoreCase(kode)) {
                return alat;
            }
        }
        return null;
    }

    // Overloading: pencarian berdasarkan nama.
    private static AlatTulis cariAlatTulis(
            String nama, boolean berdasarkanNama) {

        if (berdasarkanNama) {
            for (AlatTulis alat : daftarAlatTulis) {
                if (alat.getNama().equalsIgnoreCase(nama)) {
                    return alat;
                }
            }
        }
        return null;
    }

    private static void menuPencarian() {
        System.out.println("Cari berdasarkan:");
        System.out.println("1. Kode");
        System.out.println("2. Nama");
        System.out.print("Pilihan: ");

        String jenis = input.nextLine();
        AlatTulis hasil;

        if (jenis.equals("1")) {
            System.out.print("Masukkan kode: ");
            hasil = cariAlatTulis(input.nextLine());
        } else if (jenis.equals("2")) {
            System.out.print("Masukkan nama: ");
            hasil = cariAlatTulis(input.nextLine(), true);
        } else {
            System.out.println("Pilihan pencarian tidak tersedia.");
            return;
        }

        if (hasil != null) {
            System.out.println("Data ditemukan:");
            hasil.tampilkanInfo();
        } else {
            System.out.println("Data tidak ditemukan.");
        }
    }

    private static void prosesInterface() {
        System.out.println("--- PROSES INTERFACE ---");

        for (AlatTulis alat : daftarAlatTulis) {
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
        System.out.println("--- PROSES POLYMORPHISM ---");

        for (AlatTulis alat : daftarAlatTulis) {
            alat.tampilkanInfo();
        }
    }
}
