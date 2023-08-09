<%-- 
    Document   : ThemQuyDinh
    Created on : Jul 3, 2023, 11:08:17 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Dao.Dao_ChiTieu"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
                    String erro_tenquydinh = (String)request.getAttribute("erro_tenquydinh");
                    String erro_sotienquydinh = (String)request.getAttribute("erro_sotienquydinh");
                    String erro_noidungquydinh = (String)request.getAttribute("erro_noidungquydinh");
                    String sussec = (String)request.getAttribute("sussec");
                    ArrayList<LoaiChiTieu> loais = Dao_LoaiChiTieu_Dao.get().selectQuery("", "on");
                    %>
            <link rel="stylesheet" href="<%=url%>/Css/ThemQuyDinh.css"/>
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
                            Thêm Quy Định
                        </a>
                    </div>
                    <div class="content_center">
                        
                        <form action="/QuanLiChiTieu/Them_quydinh" method="get">
                            <div class="from_add">
                                <div class="row nt-from">
                                    <div class="col-6 from">
                                        <div class="input_name">
                                            <label>Tên Quy Định</label>
                                            <input name="tenquyduinh" class="form-control" type="text" placeholder="Nhập Tên Quy Định"/>
                                            <span class="text-danger"><%=erro_tenquydinh==null ? "":erro_tenquydinh%></span>
                                        </div>
                                        <div class="input_rulemoney">
                                            <label>Số Tiền Giới Hạn</label>
                                            <input name="sotienquyduinh" class="form-control" type="number" placeholder="Nhập Số Tiền Quy Định"/>
                                            <span class="text-danger"><%=erro_sotienquydinh==null ? "":erro_sotienquydinh%></span>
                                        </div>
                                         <div class="input_loai">
                                             <label>Quy Định loại chi Tiêu</label>
                                            <select class="form-control" name="loaiquydinh">
                                                <option value="0">
                                                   tất cả
                                                </option>
                                                <%
                                                    for (LoaiChiTieu loaiss : loais) {
                                                %>
                                                <option value="<%=loaiss.getId()%>">
                                                   <%=loaiss.getTenLoaiChiTieu()%>
                                                </option>
                                                <%
                                                    }
                                                %>
                                            </select>
                                        </div>
                                    </div>
                                    <div class="col-6 from">
                                        <div class="input_content">
                                            <label>Nội Dung quy Định</label>
                                            <textarea class="form-control" name="noidungquydinh" placeholder="Nhập Nội dung quy định"></textarea>
                                            <span class="text-danger"><%=erro_noidungquydinh == null ? "":erro_noidungquydinh%></span>
                                        </div>
                                        <div class="input_time">
                                            <label>Thời Gian sữ dụng</label>
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
                                        <span class="text-success"><%=sussec == null ? "":sussec%></span>
                                        <button class="add">
                                            Thêm
                                        </button>
                                        </div>
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
