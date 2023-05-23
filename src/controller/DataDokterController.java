/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
/**
 *
 * @author ACER
 */
import DAODokter.DataDokterDAO;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import model.ModelDataDokter;
import model.ModelTabelDataDokter;
import view.vAdminPage;

public class DataDokterController {
    private final vAdminPage view;
    private final DataDokterDAO dao;

    public DataDokterController(vAdminPage view) {
        this.view = view;
        dao = new DataDokterDAO();
    }

    public void insert() {
        if (view.getjTFNama().getText().trim().isEmpty() ||
            view.getjTFNoTelp().getText().trim().isEmpty() ||
            view.getjDateChooserTanggalLahir().getDate().toString().isEmpty() ||
            view.getjTFAlamat().getText().trim().isEmpty() ||
            view.getjTFJenis().getText().trim().isEmpty() || 
            view.getjTFHarga().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data dokter tidak boleh kosong!");
        } else {
            ModelDataDokter dokter = new ModelDataDokter();

            dokter.setNamaDokter(view.getjTFNama().getText());
            dokter.setTlpDokter(view.getjTFNoTelp().getText());
            dokter.setTanggalLahirDokter(view.getjDateChooserTanggalLahir().getDate());
            dokter.setAlamatDokter(view.getjTFAlamat().getText());
            dokter.setJenisDokter(view.getjTFJenis().getText());
            dokter.setHargaDokter(Double.parseDouble(view.getjTFHarga().getText()));

            dao.insert(dokter);
            JOptionPane.showMessageDialog(view, "Data dokter berhasil ditambahkan!");
        }
    }

    public void update() {
        if (view.getjTFID().getText().trim().isEmpty() ||
            view.getjTFNama().getText().trim().isEmpty() ||
            view.getjTFNoTelp().getText().trim().isEmpty() ||
            view.getjDateChooserTanggalLahir().getDate().toString().isEmpty() ||
            view.getjTFAlamat().getText().trim().isEmpty() ||
            view.getjTFJenis().getText().trim().isEmpty() ||
            view.getjTFHarga().getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(view, "Data dokter tidak boleh kosong!");
        } else {
            ModelDataDokter dokter = new ModelDataDokter();

            dokter.setIdDokter(Integer.parseInt(view.getjTFID().getText()));
            dokter.setNamaDokter(view.getjTFNama().getText());
            dokter.setTlpDokter(view.getjTFNoTelp().getText());
            dokter.setTanggalLahirDokter(view.getjDateChooserTanggalLahir().getDate());
            dokter.setAlamatDokter(view.getjTFAlamat().getText());
            dokter.setJenisDokter(view.getjTFJenis().getText());
            dokter.setHargaDokter(Double.parseDouble(view.getjTFHarga().getText()));

            dao.update(dokter);
            JOptionPane.showMessageDialog(view, "Data dokter berhasil diubah!");
        }
    }

    public void delete() {
        int id = Integer.parseInt(view.getjTFID().getText());
        dao.delete(id);
        JOptionPane.showMessageDialog(view, "Data dokter berhasil dihapus!");
    }

    public void reset() {
        view.getjTFID().setText("");
        view.getjTFNama().setText("");
        view.getjTFNoTelp().setText("");
        view.getjDateChooserTanggalLahir().setDate(null);
        view.getjTFAlamat().setText("");
        view.getjTFJenis().setText("");
        view.getjTFHarga().setText("");
    }

    public void getDataDokterById(int id) {
        
        ModelDataDokter dokter = dao.getAll().stream()
                                .filter(d -> d.getIdDokter() == id)
                                .findFirst()
                                .get();
        view.getjTFID().setText(Integer.toString(dokter.getIdDokter()));
        view.getjTFNama().setText(dokter.getNamaDokter());
        view.getjTFNoTelp().setText(dokter.getTlpDokter());
        view.getjDateChooserTanggalLahir().setDate(dokter.getTanggalLahirDokter());
        view.getjTFAlamat().setText(dokter.getAlamatDokter());
        view.getjTFJenis().setText(dokter.getJenisDokter());
        view.getjTFHarga().setText(Double.toString(dokter.getHargaDokter()));
    }

    public void fillTableDataDokter() {
        List<ModelDataDokter> dataDokter = dao.getAll();
        ModelTabelDataDokter model = new ModelTabelDataDokter((ArrayList<ModelDataDokter>) dataDokter);

        view.getjTable().setModel(model);
    }
}