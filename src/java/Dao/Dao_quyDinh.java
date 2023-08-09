/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.QuyDinh;
import java.util.ArrayList;

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
public class Dao_quyDinh{

    
    
    public  static  Dao_quyDinh get() {
      return  new Dao_quyDinh();
    }
    
    
    public void capnhatquypham(int id) {
        try {
             Calendar cal = Calendar.getInstance();
            java.util.Date datel =  cal.getTime();         
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
            String date1 = format1.format(datel); 
            
            
            Connection connection = JDBC.ConectSQLserver();
            String query = "update QuyDinh set "
                    + "ThoiGianQuyPham = ?,"
                    + "TrangThai = ? "
                    + " where id = ?";
            PreparedStatement pd = connection.prepareStatement(query);
            pd.setString(1, date1);
            pd.setString(2, "Đã Vi Phạm");
            pd.setInt(3,id);
            pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
    
    
    public QuyDinh layquydinh(int id) {
        QuyDinh uy =  null;
        try {
            Connection connection = JDBC.ConectSQLserver();
            String query = "select * from QuyDinh where id = ?";
            PreparedStatement pd = connection.prepareStatement(query);
            pd.setInt(1,id);
            ResultSet set = pd.executeQuery();
            while(set.next()) {
              uy = new QuyDinh(set.getString("TenQuyDinh"),set.getString("NgayTao"),
                      set.getDouble("GioiHan"),set.getString("GioiHanThoiGian") , 
                      set.getString("NoiDung"), set.getString("TrangThai"),set.getInt("LoaiChiTieu"));
              uy.setId(set.getInt("id"));
            }
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  uy;
    }
    
    
    public ArrayList<QuyDinh> kiemtraquydinh() {
        ArrayList<QuyDinh> qd = new ArrayList<>();
        QuyDinh uy =  null;
        try {
            Connection connection = JDBC.ConectSQLserver();
            String query = "select * from QuyDinh where TrangThai != N'Đã Vi Phạm' and GioiHanThoiGian > GETDATE()";
            PreparedStatement pd = connection.prepareStatement(query);
            ResultSet set = pd.executeQuery();
            while(set.next()) {
              uy = new QuyDinh(set.getString("TenQuyDinh"),set.getString("NgayTao"),
                      set.getDouble("GioiHan"),set.getString("GioiHanThoiGian") , 
                      set.getString("NoiDung"), set.getString("TrangThai"),set.getInt("LoaiChiTieu"));
              uy.setId(set.getInt("id"));
              qd.add(uy);
            }
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  qd;
    }
    
    
    public ArrayList<QuyDinh> checkngaysudung(int id) {
        ArrayList<QuyDinh> qd = new ArrayList<>();
        QuyDinh uy =  null;
        try {
            Connection connection = JDBC.ConectSQLserver();
            String query = "select * from QuyDinh where GioiHanThoiGian > GETDATE() and id = ?";
            PreparedStatement pd = connection.prepareStatement(query);
            pd.setInt(1, id);
            ResultSet set = pd.executeQuery();
            while(set.next()) {
              uy = new QuyDinh(set.getString("TenQuyDinh"),set.getString("NgayTao"),
                      set.getDouble("GioiHan"),set.getString("GioiHanThoiGian") , 
                      set.getString("NoiDung"), set.getString("TrangThai"),set.getInt("LoaiChiTieu"));
              uy.setId(set.getInt("id"));
              qd.add(uy);
            }
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return  qd;
    }
    
    
    
    
    public ArrayList<QuyDinh> selectquery(String key) {
       ArrayList<QuyDinh> array =  new ArrayList<>();
        QuyDinh uy =  null;
        try {
             array = new ArrayList<>();
            Connection connection = JDBC.ConectSQLserver();
            String query = "select * from QuyDinh";
            if (key != null && key != "") {
                      query = "select * from  QuyDinh where TenQuyDinh like N'%"+key+"%'";
            }
            PreparedStatement pd = connection.prepareStatement(query);
            ResultSet set = pd.executeQuery();
            while(set.next()) {
              uy = new QuyDinh(set.getString("TenQuyDinh"),set.getString("NgayTao"),
                      set.getInt("GioiHan"),set.getString("GioiHanThoiGian") , 
                      set.getString("NoiDung"), set.getString("TrangThai"),set.getInt("LoaiChiTieu"));
              uy.setId(set.getInt("id"));
              array.add(uy);
            }
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }

    public int ThemQuyDinh(QuyDinh t) {
          int i = 0;
       try {
            Calendar cal = Calendar.getInstance();
            java.util.Date datel =  cal.getTime();         
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
            String date1 = format1.format(datel); 
            
            
            Connection connection = JDBC.ConectSQLserver();
            String query = "insert into QuyDinh(TenQuyDinh,TrangThai,NgayTao,GioiHan,NoiDung,GioiHanThoiGian,LoaiChiTieu)"
                    + " values(?,N'chưa vi phạm',?,?,?,?,?);";
            PreparedStatement pd = connection.prepareStatement(query);
             pd.setString(1,t.getTenquydinh());
             pd.setString(2, date1);
             pd.setDouble(3,t.getGioihanquydinh());
             pd.setString(4, t.getNoidung());
             pd.setString(5,t.getGioihanngay());
             pd.setInt(6, t.getLoaiChiTieu());
             i = pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
       return  i;
    }

    public void capnhatquydinh(QuyDinh t,String typedate, int valuesdate) {
       try { 
            Connection connection = JDBC.ConectSQLserver();
            String query = "update QuyDinh "
                    + "set "
                    + "TenQuyDinh = ?,"
                    + "GioiHan = ?,"
                    + "NoiDung = ? ,"
                    + "GioiHanThoiGian = DATEADD("+typedate+","+valuesdate+",GioiHanThoiGian) ,"
                    + "LoaiChiTieu = ? "
                    + "where  id = ? ";
            PreparedStatement pd = connection.prepareStatement(query);
             pd.setString(1,t.getTenquydinh());
             pd.setInt(2, (int) t.getGioihanquydinh());
             pd.setString(3, t.getNoidung());
             pd.setInt(4, t.getLoaiChiTieu());
             pd.setInt(5, t.getId());
             
             pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
    
     public void XoaQuyDinh(int id) {
       try { 
            Connection connection = JDBC.ConectSQLserver();
            String query = "delete from QuyDinh "
                    + "where  id = ? ";
            PreparedStatement pd = connection.prepareStatement(query);
             pd.setInt(1,id);
             pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

      public void khoiphuctinhtrang(int id) {
       try { 
           
            Calendar cal = Calendar.getInstance();
            java.util.Date datel =  cal.getTime();         
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
            String date1 = format1.format(datel); 
           
           
           
            Connection connection = JDBC.ConectSQLserver();
            String query = "update QuyDinh "
                    + "set TrangThai = N'chưa vi phạm',"
                    + "NgayTao = '"+date1+"',"
                    + "GioiHanThoiGian = DATEADD(DAY,1,NgayTao)"
                    + "where  id = ? ";
            PreparedStatement pd = connection.prepareStatement(query);
             pd.setInt(1,id);
             pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
      
      
      
      
      public ArrayList<QuyDinh> LayThongBao() {
       ArrayList<QuyDinh> array =  new ArrayList<>();
        QuyDinh uy =  null;
        try {
             array = new ArrayList<>();
            Connection connection = JDBC.ConectSQLserver();
            String query = "select * " +
                        "from QuyDinh " +
                        "where DAY(ThoiGianQuyPham) = DAY(GETDATE()) and ThoiGianQuyPham<= GETDATE()";
            PreparedStatement pd = connection.prepareStatement(query);
            ResultSet set = pd.executeQuery();
            while(set.next()) {
              uy = new QuyDinh(set.getString("TenQuyDinh"),set.getString("NgayTao"),
                      set.getInt("GioiHan"),set.getString("GioiHanThoiGian") , 
                      set.getString("NoiDung"), set.getString("TrangThai"),set.getInt("LoaiChiTieu"));
              uy.setId(set.getInt("id"));
              array.add(uy);
            }
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return array;
    }
    
}
