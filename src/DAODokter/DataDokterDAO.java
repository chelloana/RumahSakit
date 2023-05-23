/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ACER
 */
package DAODokter;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import koneksi.connector;
import model.ModelDataDokter;

public class DataDokterDAO implements DAOImplementDokter.DataDokterIntf {

    Connection conn = connector.connection();

    @Override
    public void insert(ModelDataDokter dokter) {
        String sql = "INSERT INTO dokter (nama_dokter, tlp_dokter, tanggallahir_dokter, alamat_dokter, jenis_dokter, harga_dokter) VALUES (?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dokter.getNamaDokter());
            ps.setString(2, dokter.getTlpDokter());
            ps.setDate(3, new java.sql.Date(dokter.getTanggalLahirDokter().getTime()));
            ps.setString(4, dokter.getAlamatDokter());
            ps.setString(5, dokter.getJenisDokter());
            ps.setDouble(6, dokter.getHargaDokter());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void update(ModelDataDokter dokter) {
        String sql = "UPDATE dokter SET nama_dokter=?, tlp_dokter=?, tanggallahir_dokter=?, alamat_dokter=?, jenis_dokter=?, harga_dokter=? WHERE id_dokter=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, dokter.getNamaDokter());
            ps.setString(2, dokter.getTlpDokter());
            ps.setDate(3, new java.sql.Date(dokter.getTanggalLahirDokter().getTime()));
            ps.setString(4, dokter.getAlamatDokter());
            ps.setString(5, dokter.getJenisDokter());
            ps.setDouble(6, dokter.getHargaDokter());
            ps.setInt(7, dokter.getIdDokter());
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public void delete(int id) {
        String sql = "DELETE FROM dokter WHERE id_dokter=?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }
    }

    @Override
    public List<ModelDataDokter> getAll() {
        List<ModelDataDokter> dokters = new ArrayList<>();
        String sql = "SELECT * FROM dokter";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ModelDataDokter dokter = new ModelDataDokter();
                dokter.setIdDokter(rs.getInt("id_dokter"));
                dokter.setNamaDokter(rs.getString("nama_dokter"));
                dokter.setTlpDokter(rs.getString("tlp_dokter"));
                dokter.setTanggalLahirDokter(rs.getDate("tanggallahir_dokter"));
                dokter.setAlamatDokter(rs.getString("alamat_dokter"));
                dokter.setJenisDokter(rs.getString("jenis_dokter"));
                dokter.setHargaDokter(rs.getDouble("harga_dokter"));
                dokters.add(dokter);
            }
        } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        return dokters;
    }
}