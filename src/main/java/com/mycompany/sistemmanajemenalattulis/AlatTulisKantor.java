/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.sistemmanajemenalattulis;

/**
 *
 * @author user
 */
public class AlatTulisKantor extends AlatTulis {
    
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
    public void tampilkanInfo() {
        super.tampilkanInfo();
        System.out.println("Bahan       : " + bahan);
        System.out.println("Ukuran      : " + ukuran);
        System.out.println("---------------------------------------------");
    }
}
