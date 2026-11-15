
package com.mycompany.sistemmanajemenalattulis;

import java.io.FileWriter;
import java.io.IOException;

public class TransaksiPeminjaman {

    public void prosesPeminjaman(Anggota anggota, AlatTulis alat) {

        System.out.println("\n=== TRANSAKSI PEMINJAMAN ===");

        if (anggota == null) {
            System.out.println("Transaksi gagal: anggota tidak ditemukan.");
            return;
        }

        if (alat == null) {
            System.out.println("Transaksi gagal: alat tulis tidak ditemukan.");
            return;
        }

        System.out.println("Nama Anggota : " + anggota.getNamaAnggota());
        System.out.println("ID Anggota   : " + anggota.getIdAnggota());
        System.out.println("Kode Alat    : " + alat.getKode());
        System.out.println("Nama Alat    : " + alat.getNama());
        System.out.println("Status       : Transaksi berhasil diproses.");

        try {
            FileWriter writer = new FileWriter("log_transaksi.txt", true);

            writer.write("Nama Anggota : " + anggota.getNamaAnggota() + "\n");
            writer.write("ID Anggota   : " + anggota.getIdAnggota() + "\n");
            writer.write("Kode Alat    : " + alat.getKode() + "\n");
            writer.write("Nama Alat    : " + alat.getNama() + "\n");
            writer.write("Status       : Berhasil\n");
            writer.write("-------------------------------\n");

            writer.close();

            System.out.println("Riwayat transaksi berhasil disimpan.");

        } catch (IOException e) {
            System.out.println("Gagal menyimpan transaksi: " + e.getMessage());
        }
    }
}
