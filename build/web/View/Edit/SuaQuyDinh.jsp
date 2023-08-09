<%-- 
    Document   : SuaQuyDinh
    Created on : Jul 5, 2023, 1:25:55 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.QuyDinh"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>sửa quy định</title>
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
                    ArrayList<LoaiChiTieu> loais = Dao_LoaiChiTieu_Dao.get().selectQuery("", "on");
                       %>
                    <link rel="stylesheet" href="<%=url%>/Css/SuaQuyDinh.css"/>
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
                            Sửa Quy Định
                        </a>
                    </div>
                    <div class="content_center">
                        
                        <form action="/QuanLiChiTieu/TuyBien_Quydinh" method="get">
                            <div class="from_add">
                                <div class="row nt-from">
                                    <div class="col-6 from">
                                        <div class="input_name">
                                            <label>Tên Quy Định cần sửa</label>
                                            <input value="<%=quy.getTenquydinh().toString()%>" name="tenquydinh" class="form-control" type="text" placeholder="Nhập Tên Quy Định"/>
                                        </div>
                                        <div class="input_rulemoney">
                                            <label>Số Tiền Giới Hạn cần sửa</label>
                                            <input value="<%=quy.getGioihanquydinh()%>" name="sotienquydinh" class="form-control" type="number" placeholder="Nhập Số Tiền Quy Định"/>
                                          
                                        </div>
                                         <div class="input_category">
                                            <label>Loại quy định</label>
                                            <select class="form-control" name="LoaChiTieus">
                                                <option value="0" selected>
                                                   tất cả
                                                </option>
                                                <%
                                                    for (LoaiChiTieu loaisx : loais) {
                                                   if (loaisx.getId() == quy.getLoaiChiTieu()) {
                                                %>
                                                <option value="<%=loaisx.getId()%>" selected>
                                                    <%=loaisx.getTenLoaiChiTieu()%>
                                                </option>
                                                <%
                                                    } else {
                                                %>
                                                <option value="<%=loaisx.getId()%>">
                                                    <%=loaisx.getTenLoaiChiTieu()%>
                                                </option>
                                                <%
                                                    }}
                                                %>
                                            </select>
                                        </div>

                                    </div>
                                    <div class="col-6 from">
                                        <div class="input_content">
                                            <label>Nội Dung quy Định cần sửa</label>
                                            <textarea class="form-control" name="noidungquydinh" placeholder="Nhập Nội dung quy định"><%=quy.getNoidung()%></textarea>
                                  
                                        </div>
                                        <div class="input_time">
                                            <label>Thời Gian cần thêm</label>
                                            <select class="form-control" name="gioihanngay">
                                                <option value="0">
                                                   5 phút
                                                </option>
                                                 <option value="1">
                                                   1 giờ
                                                </option>
                                                <option value="2">
                                                   1 ngày
                                                </option>
                                            </select>
                                        </div>
                                        
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
