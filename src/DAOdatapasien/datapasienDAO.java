/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatapasien;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplementpasien.datapasienimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class datapasienDAO implements datapasienimplement {
    Connection connection;

    final String select = "SELECT * FROM pasien";
    final String insert = "INSERT INTO pasien (nama_pasien, tlp_pasien, tanggallahir_pasien, alamat_pasien, pendaftaran_pasien) VALUES (?, ?, ?, ?, ?);";
    final String update = "update pasien set nama_pasien=?, tlp_pasien=?, tanggallahir_pasien=?, alamat_pasien=?, pendaftaran_pasien=? where id_pasien=?";
    final String delete = "delete from pasien where id_pasien=?";

    public datapasienDAO() {
        connection = connector.connection();
    }

    @Override
    public void insert(datapasien p) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, p.getNama_pasien());
            statement.setString(2, p.getTlp_pasien());
            statement.setString(3, p.getTanggallahir_pasien());
            statement.setString(4, p.getAlamat_pasien());
            statement.setString(5, p.getPendaftaran_pasien());
            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();
            while (rs.next()) {
                p.setId_pasien(rs.getInt(1));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void update(datapasien p) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(update);
            statement.setString(1, p.getNama_pasien());
            statement.setString(2, p.getTlp_pasien());
            statement.setString(3, p.getTanggallahir_pasien());
            statement.setString(4, p.getAlamat_pasien());
            statement.setString(5, p.getPendaftaran_pasien());
            statement.setInt(6, p.getId_pasien());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try {
            statement = connection.prepareStatement(delete);

            statement.setInt(1, id);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();

        } finally {
            try {
                statement.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datapasien> getAll() {
        List<datapasien> dp = null;
        try {
            dp = new ArrayList<datapasien>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while (rs.next()) {
                datapasien hp = new datapasien();
                hp.setId_pasien(rs.getInt("id_pasien"));
                hp.setNama_pasien(rs.getString("nama_pasien"));
                hp.setTlp_pasien(rs.getString("tlp_pasien"));
                hp.setTanggallahir_pasien(rs.getString("tanggallahir_pasien"));
                hp.setAlamat_pasien(rs.getString("alamat_pasien"));
                hp.setPendaftaran_pasien(rs.getString("pendaftaran_pasien"));
                dp.add(hp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(datapasienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }

        return dp;
    }

}
