
package com.mycompany.sistemmanajemenalattulis;

public class AlatTulisSekolah extends AlatTulis
        implements DapatDipinjam, DapatDinilai {

    private String tingkat;

    public AlatTulisSekolah(String kode, String nama,
            double harga, String tingkat) {
        super(kode, nama, harga);
        this.tingkat = tingkat;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Kategori: Alat Tulis Sekolah");
        System.out.println("Kode: " + getKode());
        System.out.println("Nama: " + getNama());
        System.out.println("Tingkat: " + tingkat);
        tampilkanHarga();
    }

    @Override
    public void pinjam() {
        System.out.println(getNama()
                + " dapat dipinjam untuk kegiatan belajar.");
    }

    @Override
    public void beriNilai() {
        System.out.println("Penilaian alat tulis: " + getNama());
    }
}
