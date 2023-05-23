/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOdatapasien;

import java.sql.*;
import java.util.*;
import koneksi.connector;
import model.*;
import DAOimplementpasien.datapendaftaranimplement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class datapendaftaranDAO implements datapendaftaranimplement {
    Connection connection= connector.connection();
    
    final String select = "SELECT pendaftaran.*, pasien.*, dokter.* FROM pendaftaran JOIN pasien ON pendaftaran.id_pasien = pasien.id_pasien JOIN dokter ON pendaftaran.id_dokter = dokter.id_dokter LEFT JOIN pembayaran ON pendaftaran.id_pendaftaran = pembayaran.id_pendaftaran WHERE pembayaran.id_pendaftaran IS NULL";
    final String insert = "INSERT INTO pendaftaran (id_pasien, id_dokter, tanggal_daftar) VALUES (?, ?, ?)";
    final String delete = "delete from pendaftaran where id_pendaftaran=?";
    

    public void cb(){
        
    }
    
    @Override
    public void insert(datapendaftaran p) {
        
        PreparedStatement statement = null;
        try{
           statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);
           statement.setInt(1, p.getId_pasien());
           statement.setInt(2, p.getId_dokter());
           statement.setDate(3, p.getTanggal_pendaftaran());
           statement.executeUpdate();
           ResultSet rs = statement.getGeneratedKeys();
           while(rs.next()){
               p.setId_pendaftaran(rs.getInt(1));
           }
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }

    }

    @Override
    public void update(datapendaftaran p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void delete(int id) {
        PreparedStatement statement = null;
        try{
            statement = connection.prepareStatement(delete);
            
            statement.setInt(1, id);
            statement.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
            
        }finally{
            try{
                statement.close();
            }catch(SQLException ex){
                ex.printStackTrace();
            }
        }
    }

    @Override
    public List<datapendaftaran> getAll() {
        List<datapendaftaran> dp = null;
        try{
            dp = new ArrayList<datapendaftaran>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(select);
            while(rs.next()){
                datapendaftaran hp = new datapendaftaran();
                hp.setId_pendaftaran(rs.getInt("id_pendaftaran"));
                hp.setId_pasien(rs.getInt("id_pasien"));
                hp.setNama_pasien(rs.getString("nama_pasien"));
                hp.setJenis_dokter(rs.getString("jenis_dokter"));
                hp.setNama_dokter(rs.getString("nama_dokter"));
                hp.setPendaftaran_pasien(rs.getString("pendaftaran_pasien"));
                hp.setTanggal_pendaftaran(rs.getDate("tanggal_daftar"));
                dp.add(hp);
            }
        }catch(SQLException ex){
            Logger.getLogger(datapasienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return dp;
    
    }

    @Override
    public List<ModelDataDokter> getAllDokter() {
        List<ModelDataDokter> dp = null;
        try{
            String query = "SELECT nama_dokter, id_dokter, jenis_dokter FROM dokter ORDER BY nama_dokter";
            dp = new ArrayList<ModelDataDokter>();
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery(query);
            while(rs.next()){
                ModelDataDokter hp = new ModelDataDokter();
                hp.setIdDokter(rs.getInt("id_dokter"));
                hp.setNamaDokter(rs.getString("nama_dokter"));
                hp.setJenisDokter(rs.getString("jenis_dokter"));
                dp.add(hp);
            }
        } catch(SQLException ex){
            Logger.getLogger(datapasienDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return dp;
    }
}
