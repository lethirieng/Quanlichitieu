/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Dao;
import Model.LoaiChiTieu;
import java.util.ArrayList;
/**
 *
 * @author AD
 */
public interface Dao_interface<T>{
  public abstract ArrayList<T> get_all();
  public abstract int insert(T t);
  public abstract int update(T t); 
  public abstract int delete(String id);
}
