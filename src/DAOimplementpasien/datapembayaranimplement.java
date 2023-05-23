/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOimplementpasien;

import java.util.List;
import model.datapembayaran;

public interface datapembayaranimplement {
    public void insert(datapembayaran p);
    
    public void update(datapembayaran p);
    
    public void delete(int id);
    
    public List<datapembayaran> getAll();
}
