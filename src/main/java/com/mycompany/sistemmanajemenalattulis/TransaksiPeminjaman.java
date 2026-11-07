
package com.mycompany.sistemmanajemenalattulis;

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
    }
}
