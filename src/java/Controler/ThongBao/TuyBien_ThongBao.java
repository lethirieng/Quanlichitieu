/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler.ThongBao;

import Dao.Dao_ThongBao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TuyBien_ThongBao extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       String trangthai =request.getParameter("settab");
       String tb = request.getParameter("tb");
       if(trangthai != null) {
        if (trangthai.equalsIgnoreCase("all")) {
          request.setAttribute("settab", trangthai);
        }
        if (trangthai.equalsIgnoreCase("thu")) {
          request.setAttribute("settab", trangthai);
        }
        if (trangthai.equalsIgnoreCase("chi")) {
          request.setAttribute("settab", trangthai);
        }
        if (trangthai.equalsIgnoreCase("quydinh")) {
          request.setAttribute("settab", trangthai);
        }
       }
       if(tb != null) {
           Dao_ThongBao.get().capnhatdaxem();
       }
        RequestDispatcher rd = request.getRequestDispatcher("/View/ThongBao.jsp");
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
