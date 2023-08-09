/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler.QuyDinh;

import Dao.Dao_quyDinh;
import Model.QuyDinh;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AD
 */
@WebServlet(name = "Them_quydinh", urlPatterns = {"/Them_quydinh"})
public class Them_quydinh extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        
         String Tenquydinh =  request.getParameter("tenquyduinh");
         String limitmoney = request.getParameter("sotienquyduinh");
         String content =  request.getParameter("noidungquydinh");
         String Gioihanngay =  request.getParameter("gioihanngay");
         String loaiquydinh = request.getParameter("loaiquydinh");
         
 
         
         
         if(Tenquydinh == "") {
            request.setAttribute("erro_tenquydinh", "Vui Lòng Nhập Tên Quy Định");
         }
         if(limitmoney == "") {
            request.setAttribute("erro_sotienquydinh", "Vui Lòng Nhập số tiền giới hạn");
         }else {
            if(Integer.valueOf(limitmoney) < 0)
            {
               request.setAttribute("erro_sotienquydinh", "Tiền giới hạn  phải lớn hơn 0");
            }
         }
        
         if(content == "") {
           request.setAttribute("erro_noidungquydinh", "Vui Lòng Nhập nội dung  quy định");
         }
         
         
          Calendar cal = Calendar.getInstance();
          SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");     
         if (Gioihanngay.equalsIgnoreCase("0")) {
             cal.set(Calendar.MINUTE, cal.get(Calendar.MINUTE) + 5);
         }
         if (Gioihanngay.equalsIgnoreCase("1")) {
             cal.set(Calendar.HOUR_OF_DAY, cal.get(Calendar.HOUR_OF_DAY) + 1);
         }
         if (Gioihanngay.equalsIgnoreCase("2")) {
              cal.set(Calendar.DAY_OF_MONTH, cal.get(Calendar.DAY_OF_MONTH) + 1);
         }
             java.util.Date datel =  cal.getTime();  
             String date1 = format1.format(datel);

         
         if (content != "" && Tenquydinh!= "") {
             
               QuyDinh quyDinh = new QuyDinh(Tenquydinh, "", Double.valueOf(limitmoney), 
                       date1, content, "chưa vi phạm",Integer.valueOf(loaiquydinh));
               int i = Dao_quyDinh.get().ThemQuyDinh(quyDinh);
               if (i >0) {
                   // duyệt các quy định tại đây
                   request.setAttribute("sussec", "Thêm Thành Công");
               }
               else {
                   System.out.println("Thất bại"); 
               }
            }
             RequestDispatcher rd = request.getRequestDispatcher("/View/Add/ThemQuyDinh.jsp");
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
