/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAORiwayat;

/**
 *
 * @author ACER
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koneksi.connector;
import model.ModelDataRiwayat;
public class DataRiwayatDAO implements DAOImplementRiwayat.DAORiwayatIntf{
    
    Connection conn = connector.connection();

    @Override
    public void insert(ModelDataRiwayat mdr) {
        // INSERT INTO `riwayat` (`id_riwayat`, `id_pasien`, `diagnosa`, `resep`, `tgl_Diagnosa`)
        String query = "INSERT INTO riwayat (id_pendaftaran, id_dokter, id_pasien, diagnosa, resep, tanggal_daftar) VALUES (?,?,?,?,?,?)";
        java.util.Date util = mdr.getTgl_daftar();
        java.sql.Date sql = new java.sql.Date(util.getTime());
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, mdr.getId_pendaftaran());
            ps.setInt(2, mdr.getId_dokter());
            ps.setInt(3, mdr.getId_pasien());
            ps.setString(4, mdr.getDiagnosa());
            ps.setString(5, mdr.getObat());
            ps.setDate(6, sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
         System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void update(ModelDataRiwayat mdr) {
        String query = "UPDATE riwayat SET id_Pasien=?, diagnosa=?, resep=?, tgl_Diagnosa=? WHERE id_riwayat=?";
        java.util.Date util = mdr.getTgl_daftar();
        java.sql.Date sql = new java.sql.Date(util.getTime());
        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, mdr.getId_pasien());
            ps.setString(2, mdr.getDiagnosa());
            ps.setString(3, mdr.getObat());
            ps.setDate(4, sql);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String query = "DELETE FROM riwayat WHERE id_riwayat=?";

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<ModelDataRiwayat> getAll() {
        String query = "SELECT * FROM riwayat";
        List<ModelDataRiwayat> list = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModelDataRiwayat mdr = new ModelDataRiwayat();
                mdr.setId_riwayat(rs.getInt("id_riwayat"));
                mdr.setId_pendaftaran(rs.getInt("id_pendaftaran"));
                mdr.setId_dokter(rs.getInt("id_dokter"));
                mdr.setId_pasien(rs.getInt("id_pasien"));
                mdr.setDiagnosa(rs.getString("diagnosa"));
                mdr.setObat(rs.getString("resep"));
                mdr.setTgl_daftar(rs.getDate("tanggal_daftar"));
                list.add(mdr);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }

    @Override
    public List<ModelDataRiwayat> getAllById(int id) {
        String query = "SELECT * FROM riwayat WHERE id_Pasien=?";
        List<ModelDataRiwayat> list = new ArrayList<>();

        try {
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ModelDataRiwayat mdr = new ModelDataRiwayat();
                mdr.setId_riwayat(rs.getInt("id_riwayat"));
                mdr.setId_pendaftaran(rs.getInt("id_pendaftaran"));
                mdr.setId_dokter(rs.getInt("id_dokter"));
                mdr.setId_pasien(rs.getInt("id_pasien"));
                mdr.setDiagnosa(rs.getString("diagnosa"));
                mdr.setObat(rs.getString("resep"));
                mdr.setTgl_daftar(rs.getDate("tanggal_daftar"));
                list.add(mdr);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
        return list;
    }
}
