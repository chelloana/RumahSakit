/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package DAOimplementpasien;

import java.util.List;
import model.*;

public interface datapendaftaranimplement {
    public void insert(datapendaftaran p);
    
    public void update(datapendaftaran p);
    
    public void delete(int id);
    
    public List<datapendaftaran> getAll();

    public List<ModelDataDokter> getAllDokter();
}
