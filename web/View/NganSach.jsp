<%-- 
    Document   : NganSach
    Created on : Jun 27, 2023, 1:30:56 PM
    Author     : AD
--%>

<%@page import="javax.swing.JOptionPane"%>
<%@page import="Model.ThongBao"%>
<%@page import="Dao.Dao_ThongBao"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Date"%>
<%@page import="Dao.Dao_LoaiChiTieu_Dao"%>
<%@page import="Model.LoaiChiTieu"%>
<%@page import="java.util.ArrayList"%>
<%@page import="Dao.Dao_ChiTieu"%>
<%@page import="Model.ChiTieu"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
       <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ngân sách Chi Tiêu</title>
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
                       String dateS = (String)request.getAttribute("date");
                         if(dateS == null) {
                          dateS = "";
                         }
                         String url = request.getScheme()+"://"+ request.getServerName()+":" +request.getServerPort() + request.getContextPath();
                         ArrayList<ChiTieu> thuchi = Dao_ChiTieu.get().selectquery("",dateS);
                     int sothongbao =  Dao_ThongBao.get().laysothongbao();
%>
                    <link rel="stylesheet" href="<%=url%>/Css/NganSach.css"/>
    </head>
    <body>

        
        
        <%
            Calendar cal = Calendar.getInstance();
            Date datel =  cal.getTime();         
            SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
            String date1 = format1.format(datel);
         if(Dao_ThongBao.get().kiemtradate(date1)) {
 
          ThongBao tb = new ThongBao();
           int chi_thangnay = Dao_ChiTieu.get().LayTienChiTieuThang("",0); 
           int chi_thangtruoc = Dao_ChiTieu.get().LayTienChiTieuThang("BEFORE",0); 
           int thu_thangnay = Dao_ChiTieu.get().LayTienChiTieuThang("",1); 
           int thu_thangtruoc = Dao_ChiTieu.get().LayTienChiTieuThang("BEFORE",1); 


            // tính chất 0 là chi không thay đổi
            // tính chất 1 là chi nhiều 
            // tính chất 2 là chi kém hơn
            
            
            // 1 là chi 
            // 0 là thu
            if(chi_thangnay > chi_thangtruoc) {
                tb.setNoidung("Tháng này bạn hao hụt "+ String.valueOf(chi_thangnay) + " ,"
                + " hơn tháng trước " +String.valueOf(chi_thangnay - chi_thangtruoc) + " đồng" );
                tb.setMathuchi(1);
                tb.setTinhchat(1);
            }
            if(chi_thangnay == chi_thangtruoc) {
                tb.setNoidung("Tháng này bạn hao hụt "+ String.valueOf(chi_thangnay) + " ,"
                + " tương tự tháng trước " );
                tb.setMathuchi(1);
                 tb.setTinhchat(0);
            }
            if(chi_thangnay < chi_thangtruoc) {
                tb.setNoidung("Tháng này bạn hao hụt "+ String.valueOf(chi_thangnay) + " ,"
                + " ít hơn tháng trước " +String.valueOf(chi_thangtruoc - chi_thangnay) + " đồng" );
                tb.setMathuchi(1);
                 tb.setTinhchat(2);
            }
            
            Dao_ThongBao.get().TaoThongBao(tb);
            
            if(thu_thangnay > thu_thangtruoc) {
                tb.setNoidung("Tháng này bạn có Thu nhập là "+ String.valueOf(thu_thangnay) + " ,"
                + "hơn tháng trước " +String.valueOf(thu_thangnay - thu_thangtruoc) + " đồng" );
                tb.setMathuchi(0);
                 tb.setTinhchat(1);
            }
            
            if(thu_thangnay == thu_thangtruoc) {
                tb.setNoidung("Tháng này bạn có Thu nhập là "+ String.valueOf(thu_thangnay) + " ,"
                + " tương tự tháng trước" );
                tb.setMathuchi(0);
                 tb.setTinhchat(0);
            }
            if(thu_thangnay < thu_thangtruoc) {
                tb.setNoidung("Tháng này bạn có Thu nhập là "+ String.valueOf(thu_thangnay) + " ,"
                + "ít hơn tháng trước " +String.valueOf( thu_thangtruoc - thu_thangnay) + " đồng" );
                tb.setMathuchi(0);
                 tb.setTinhchat(2);
            }  
            Dao_ThongBao.get().TaoThongBao(tb); 
            Dao_ThongBao.get().capnhatngay();
        %>
         <div id="screen_info" class="screen_info">
        </div>
        <div id="info" class="info text-center">
            Bạn có <%=sothongbao%> thông báo mới 
        </div>
        <%
          }
        %>
        <div class="main">
            <div class="navbar">
                <div class="nav_flex">
                    <a class="nav_logo" >
                        Money
                    </a>
                </div>
               
            </div>
            <div class="content_center">
                <div class="row content_row">
                    <div class="col-4">
                        <div class="left_content">
                            <div class="text">
                                
                                <div class="sumtol p-3">
                                    <div class="text-center pb-3">
                                          <p class="title h4">Chào và chúc bạn một <br>ngày thành công <i class="fa-solid fa-coins text-success"></i></p>
                                    </div>
                                  
                                    
                                    <%
                                    int  tongchingay = Dao_ChiTieu.get().laygansach("DAY", "1");
                                    int  tongthungay = Dao_ChiTieu.get().laygansach("DAY", "0");
                                       int  tongngay = tongthungay - tongchingay;
                                       
                                   
                                     int tongthuthang = Dao_ChiTieu.get().laygansach("MONTH", "0");
                                      int tongchithang = Dao_ChiTieu.get().laygansach("MONTH", "1");
                                       int tongthang = tongthuthang - tongchithang;


                                     
                                     int tongthunam = Dao_ChiTieu.get().laygansach("YEAR", "0");
                                     int tongchinam = Dao_ChiTieu.get().laygansach("YEAR", "1");
                                     int tongnam = tongthunam - tongchinam;
                                    %>
                                    
                                   
                                    <span>Thống Kê</span>
                                    <div class="day fw-bold">
                                        <div>
                                            Hôm nay Tổng cộng :<strong><%=tongngay%></strong>
                                        </div>
                                        <div class="mb-3">
                                            <span class="text-success">+ <%=tongthungay%></span>
                                            <span class="text-danger">- <%=tongchingay%> </span>
                                        </div>
                                        <div>
                                            Tháng nay Tổng cộng :<strong><%=tongthang%></strong>
                                        </div>
                                        <div class="mb-3">
                                            <span class="text-success">+<%=tongthuthang%> </span>
                                            <span class="text-danger">-<%=tongchithang%></span>
                                        </div>
                                        <div>
                                            Năm nay Tổng cộng :<strong><%=tongnam%></strong>
                                        </div>
                                        <div>
                                            <span class="text-success">+<%=tongthunam%></span>
                                            <span class="text-danger">-<%=tongchinam%> </span>
                                        </div>
                                    </div>
                                </div>
                                
                                
                            </div>
                            <div class="group_link">
                                <form class="item_link tb" action="/QuanLiChiTieu/TuyBien_ThongBao" method="post">
                                    <input class="fake" name="tb" value="infomtion" />
                                    <button class="btnfake">Thông Báo</button>
                                     <span class="sothongbao"><%=sothongbao%></span>
                                </form>
                   
                                <a class="item_link" href="<%=url%>/View/ChiTieu.jsp">Thu Chi</a>
                                <a class="item_link" href="<%=url%>/View/LoaiChiTieu.jsp">Loại Chi Tiêu</a>
                                <a class="item_link" href="<%=url%>/View/QuyDinh.jsp">Quy Định</a>
                            </div>
                        </div>
                    </div>
                     <div class="col-8">
                         <div class="right_content">
                             <div class="row filterdate">
                                 <div class="col-4 item_fiterdate">
                                     <form action="/QuanLiChiTieu/TuyBien_ChiTieu" method="get">
                                         <input type="text" class="fake" value="DAY" name="date">
                                         <button class="getdate <%=dateS.equalsIgnoreCase("DAY")? "text-success":""%>">Ngày</button>
                                     </form>
                                 </div>
                                 <div class="col-4 item_fiterdate">
                                    <form action="/QuanLiChiTieu/TuyBien_ChiTieu" method="get">
                                        <input type="text" class="fake" value="MONTH" name="date">
                                         <button class="getdate <%=dateS.equalsIgnoreCase("MONTH")? "text-success":""%>">Tháng</button>
                                     </form>
                                 </div>
                                 <div class="col-4 item_fiterdate">
                                    <form action="/QuanLiChiTieu/TuyBien_ChiTieu" method="get">
                                        <input type="text" class="fake" value="YEAR" name="date">
                                         <button class="getdate <%=dateS.equalsIgnoreCase("YEAR")? "text-success":""%>">Năm</button>
                                     </form>
                                 </div>
                             </div>
                             <div class="m-2 menu_main">  
                                    <div class="menu_filter d-flex justify-content-between p-3">
                                        <div class="coun fw-bold">
                                           Số Lượng #<%=thuchi.size()%>
                                        </div>
                                        
                                    </div>
                                    <div class="lists">
                                        <%
                                         
                                            for (ChiTieu chitieu : thuchi) {
                                            LoaiChiTieu loaichi = Dao_LoaiChiTieu_Dao.get().LayLoaiChiTieu(chitieu.getIdLoaiChiTieu());
                                        %>
                                        <div class="item_list" style="background: <%=chitieu.getIdLoaiThuChi() == 0 ? "#CBE7D9":"#FFE3BA"%>">
                                            <p class="title_card">
                                                <%=loaichi.getTenLoaiChiTieu()%>
                                            </p>
                                            <div class="title_values d-flex gap-3">
                                                <p><%=chitieu.getThoiGianChiTieu()%></p>
                                                <p class="<%=chitieu.getIdLoaiThuChi() == 0 ? "text-success":"text-danger"%>" >
                                                    <%
                                                        if(chitieu.getIdLoaiThuChi() == 0) {
                                                    %>
                                                    +
                                                    <%
                                                        } else {
                                                    %>
                                                    -
                                                    <%
                                                        }
                                                    %>
                                                   <%=chitieu.getSoTienChiTieu()%></p>
                                            </div>
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
        </div>
                                        <script src="<%=url%>/js/Ngansach.js"></script>
    </body>
</html>
