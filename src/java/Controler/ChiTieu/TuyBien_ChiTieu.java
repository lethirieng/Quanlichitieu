/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler.ChiTieu;

import Dao.Dao_ChiTieu;
import Model.ChiTieu;
import java.io.IOException;
import java.io.PrintWriter;
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
public class TuyBien_ChiTieu extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String edit = (String)request.getParameter("edit");
        String detail = request.getParameter("detail");
        String delete = request.getParameter("delete");
        String search = request.getParameter("search");
        String getdate = request.getParameter("date");
        String url = "./View/ChiTieu.jsp";
        
        
        if (getdate != null) {
             request.setAttribute("date", getdate);
          url = "./View/NganSach.jsp";
            }
        if (search != null && search != "") {
          request.setAttribute("search", search);
          url = "./View/ChiTieu.jsp";
        }
        if(delete != null) {
          ChiTieu chi = Dao_ChiTieu.get().LayChiTieu(Integer.valueOf(delete));
          Dao_ChiTieu.get().XoaChiTieu(chi.getId());
           url = "./View/ChiTieu.jsp";
        }
        if(detail != null) {
          ChiTieu chi = Dao_ChiTieu.get().LayChiTieu(Integer.valueOf(detail));
          session.setAttribute("info", chi);
          url = "./View/detail/ChiTietChiTieu.jsp";
        }
        if(edit != null) {
          ChiTieu chi = Dao_ChiTieu.get().LayChiTieu(Integer.valueOf(edit));
          session.setAttribute("info", chi);
          url = "./View/Edit/SuaChiTieu.jsp";
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
