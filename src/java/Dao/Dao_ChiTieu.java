/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;

import Model.ChiTieu;
import java.sql.Connection;
import java.util.ArrayList;
import Database.JDBC;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
public class Dao_ChiTieu{
    
    
 public  static  Dao_ChiTieu get() {
  return new  Dao_ChiTieu();
 }
 
 
 public ChiTieu LayChiTieu(int id) {
  ChiTieu tieu = new ChiTieu();
     try {
         Connection connect = JDBC.ConectSQLserver();
         String query = "select * from ChiTieu where id = ?";
         PreparedStatement pd  = connect.prepareStatement(query);
         pd.setInt(1,id);
         ResultSet set = pd.executeQuery();
         while(set.next()) {
           tieu.setId(set.getInt("id"));
           tieu.setTenChiTieu(set.getString("TenChiTieu"));
           tieu.setIdLoaiChiTieu(set.getInt("idLoaiChiTieu"));
           tieu.setSoTienChiTieu(set.getInt("SoTienChiTieu"));
           tieu.setThoiGianChiTieu(set.getString("ThoiGianChiTieu"));
           tieu.setChiTietChiTieu(set.getString("ChiTietChiTieu"));
           tieu.setIdLoaiThuChi(set.getInt("idLoaiThuChi"));
           tieu.setHinhanhChiTieu(set.getString("HinhAnhChiTieu"));
           tieu.setIdLoaiThuChi(set.getInt("idLoaiThuChi"));
         }
     } catch (SQLException ex) {
         Logger.getLogger(Dao_ChiTieu.class.getName()).log(Level.SEVERE, null, ex);
     }
   return tieu;
 }
 
 
 
  public int LayTienChiTieuThang(String date, int trangthai) {
      int i = 0;
     try {
         Connection connect = JDBC.ConectSQLserver();
         //chi 
        String query = "select sum(SoTienChiTieu) as Tongtien From ChiTieu where idLoaiThuChi = 1  " +
                "and year(ThoiGianChiTieu) = Year(getdate()) " +
                "and  month(ThoiGianChiTieu) = month(getdate())";
        if(date.equalsIgnoreCase("BEFORE")) {
          query = "select sum(SoTienChiTieu) as Tongtien From ChiTieu where idLoaiThuChi = 1  " +
                "and year(ThoiGianChiTieu) = Year(getdate()) " +
                "and  month(ThoiGianChiTieu) = month(getdate()) - 1";
        }
        
        //tieu
        if (trangthai > 0) {
          query = "select sum(SoTienChiTieu) as Tongtien From ChiTieu where idLoaiThuChi = 0  " +
                "and year(ThoiGianChiTieu) = Year(getdate()) " +
                "and  month(ThoiGianChiTieu) = month(getdate())";
        if(date.equalsIgnoreCase("BEFORE")) {
          query = "select sum(SoTienChiTieu) as Tongtien From ChiTieu where idLoaiThuChi = 0  " +
                "and year(ThoiGianChiTieu) = Year(getdate()) " +
                "and  month(ThoiGianChiTieu) = month(getdate()) - 1";
        }
            
        }
        
         PreparedStatement pd  = connect.prepareStatement(query);
         ResultSet set = pd.executeQuery();
         while(set.next()) {
             i = set.getInt("Tongtien");
         }
         JDBC.closeconnect(connect);
     } catch (SQLException ex) {
         Logger.getLogger(Dao_ChiTieu.class.getName()).log(Level.SEVERE, null, ex);
     }
   return i;
 }
 
 
 
