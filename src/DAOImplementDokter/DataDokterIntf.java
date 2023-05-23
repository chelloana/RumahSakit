/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplementDokter;

/**
 *
 * @author ACER
 */
import java.util.List;
import model.ModelDataDokter;

public interface DataDokterIntf {
    public void insert(ModelDataDokter dokter);
    public void update(ModelDataDokter dokter);
    public void delete(int id);
    public List<ModelDataDokter> getAll();
}
