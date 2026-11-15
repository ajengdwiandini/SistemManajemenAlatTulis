
package com.mycompany.sistemmanajemenalattulis;

import java.util.ArrayList;
import java.util.HashMap;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class TokoAlatTulis {

    private ArrayList<AlatTulis> daftarAlatTulis;
    private HashMap<String, Anggota> dataAnggota;
    private RuangPenyimpanan ruangPenyimpanan;

    public TokoAlatTulis() {
        daftarAlatTulis = new ArrayList<>();
        dataAnggota = new HashMap<>();

        ruangPenyimpanan = new RuangPenyimpanan(
            "Ruang Penyimpanan Alat Tulis", 100
        );
    }

    public void tambahAlatTulis(AlatTulis alat) {
        daftarAlatTulis.add(alat);
        System.out.println("Alat tulis berhasil ditambahkan.");
    }

    public void tambahAnggota(Anggota anggota) {
        dataAnggota.put(anggota.getIdAnggota(), anggota);
        System.out.println("Anggota berhasil ditambahkan.");
    }

    public Anggota cariAnggota(String id) {
        return dataAnggota.get(id);
    }

    public AlatTulis cariAlatTulis(String kode)
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

    public AlatTulis cariAlatTulis(String nama, boolean berdasarkanNama) {
        if (berdasarkanNama) {
            for (AlatTulis alat : daftarAlatTulis) {
                if (alat.getNama().equalsIgnoreCase(nama)) {
                    return alat;
                }
            }
        }
        return null;
    }

    public ArrayList<AlatTulis> getDaftarAlatTulis() {
        return daftarAlatTulis;
    }

    public void tampilkanSemuaAlatTulis() {
        System.out.println("\n=== SELURUH DATA ALAT TULIS ===");

        if (daftarAlatTulis.isEmpty()) {
            System.out.println("Belum ada data alat tulis.");
            return;
        }

        for (AlatTulis alat : daftarAlatTulis) {
            alat.tampilkanInfo();
            System.out.println("-------------------------------");
        }

        System.out.println("Jumlah data: " + daftarAlatTulis.size());
    }

    public void tampilkanSemuaAnggota() {
        System.out.println("\n=== DAFTAR ANGGOTA ===");

        if (dataAnggota.isEmpty()) {
            System.out.println("Belum ada data anggota.");
            return;
        }

        for (Anggota anggota : dataAnggota.values()) {
            anggota.tampilkanInformasi();
            System.out.println("--------------------");
        }
    }

    public void tampilkanRuangPenyimpanan() {
        System.out.println("\n=== INFORMASI RUANG PENYIMPANAN ===");
        ruangPenyimpanan.tampilkanInformasi();
    }

    public void simpanDataKeFile() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(
                new FileOutputStream("data_alat_tulis.dat")
            );

            output.writeObject(daftarAlatTulis);
            output.writeObject(dataAnggota);
            output.close();

            System.out.println("Data berhasil disimpan ke file.");
        } catch (IOException e) {
            System.out.println("Gagal menyimpan data: " + e.getMessage());
        }
    }

    @SuppressWarnings("unchecked")
    public boolean muatDataDariFile() {
        File file = new File("data_alat_tulis.dat");

        if (!file.exists()) {
            System.out.println("Belum ada data tersimpan.");
            return false;
        }

        try {
            ObjectInputStream input = new ObjectInputStream(
                new FileInputStream(file)
            );

            daftarAlatTulis = (ArrayList<AlatTulis>) input.readObject();
            dataAnggota = (HashMap<String, Anggota>) input.readObject();

            input.close();

            System.out.println("Data berhasil dimuat dari file.");
            return true;

        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
            return false;
        }
    }

    public void bacaLogTransaksi() {
        File file = new File("log_transaksi.txt");

        System.out.println("\n=== RIWAYAT TRANSAKSI ===");

        if (!file.exists()) {
            System.out.println("Belum ada riwayat transaksi.");
            return;
        }

        try {
            Scanner pembaca = new Scanner(file);

            while (pembaca.hasNextLine()) {
                System.out.println(pembaca.nextLine());
            }

            pembaca.close();

        } catch (IOException e) {
            System.out.println("Gagal membaca log: " + e.getMessage());
        }
    }
}
