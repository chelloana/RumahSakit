/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabeldataSudahBayar extends AbstractTableModel {
    List<datapembayaran> dp;
    
    public modeltabeldataSudahBayar(List<datapembayaran>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Pembayaran";
            case 1:
                return "ID Pendaftaran";
            case 2:
                return "Nama Pasien";
            case 3:
                return "Nama Dokter";
            case 4:
                return "Harga Dokter";
            case 5:
                return "Administrasi Rumah Sakit";
            case 6:
                return "Total Biaya";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId_pembayaran();
            case 1:
                return dp.get(row).getId_pendaftaran();
            case 2:
                return dp.get(row).getNama_pasien();
            case 3:
                return dp.get(row).getNama_dokter();
            case 4:
                return dp.get(row).getHarga_dokter();
            case 5:
                return dp.get(row).getAdminrs();
            case 6:
                return dp.get(row).getTotal_biaya();
            default:
                return null;
        }
    }
    
}
