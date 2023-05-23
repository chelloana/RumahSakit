/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class datapasien {
    private Integer id_pasien;
    private String nama_pasien;
    private String tlp_pasien;
    private String tanggallahir_pasien;
    private String alamat_pasien;
    private String pendaftaran_pasien;

    public Integer getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(Integer id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getTlp_pasien() {
        return tlp_pasien;
    }

    public void setTlp_pasien(String tlp_pasien) {
        this.tlp_pasien = tlp_pasien;
    }

    public String getTanggallahir_pasien() {
        return tanggallahir_pasien;
    }

    public void setTanggallahir_pasien(String tanggallahir_pasien) {
        this.tanggallahir_pasien = tanggallahir_pasien;
    }

    public String getAlamat_pasien() {
        return alamat_pasien;
    }

    public void setAlamat_pasien(String alamat_pasien) {
        this.alamat_pasien = alamat_pasien;
    }

    public String getPendaftaran_pasien() {
        return pendaftaran_pasien;
    }

    public void setPendaftaran_pasien(String pendaftaran_pasien) {
        this.pendaftaran_pasien = pendaftaran_pasien;
    }

    public void setTanggallahir_pasien(Date tanggal) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        this.tanggallahir_pasien = format.format(tanggal);
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }

    
}
