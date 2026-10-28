
package com.mycompany.sistemmanajemenalattulis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.InputMismatchException;

public class SistemManajemenAlatTulis {

    private static final Scanner input = new Scanner(System.in);

    private static final ArrayList<AlatTulis> daftarAlatTulis =
        new ArrayList<>();
    private static final HashMap<String, String> dataAnggota =
        new HashMap<>();

static {
    daftarAlatTulis.add(
        new AlatTulisSekolah("S001", "Pensil", 3000, "SD")
    );
    daftarAlatTulis.add(
        new AlatTulisSekolah("S002", "Buku Tulis", 5000, "SMP")
    );
    daftarAlatTulis.add(
        new AlatTulisKantor("K001", "Pulpen Kantor", 4000, "Administrasi")
    );
    daftarAlatTulis.add(
        new AlatTulisKantor("K002", "Map Folder", 7000, "Arsip")
    );
    daftarAlatTulis.add(
        new AlatTulisGambar("G001", "Pensil Warna", 15000, "Mewarnai")
    );
    
    dataAnggota.put("A001", "Andi");
    dataAnggota.put("A002", "Siti");
    dataAnggota.put("A003", "Budi");
}

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
            System.out.println("5. Kelola data anggota");
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
                case 5:
                    menuAnggota();
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

    if (daftarAlatTulis.isEmpty()) {
        System.out.println("Belum ada data alat tulis.");
        return;
    }

    for (int i = 0; i < daftarAlatTulis.size(); i++) {
        AlatTulis alat = daftarAlatTulis.get(i);
        alat.tampilkanInfo();
        System.out.println("-------------------------------");
    }

    System.out.println("Jumlah data: " + daftarAlatTulis.size());
}


    // Pencarian berdasarkan kode.
    
private static AlatTulis cariAlatTulis(String kode)
        throws AlatTulisTidakDitemukanException {

    if (kode == null || kode.trim().isEmpty()) {
        throw new AlatTulisTidakDitemukanException(
            "Kode alat tulis tidak boleh kosong!"
        );
    }

    for (AlatTulis alat : daftarAlatTulis) {
        if (alat.getKode().equalsIgnoreCase(kode.trim())) {
            return alat;
        }
    }

    throw new AlatTulisTidakDitemukanException(
        "Alat tulis dengan kode " + kode + " tidak ditemukan!"
    );
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
    try {
        System.out.print("Masukkan kode alat tulis: ");
        String kode = input.nextLine();

        AlatTulis hasil = cariAlatTulis(kode);

        System.out.println("Data ditemukan:");
        hasil.tampilkanInfo();

    } catch (AlatTulisTidakDitemukanException e) {
        System.out.println("Kesalahan pencarian: " + e.getMessage());

    } finally {
        System.out.println("Proses pencarian selesai.");
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

                    if (dataAnggota.containsKey(kode)) {
                        System.out.println(
                            "Kode anggota sudah digunakan!"
                        );
                    } else {
                        dataAnggota.put(kode, nama);
                        System.out.println(
                            "Anggota berhasil ditambahkan."
                        );
                    }
                    break;

                case 2:
                    System.out.print("Masukkan kode anggota: ");
                    String cariKode = input.nextLine().trim();

                    if (dataAnggota.containsKey(cariKode)) {
                        System.out.println(
                            "Nama anggota: " + dataAnggota.get(cariKode)
                        );
                    } else {
                        System.out.println("Anggota tidak ditemukan.");
                    }
                    break;

                case 3:
                    if (dataAnggota.isEmpty()) {
                        System.out.println("Belum ada data anggota.");
                    } else {
                        for (String id : dataAnggota.keySet()) {
                            System.out.println(
                                id + " - " + dataAnggota.get(id)
                            );
                        }
                    }
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
            System.out.println(
                "Pemeriksaan menu anggota selesai."
            );
        }

    } while (pilihanAnggota != 0);
}
}