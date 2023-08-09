/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class QuyDinh {
    private  int id;
    private  String tenquydinh;
    private  String ngaytao;
    private  double  gioihanquydinh;
    private  String gioihanngay;
    private  String Noidung;
    private  String trangrthai;
    private  int LoaiChiTieu;
    private  String ThoiGianQuyPham;

    public QuyDinh(String tenquydinh, String ngaytao, double gioihanquydinh, String gioihanngay, String Noidung, String trangrthai, int LoaiChiTieu) {
        this.tenquydinh = tenquydinh;
        this.ngaytao = ngaytao;
        this.gioihanquydinh = gioihanquydinh;
        this.gioihanngay = gioihanngay;
        this.Noidung = Noidung;
        this.trangrthai = trangrthai;
        this.LoaiChiTieu = LoaiChiTieu;
    }

    public String getThoiGianQuyPham() {
        return ThoiGianQuyPham;
    }

    public void setThoiGianQuyPham(String ThoiGianQuyPham) {
        this.ThoiGianQuyPham = ThoiGianQuyPham;
    }

    
    
    
    public int getLoaiChiTieu() {
        return LoaiChiTieu;
    }

    public void setLoaiChiTieu(int LoaiChiTieu) {
        this.LoaiChiTieu = LoaiChiTieu;
    }

    public QuyDinh() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTenquydinh() {
        return tenquydinh;
    }

    public void setTenquydinh(String tenquydinh) {
        this.tenquydinh = tenquydinh;
    }

    public String getNgaytao() {
        return ngaytao;
    }

    public void setNgaytao(String ngaytao) {
        this.ngaytao = ngaytao;
    }

    public double getGioihanquydinh() {
        return gioihanquydinh;
    }

    public void setGioihanquydinh(double gioihanquydinh) {
        this.gioihanquydinh = gioihanquydinh;
    }

    public String getGioihanngay() {
        return gioihanngay;
    }

    public void setGioihanngay(String gioihanngay) {
        this.gioihanngay = gioihanngay;
    }

    public String getNoidung() {
        return Noidung;
    }

    public void setNoidung(String Noidung) {
        this.Noidung = Noidung;
    }

    public String getTrangrthai() {
        return trangrthai;
    }

    public void setTrangrthai(String trangrthai) {
        this.trangrthai = trangrthai;
    }
}
