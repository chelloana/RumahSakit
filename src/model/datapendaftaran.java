/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import java.sql.Date;

public class datapendaftaran {
    private Integer id_pendaftaran;
    private Integer id_pasien;
    private Integer id_dokter;
    private String nama_pasien;
    private String jenis_dokter;
    private String nama_dokter;
    private String pendaftaran_pasien;
    private Date tanggal_pendaftaran;


    public Date getTanggal_pendaftaran() {
        return tanggal_pendaftaran;
    }

    public void setTanggal_pendaftaran(Date tanggal_pendaftaran) {
        this.tanggal_pendaftaran = tanggal_pendaftaran;
    }

    public Integer getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(Integer id_dokter) {
        this.id_dokter = id_dokter;
    }
    
    

    public Integer getId_pendaftaran() {
        return id_pendaftaran;
    }

    public void setId_pendaftaran(Integer id_pendaftaran) {
        this.id_pendaftaran = id_pendaftaran;
    }

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

    public String getJenis_dokter() {
        return jenis_dokter;
    }

    public void setJenis_dokter(String jenis_dokter) {
        this.jenis_dokter = jenis_dokter;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getPendaftaran_pasien() {
        return pendaftaran_pasien;
    }

    public void setPendaftaran_pasien(String pendaftaran_pasien) {
        this.pendaftaran_pasien = pendaftaran_pasien;
    }
    
    
}