 public ArrayList<ChiTieu> LayChiTieukiemtra(int Loaichitieu,String Ngaytao) {
     ArrayList<ChiTieu> array =  new ArrayList<>();
  ChiTieu tieu = new ChiTieu();
     try {
         Connection connect = JDBC.ConectSQLserver();
         String query = "select * from ChiTieu where ThoiGianChiTieu >= '"+Ngaytao+"' and  idLoaiThuChi = 1";
         if(Loaichitieu != 0) {
              query = "select * from ChiTieu where  ThoiGianChiTieu >= '"+Ngaytao+"' and idLoaiChiTieu = "+Loaichitieu+" and idLoaiThuChi = 1";
          }
         PreparedStatement pd  = connect.prepareStatement(query);
         ResultSet set = pd.executeQuery();
         while(set.next()) {
           tieu.setId(set.getInt("id"));
           tieu.setTenChiTieu(set.getString("TenChiTieu"));
           tieu.setIdLoaiChiTieu(set.getInt("idLoaiChiTieu"));
           tieu.setSoTienChiTieu(set.getInt("SoTienChiTieu"));
           tieu.setThoiGianChiTieu(set.getString("ThoiGianChiTieu"));
           tieu.setChiTietChiTieu(set.getString("ChiTietChiTieu"));
           tieu.setHinhanhChiTieu(set.getString("HinhAnhChiTieu"));
           tieu.setIdLoaiThuChi(set.getInt("idLoaiThuChi"));
           array.add(tieu);
         }
     } catch (SQLException ex) {
         Logger.getLogger(Dao_ChiTieu.class.getName()).log(Level.SEVERE, null, ex);
     }
  
   return array;
 }
 
 
 public  void XoaChiTieu(int id) {
     try {
         Connection connect = JDBC.ConectSQLserver();
         String query = "delete from ChiTieu where id = ?";
         PreparedStatement pd  = connect.prepareStatement(query);
         pd.setInt(1,id);
         pd.executeUpdate();
     } catch (SQLException ex) {
         Logger.getLogger(Dao_ChiTieu.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
 
 public int ThemCT(ChiTieu chi) {
     int i = 0;
     try {
         Connection connect = JDBC.ConectSQLserver();
         String query = "insert into ChiTieu (TenChiTieu,ChiTietChiTieu,SoTienChiTieu,ThoiGianChiTieu,idLoaiChiTieu,Hinhanhchitieu,idLoaiThuChi) "
                 + "values (?,?,?,?,?,?,?)";
         PreparedStatement pd  = connect.prepareStatement(query);
         pd.setString(1,chi.getTenChiTieu());
         pd.setFloat(3, chi.getSoTienChiTieu());
         pd.setString(2, chi.getChiTietChiTieu());
         pd.setString(4, chi.getThoiGianChiTieu());
         pd.setInt(5, Integer.valueOf(chi.getIdLoaiChiTieu()));
         pd.setString(6, chi.getHinhanhChiTieu());
         pd.setInt(7, chi.getIdLoaiThuChi());
         i = pd.executeUpdate();
     } catch (SQLException ex) {
         Logger.getLogger(Dao_ChiTieu.class.getName()).log(Level.SEVERE, null, ex);
     }  
   return i;
 }
 
 
 public ArrayList<ChiTieu> selectquery(String key,String fordate) {
     
     ArrayList<ChiTieu> array = new ArrayList<>();
     ChiTieu chitieu = null;
     try {
         Connection connect = JDBC.ConectSQLserver();
         String query = "select * from ChiTieu";
         if (key != null && key != "") {
             query = "select * from ChiTieu where TenChiTieu Like N'%"+key+"%'";
         }
         if (fordate.equalsIgnoreCase("DAY")) {
              query = "select * from ChiTieu where DAY(GETDATE()) = DAY(ThoiGianChiTieu)" +
                    "and month(ThoiGianChiTieu)= MONTH(getdate())" +
                    "and YEAR(GETDATE()) = YEAR(ThoiGianChiTieu)";
         }
         if(fordate.equalsIgnoreCase("MONTH")) {
              query = "select * from ChiTieu where " +
                    " month(ThoiGianChiTieu)= MONTH(getdate())" +
                    "and YEAR(GETDATE()) = YEAR(ThoiGianChiTieu)";
         }
         if (fordate.equalsIgnoreCase("YEAR")) {
            query = "select * from ChiTieu where YEAR(GETDATE()) = YEAR(ThoiGianChiTieu)";
         }
         
         PreparedStatement pd  = connect.prepareStatement(query);
         ResultSet result = pd.executeQuery();
         while(result.next()) {
           chitieu = new ChiTieu();
           chitieu.setId(result.getInt("id"));
           chitieu.setChiTietChiTieu(result.getString("ChiTietChiTieu"));
           chitieu.setHinhanhChiTieu(result.getString("HinhAnhChiTieu"));
           chitieu.setTenChiTieu(result.getString("TenChiTieu"));
           chitieu.setThoiGianChiTieu(result.getString("ThoiGianChiTieu"));
           chitieu.setSoTienChiTieu(result.getInt("SoTienChiTieu"));
           chitieu.setIdLoaiChiTieu(result.getInt("IdLoaiChiTieu"));
           chitieu.setIdLoaiThuChi(result.getInt("idLoaiThuChi"));
          array.add(chitieu);
         }
         
         JDBC.closeconnect(connect);
     } catch (SQLException ex) {
         Logger.getLogger(Dao_ChiTieu.class.getName()).log(Level.SEVERE, null, ex);
     }
   return  array;
 }

 
 public void CapNhatChiTieu(ChiTieu ct) {
     try {
         Connection connect = JDBC.ConectSQLserver();
         String query = "update ChiTieu"
                 + " set "
                 + " ChiTietChiTieu = ?, "
                 + "TenChiTieu = ?,"
                 + "HinhAnhChiTieu = ?,"
                 + "SoTienChiTieu = ?,"
                 + "IdLoaiChiTieu = ?,"
                 + "idLoaiThuChi = ? "
                 + " where id = ?";
         PreparedStatement pd  = connect.prepareStatement(query);
          pd.setString(1, ct.getChiTietChiTieu());
          pd.setString(2, ct.getTenChiTieu());
          pd.setString(3, ct.getHinhanhChiTieu());
          pd.setFloat(4, ct.getSoTienChiTieu());
          pd.setInt(5, ct.getIdLoaiChiTieu());
          pd.setInt(6, ct.getIdLoaiThuChi());
          pd.setInt(7, ct.getId());
          pd.executeUpdate();
         JDBC.closeconnect(connect);
     } catch (SQLException ex) {
         Logger.getLogger(Dao_ChiTieu.class.getName()).log(Level.SEVERE, null, ex);
     }
 } 
 
 
 public int laygansach(String Date,String thuchi) {
    int i =0;
     try {
         Connection connect = JDBC.ConectSQLserver();
         String query = "";
          if (Date.equalsIgnoreCase("DAY")) {
              query = "select  sum(SoTienChiTieu) as tong " +
                        "from ChiTieu " +
                        "where DAY(GETDATE()) = DAY(ThoiGianChiTieu) and " +
                        "MONTH(GETDATE()) = MONTH(ThoiGianChiTieu) and  " +
                        "YEAR(GETDATE()) = YEAR(ThoiGianChiTieu)";
              if (thuchi != null && thuchi!= "") {
                  query = "select  sum(SoTienChiTieu) as tong " +
                        "from ChiTieu " +
                        "where DAY(GETDATE()) = DAY(ThoiGianChiTieu) and " +
                        "MONTH(GETDATE()) = MONTH(ThoiGianChiTieu) and  " +
                        "YEAR(GETDATE()) = YEAR(ThoiGianChiTieu) and idLoaiThuChi = "+thuchi+" ";
              } 
         }
         if(Date.equalsIgnoreCase("MONTH")) {
              query = "select  sum(SoTienChiTieu) as tong " +
                        "from ChiTieu " +
                        "where " +
                        "MONTH(GETDATE()) = MONTH(ThoiGianChiTieu) and  " +
                        "YEAR(GETDATE()) = YEAR(ThoiGianChiTieu) ";
               if (thuchi != null && thuchi!= "") {
                  query = "select  sum(SoTienChiTieu) as tong " +
                        "from ChiTieu " +
                        "where " +
                        "MONTH(GETDATE()) = MONTH(ThoiGianChiTieu) and  " +
                        "YEAR(GETDATE()) = YEAR(ThoiGianChiTieu) and idLoaiThuChi = "+thuchi+" ";
              } 
         }
         if (Date.equalsIgnoreCase("YEAR")) {
               query = "select  sum(SoTienChiTieu) as tong " +
                        "from ChiTieu " +
                        "where " +
                        "YEAR(GETDATE()) = YEAR(ThoiGianChiTieu) ";
             if (thuchi != null && thuchi!= "") {
                query = "select  sum(SoTienChiTieu) as tong " +
                        "from ChiTieu " +
                        "where " +
                        "YEAR(GETDATE()) = YEAR(ThoiGianChiTieu) and idLoaiThuChi = "+thuchi+" ";
              } 
         }
           PreparedStatement pd  = connect.prepareStatement(query);
           ResultSet set = pd.executeQuery();
           while(set.next()) {
            i = set.getInt("tong");
           }
         JDBC.closeconnect(connect);
     } catch (SQLException ex) {
         Logger.getLogger(Dao_ChiTieu.class.getName()).log(Level.SEVERE, null, ex);
     }
     return i;
 }
 
 
        public  void checkthuchi() {

        }
  
}
