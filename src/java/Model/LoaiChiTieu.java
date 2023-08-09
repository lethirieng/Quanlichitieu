/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

public class LoaiChiTieu {
  private  int id;
  private  String TenLoaiChiTieu;
  private  String Trangthai;

    public LoaiChiTieu(String TenLoaiChiTieu, String Trangthai, String NgayTao) {
        this.TenLoaiChiTieu = TenLoaiChiTieu;
        this.Trangthai = Trangthai;
        this.NgayTao = NgayTao;
    }

    public String getTrangthai() {
        return Trangthai;
    }

    public void setTrangthai(String Trangthai) {
        this.Trangthai = Trangthai;
    }

  private  String NgayTao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenLoaiChiTieu() {
        return TenLoaiChiTieu;
    }

    public void setTenLoaiChiTieu(String TenLoaiChiTieu) {
        this.TenLoaiChiTieu = TenLoaiChiTieu;
    }

    public String getNgayTao() {
        return NgayTao;
    }

    public void setNgayTao(String NgayTao) {
        this.NgayTao = NgayTao;
    }

    public LoaiChiTieu() {
    }
}
