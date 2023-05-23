/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.List;
import javax.swing.table.AbstractTableModel;

public class modeltabeldatapendaftaran extends AbstractTableModel {
    List<datapendaftaran> dp;

    public modeltabeldatapendaftaran(List<datapendaftaran>dp){
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
                return "ID Pendaftaran";
            case 1:
                return "ID Pasien";
            case 2:
                return "Nama Pasien";
            case 3:
                return "Jenis Dokter";
            case 4:
                return "Nama Dokter";
            case 5:
                return "Jenis Pendaftaran";
            case 6:
                return "Tanggal Daftar";
            default:
                return null;
        }
    }
    
    @Override
    public Object getValueAt(int row, int column) {
        switch(column){
            case 0:
                return dp.get(row).getId_pendaftaran();
            case 1:
                return dp.get(row).getId_pasien();
            case 2:
                return dp.get(row).getNama_pasien();
            case 3:
                return dp.get(row).getJenis_dokter();
            case 4:
                return dp.get(row).getNama_dokter();
            case 5:
                return dp.get(row).getPendaftaran_pasien();
            case 6:
                return dp.get(row).getTanggal_pendaftaran();
            default:
                return null;
        }
    }
}
