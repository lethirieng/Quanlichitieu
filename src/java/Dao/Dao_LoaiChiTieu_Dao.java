/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.LoaiChiTieu;
import java.util.ArrayList;
import java.sql.Connection;
import Database.JDBC;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;
/**
 *
 * @author AD
 */
public abstract class Dao_LoaiChiTieu_Dao {

    
    public static Dao_LoaiChiTieu_Dao get(){
        return  new Dao_LoaiChiTieu_Dao() {};
    }
   
    
    public void sualoaiCT(LoaiChiTieu loai) {
        try {
            Connection connection = JDBC.ConectSQLserver();
            String query = "update LoaiChiTieu set "
                    + "TenLoaiChiTieu = ? "
                    + "where id = ?";
            PreparedStatement pd = connection.prepareStatement(query);
            pd.setString(1, loai.getTenLoaiChiTieu());
            pd.setInt(2, loai.getId());
            pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    public  ArrayList<LoaiChiTieu> selectQuery(String key,String use) {
        ArrayList<LoaiChiTieu> array =  new ArrayList<>();
        LoaiChiTieu ob = null;
        try {
             array = new ArrayList<>();
            Connection connection = JDBC.ConectSQLserver();
            String query = "select * from  LoaiChiTieu";
            if (use != null && use != "") {
                query = "select * from  LoaiChiTieu where TrangThai = 'on'";
            }
            if (key != null && key != "") {
                      query = "select * from  LoaiChiTieu where TenLoaiChiTieu like'%"+key+"%'";
            }
            PreparedStatement pd = connection.prepareStatement(query);
            ResultSet set = pd.executeQuery();
            while(set.next()) {
               ob = new LoaiChiTieu(set.getString("TenLoaiChiTieu") ,set.getString("TrangThai"),set.getString("NgayTao"));
               ob.setId(set.getInt("id"));
               array.add(ob);
            }
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    

    public  LoaiChiTieu LayLoaiChiTieu(int id) {
        LoaiChiTieu loai = null;
        try {
            Connection connection = JDBC.ConectSQLserver();
            String query = "select * from  LoaiChiTieu where id = ?";
            PreparedStatement pd = connection.prepareStatement(query);
            pd.setInt(1, id);
            ResultSet set = pd.executeQuery();
            while(set.next()) {
               loai = new LoaiChiTieu(set.getString("TenLoaiChiTieu") ,set.getString("TrangThai"),set.getString("NgayTao"));
               loai.setId(set.getInt("id"));
            }
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return loai;
    }
    
   

    public void ThemLoaiCT(LoaiChiTieu a) {
       try {
            Calendar cal = Calendar.getInstance();
            java.util.Date datel =  cal.getTime();         
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
            String date1 = format1.format(datel);
            
           // api connect
            Connection connection = JDBC.ConectSQLserver();
            
            
            // query dữ liệu
            String query = "insert into LoaiChiTieu(TenLoaiChiTieu,NgayTao) values(?,?); ";
            
            PreparedStatement pd = connection.prepareStatement(query);
             pd.setString(1, a.getTenLoaiChiTieu());
             pd.setString(2,date1);
              
             // Cập nhật database
             pd.executeUpdate();
                
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


   
     public void khongsudung(int id) {
       try { 
            Connection connection = JDBC.ConectSQLserver();
            String query = "update LoaiChiTieu "
                    + "set "
                    + "TrangThai = 'off'"
                    + "where  id = ? ";
            PreparedStatement pd = connection.prepareStatement(query);
             pd.setInt(1,id);
             pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     
      public void sudung(int id) {
       try { 
            Connection connection = JDBC.ConectSQLserver();
            String query = "update LoaiChiTieu "
                    + "set "
                    + "TrangThai = 'on'"
                    + "where  id = ? ";
            PreparedStatement pd = connection.prepareStatement(query);
             pd.setInt(1,id);
             pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

     
     
     
    public void XoaLoaiCT(int id) {
       try { 
            Connection connection = JDBC.ConectSQLserver();
            String query = "delete from LoaiChiTieu "
                    + "where  id = ? ";
            PreparedStatement pd = connection.prepareStatement(query);
             pd.setInt(1,id);
             pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
