package com.mycompany.sistemmanajemenalattulis;

public class AlatTulisKantor extends AlatTulis
        implements DapatDipinjam, DapatDinilai {

    private String bahan;
    private String ukuran;

    public AlatTulisKantor(String kode, String nama, double harga,
            int stok, String bahan, String ukuran) {

        super(kode, nama, harga, stok);
        this.bahan = bahan;
        this.ukuran = ukuran;
    }

    public String getBahan() {
        return bahan;
    }

    public void setBahan(String bahan) {
        if (bahan != null && !bahan.isEmpty()) {
            this.bahan = bahan;
        } else {
            System.out.println("Bahan tidak boleh kosong.");
        }
    }

    public String getUkuran() {
        return ukuran;
    }

    public void setUkuran(String ukuran) {
        if (ukuran != null && !ukuran.isEmpty()) {
            this.ukuran = ukuran;
        } else {
            System.out.println("Ukuran tidak boleh kosong.");
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
            System.out.println("Alat tulis kantor berhasil dipinjam.");
        } else {
            System.out.println("Stok alat tulis habis.");
        }
    }

    @Override
    public void beriRating(int bintang) {

        if (bintang >= 1 && bintang <= 5) {
            System.out.println("Rating alat tulis kantor: "
                    + bintang + "/5");
        } else {
            System.out.println("Rating harus antara 1 sampai 5.");
        }
    }

    @Override
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bahan  : " + bahan);
        System.out.println("Ukuran : " + ukuran);
        System.out.println("--------------------------------");
    }
}