/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplementasiAkun;

/**
 *
 * @author ACER
 */
import java.util.List;
import model.ModelDataAkun;


public interface DataAkunIntf {
   public void insert(ModelDataAkun mda);
   public void update(ModelDataAkun mda);
   public void delete(int id);
   public List<ModelDataAkun> getAll();
}
