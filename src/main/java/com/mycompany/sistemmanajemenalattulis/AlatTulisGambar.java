package com.mycompany.sistemmanajemenalattulis;

public class AlatTulisGambar extends AlatTulis
        implements DapatDinilai {

    private String jenis;
    private String warna;

    public AlatTulisGambar(String kode, String nama, double harga,
            int stok, String jenis, String warna) {

        super(kode, nama, harga, stok);
        this.jenis = jenis;
        this.warna = warna;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        this.jenis = jenis;
    }

    public String getWarna() {
        return warna;
    }

    public void setWarna(String warna) {
        this.warna = warna;
    }

    @Override
    public double hitungNilaiStok() {
        return getHarga() * getStok();
    }

    @Override
    public void beriRating(int bintang) {

        if (bintang >= 1 && bintang <= 5) {
            System.out.println("Rating alat tulis gambar: "
                    + bintang + "/5");
        } else {
            System.out.println("Rating harus antara 1 sampai 5.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis : " + jenis);
        System.out.println("Warna : " + warna);
        System.out.println("--------------------------------");
    }
}