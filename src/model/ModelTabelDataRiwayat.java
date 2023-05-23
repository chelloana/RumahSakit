/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
public class ModelTabelDataRiwayat extends AbstractTableModel{
    private ArrayList<ModelDataRiwayat> dataRiwayat;

    public ModelTabelDataRiwayat(ArrayList<ModelDataRiwayat> dataRiwayat) {
        this.dataRiwayat = dataRiwayat;
    }

    @Override
    public int getRowCount() {
        return dataRiwayat.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Riwayat";
            case 1:
                return "ID Pendaftaran";
            case 2:
                return "ID Dokter";
            case 3:
                return "ID Pasien";
            case 4:
                return "Diagnosa";
            case 5:
                return "Obat";
            case 6:
                return "Tanggal Daftar";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return dataRiwayat.get(rowIndex).getId_riwayat();
            case 1:
                return dataRiwayat.get(rowIndex).getId_pendaftaran();
            case 2:
                return dataRiwayat.get(rowIndex).getId_dokter();
            case 3:
                return dataRiwayat.get(rowIndex).getId_pasien();
            case 4:
                return dataRiwayat.get(rowIndex).getDiagnosa();
            case 5:
                return dataRiwayat.get(rowIndex).getObat();
            case 6:
                return dataRiwayat.get(rowIndex).getTgl_daftar();
            default:
                return null;
        }
    }
}
