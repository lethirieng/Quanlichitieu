<%-- 
    Document   : SuaLoaiChiTieu
    Created on : Jul 4, 2023, 5:58:31 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
     <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Thêm Loại Chi Tiêu</title>
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
                    <link rel="stylesheet" href="<%=url%>/Css/SuaLoaiChiTieu.css"/>
    </head>
    
    
    
    <%
    String thongbao = (String)request.getAttribute("fail_up");
    String thongbao2 = (String)request.getAttribute("sussec_up");
    
    
    String id = (String)session.getAttribute("info");
    LoaiChiTieu loais = Dao_LoaiChiTieu_Dao.get().LayLoaiChiTieu(Integer.valueOf(id));
    %>
    
    
    <body>
         <div class="main">
            <div class="navbar">
                <div class="nav_flex">
                    <a class="nav_back" href="<%=url%>/View/LoaiChiTieu.jsp">
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
                            Sửa Loại Chi Tiêu
                        </a>
                    </div>
                    <div class="content_center">
                        
                        <form action="/QuanLiChiTieu/TuyBien" method="get">
                            <div class="from_add">
                                <label>Tên Loại Chi Tiêu cần sửa</label>
                                <input value="<%=loais.getTenLoaiChiTieu()%>" class="form-control" type="text" placeholder="Nhập Tên Loại Chi Tiêu" name="sualoaichitieu"/>
                                <button class="add">Cập nhật</button><br>
                                <span class="text-danger"><%=thongbao ==  null ? "":thongbao%></span>
                                <span class="text-success"><%=thongbao2== null ? "" : thongbao2 %></span>
                            </div> 
                        </form>
                        
                        
                    </div>
                    
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
