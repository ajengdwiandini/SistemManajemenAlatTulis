package com.mycompany.sistemmanajemenalattulis;

public class AlatTulisSekolah extends AlatTulis
        implements DapatDipinjam, DapatDinilai {

    private String jenis;
    private String merek;

    public AlatTulisSekolah(String kode, String nama, double harga,
            int stok, String jenis, String merek) {

        super(kode, nama, harga, stok);
        this.jenis = jenis;
        this.merek = merek;
    }

    public String getJenis() {
        return jenis;
    }

    public void setJenis(String jenis) {
        if (jenis != null && !jenis.isEmpty()) {
            this.jenis = jenis;
        } else {
            System.out.println("Jenis tidak boleh kosong.");
        }
    }

    public String getMerek() {
        return merek;
    }

    public void setMerek(String merek) {
        if (merek != null && !merek.isEmpty()) {
            this.merek = merek;
        } else {
            System.out.println("Merek tidak boleh kosong.");
        }
    }

    @Override
    public double hitungNilaiStok() {
        return getHarga() * getStok();
    }

    @Override
    public void prosesPinjamFisik() {

        if (getStok() > 0) {
            setStok(getStok() - 1);
            System.out.println("Alat tulis berhasil dipinjam.");
        } else {
            System.out.println("Stok alat tulis habis.");
        }
    }

    @Override
    public void beriRating(int bintang) {

        if (bintang >= 1 && bintang <= 5) {
            System.out.println("Rating alat tulis sekolah: "
                    + bintang + "/5");
        } else {
            System.out.println("Rating harus antara 1 sampai 5.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis : " + jenis);
        System.out.println("Merek : " + merek);
        System.out.println("--------------------------------");
    }
}