/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler.QuyDinh;

import Dao.Dao_quyDinh;
import Model.QuyDinh;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author AD
 */
public class TuyBien_Quydinh extends HttpServlet {


    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String tenquydinh =  request.getParameter("tenquydinh");
        String gioihantien = request.getParameter("sotienquydinh");
        String gioihanngay = request.getParameter("gioihanngay");
        String noidung = request.getParameter("noidungquydinh");
        String loaichitieu = request.getParameter("LoaChiTieus");
        String edit  = request.getParameter("edit");
        String delete = request.getParameter("remove");
        String detail = request.getParameter("detail");
        String search = request.getParameter("search");
        String devstatus = request.getParameter("devstatus");
        
  
        
        String tbtenquydinh = "", tbnoidung = "",tbgioihantien = "";
        String url = "";
        QuyDinh quy = null;
        
        
        if(devstatus != null) {
        url = "./View/QuyDinh.jsp";
          Dao_quyDinh.get().khoiphuctinhtrang(Integer.valueOf(Integer.valueOf(devstatus)));
        }
        if(search != null) {
        url = "./View/QuyDinh.jsp";
        request.setAttribute("keysearch", search);
        }
        if(detail != null) {
          url = "./View/detail/ChiTietQuyDinh.jsp";
          quy = Dao_quyDinh.get().layquydinh(Integer.valueOf(detail));
         session.setAttribute("info", quy);
        }
        if(delete != null) {
          Dao_quyDinh.get().XoaQuyDinh(Integer.valueOf(delete));
         url = "./View/QuyDinh.jsp";
        }
        
        if(edit != null) {
          
         session.removeAttribute("info");
         url = "./View/Edit/SuaQuyDinh.jsp";
         quy = Dao_quyDinh.get().layquydinh(Integer.valueOf(edit));
         session.setAttribute("info", quy);
        }
        System.out.println("Minhkhoi"+ loaichitieu);
        
        if(tenquydinh != null && gioihanngay != null && gioihantien != null && noidung != null) {
            QuyDinh quyd = (QuyDinh)session.getAttribute("info");
            url = "./View/Edit/SuaQuyDinh.jsp";
            String typedate ="";
            int valuesdate = 0;
             
            QuyDinh quydinh = new QuyDinh();
            quydinh.setTenquydinh(tenquydinh.toString());
            quydinh.setNoidung(noidung);
            quydinh.setGioihanquydinh(Float.parseFloat(gioihantien));
            quydinh.setId(quyd.getId());
            quydinh.setLoaiChiTieu(Integer.valueOf(loaichitieu));
           
           if (gioihanngay.equalsIgnoreCase("0")) {
              typedate ="MINUTE";
              valuesdate = 5;
           }
           if (gioihanngay.equalsIgnoreCase("1")) {
               typedate ="HOUR";
              valuesdate = 1;
           }
           if (gioihanngay.equalsIgnoreCase("2")) {
               typedate ="DAY";
              valuesdate = 1;
           }
           Dao_quyDinh.get().capnhatquydinh(quydinh, typedate, valuesdate);
          QuyDinh quys = Dao_quyDinh.get().layquydinh(quyd.getId());
           session.setAttribute("info", quys);
        }
      
        
        
        
        
        
        
        request.setAttribute("tbnoidung", tbnoidung);
        request.setAttribute("tbgioihantien", tbgioihantien);
        request.setAttribute("tbtenquydinh", tbtenquydinh);

        RequestDispatcher rd = request.getRequestDispatcher(url);
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
