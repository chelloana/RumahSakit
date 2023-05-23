/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

/**
 *
 * @author ACER
 */
import java.util.List;
import DAOdatapasien.dataBelumBayarDAO;
import DAOimplementpasien.datapembayaranimplement;
import javax.swing.JOptionPane;
import model.*;
import view.vBelumBayar;
public class DataBelumBayarController {
    vBelumBayar frame;
    datapembayaranimplement impldatapembayaran;
    
    private final dataBelumBayarDAO dao = new dataBelumBayarDAO();
    
    List<datapembayaran> dp;
    
    public DataBelumBayarController(vBelumBayar frame){
        this.frame = frame;
        impldatapembayaran = new dataBelumBayarDAO();
    }
    
    public void insert() {
        datapembayaran bayar = new datapembayaran();
        
        bayar.setId_pendaftaran(Integer.parseInt(frame.getIddaftar().getText()));
        bayar.setAdminrs(frame.getBiayaAdmin());

        dao.insert(bayar);
        JOptionPane.showMessageDialog(frame, "Data pembayaran berhasil ditambahkan!");
    }
    
    public void isitabel(){
        dp = impldatapembayaran.getAll();
        ModelDataTabelBelumBayar mp = new ModelDataTabelBelumBayar(dp);
        frame.getTabelpembayaran().setModel(mp);
    }

    
}
