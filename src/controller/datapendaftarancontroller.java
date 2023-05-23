/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAOdatapasien.datapendaftaranDAO;
import DAOimplementpasien.datapasienimplement;
import DAOimplementpasien.datapendaftaranimplement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import model.*;
import view.vPendaftaran;
import javax.swing.JOptionPane;

public class datapendaftarancontroller {
    vPendaftaran frame;
    datapendaftaranimplement impldatapendaftaran;
    List<datapendaftaran> dp;
    
    public datapendaftarancontroller(vPendaftaran frame){
        this.frame = frame;
        impldatapendaftaran = new datapendaftaranDAO();
        dp = impldatapendaftaran.getAll();
    }
    
    public void isitabel(){
        dp = impldatapendaftaran.getAll();
        modeltabeldatapendaftaran mp = new modeltabeldatapendaftaran(dp);
        frame.getTabelPendaftaran().setModel(mp);
    }
    
    public void insert() {
        if (
            frame.getNamaPasien().getText().trim().isEmpty() 
        ){JOptionPane.showMessageDialog(frame, "Data riwayat tidak boleh kosong!");
        } else
        {
            datapendaftaran dp = new datapendaftaran();

            int selectedValueDokter = frame.getCbdokter().getSelectedIndex();
            int idDokter = frame.getIdDokterArray()[selectedValueDokter];
            dp.setId_dokter(idDokter);
            dp.setId_pasien(frame.getId_pasien());
            dp.setTanggal_pendaftaran(frame.getTanggalSekarang());

            impldatapendaftaran.insert(dp);
        }

    }

    
    public void delete(){
        int id = Integer.parseInt(frame.getIddaftar().getText());
        impldatapendaftaran.delete(id);
    }

    public void setOptionCBDokter(){
        int[] idDokter = new int[100];
        List<ModelDataDokter> list = impldatapendaftaran.getAllDokter();
        for (int i = 0; i < list.size(); i++) {
            frame.getCbdokter().addItem(String.valueOf(list.get(i).getNamaDokter() + " - " + list.get(i).getJenisDokter()));
            idDokter[i] = list.get(i).getIdDokter();
        }
        frame.setIdDokterArray(idDokter);
    }
    
}
