/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ACER
 */
import DAOAkun.DataAkunDAO;
import DAOImplementasiAkun.DataAkunIntf;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import model.ModelDataAkun;
import model.ModelTabelDataAkun;
import view.vAkun;

public class DataAkunController {
    private final vAkun view;
    private final DataAkunIntf dao = new DataAkunDAO();

    public DataAkunController(vAkun view){
        this.view = view;
    }



    public void insert() {
        if (view.getjTFUsername().getText().trim().isEmpty() ||
            view.getjTFPassword().getText().trim().isEmpty() ||
            view.getPosisi().getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data Akun tidak boleh kosong!");
        } else {
            ModelDataAkun akun = new ModelDataAkun();

            akun.setUsername(view.getjTFUsername().getText());
            akun.setPassword(view.getjTFPassword().getText());
            akun.setPosisi(view.getPosisi().getSelectedItem().toString());

            dao.insert(akun);
            JOptionPane.showMessageDialog(view, "Data Akun berhasil ditambahkan!");
        }
    }

    public void update() {
        if (view.getjTFID().getText().trim().isEmpty() ||
            view.getjTFUsername().getText().trim().isEmpty() ||
            view.getjTFPassword().getText().trim().isEmpty() ||
            view.getPosisi().getSelectedItem().toString().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data Akun tidak boleh kosong!");
        } else {
            ModelDataAkun akun = new ModelDataAkun();

            akun.setId(Integer.parseInt(view.getjTFID().getText()));
            akun.setUsername(view.getjTFUsername().getText());
            akun.setPassword(view.getjTFPassword().getText());
            akun.setPosisi(view.getPosisi().getSelectedItem().toString());

            dao.update(akun);
            JOptionPane.showMessageDialog(view, "Data Akun berhasil diubah!");
        }
    }

    public void delete() {
        int id = Integer.parseInt(view.getjTFID().getText());
        dao.delete(id);
        JOptionPane.showMessageDialog(view, "Data Akun berhasil dihapus!");
    }

    public void reset() {
        view.getjTFID().setText("");
        view.getjTFUsername().setText("");
        view.getjTFPassword().setText("");
        view.getPosisi().setSelectedItem("");
    }

    public void getDataAkunById(int id) {
        
        ModelDataAkun akun = dao.getAll().stream()
                                .filter(d -> d.getId() == id)
                                .findFirst()
                                .get();
        view.getjTFID().setText(Integer.toString(akun.getId()));
        view.getjTFUsername().setText(akun.getUsername());
        view.getjTFPassword().setText(akun.getPassword());
        view.getPosisi().setSelectedItem(akun.getPosisi());
    }

    public void fillTableDataAkun() {
        List<ModelDataAkun> dataAkun = dao.getAll();
        ModelTabelDataAkun model = new ModelTabelDataAkun((ArrayList<ModelDataAkun>) dataAkun);

        view.getjTable().setModel(model);
    }
}