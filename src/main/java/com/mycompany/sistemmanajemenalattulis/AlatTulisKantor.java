
package com.mycompany.sistemmanajemenalattulis;

public class AlatTulisKantor extends AlatTulis
        implements DapatDinilai {

    private String bagian;

    public AlatTulisKantor(String kode, String nama,
            double harga, String bagian) {
        super(kode, nama, harga);
        this.bagian = bagian;
    }

    @Override
    public void tampilkanInfo() {
        System.out.println("Kategori: Alat Tulis Kantor");
        System.out.println("Kode: " + getKode());
        System.out.println("Nama: " + getNama());
        System.out.println("Bagian: " + bagian);
        tampilkanHarga();
    }

    @Override
    public void beriNilai() {
        System.out.println(getNama()
                + " cocok untuk kebutuhan kantor.");
    }
}
