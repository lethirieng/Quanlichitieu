<%-- 
    Document   : Add_LoaichiTieu
    Created on : Jun 27, 2023, 2:27:48 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_quyDinh"%>
<%@page import="Model.QuyDinh"%>
<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Quy Dinh</title>
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
                    String keysearch = (String)request.getAttribute("keysearch");
                    ArrayList<QuyDinh>  array = Dao_quyDinh.get().selectquery(keysearch);
                    String url = request.getScheme()+"://"+ request.getServerName()+":" +request.getServerPort() + request.getContextPath();
                    %>
                    <link rel="stylesheet" href="<%=url%>/Css/Quydinh.css"/>
            </head>
    <body> 
         <div class="main">
            <div class="navbar">
                <div class="nav_flex">
                    <a class="nav_back" href="<%=url%>/View/NganSach.jsp">
                        Quay về
                    </a>
                    <a class="nav_logo">
                       Quy Định
                    </a>
                </div>
            </div>
            <div class="center">
                <div class="main_center">
                    <div class="tiitle_center">
                        <a class="text-tilte">
                            Danh sách Quy Định
                        </a>
                    </div>
                    <div class="content_center">
                        <div class="menu_content">
                            <a class="add_content" href="<%=url%>/View/Add/ThemQuyDinh.jsp">
                                <i class="fa-solid fa-plus"></i>
                            </a>
                          
                             <form action="/QuanLiChiTieu/TuyBien_Quydinh" method="get">
                                <div class="search_menu">
                                    <input name="search" class="form-control" type="text" placeholder="Nhập Tên Quy Định">
                                    <button class="search_button">
                                        <i class="fa-solid fa-magnifying-glass"></i>
                                    </button>
                                </div>
                            </form>
                        </div>
                        <div class="list_content">
                            <table class="table">
                                
                                    <thead>
                                      <tr>
                                        <th scope="col">Id</th>
                                        <th scope="col">Tên Quy Định</th>
                                        <th scope="col">Sữ Dụng Đến Ngày </th>
                                        <th scope="col"> Mức Hạn</th>
                                        <th scope="col"> Tình Trạng </th> 
                                        <th scope="col"> Tùy Chỉnh </th> 
                                      </tr>
                                    </thead>
                                    
                                    <tbody>
                                        <%
                                          for(QuyDinh qd :array) {
                                             ArrayList<QuyDinh> check = Dao_quyDinh.get().checkngaysudung(qd.getId());
                                        %>
                                        <tr class="<%=check.size() == 0 || qd.getTrangrthai().equalsIgnoreCase("Đã Vi Phạm") ? "bg-danger":""%>" >
                                        <th scope="row"><%=qd.getId()%></th>
                                        <td><%=qd.getTenquydinh()%></td>
                                        <%
                                          if (check.size() == 0 || qd.getTrangrthai().equalsIgnoreCase("Đã Vi Phạm")) {
                                        %>
                                            <td class="fw-bold text-light">Không còn Khả Dụng</td>
                                        <%
                                            } else {
                                        %>
                   
                                         <td class="fw-bold text-success">Còn Khả Dụng</td>
                                         <%
                                             }
                                         %>
                                         <td><%=qd.getGioihanquydinh()%></td>
                                        <td><%=qd.getTrangrthai()%></td>
                                        <td style="width: 500px">
                                            <div class="setting gap-2">
                                                <form action="/QuanLiChiTieu/TuyBien_Quydinh" method="get">
                                                     <input class="fake" value="<%=qd.getId()%>" type="text" name="detail">
                                                     <button class="use">
                                                        <i class="fa-solid fa-circle-info"></i>
                                                        Chi Tiết
                                                    </button>
                                                </form>
                                                <form action="/QuanLiChiTieu/TuyBien_Quydinh" method="get">
                                                    <input class="fake" value="<%=qd.getId()%>" type="text" name="edit">
                                                    <button class="edit">
                                                       <i class="fa-solid fa-pen-to-square"></i>
                                                        sửa
                                                    </button>
                                                </form>
                                                <form action="/QuanLiChiTieu/TuyBien_Quydinh" method="get">
                                            <input class="fake" value="<%=qd.getId()%>" type="text" name="remove">
                                            <button class="remove">
                                                        <i class="fa-solid fa-xmark"></i>
                                                        xóa
                                                    </button>
                                                </form>
                                                     <form action="/QuanLiChiTieu/TuyBien_Quydinh" method="get">
                                            <input class="fake" value="<%=qd.getId()%>" type="text" name="devstatus">
                                            <button class="restore">
                                                        <i class="fa-solid fa-window-restore"></i>
                                                            khôi phục tình trạng
                                                    </button>
                                                </form>
                                            </div>
                                        </td>
                                      </tr>
                                      <%
                                          }
                                      %>
                                    </tbody>
                                </table>
                        </div>
                    </div>
                    
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
