<%-- 
    Document   : SuaChiTieu
    Created on : Jul 5, 2023, 4:27:11 PM
    Author     : AD
--%>

<%@page import="Model.ChiTieu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sửa Chi Tiêu</title>
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
                    ChiTieu chi = (ChiTieu)session.getAttribute("info");
                    ArrayList<LoaiChiTieu> loais = Dao.Dao_LoaiChiTieu_Dao.get().selectQuery("", "on");
                    String url = request.getScheme()+"://"+ request.getServerName()+":" +request.getServerPort() + request.getContextPath();
                     String tbten = (String)request.getAttribute("tbten");
                     String tbtien = (String)request.getAttribute("tbtien");
                    %>
                    <link rel="stylesheet" href="<%=url%>/Css/SuaChiTieu.css"/>
    </head>
    <body>
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
                            Sửa  Thu Chi
                        </a>
                    </div>
                    <div class="content_center">
                         <form action="/QuanLiChiTieu/ThemChiTieu" method="post" enctype="multipart/form-data">
                            <div class="from_add">
                              <div class="row nt-from">
                                  <div class="col-6 from">
                                      <div class="input_name">
                                          <label>Tên</label>
                                          <input value="<%=chi.getTenChiTieu()%>" name="tenchitieu" class="form-control" type="text" placeholder="Nhập Tên Chi Tiêu"/>
                                             <span class="text-danger"><%=tbten == null ? "":tbten%></span>
                                      </div>
                                      <div class="input_money">
                                          <label>Số Tiền</label>
                                          <input value="<%=chi.getSoTienChiTieu()%>" name="tienchitieu" class="form-control" type="nummber" placeholder="Nhập Số Tiền Chi Tiêu"/>
                                            <span class="text-danger"><%=tbtien == null ? "":tbtien%></span>
                                      </div>

                                      <div class="input_detail">
                                          <label>Mô tả</label>
                                          <textarea name="noidungchitieu" class="form-control"><%=chi.getChiTietChiTieu() == null ? "":chi.getChiTietChiTieu()%></textarea>
                                        
                                      </div>
                                  </div>
                                  <div class="col-6 from">
                                      <div class="input_Category">
                                          <label> Loại</label>
                                          <select name="loaichitieu" class="form-control">
                                              <%
                                              for (LoaiChiTieu loai : loais) {
                                              if(loai.getId() == chi.getIdLoaiChiTieu()) {
                                              %>
                                              <option value="<%=loai.getId()%>" selected>
                                                  <%=loai.getTenLoaiChiTieu()%>
                                              </option>
                                              <%
                                                  } else {
                                              %>
                                              <option value="<%=loai.getId()%>">
                                                  <%=loai.getTenLoaiChiTieu()%>
                                              </option>
                                              <%
                                                  }}
                                              %>
                                          </select>
                                      </div>
                                         
                                        <div class="input_type">
                                          <label> Loại Thu Chi</label>
                                          <select name="loaiThuChi" class="form-control">
                                              <option value="1">
                                                 Chi
                                              </option>
                                               <%
                                              if(chi.getIdLoaiThuChi() == 0) {
                                                %>
                                                <option value="0" selected>
                                                 Thu
                                              </option>
                                              <%
                                                  }
                                              %>
                                          </select>
                                      </div>
                                       <div class="input_Category">
                                          <label>Hình Ảnh Hiện tại </label>
                                          <%
                                              if (chi.getHinhanhChiTieu() == null) {
                                          %>
                                          <p>Không có hình ảnh</p>
                                          <%
                                              } else {
                                          %>
                                             <img src="<%=url%>/img/<%=chi.getHinhanhChiTieu()%>" alt="alt" style="width: 60px;height: 60px"/>
                                          <%
                                              }
                                          %>
                                       
                                          <input name="hinhchitieu" class="form-control" type="file"/>
                                      </div>
                                          <input class="fake" type="text" name="edits" value="<%=chi.getId()%>">
                                      <button class="add">
                                          Cập Nhật
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
    </body>
</html>
