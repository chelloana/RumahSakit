/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAOdatapasien.datapasienDAO;
import DAOimplementpasien.datapasienimplement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.*;
import view.vPasien;

public class datapasiencontroller {
    vPasien frame;
    datapasienimplement impldatapasien;
    List<datapasien> dp;

    public datapasiencontroller(vPasien frame) {
        this.frame = frame;
        impldatapasien = new datapasienDAO();
        dp = impldatapasien.getAll();
    }

    public void isitabel() {
        dp = impldatapasien.getAll();
        modeltabeldatapasien mp = new modeltabeldatapasien(dp);
        frame.getTabelpasien().setModel(mp);
    }

    public void insert() {
        datapasien dp = new datapasien();
        dp.setNama_pasien(frame.getTnamapasien().getText());
        dp.setTlp_pasien(frame.getTtlppasien().getText());

        // Konversi String menjadi Date
        Date tanggal = frame.getTtanggalpasien().getDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalText = format.format(tanggal);

        try {
            tanggal = format.parse(tanggalText);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dp.setTanggallahir_pasien(tanggal);

        dp.setAlamat_pasien(frame.getTalamatpasien().getText());
        dp.setPendaftaran_pasien(frame.getCbjenis().getSelectedItem().toString());
        impldatapasien.insert(dp);
    }

    public void update() {
        datapasien dp = new datapasien();
        dp.setNama_pasien(frame.getTnamapasien().getText());
        dp.setTlp_pasien(frame.getTtlppasien().getText());

        // Konversi String menjadi Date
        Date tanggal = frame.getTtanggalpasien().getDate();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String tanggalText = format.format(tanggal);

        try {
            tanggal = format.parse(tanggalText);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        dp.setTanggallahir_pasien(tanggal);

        dp.setAlamat_pasien(frame.getTalamatpasien().getText());
        dp.setPendaftaran_pasien(frame.getCbjenis().getSelectedItem().toString());
        dp.setId_pasien(Integer.parseInt(frame.getTidpasien().getText()));
        impldatapasien.update(dp);
    }

    public void delete() {
        int id = Integer.parseInt(frame.getTidpasien().getText());
        impldatapasien.delete(id);
    }
}
