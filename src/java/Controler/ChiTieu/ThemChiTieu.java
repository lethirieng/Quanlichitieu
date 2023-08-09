/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package Controler.ChiTieu;

import Dao.Dao_ChiTieu;
import Dao.Dao_ThongBao;
import Dao.Dao_quyDinh;
import Model.ChiTieu;
import Model.QuyDinh;
import Model.ThongBao;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

public class ThemChiTieu extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

                 String tbten ="",tbtien="";
                 int check = 0;
                 String url ="";
				boolean isMultipart = ServletFileUpload.isMultipartContent(request);
			
				     
                                ChiTieu chi = new ChiTieu();

				if(isMultipart == false ) {
				    response.getWriter().append("erro ");
				}
                                else
                                    {
					try {
					String folder = getServletContext().getRealPath("/img"); 
					// XÉT KÍCH THƯỚC FILE QUY ĐỊNH
					int maxFileSize = 5000 * 1024;
					int maxMemSize = 5000 * 1024;
					
					File file;
					
					String contentType = request.getContentType();
					
					if (contentType.indexOf(contentType) >= 0) {
						
						DiskFileItemFactory factory = new DiskFileItemFactory();
						factory.setSizeThreshold(maxMemSize);
						ServletFileUpload upload = new ServletFileUpload(factory);
						upload.setSizeMax(maxFileSize);

						  List<FileItem>  files = upload.parseRequest(request);
						
						for (FileItem fileItem : files) {
							
							if(!fileItem.isFormField()) {
								
								String fileName = System.currentTimeMillis() + fileItem.getName();

								String path = folder + "\\" + fileName;
								
								if  (fileItem.getName().toString() == "" || fileItem.getName().toString() == null) {
							
						     		} else {
                                                                       chi.setHinhanhChiTieu(fileName);
						     			file = new File(path);
						     			fileItem.write(file);
						     		}
                                                                
							}
							else {
                                                           
                                                           if("tenchitieu".equals(fileItem.getFieldName().toString())){
                                                               
                                                                        if("".equals(fileItem.getString())) {	
										tbten = "vui lòng nhập tên!";
									}else {
									  chi.setTenChiTieu(fileItem.getString("UTF-8"));
									}
                                                            }
                                                            if("tienchitieu".equals(fileItem.getFieldName().toString())){
                                                                      if("".equals(fileItem.getString())) {	
										tbtien = "vui lòng nhập tiền!";
									}else {
                                                                          if (Integer.valueOf(fileItem.getString("UTF-8")) < 0) {
                                                                              tbtien = "tiền chi tiêu phải lớn hơn 0 !";
                                                                          }
									  chi.setSoTienChiTieu(Integer.valueOf(fileItem.getString("UTF-8")));
									}
                                                             }
                   
                                                            if("loaichitieu".equals(fileItem.getFieldName().toString())){
                                                                        if("".equals(fileItem.getString())) {	
										
									}else {
							                    chi.setIdLoaiChiTieu(Integer.valueOf(fileItem.getString()));
									}
                                                            }
                                                            if("edits".equals(fileItem.getFieldName().toString())){
                                                                   if("".equals(fileItem.getString())) {	
										
									}else {
							                   check = Integer.valueOf(fileItem.getString());
									}
                                                                  
                                                            }
                                                            if("loaiThuChi".equals(fileItem.getFieldName().toString())){
							        chi.setIdLoaiThuChi(Integer.valueOf(fileItem.getString()));
                                                                  
                                                            }
     
                                                   }
                                                   
                                                }
                                          
                                        }
                                        
					 
					} catch (FileUploadException e) {
						request.setAttribute("ero", e.getMessage());
						
					} catch (Exception e) {
						// TODO Auto-generated catch block
						request.setAttribute("ero", e.getMessage());
					}
                                        
                                        
				}
                                
                                          Calendar cal = Calendar.getInstance();
				        java.util.Date datel =  cal.getTime();         
				       SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd   HH:mm:ss");
				       String date1 = format1.format(datel); 
                                       chi.setThoiGianChiTieu(date1);
                                      
                                       
                                       
                                       
                                       
                                       if(check == 0) {
                                            url = "/View/Add/ThemChiTieu.jsp";
                                            
                                            if (tbten.equalsIgnoreCase("") && tbtien.equalsIgnoreCase("") ) {
                                               int  i = Dao_ChiTieu.get().ThemCT(chi);
                                              request.setAttribute("thanhcong", "Thêm Thành Công"); 
                                             
                                           
                                                   
                                            ArrayList<QuyDinh> danhsachquydinh = Dao_quyDinh.get().kiemtraquydinh();
                                            int sum = 0;

                                            for (QuyDinh quy : danhsachquydinh) {


                                                ArrayList<ChiTieu> chitieus = Dao_ChiTieu.get().LayChiTieukiemtra(
                                                           quy.getLoaiChiTieu(), quy.getNgaytao());

                                                for(ChiTieu chis : chitieus) {
                                                   sum += chis.getSoTienChiTieu();
                                                }

                                                if (sum > quy.getGioihanquydinh()) {
                                                    
                                                    Dao_quyDinh.get().capnhatquypham(quy.getId());
                                                    ArrayList<QuyDinh> quyDinhs = Dao_quyDinh.get().LayThongBao();
                                                    request.setAttribute("openinfo", String.valueOf(quyDinhs.size()));
                                                    
                                                    ThongBao tb = new ThongBao();
                                                    tb.setMagd(quy.getId());
                                                    Dao_ThongBao.get().TaoThongBao(tb);
                                                    
                                                } else {
                                                  System.err.println(quy.getTenquydinh()+" chưa quy phạm");
                                                }
                                                sum = 0;
                                            }
 
                                             }
                                       } else {
                                       HttpSession session = request.getSession();
                                         chi.setId(check);
                                         url = "/View/Edit/SuaChiTieu.jsp";
                                           if (tbten.equalsIgnoreCase("") && tbtien.equalsIgnoreCase("") ) {
                                         Dao_ChiTieu.get().CapNhatChiTieu(chi);
                                          session.setAttribute("info", chi);
                                           }
                                       }
                                request.setAttribute("tbten",tbten);
                                request.setAttribute("tbtien", tbtien);
				// TẠO  HÀM CHUYỂN TOÀN BỘ REQUST VỀ TRANG CHỈ ĐỊNH
				RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
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
