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
import java.util.logging.Level;
import java.util.logging.Logger;

public class dataBelumBayarDAO implements datapembayaranimplement{
    Connection conn = connector.connection();
    
    // final String select = "SELECT pembayaran.id_pembayaran, pembayaran.id_pendaftaran, pasien.nama_pasien, dokter.nama_dokter, dokter.harga_dokter, pembayaran.harga_admin, pembayaran.total FROM pembayaran JOIN pendaftaran ON pembayaran.id_pendaftaran = pendaftaran.id_pendaftaran JOIN pasien ON pendaftaran.id_pasien = pasien.id_pasien JOIN dokter ON pendaftaran.id_dokter = dokter.id_dokter";
    // final String update = "";
    // final String delete = "delete from pembayaran where id_pembayaran=?";
    

    @Override
    public void insert(datapembayaran p) {
        String query = "INSERT INTO pembayaran (id_pendaftaran, harga_admin, total) SELECT id_pendaftaran, ? AS harga_admin, (SELECT harga_dokter FROM dokter WHERE id_dokter = pendaftaran.id_dokter) + ? AS total FROM pendaftaran WHERE id_pendaftaran = ?;";
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, p.getAdminrs());
            ps.setInt(2, p.getAdminrs());
            ps.setInt(3, p.getId_pendaftaran());
            ps.executeUpdate();
        } catch (SQLException ex) {
         System.out.println("Error: " + ex.getMessage());
        }
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
        String query = "SELECT * FROM pendaftaran JOIN pasien ON pendaftaran.id_pasien = pasien.id_pasien JOIN dokter ON pendaftaran.id_dokter = dokter.id_dokter WHERE id_pendaftaran NOT IN (SELECT id_pendaftaran FROM pembayaran);";
        List<datapembayaran> dp = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                datapembayaran p = new datapembayaran();
                p.setId_pendaftaran(rs.getInt("id_pendaftaran"));
                p.setId_pasien(rs.getInt("id_pasien"));
                p.setNama_pasien(rs.getString("nama_pasien"));
                p.setNama_dokter(rs.getString("nama_dokter"));
                p.setHarga_dokter(rs.getInt("harga_dokter"));
                p.setJenis_tunjangan(rs.getString("pendaftaran_pasien"));
                if(rs.getString("pendaftaran_pasien").equals("BPJS"))
                {
                    p.setAdminrs(0);
                }
                else
                {
                    p.setAdminrs(75000);
                }
                p.setTotal_biaya(p.getHarga_dokter() + p.getAdminrs());
                dp.add(p);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage() + "getAlli");
        }
        return dp;
    }


    // @Override
    // public List<ModelDataRiwayat> getAllById(int id) {
    //     String query = "SELECT * FROM riwayat WHERE id_Pasien=?";
    //     List<ModelDataRiwayat> list = new ArrayList<>();

    //     try {
    //         PreparedStatement ps = conn.prepareStatement(query);
    //         ps.setInt(1, id);
    //         ResultSet rs = ps.executeQuery();
    //         while (rs.next()) {
    //             ModelDataRiwayat mdr = new ModelDataRiwayat();
    //             mdr.setId_riwayat(rs.getInt("id_riwayat"));
    //             mdr.setId_pasien(rs.getInt("id_Pasien"));
    //             mdr.setDiagnosa(rs.getString("diagnosa"));
    //             mdr.setObat(rs.getString("resep"));
    //             mdr.setTgl_diagnosa(rs.getDate("tgl_Diagnosa"));
    //             list.add(mdr);
    //         }
    //     } catch (SQLException ex) {
    //         System.out.println("Error: " + ex.getMessage());
    //     }
    //     return list;
    // }
}
