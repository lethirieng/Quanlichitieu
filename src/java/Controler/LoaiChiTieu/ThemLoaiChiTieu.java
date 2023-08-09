/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler.LoaiChiTieu;

import Dao.Dao_LoaiChiTieu_Dao;
import Model.LoaiChiTieu;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
/**
 *
 * @author AD
 */
public class ThemLoaiChiTieu extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String  name = request.getParameter("tenloaichitieu");
       
       
       String sussec = "";
       String ero = "";
       
       if (name.equalsIgnoreCase("")) {
           
          ero = "vui lòng điền vào !";
          
       } else {
           
           // tạo đối tượng hứng dữ liệu
        LoaiChiTieu loaiChiTieus = new LoaiChiTieu(name,"Sử Dụng","");
        
        // Thêm vào database (Dao)
        Dao_LoaiChiTieu_Dao.get().ThemLoaiCT(loaiChiTieus);
        
        
        // gán thông báo
        sussec = "Thêm Thành Công";
        
        }

        // đưa vào thùng thông báo
         request.setAttribute("erro", ero);
         request.setAttribute("sussec", sussec);
        
         // chuyển vể trang view theo link url
        RequestDispatcher rd = request.getRequestDispatcher("./View/Add/ThemLoaiChiTieu.jsp");
        
        // chuyển thùng thư 
        rd.forward(request, response);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
