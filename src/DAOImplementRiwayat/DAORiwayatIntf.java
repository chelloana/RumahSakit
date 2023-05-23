/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAOImplementRiwayat;

/**
 *
 * @author ACER
 */
import java.util.List;
import model.ModelDataRiwayat;
public interface DAORiwayatIntf {
    public void insert(ModelDataRiwayat mdr);
    public void update(ModelDataRiwayat mdr);
    public void delete(int id);
    public List<ModelDataRiwayat> getAll();
    public List<ModelDataRiwayat> getAllById(int id);
}
