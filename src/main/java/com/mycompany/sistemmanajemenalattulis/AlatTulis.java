package com.mycompany.sistemmanajemenalattulis;

import java.io.Serializable;

public abstract class AlatTulis implements Serializable {

    private static final long serialVersionUID = 1L;

    private String kode;
    private String nama;
    private double harga;

    public AlatTulis(String kode, String nama, double harga) {
        this.kode = kode;
        this.nama = nama;
        this.harga = harga;
    }

    public String getKode() {
        return kode;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public abstract void tampilkanInfo();

    public void tampilkanHarga() {
        System.out.println("Harga: Rp" + harga);
    }
}
