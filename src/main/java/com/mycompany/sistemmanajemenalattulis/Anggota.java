
package com.mycompany.sistemmanajemenalattulis;

import java.io.Serializable;

public class Anggota implements Serializable {

    private static final long serialVersionUID = 1L;

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
