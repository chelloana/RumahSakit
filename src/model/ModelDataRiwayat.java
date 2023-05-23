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

public class ModelDataRiwayat {
    private int id_dokter;

    public int getId_dokter() {
        return id_dokter;
    }

    public void setId_dokter(int id_dokter) {
        this.id_dokter = id_dokter;
    }


    private int id_pendaftaran;

    public int getId_pendaftaran() {
        return id_pendaftaran;
    }

    public void setId_pendaftaran(int id_pendaftaran) {
        this.id_pendaftaran = id_pendaftaran;
    }


    private int id_pasien;

    public int getId_pasien() {
        return id_pasien;
    }

    public void setId_pasien(int id_pasien) {
        this.id_pasien = id_pasien;
    }


    private int id_Riwayat;

    public int getId_riwayat() {
        return id_Riwayat;
    }

    public void setId_riwayat(int id_riwayat) {
        this.id_Riwayat = id_riwayat;
    }


    private String Diagnosa;

    public String getDiagnosa() {
        return Diagnosa;
    }

    public void setDiagnosa(String diagnosa) {
        Diagnosa = diagnosa;
    }


    private String Obat;

    public String getObat() {
        return Obat;
    }

    public void setObat(String obat) {
        Obat = obat;
    }


    private Date tgl_daftar;

    public Date getTgl_daftar() {
        return tgl_daftar;
    }

    public void setTgl_daftar(Date tgl_daftar) {
        this.tgl_daftar = tgl_daftar;
    }
}
