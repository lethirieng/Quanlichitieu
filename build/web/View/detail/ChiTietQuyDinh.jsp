<%-- 
    Document   : ChiTietQuyDinh
    Created on : Jul 5, 2023, 3:38:33 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page import="Dao.Dao_quyDinh"%>
<%@page import="Model.QuyDinh"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chi Tiết Quy Định</title>
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
                    QuyDinh quy = (QuyDinh)session.getAttribute("info");
                    LoaiChiTieu loais = Dao_LoaiChiTieu_Dao.get().LayLoaiChiTieu(quy.getLoaiChiTieu());
                    %>
            <link rel="stylesheet" href="<%=url%>/Css/ChiTietQuyDinh.css"/>
    </head>
    <body>
        <div class="main">
            <div class="navbar">
                <div class="nav_flex">
                    <a class="nav_back" href="<%=url%>/View/QuyDinh.jsp">
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
                            Chi Tiết Quy Định
                        </a>
                    </div>
                    <div class="content_center">
                        <form action="/QuanLiChiTieu/Them_quydinh" method="get">
                            <div class="from_add">
                                <p>Tên Quy định     : <strong><%=quy.getTenquydinh()%></strong></p> <br>
                                <p>Số Tiền Quy định :<strong><%=quy.getGioihanquydinh()%></strong></p> <br>
                                <p>Nội Dung Quy Định:<strong><%=quy.getNoidung()%></strong></p><br>
                                <p>Ngày Tạo         : <strong><%=quy.getNgaytao()%></strong></p><br>
                                <p>Ngày Hết Hạn     : <strong><%=quy.getGioihanngay()%></strong></p><br>
                                <p>Loại Quy Định    : <strong> <%=quy.getLoaiChiTieu() == 0 ? "Tất cả": loais.getTenLoaiChiTieu()%> </strong></p><br>
                                <p>Trạng thái       : <strong><%=quy.getTrangrthai()%></strong></p><br>
                            </div>                         
                        </form>
                    </div>
                    
                </div>
            </div>
        </div>
        </div>
    </body>
</html>
