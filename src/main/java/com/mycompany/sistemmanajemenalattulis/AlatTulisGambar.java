
package com.mycompany.sistemmanajemenalattulis;

public class AlatTulisGambar extends AlatTulis
        implements DapatDipinjam {

    private String jenisGambar;

    public AlatTulisGambar(String kode, String nama,
            double harga, String jenisGambar) {
        super(kode, nama, harga);
        this.jenisGambar = jenisGambar;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Kategori: Alat Tulis Gambar");
        System.out.println("Kode: " + getKode());
        System.out.println("Nama: " + getNama());
        System.out.println("Jenis gambar: " + jenisGambar);
        tampilkanHarga();
    }

    @Override
    public void pinjam() {
        System.out.println(getNama()
                + " dapat dipinjam untuk kegiatan menggambar.");
    }
}
