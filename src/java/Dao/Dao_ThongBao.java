
package Dao;

import Database.JDBC;
import Model.ThongBao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Dao_ThongBao {
    
    public static   Dao_ThongBao get() {
      return new  Dao_ThongBao();
    }
    
    public void TaoThongBao(ThongBao tb) {
       try {
            Calendar cal = Calendar.getInstance();
            java.util.Date datel =  cal.getTime();         
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format1.format(datel); 
            
            Connection connection = JDBC.ConectSQLserver();
            String query = "insert into ThongBao (noidung,mathuchi,trangthai,gimthoigian,tinhchat,magd)"
                    + " values(?,?,1,'"+date1+"',?,0);";
            if(tb.getMagd() >0) {
                query = "insert into ThongBao (magd,gimthoigian,trangthai)"
                    + " values(?,'"+date1+"',1);";
                 PreparedStatement pd = connection.prepareStatement(query);
                 pd.setInt(1, tb.getMagd());
                  pd.executeUpdate();
                return;
            }
            
            PreparedStatement pd = connection.prepareStatement(query);
            pd.setString(1, tb.getNoidung());
            pd.setInt(2, tb.getMathuchi());
             pd.setInt(3, tb.getTinhchat());
             pd.executeUpdate();
            JDBC.closeconnect(connection);
        } catch (SQLException ex) {
            Logger.getLogger(Dao_LoaiChiTieu_Dao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public boolean kiemtradate(String date) {
        int i  = 0;
         Connection connection;
        try {
            connection = JDBC.ConectSQLserver();
            String query = "select *  from thoigian where id = 1 and  ngaygim = '"+date+"' ";
            PreparedStatement pd = connection.prepareStatement(query);
              ResultSet set = pd.executeQuery();
              while(set.next()) {
                 i = set.getInt("id");
              }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThongBao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return i>0;
    }
    
    public void capnhatngay() {
         Connection connection;
        try {
            connection = JDBC.ConectSQLserver();
            String query = "update thoigian "
                    + "set ngaygim = dateadd(month,1,ngaygim) "
                    + "where id = 1";
            PreparedStatement pd = connection.prepareStatement(query);
            pd.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThongBao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   public int laysothongbao() {
     int i  = 0;
         Connection connection;
        try {
            connection = JDBC.ConectSQLserver();
            String query = " select * from ThongBao where trangthai = 1";
            PreparedStatement pd = connection.prepareStatement(query);
              ResultSet set = pd.executeQuery();
              while(set.next()) {
                 i ++;
              }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThongBao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return i;
   }
   
   
      
   public ArrayList<ThongBao> laythongbao(String check) {
       ArrayList<ThongBao> tbs = new ArrayList<>();
       ThongBao tb = null;
     int i  = 0;
         Connection connection;
        try {
            connection = JDBC.ConectSQLserver();
            String query = " select * from ThongBao";
            if(check != null) {
                if (check.equalsIgnoreCase("chi")) {
                    query = " select * from ThongBao where mathuchi = 1";
                }
                if (check.equalsIgnoreCase("thu")) {
                    query = " select * from ThongBao where mathuchi = 0";
                }
                if (check.equalsIgnoreCase("quydinh")) {
                    query = " select * from ThongBao where magd > 0";
                }
            }
            PreparedStatement pd = connection.prepareStatement(query);
              ResultSet set = pd.executeQuery();
              while(set.next()) {
                 tb = new ThongBao();
                 tb.setNoidung(set.getString("noidung"));
                 tb.setMathuchi(set.getInt("mathuchi"));
                 tb.setTinhchat(set.getInt("tinhchat"));
                 tb.setMagd(set.getInt("magd"));
                 tb.setGhimthoigian(set.getString("gimthoigian"));
                 tbs.add(tb);
              }
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThongBao.class.getName()).log(Level.SEVERE, null, ex);
        }
    return tbs;
   }
   
    public void capnhatdaxem() {
         Connection connection;
        try {
            connection = JDBC.ConectSQLserver();
            String query = "update ThongBao set trangthai = 0 where  trangthai = 1";
            PreparedStatement pd = connection.prepareStatement(query);
            pd.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Dao_ThongBao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
