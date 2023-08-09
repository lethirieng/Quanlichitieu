/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author AD
 */
public class ChiTieu {
    private  int  id;
    private String TenChiTieu;
    private String ChiTietChiTieu;
    private int SoTienChiTieu;
    private String ThoiGianChiTieu;
    private int idLoaiChiTieu;
    private String HinhanhChiTieu;
    private int idLoaiThuChi;

    public int getIdLoaiThuChi() {
        return idLoaiThuChi;
    }

    public ChiTieu(String TenChiTieu, String ChiTietChiTieu, int SoTienChiTieu, String ThoiGianChiTieu, int idLoaiChiTieu, String HinhanhChiTieu, int idLoaiThuChi) {
        this.TenChiTieu = TenChiTieu;
        this.ChiTietChiTieu = ChiTietChiTieu;
        this.SoTienChiTieu = SoTienChiTieu;
        this.ThoiGianChiTieu = ThoiGianChiTieu;
        this.idLoaiChiTieu = idLoaiChiTieu;
        this.HinhanhChiTieu = HinhanhChiTieu;
        this.idLoaiThuChi = idLoaiThuChi;
    }
    
    public void setIdLoaiThuChi(int idLoaiThuChi) {
        this.idLoaiThuChi = idLoaiThuChi;
    }
    
    
   
    
    public ChiTieu() {
    }

 
    public String getHinhanhChiTieu() {
        return HinhanhChiTieu;
    }

    public void setHinhanhChiTieu(String HinhanhChiTieu) {
        this.HinhanhChiTieu = HinhanhChiTieu;
    }

    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenChiTieu() {
        return TenChiTieu;
    }

    public void setTenChiTieu(String TenChiTieu) {
        this.TenChiTieu = TenChiTieu;
    }

    public String getChiTietChiTieu() {
        return ChiTietChiTieu;
    }

    public void setChiTietChiTieu(String ChiTietChiTieu) {
        this.ChiTietChiTieu = ChiTietChiTieu;
    }

    public  int getSoTienChiTieu() {
        return SoTienChiTieu;
    }

    public void setSoTienChiTieu(int SoTienChiTieu) {
        this.SoTienChiTieu = SoTienChiTieu;
    }

    public String getThoiGianChiTieu() {
        return ThoiGianChiTieu;
    }

    public void setThoiGianChiTieu(String ThoiGianChiTieu) {
        this.ThoiGianChiTieu = ThoiGianChiTieu;
    }

    public int getIdLoaiChiTieu() {
        return idLoaiChiTieu;
    }

    public void setIdLoaiChiTieu(int idLoaiChiTieu) {
        this.idLoaiChiTieu = idLoaiChiTieu;
    }
    
    
    
    
    
    
}

