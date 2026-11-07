
package com.mycompany.sistemmanajemenalattulis;

public class RuangPenyimpanan {

    private String namaRuang;
    private int kapasitas;

    public RuangPenyimpanan(String namaRuang, int kapasitas) {
        this.namaRuang = namaRuang;
        this.kapasitas = kapasitas;
    }

    public void tampilkanInformasi() {
        System.out.println("Nama Ruang: " + namaRuang);
        System.out.println("Kapasitas: " + kapasitas + " alat tulis");
    }
}
