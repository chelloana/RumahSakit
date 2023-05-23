/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatapasien;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplementpasien.datapembayaranimplement;

public class dataSudahBayarDAO implements datapembayaranimplement{
    Connection conn = connector.connection();
    
    

    @Override
    public void insert(datapembayaran p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void update(datapembayaran p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<datapembayaran> getAll() {
        String query = "SELECT * FROM pembayaran JOIN pendaftaran ON pembayaran.id_pendaftaran = pendaftaran.id_pendaftaran JOIN pasien ON pendaftaran.id_pasien = pasien.id_pasien JOIN dokter ON pendaftaran.id_dokter = dokter.id_dokter;";
        List<datapembayaran> dp = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datapembayaran p = new datapembayaran();
                p.setId_pembayaran(rs.getInt("id_pembayaran"));
                p.setId_pendaftaran(rs.getInt("id_pendaftaran"));
                p.setNama_pasien(rs.getString("nama_pasien"));
                p.setNama_dokter(rs.getString("nama_dokter"));
                p.setHarga_dokter(rs.getInt("harga_dokter"));
                p.setAdminrs(rs.getInt("harga_admin"));
                p.setTotal_biaya(rs.getInt("total"));
                dp.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage() + "getAll");
        }
        return dp;
    }

}
