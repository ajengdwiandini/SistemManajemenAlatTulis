/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemmanajemenalattulis;

/**
 *
 * @author user
 */
public class AlatTulisSekolah extends AlatTulis {
    
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
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Jenis : " + jenis);
        System.out.println("Merek : " + merek);
        System.out.println("--------------------------------");
    }
}
