/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOAkun;

/**
 *
 * @author ACER
 */
import DAOImplementasiAkun.DataAkunIntf;
import koneksi.connector;
import model.ModelDataAkun;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DataAkunDAO implements DataAkunIntf {

    Connection conn = connector.connection();

   @Override
   public void insert(ModelDataAkun mda) {
       String query = "INSERT INTO login (username, password, posisi) VALUES (?,?,?)";
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setString(1, mda.getUsername());
           ps.setString(2, mda.getPassword());
           ps.setString(3, mda.getPosisi());
           ps.executeUpdate();
       } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
       }
   }

   @Override
   public void update(ModelDataAkun mda) {
       String query = "UPDATE login SET username=?, password=?, posisi=? WHERE id_login=?";
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setString(1, mda.getUsername());
           ps.setString(2, mda.getPassword());
           ps.setString(3, mda.getPosisi());
           ps.setInt(4, mda.getId());
           ps.executeUpdate();
       } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
       }
   }

   @Override
   public void delete(int id) {
       String query = "DELETE FROM login WHERE id_login=?";
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ps.setInt(1, id);
           ps.executeUpdate();
       } catch (SQLException ex) {
        System.out.println("Error: " + ex.getMessage());
       }
   }

   @Override
   public List<ModelDataAkun> getAll() {
       List<ModelDataAkun> list = new ArrayList<>();
       String query = "SELECT * FROM login";
       try {
           PreparedStatement ps = conn.prepareStatement(query);
           ResultSet rs = ps.executeQuery();

           while (rs.next()) {
                ModelDataAkun mda = new ModelDataAkun();
                mda.setId(rs.getInt("id_login"));
                mda.setUsername(rs.getString("username"));
                mda.setPassword(rs.getString("password"));
                mda.setPosisi(rs.getString("posisi"));
                list.add(mda);
           }
       } catch (SQLException ex) {
            System.out.println("Error: " + ex.getMessage());
       }
       return list;
   }
}



