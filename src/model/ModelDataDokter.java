/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
import java.util.Date;
import java.util.List;

public class ModelDataDokter {
    private int id_dokter;
    private String nama_dokter;
    private String tlp_dokter;
    private Date tanggallahir_dokter;
    private String alamat_dokter;
    private String jenis_dokter;
    private double harga_dokter;
    List<ModelDataDokter> listDokter;

    
    public List<ModelDataDokter> getListDokter() {
        return listDokter;
    }

    public void setListDokter(List<ModelDataDokter> listDokter) {
        this.listDokter = listDokter;
    }



    public int getIdDokter() {
        return id_dokter;
    }

    public void setIdDokter(int id_dokter) {
        this.id_dokter = id_dokter;
    }

    public String getNamaDokter() {
        return nama_dokter;
    }

    public void setNamaDokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public String getTlpDokter() {
        return tlp_dokter;
    }

    public void setTlpDokter(String tlp_dokter) {
        this.tlp_dokter = tlp_dokter;
    }

    public Date getTanggalLahirDokter() {
        return tanggallahir_dokter;
    }

    public void setTanggalLahirDokter(Date tanggallahir_dokter) {
        this.tanggallahir_dokter = tanggallahir_dokter;
    }

    public String getAlamatDokter() {
        return alamat_dokter;
    }

    public void setAlamatDokter(String alamat_dokter) {
        this.alamat_dokter = alamat_dokter;
    }

    public String getJenisDokter() {
        return jenis_dokter;
    }

    public void setJenisDokter(String jenis_dokter) {
        this.jenis_dokter = jenis_dokter;
    }

    public double getHargaDokter() {
        return harga_dokter;
    }

    public void setHargaDokter(double harga_dokter) {
        this.harga_dokter = harga_dokter;
    }
}