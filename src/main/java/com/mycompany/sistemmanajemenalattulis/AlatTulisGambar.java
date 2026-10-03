/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemmanajemenalattulis;

public class AlatTulisGambar extends AlatTulis {

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
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis : " + jenis);
        System.out.println("Warna : " + warna);
        System.out.println("--------------------------------");
    }
}
