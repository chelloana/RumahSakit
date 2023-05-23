/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.List;
import DAOdatapasien.dataSudahBayarDAO;
import DAOimplementpasien.datapembayaranimplement;
import model.*;
import view.vPembayaran;

public class dataSudahBayarcontroller {
    vPembayaran frame;
    datapembayaranimplement impldatapembayaran;
    
    
    List<datapembayaran> dp;
    
    public dataSudahBayarcontroller(vPembayaran frame){
        this.frame = frame;
        impldatapembayaran = new dataSudahBayarDAO();
    }
    
    
    public void isitabel(){
        dp = impldatapembayaran.getAll();
        modeltabeldataSudahBayar mp = new modeltabeldataSudahBayar(dp);
        frame.getTabelpembayaran().setModel(mp);
    }

    
}
