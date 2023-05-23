/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class ModelTabelDataAkun extends AbstractTableModel{
   private List<ModelDataAkun> list;
   
   public ModelTabelDataAkun(List<ModelDataAkun>list) {
       this.list = list;
   }

   @Override
   public int getRowCount() {
       return list.size();
   }

   @Override
   public int getColumnCount() {
       return 4;
   }

   @Override
   public String getColumnName(int column) {
       switch (column) {
           case 0:
               return "ID";
           case 1:
               return "Username";
           case 2:
               return "Password";
           case 3:
               return "Posisi";
           default:
               return null;
       }
   } 

   @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
         switch (columnIndex) {
              case 0:
                return list.get(rowIndex).getId();
              case 1:
                return list.get(rowIndex).getUsername();
              case 2:
                return list.get(rowIndex).getPassword();
              case 3:
                return list.get(rowIndex).getPosisi();
              default:
                return null;
         }
    }
}