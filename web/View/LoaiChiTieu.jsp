<%-- 
    Document   : Add_LoaichiTieu
    Created on : Jun 27, 2023, 2:27:48 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Lọa Chi Tiêu</title>
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
                    %>
                    <link rel="stylesheet" href="<%=url%>/Css/LoaiChiTieu.css"/>
                    <%
                     String key  = (String)request.getAttribute("timkiem");
                     ArrayList<LoaiChiTieu> listcategory = Dao_LoaiChiTieu_Dao.get().selectQuery(key,"");
                    %>
            </head>
    <body> 
          <div class="main">
            <div class="navbar">
                <div class="nav_flex">
                    <a class="nav_back" href="<%=url%>/View/NganSach.jsp">
                        Quay về
                    </a>
                    <a class="nav_logo">
                       Loại Chi Tiêu
                    </a>
                </div>
            </div>
            <div class="center">
                <div class="main_center">
                    <div class="tiitle_center">
                        <a class="text-tilte">
                            Danh sách Loại Chi Tiêu
                        </a>
                    </div>
                    <div class="content_center">
                        <div class="menu_content">
                            <a class="add_content" href="<%=url%>/View/Add/ThemLoaiChiTieu.jsp">
                                <i class="fa-solid fa-plus"></i>
                            </a>
            
                            <form action="/QuanLiChiTieu/TuyBien">
                                <div class="search_menu">
                                    <input class="form-control" type="text" placeholder="Nhập Tên Loại Chi Tiêu" name="">
                                <button id="search">
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
                                        <th scope="col">Tên Loại Chi Tiêu</th>
                                        <th scope="col">Trạng thái </th>
                                        <th scope="col"> Ngày tạo </th>
                                        <th scope="col"> Tùy Chỉnh </th> 
                                      </tr>
                                    </thead>
                                    <tbody>
                                      <%
                                       for( LoaiChiTieu loai : listcategory) {
                                      %>
                                      <tr>
                                        <th scope="row"><%=loai.getId()%></th>
                                        <td><%=loai.getTenLoaiChiTieu()%></td>
                                        <td><%=loai.getTrangthai()%></td>
                                        <td><%=loai.getNgayTao()%></td>
                                        <td>
                                            <div class="d-flex gap-2">
                                             <%
                                             if(loai.getTrangthai().contains("on")) {
                                             %>
                                             
                                       
                                                <form action="/QuanLiChiTieu/TuyBien">
                                                    <input name="edit" class="fake" type="text" value="<%=loai.getId()%>">
                                                    <button class="edit">
                                                        <i class="fa-solid fa-pen-to-square"></i>
                                                        Sửa
                                                    </button>
                                                </form>
                                                    
                                                    
                                                    
                                                <form action="/QuanLiChiTieu/TuyBien">
                                                    <input  name="changeoff" class="fake" type="text" value="<%=loai.getId()%>">
                                                    <button class="off">
                                                        <i class="fa-solid fa-down-long"></i>
                                                        không dùng
                                                    </button>
                                                </form>
                                                
                                              <%
                                                  } else {
                                              %>
                                      
                                           
                                               <form action="/QuanLiChiTieu/TuyBien">
                                                    <input  name="changeon" class="fake" type="text" value="<%=loai.getId()%>">
                                                    <button class="use">
                                                        <i class="fa-solid fa-up-long"></i>
                                                        dùng
                                                    </button>
                                                </form>
                                                    
                                                 
                                                    
                         
                                                <form action="/QuanLiChiTieu/TuyBien">
                                                    <input  name="delete" class="fake" type="text" value="<%=loai.getId()%>">
                                                    <button class="remove">
                                                        <i class="fa-solid fa-xmark"></i>
                                                        xóa
                                                    </button>
                                                </form>
                                                    
                                                    
                                              <%
                                                  }
                                              %>
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
        <script src="<%=url%>/js/LoaiChiTieu.js"></script>
    </body>
</html>
