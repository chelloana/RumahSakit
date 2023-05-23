/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabeldatapasien extends AbstractTableModel {
    
    List<datapasien> dp;
    
    public modeltabeldatapasien(List<datapasien>dp){
        this.dp = dp;
    }
    
    @Override
    public int getRowCount() {
        return dp.size();
    }

    @Override
    public int getColumnCount() {
        return 6;
    }
    
    @Override
    public String getColumnName(int column){
        switch(column){
            case 0:
                return "ID Pasien";
            case 1:
                return "Nama";
            case 2:
                return "No Telepon";
            case 3:
                return "Tanggal Lahir";
            case 4:
                return "Alamat";
            case 5:
                return "Jenis Pendaftaran";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId_pasien();
            case 1:
                return dp.get(row).getNama_pasien();
            case 2:
                return dp.get(row).getTlp_pasien();
            case 3:
                return dp.get(row).getTanggallahir_pasien();
            case 4:
                return dp.get(row).getAlamat_pasien();
            case 5:
                return dp.get(row).getPendaftaran_pasien();
            default:
                return null;
        }
    }
    
}
