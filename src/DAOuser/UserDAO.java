/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOuser;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.DataUser;
import koneksi.connector;

public class UserDAO {
    
    public DataUser loginUser(String username, String password) throws SQLException{
        Connection con = connector.connection();
        DataUser data = null;
        String query = "SELECT * FROM login WHERE username=? AND password=?";
        
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, username);
            ps.setString(2, password);
            
            ResultSet rs = ps.executeQuery();
            
            if(rs.next()){
                data = new DataUser();
                data.setUsername(rs.getString("username"));
                data.setPassword(rs.getString("password"));
                data.setPosition(rs.getString("posisi"));
            }
            rs.close();
        }
        return data;
    }
    
}