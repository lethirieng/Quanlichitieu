<%-- 
    Document   : ChiTieu
    Created on : Jun 27, 2023, 1:30:41 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page import="Dao.Dao_ChiTieu"%>
<%@page import="Model.ChiTieu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi Tiêu</title>
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
         String key = (String)request.getAttribute("search");
         ArrayList<ChiTieu> array = Dao_ChiTieu.get().selectquery(key,"");
        
         %>      
          <link rel="stylesheet" href="<%=url%>/Css/ChiTieu.css"/>
    </head>
    <body>
        
        
        
        
            
            
            
            
        <div class="main">
            <div class="navbar">
                <div class="nav_flex">
                    <a class="nav_back" href="<%=url%>/View/NganSach.jsp">
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
                            Danh sách Thu Chi
                        </a>
                    </div>
                    <div class="content_center">
                        <div class="menu_content">
                            <a class="add_content" href="<%=url%>/View/Add/ThemChiTieu.jsp">
                                <i class="fa-solid fa-plus"></i>
                            </a>
                          <form action="/QuanLiChiTieu/TuyBien_ChiTieu" method="get">
                            <div class="search_menu">
                                <input name="search" class="form-control" type="text" placeholder="Nhập Tên Chi Tiêu">
                                <button class="button_search">
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
                                        <th scope="col">Tên</th>
                                        <th scope="col">Số Tiền</th>
                                        <th scope="col">Loại Thu Chi</th>
                                        <th scope="col">Thuộc Loại</th>
                                        <th scope="col">Ngày Tạo</th>
                                        <th scope="col">Hình Ành</th>
                                        <th scope="col">Tùy Chỉnh</th>
                                      </tr>
                                    </thead>
                                    <tbody>
                                        <%
                                            for (ChiTieu ct : array) {
                                           LoaiChiTieu loai = Dao_LoaiChiTieu_Dao.get().LayLoaiChiTieu(ct.getIdLoaiChiTieu());
                                        %>
                                      <tr>
                                        <th scope="row"><%=ct.getId()%></th>
                                        <td><%=ct.getTenChiTieu()%></td>
                                        <td><%=ct.getSoTienChiTieu()%></td>
                                        <td><%=loai.getTenLoaiChiTieu()%></td>
                                        <%
                                            if (ct.getIdLoaiThuChi() == 0) {
                                        %>
                                         <td>Tiền Thu</td>
                                        <%
                                            } else {
                                        %>
                                         <td>Tiền Chi</td>
                                       <%
                                           }
                                       %>
                                        <td><%=ct.getThoiGianChiTieu()%></td>
                                        <td>
                                            <div class="img" >
                                                <%
                                                   if (ct.getHinhanhChiTieu() == null) {
                                                %>
                                                <p>Không có hình ảnh</p>
                                                <%
                                                    }else {
                                                %>
                                                <img src="<%=url%>/img/<%=ct.getHinhanhChiTieu()%>" alt="alt" style="width: 100%;height: 100%"/>
                                                <%
                                                    }
                                                %>
                                            </div>
                                        </td>
                                        <td>
                                            <div class="setting d-flex gap-2">
                                                 <form action="/QuanLiChiTieu/TuyBien_ChiTieu">
                                                    <input class="fake" value="<%=ct.getId()%>"  name="detail">
                                                    <button class="use">
                                                        <i class="fa-solid fa-circle-info"></i>
                                                        chi Tiết
                                                    </button>
                                                </form>
                                                <form action="/QuanLiChiTieu/TuyBien_ChiTieu">
                                                    <input class="fake" value="<%=ct.getId()%>"  name="edit">
                                                    <button class="edit">
                                                        <i class="fa-solid fa-pen-to-square"></i>
                                                        Sửa
                                                    </button>
                                                </form>
                                                <form action="/QuanLiChiTieu/TuyBien_ChiTieu">
                                                    <input class="fake" value="<%=ct.getId()%>"  name="delete">
                                                    <button class="remove">
                                                       <i class="fa-solid fa-xmark"></i>
                                                         xóa
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
