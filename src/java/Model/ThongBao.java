/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;


public class ThongBao {
   private  int matb;
   private  String noidung;
   private  int mathuchi;
   private  int magd;
   private  String trangthai;
   private  String ghimthoigian;
   private  int tinhchat;

    public int getTinhchat() {
        return tinhchat;
    }

    public void setTinhchat(int tinhchat) {
        this.tinhchat = tinhchat;
    }

    public ThongBao(String noidung, int mathuchi, int magd, String trangthai, String ghimthoigian, int tinhchat) {
        this.matb = matb;
        this.noidung = noidung;
        this.mathuchi = mathuchi;
        this.magd = magd;
        this.trangthai = trangthai;
        this.ghimthoigian = ghimthoigian;
        this.tinhchat = tinhchat;
    }

    public String getGhimthoigian() {
        return ghimthoigian;
    }

    public void setGhimthoigian(String ghimthoigian) {
        this.ghimthoigian = ghimthoigian;
    }

   
    public int getMatb() {
        return matb;
    }

    public void setMatb(int matb) {
        this.matb = matb;
    }

    public String getNoidung() {
        return noidung;
    }

    public void setNoidung(String noidung) {
        this.noidung = noidung;
    }

    public int getMathuchi() {
        return mathuchi;
    }

    public void setMathuchi(int mathuchi) {
        this.mathuchi = mathuchi;
    }

    public int getMagd() {
        return magd;
    }

    public void setMagd(int magd) {
        this.magd = magd;
    }

    public String getTrangthai() {
        return trangthai;
    }

    public void setTrangthai(String trangthai) {
        this.trangthai = trangthai;
    }

    public ThongBao() {
    }
   
   
   
}
