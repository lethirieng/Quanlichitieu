<%-- 
    Document   : ThongBao
    Created on : Jul 13, 2023, 2:22:58 PM
    Author     : AD
--%>

<%@page import="Dao.Dao_quyDinh"%>
<%@page import="Model.QuyDinh"%>
<%@page import="Dao.Dao_ThongBao"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Model.ThongBao"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
            <title>Thông báo</title>
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
                      String param = (String)request.getAttribute("settab");
                      String url = request.getScheme()+"://"+ request.getServerName()+":" +request.getServerPort() + request.getContextPath();
                        ArrayList<ThongBao> tb = Dao_ThongBao.get().laythongbao(param);
                    %>
                 <link rel="stylesheet" href="<%=url%>/Css/ThongBao.css"/>
        </head>
    <body>
           <div class="main">
            <div class="navbar">
                <div class="nav_flex">
                    <a class="nav_back" href="<%=url%>/View/NganSach.jsp">
                        Quay về
                    </a>
                    <a class="nav_logo">
                       Thông Báo
                    </a>
                </div>
            </div>
            <div class="center">
                <div class="menu">
                    <div class="item_menu ">
                        <form action="/QuanLiChiTieu/TuyBien_ThongBao" method="get">
                            <input class="fake" value="all" name="settab">
                            <button class="btnfake">all</button>
                        </form>
                    </div>
                    <div class="item_menu ">
                        <form action="/QuanLiChiTieu/TuyBien_ThongBao" method="get">
                              <input class="fake" value="chi" name="settab">
                              <button class="btnfake">Chi</button>
                        </form>
                    </div>
                    <div class="item_menu">
                        <form action="/QuanLiChiTieu/TuyBien_ThongBao" method="get">
                              <input class="fake" value="thu" name="settab">
                            <button class="btnfake">Thu</button>
                        </form>
                    </div>
                    <div class="item_menu">
                        <form action="/QuanLiChiTieu/TuyBien_ThongBao" method="get">
                              <input class="fake" value="quydinh" name="settab">
                            <button class="btnfake">Quy định</button>
                        </form>
                    </div>
                </div>
                
                  <div class="container mt-2">
                            <div class="list" style="height:500px">
                                <div class="list_ment">
                                     <%
                                    
                                      for(ThongBao tbx : tb) {
                                     %>
                                        <div class="item_list">
                                            <%
                                                if(tbx.getMathuchi() == 1 && tbx.getMagd() == 0) {
                                            %>
                                            <span class="meto">Chi tháng 
                                                <%
                                                    if(tbx.getTinhchat() == 1) {
                                                %>
                                                  <i class="fa-solid fa-up-long text-danger"></i>
                                                <%
                                                    } else if(tbx.getTinhchat() == 2) {
                                                %>
                                                <i class="fa-solid fa-down-long text-success"></i>
                                                <%
                                                    } else {
                                                %>
                                                 <i class="fa-solid fa-minus text-secondary"></i>
                                                <%
                                                    }
                                                %>
                                            </span>
                                            <%
                                                } else if(tbx.getMathuchi() == 0 && tbx.getMagd() == 0) {
                                            %>
                                            <span class="meto">Thu tháng
                                               <%
                                                    if(tbx.getTinhchat() == 1) {
                                                %>
                                                  <i class="fa-solid fa-up-long text-danger"></i>
                                                <%
                                                    } else if(tbx.getTinhchat() == 2) {
                                                %>
                                                <i class="fa-solid fa-down-long text-success"></i>
                                                <%
                                                    } else {
                                                %>
                                                 <i class="fa-solid fa-minus text-success"></i>
                                                <%
                                                    }
                                                %>
                                            </span>
                                            <%
                                                }
                                            if(tbx.getMagd() > 0) {
                                                 QuyDinh qd = Dao_quyDinh.get().layquydinh(tbx.getMagd());
                                            %>
                                            <span class="meto">Quy Phạm <%=qd.getTenquydinh()%></span>
                                            <p style="width: 300px">
                                                 <%=qd.getNoidung() == null ? "": qd.getNoidung()%>
                                            </p>
                                            <%
                                                } else {
                                            %>
                                            
                                            <p style="width: 300px">
                                                <%=tbx.getNoidung()%>
                                            </p>
                                            <%
                                                }
                                            %>
                                            <span class="date"><%=tbx.getGhimthoigian()%></span>
                                          
                                         </div>
                                      <%
                                          }
                                      %>
                                </div>
                            </div>
                   </div>
            </div>
        </div>
        </div>
    </body>
</html>
