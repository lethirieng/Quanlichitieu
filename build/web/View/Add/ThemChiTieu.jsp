<%-- 
    Document   : ThemChiTieu
    Created on : Jul 4, 2023, 12:05:44 AM
    Author     : AD
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Dao.Dao_ChiTieu"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Chi Tiêu</title>
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
                <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet">
                <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
                <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
                 <link
                   rel="stylesheet"
                   type="text/css"
                   href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css"
                 />
                 <link rel="preconnect" href="https://fonts.googleapis.com">
             <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
             <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,500;0,700;0,900;1,400;1,500;1,700;1,900&family=Ysabeau+Infant:ital,wght@0,400;0,500;1,300;1,400&display=swap" rel="stylesheet">
                    <%
                    String url = request.getScheme()+"://"+ request.getServerName()+":" +request.getServerPort() + request.getContextPath();
                    
                     ArrayList<LoaiChiTieu> loais = Dao_LoaiChiTieu_Dao.get().selectQuery("", "on");
                     String tbten = (String)request.getAttribute("tbten");
                     String tbtien = (String)request.getAttribute("tbtien");
                    String thanhcong = (String)request.getAttribute("thanhcong");
                    String openinfo = (String)request.getAttribute("openinfo");
                    %>
                    <link rel="stylesheet" href="<%=url%>/Css/ThemChiTieu.css"/>
    </head>
    <body>
        
        
        
        <%
         if(openinfo != null) {
        %>
        <div class="infomation_screen" id="black" >
            
        </div>
        <div class="from_infomation" id="froms">
            <div class="p-4 d-flex justify-content-between ">
                <i class="fa-solid fa-circle-info"></i>
                <i id="close" class="fa-solid fa-xmark fs-1"></i>
            </div>
            <div class="text-center p-5">
                Hôm nay bạn đã vi phạm <strong class="fs-1 text-danger"><%=openinfo%></strong>  điều lệ do bạn đặt ra <br>
                <h1>Thật Thất vọng <i class="fa-solid fa-face-sad-tear"></i></h1><br>
                Chi Tiết hơn <a class="text-info" href="<%=url%>/View/QuyDinh.jsp">tại đây</a>
            </div>
        </div>
        <%
            }
        %>
        
        
        
        
        
        <div class="main">
            <div class="navbar">
                <div class="nav_flex">
                    <a class="nav_back" href="<%=url%>/View/ChiTieu.jsp">
                        Quay về
                    </a>
                    <a class="nav_logo">
                       Thu Chi
                    </a>
                </div>
            </div>
            <div class="center">
                <div class="main_center">
                    <div class="tiitle_center">
                        <a class="text-tilte">
                            Thêm Thu Chi
                        </a>
                    </div>
                    <div class="content_center">
                        <form action="/QuanLiChiTieu/ThemChiTieu" method="post" enctype="multipart/form-data">
                            <div class="from_add">
                              <div class="row nt-from">
                                  <div class="col-6 from">
                                      <div class="input_name">
                                          <label>Tiêu đề</label>
                                          <input name="tenchitieu" class="form-control" type="text" placeholder="Nhập Tên Chi Tiêu"/>
                                          <span class="text-danger"><%=tbten == null ? "":tbten%></span>
                                      </div>
                                      <div class="input_money">
                                          <label>Số Tiền</label>
                                          <input name="tienchitieu" class="form-control" type="number" placeholder="Nhập Số Tiền Chi Tiêu"/>
                                          <span class="text-danger"><%=tbtien == null ? "":tbtien%></span>
                                      </div>

                                      <div class="input_detail">
                                          <label>Mô tả</label>
                                          <textarea name="noidungchitieu" class="form-control"></textarea>
                                      </div>
                                  </div>
                                  <div class="col-6 from">
                                      <div class="input_Category">
                                          <label> Loại </label>
                                          <select name="loaichitieu" class="form-control">
                                              <%
                                              for (LoaiChiTieu loai : loais) {
                                              %>
                                              <option value="<%=loai.getId()%>">
                                                  <%=loai.getTenLoaiChiTieu()%>
                                              </option>
                                              <%
                                                  }
                                              %>
                                          </select>
                                      </div>
                                           <div class="input_type">
                                          <label> Loại Thu Chi</label>
                                          <select name="loaiThuChi" class="form-control">
                                               <option value="0">
                                                 Thu
                                              </option>
                                               <option value="1">
                                                 Chi
                                              </option>
                                          </select>
                                      </div>

                                      <div class="input_Category">
                                          <label>Hình Ảnh </label>
                                          <input name="hinhchitieu" class="form-control" type="file"/>
                                      </div>
                                       <span class="text-success"><%=thanhcong == null ? "":thanhcong%></span>
                                      <button class="add">
                                          Thêm
                                      </button>
                                  </div>
                              </div>
                          </div>
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
        </div>
        <script src="<%=url%>/js/ChiTieu.js"></script>
    </body>
</html>
