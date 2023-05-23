/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ACER
 */
import DAORiwayat.DataRiwayatDAO;

import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JOptionPane;

import model.ModelDataRiwayat;
import model.ModelTabelDataRiwayat;
import view.vRiwayat;

public class DataRiwayatController {
    private final vRiwayat view;
    private final DataRiwayatDAO dao = new DataRiwayatDAO();

    public DataRiwayatController(vRiwayat view){
        this.view = view;
    }

    public void insert() {
        if (
            view.getjTADiagnosa().getText().trim().isEmpty() ||
            view.getjTAResep().getText().trim().isEmpty()
        ){JOptionPane.showMessageDialog(view, "Data riwayat tidak boleh kosong!");
        } else if(view.getjTFIDRiwayat().getText().isEmpty() == false){
            if(cekDuplikatID(Integer.parseInt(view.getjTFIDRiwayat().getText())) == true){
            JOptionPane.showMessageDialog(view, "ID riwayat sudah ada!");}
        } else
        {
            ModelDataRiwayat riwayat = new ModelDataRiwayat();
            riwayat.setId_pasien(view.getIDPasien());
            riwayat.setId_dokter(view.getId_Dokter());
            riwayat.setId_pendaftaran(view.getId_Daftar());
            riwayat.setDiagnosa(view.getjTADiagnosa().getText());
            riwayat.setObat(view.getjTAResep().getText());
            riwayat.setTgl_daftar(view.getTgl_daftar());

            dao.insert(riwayat);
            JOptionPane.showMessageDialog(view, "Data riwayat berhasil ditambahkan!");
        }
    }
    
    public void update() {
        if (
            view.getjTFIDRiwayat().getText().trim().isEmpty() ||
            view.getjTADiagnosa().getText().trim().isEmpty() ||
            view.getjTAResep().getText().trim().isEmpty()
        ){JOptionPane.showMessageDialog(view, "Data riwayat tidak boleh kosong!");
        } else {
            ModelDataRiwayat riwayat = new ModelDataRiwayat();
            riwayat.setId_riwayat(Integer.parseInt(view.getjTFIDRiwayat().getText()));
            riwayat.setId_pasien(view.getIDPasien());
            riwayat.setId_dokter(view.getId_Dokter());
            riwayat.setId_pendaftaran(view.getId_Daftar());
            riwayat.setDiagnosa(view.getjTADiagnosa().getText());
            riwayat.setObat(view.getjTAResep().getText());
            riwayat.setTgl_daftar(view.getTgl_daftar());

            dao.update(riwayat);
            JOptionPane.showMessageDialog(view, "Data riwayat berhasil diubah!");
        }
    }

    public void delete() {
        if (view.getjTFIDRiwayat().getText().trim().isEmpty()){
            JOptionPane.showMessageDialog(view, "ID riwayat tidak boleh kosong!");
        } else {
            int id = Integer.parseInt(view.getjTFIDRiwayat().getText());
            dao.delete(id);
            JOptionPane.showMessageDialog(view, "Data riwayat berhasil dihapus!");
        }
    }


    public void getDataRiwayatByID(int id){
        ModelDataRiwayat riwayat = dao.getAll().stream()
                .filter(x -> x.getId_riwayat() == id)
                .findFirst()
                .get();
        
        view.getjTFIDRiwayat().setText(String.valueOf(riwayat.getId_riwayat()));
        view.getjTADiagnosa().setText(riwayat.getDiagnosa());
        view.getjTAResep().setText(riwayat.getObat());
    }

    public void isitabelByID(int id){
        List<ModelDataRiwayat> list = dao.getAllById(id);
        ModelTabelDataRiwayat mtbr = new ModelTabelDataRiwayat((ArrayList<ModelDataRiwayat>) list);
        view.getjTable().setModel(mtbr);
    }

    public void isitabel(){
        List<ModelDataRiwayat> list = dao.getAll();
        ModelTabelDataRiwayat mtbr = new ModelTabelDataRiwayat((ArrayList<ModelDataRiwayat>) list);
        view.getjTable().setModel(mtbr);
    }

    public boolean cekDuplikatID(int id){
        boolean hasil = false;
        List<ModelDataRiwayat> list = dao.getAllById(id);
        for (ModelDataRiwayat riwayat : list) {
            if (riwayat.getId_riwayat() == id) {
                hasil = true;
                break;
            }
        }
        return hasil;
    }
}
