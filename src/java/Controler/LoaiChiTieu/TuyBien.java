/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler.LoaiChiTieu;

import Dao.Dao_LoaiChiTieu_Dao;
import Model.LoaiChiTieu;
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
public class TuyBien extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        response.setContentType("text/html;charset=UTF-8");
        

        String update = request.getParameter("sualoaichitieu");
        
        String edit = request.getParameter("edit");
        
        String changeoff = request.getParameter("changeoff");
        String changeon = request.getParameter("changeon");
        String delete = request.getParameter("delete");
        
        String url = "";
        
        
        
        if(delete != null) {
          url = "./View/LoaiChiTieu.jsp";
          Dao_LoaiChiTieu_Dao.get().XoaLoaiCT(Integer.parseInt(delete));
        }
        
        
        if(changeon != null) {
          url = "./View/LoaiChiTieu.jsp";
          Dao_LoaiChiTieu_Dao.get().sudung(Integer.parseInt(changeon));
        }
        
        if(changeoff != null) {
          url = "./View/LoaiChiTieu.jsp";
          Dao_LoaiChiTieu_Dao.get().khongsudung(Integer.parseInt(changeoff));
        }        
  
        
        if (update!= null) {
             url = "./View/Edit/SuaLoaiChiTieu.jsp";
             
            if(update == "") {
              request.setAttribute("fail_up","Cập Nhật không Thành Công");
            } else {
                request.setAttribute("info", update);
                LoaiChiTieu loai = new LoaiChiTieu();
                loai.setId(Integer.parseInt((String) session.getAttribute("info")));
                loai.setTenLoaiChiTieu(update);
                Dao_LoaiChiTieu_Dao.get().sualoaiCT(loai);
                request.setAttribute("sussec_up","Cập Nhật Thành Công");
            }
        }
        
         if (edit != null) {
           url = "./View/Edit/SuaLoaiChiTieu.jsp";
           session.setAttribute("info", edit);
        }
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
