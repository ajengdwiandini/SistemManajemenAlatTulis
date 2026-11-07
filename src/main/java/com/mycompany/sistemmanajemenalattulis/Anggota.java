
package com.mycompany.sistemmanajemenalattulis;

public class Anggota {

    private String idAnggota;
    private String namaAnggota;

    public Anggota(String idAnggota, String namaAnggota) {
        this.idAnggota = idAnggota;
        this.namaAnggota = namaAnggota;
    }

    public String getIdAnggota() {
        return idAnggota;
    }

    public String getNamaAnggota() {
        return namaAnggota;
    }

    public void tampilkanInformasi() {
        System.out.println("ID Anggota: " + idAnggota);
        System.out.println("Nama Anggota: " + namaAnggota);
    }
}
