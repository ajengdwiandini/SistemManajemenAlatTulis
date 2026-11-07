
package com.mycompany.sistemmanajemenalattulis;

import java.util.ArrayList;
import java.util.HashMap;

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
}
