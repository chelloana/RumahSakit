/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

public class datapembayaran {
    private Integer id_pembayaran;
    private Integer id_pendaftaran;
    private Integer id_pasien;
    private String nama_pasien;
    private String nama_dokter;
    private Integer harga_dokter;
    private Integer adminrs;
    private Integer total_biaya;
    private String jenis_dokter;
    private String jenis_tunjangan;

    public String getJenis_tunjangan() {
        return jenis_tunjangan;
    }

    public void setJenis_tunjangan(String jenis_tunjangan) {
        this.jenis_tunjangan = jenis_tunjangan;
    }

    public Integer getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(Integer id_pasien) {
        this.id_pasien = id_pasien;
    }

    public String getJenis_dokter() {
        return jenis_dokter;
    }

    public void setJenis_dokter(String jenis_dokter) {
        this.jenis_dokter = jenis_dokter;
    }

    public Integer getId_pembayaran() {
        return id_pembayaran;
    }

    public void setId_pembayaran(Integer id_pembayaran) {
        this.id_pembayaran = id_pembayaran;
    }

    public Integer getId_pendaftaran() {
        return id_pendaftaran;
    }

    public void setId_pendaftaran(Integer id_pendaftaran) {
        this.id_pendaftaran = id_pendaftaran;
    }

    public String getNama_pasien() {
        return nama_pasien;
    }

    public void setNama_pasien(String nama_pasien) {
        this.nama_pasien = nama_pasien;
    }

    public String getNama_dokter() {
        return nama_dokter;
    }

    public void setNama_dokter(String nama_dokter) {
        this.nama_dokter = nama_dokter;
    }

    public Integer getHarga_dokter() {
        return harga_dokter;
    }

    public void setHarga_dokter(Integer harga_dokter) {
        this.harga_dokter = harga_dokter;
    }

    public Integer getAdminrs() {
        return adminrs;
    }

    public void setAdminrs(Integer adminrs) {
        this.adminrs = adminrs;
    }

    public Integer getTotal_biaya() {
        return total_biaya;
    }

    public void setTotal_biaya(Integer total_biaya) {
        this.total_biaya = total_biaya;
    }
    
    
}
