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

public class ModelTabelDataDokter extends AbstractTableModel {
    private ArrayList<ModelDataDokter> dataDokter;

    public ModelTabelDataDokter(ArrayList<ModelDataDokter> dataDokter) {
        this.dataDokter = dataDokter;
    }

    @Override
    public int getRowCount() {
        return dataDokter.size();
    }

    @Override
    public int getColumnCount() {
        return 7;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "ID Dokter";
            case 1:
                return "Nama Dokter";
            case 2:
                return "No. Telp Dokter";
            case 3:
                return "Tanggal Lahir Dokter";
            case 4:
                return "Alamat Dokter";
            case 5:
                return "Jenis Dokter";
            case 6:
                return "Harga Dokter";
            default:
                return null;
        }
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return dataDokter.get(rowIndex).getIdDokter();
            case 1:
                return dataDokter.get(rowIndex).getNamaDokter();
            case 2:
                return dataDokter.get(rowIndex).getTlpDokter();
            case 3:
                return dataDokter.get(rowIndex).getTanggalLahirDokter().toString();
            case 4:
                return dataDokter.get(rowIndex).getAlamatDokter();
            case 5:
                return dataDokter.get(rowIndex).getJenisDokter();
            case 6:
                return dataDokter.get(rowIndex).getHargaDokter();
            default:
                return null;
        }
    }
}
