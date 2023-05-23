/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOimplementpasien;

import java.util.List;
import model.*;

public interface datapasienimplement {
    public void insert(datapasien p);
    
    public void update(datapasien p);
    
    public void delete(int id);
    
    public List<datapasien> getAll();
}
