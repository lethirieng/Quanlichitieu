<%-- 
    Document   : ChiTietChiTieu
    Created on : Jul 5, 2023, 7:54:31 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Model.ChiTieu"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
          <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi Tiết Chi Tiêu</title>
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
                    String url = request.getScheme()+"://"+ request.getServerName()+":" +request.getServerPort() + request.getContextPath();
                    LoaiChiTieu loai = Dao_LoaiChiTieu_Dao.get().LayLoaiChiTieu(chi.getIdLoaiChiTieu());
                    %>
                    <link rel="stylesheet" href="<%=url%>/Css/ChiTietChiTieu.css"/>
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
                            Chi Tiết Thu Chi
                        </a>
                    </div>
                    <div class="content_center">
                           <div class="from_add">
                               <div class="row" style="height: 100%">
                                   <div class="col-6 text-center from-left">
                                       <div class="left">
                                           <%
                                               if(chi.getHinhanhChiTieu() == null) {
                                           %>
                                           <p>Không có hình ảnh</p>
                                           <%
                                               } else {
                                           %>
                                           <img src="<%=url%>/img/<%=chi.getHinhanhChiTieu()%>" alt="alt" style="width: 300px;height: 200px"/> <br>
                                           <%
                                               }
                                           %>
                                           <p class="fw-bold mt-3"><%=chi.getThoiGianChiTieu()%></p>
                                       </div>
                                   </div>
                                    <div class="col-6 from-right">
                                        <div class="right">
                                            <p>Tên              : <strong><%=chi.getTenChiTieu()%></strong></p><br>
                                            <p>Loại             : <strong><%=loai.getTenLoaiChiTieu()%></strong></p><br>
                                            <p>Số Tiền Chi Tiêu : <strong> <%=chi.getSoTienChiTieu()%></strong></p><br>
                                            <%
                                                if(chi.getIdLoaiThuChi() == 0) {
                                            %>
                                             <p>Loại Thu Chi     : <strong>Thu</strong></p><br>
                                            <%
                                                } else {
                                            %>
                                             <p>Loại Thu Chi     : <strong>Chi</strong></p><br>
                                            <%
                                                }
                                            %>
                                            <p>Mô tả Chi Tiêu   : 
                                                <%
                                                    if (chi.getChiTietChiTieu() == null) {
                                                %>
                                            <strong>không có </strong></p><br>
                                                <%
                                                    } else {
                                                %>
                                                  <strong><%=chi.getChiTietChiTieu()%></strong></p><br>
                                                <%
                                                    }
                                                %>
                                               
                                        </div>
                                   </div>
                               </div>
                          </div>
                    </div>
                    
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
