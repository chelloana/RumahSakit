/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author ACER
 */
public class ModelDataAkun {
   private int id;
   private String username;
   private String password;
   private String posisi;



   public int getId() {
       return id;
   }

   public void setId(int id) {
       this.id = id;
   }

   public String getUsername() {
       return username;
   }

   public void setUsername(String username) {
       this.username = username;
   }

   public String getPassword() {
       return password;
   }

    public void setPassword(String password) {
         this.password = password;
    }

   public String getPosisi() {
       return posisi;
   }

    public void setPosisi(String posisi) {
         this.posisi = posisi;
    }
}