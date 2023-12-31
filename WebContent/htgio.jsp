<%@page import="bean.khachhangbean"%>
<%@page import="bean.giohangbean"%>
<%@page import="bo.giohangbo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="bean.sachbean"%>
<%@page import="bo.sachbo"%>
<%@page import="bean.loaibean"%>
<%@page import="bo.loaibo"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <title>Mua Sách</title>
  <meta charset="UTF-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link href="/style.css" rel="stylesheet" type="text/css">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<div class="navbar navbar-expand-md fixed-top bg-dark navbar-dark navbar-text">
		<a class="ms-2 text-decoration-none text-white-50 me-3" href="sachController">Trang chủ</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Chuyển đổi điều hướng thành">
        	<span class="navbar-toggler-icon"></span>
      	</button>
		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav list-inline mx-2 mb-0 me-auto h-100 ">
				<li class="nav-item list-inline-item me-3"><a class="text-decoration-none text-white-50" href="htgioController">Giỏ hàng</a></li>
				<li class="nav-item list-inline-item me-3"><a class="text-decoration-none text-white-50" href="XacNhanController">Xác nhận đặt mua</a></li>
				<li class="nav-item list-inline-item me-3"><a class="text-decoration-none text-white-50" href="LichSuController">Lịch sử mua hàng</a></li>
			</ul>
			<ul class="navbar-nav list-inline mx-2 mb-0 h-100">
			<%
			khachhangbean kh=(khachhangbean)session.getAttribute("dn");
			if(kh==null){ %>
				<li class="nav-item list-inline-item me-2"><a class="text-decoration-none text-white-50" href="dangky.jsp">Đăng ký</a></li>
				<li class="nav-item list-inline-item">
					<a class="text-decoration-none text-white-50" href="dangnhapController"> 
						<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-fill" viewBox="0 0 16 16">
		          			<path d="M3 14s-1 0-1-1 1-4 6-4 6 3 6 4-1 1-1 1H3Zm5-6a3 3 0 1 0 0-6 3 3 0 0 0 0 6Z" />
		        		</svg> Đăng nhập
					</a>
				</li>
			<%}else if(kh!=null){ %>
				<li class="nav-item me-5 list-inline-item"><a class="text-decoration-none text-white-50" href="dangky.jsp"> Xin chào: <%=kh.getHoten() %></a></li>
				<li class="nav-item list-inline-item"><a class="text-decoration-none text-white-50" href="DangXuatController"> 
					<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-box-arrow-left" viewBox="0 0 16 16">
	          			<path fill-rule="evenodd" d="M6 12.5a.5.5 0 0 0 .5.5h8a.5.5 0 0 0 .5-.5v-9a.5.5 0 0 0-.5-.5h-8a.5.5 0 0 0-.5.5v2a.5.5 0 0 1-1 0v-2A1.5 1.5 0 0 1 6.5 2h8A1.5 1.5 0 0 1 16 3.5v9a1.5 1.5 0 0 1-1.5 1.5h-8A1.5 1.5 0 0 1 5 12.5v-2a.5.5 0 0 1 1 0v2z" />
	          			<path fill-rule="evenodd" d="M.146 8.354a.5.5 0 0 1 0-.708l3-3a.5.5 0 1 1 .708.708L1.707 7.5H10.5a.5.5 0 0 1 0 1H1.707l2.147 2.146a.5.5 0 0 1-.708.708l-3-3z" />
	        		</svg> Đăng xuất
				</a></li>
			<%} %>
			</ul>
		</div>
	</div>
	<table class="table container mx-auto mt-5 table-bordered border-warning">
		<tr class="row w-100 mx-auto">
			<td class="p-0 col-12 col-md-3">
				<table class="table" style="width: 100%">
				<%
					ArrayList<loaibean> dsloai = (ArrayList<loaibean>)request.getAttribute("dsloai");
					for(loaibean loai: dsloai){
				%>
					<tr> <td>
						<a class="text-decoration-none" href="sachController?ml=<%=loai.getMaloai()%>">
							<%=loai.getTenloai() %>
						</a>
					</td> </tr>
				<%} %>
				</table>
			</td>
			<td class="p-0 col-12 col-md-6">
				<table class="table mx-0 table-dark table-hover mt-3">
				<%
				
				if(session.getAttribute("gh")!=null){
					giohangbo gh = (giohangbo)session.getAttribute("gh");
					for(giohangbean h: gh.ds) {%>
					<tr>
						<td><input type="checkbox" name="check" value="<%=h.getMasach()%>"></td>
						<td><%=h.getMasach() %> </td>
						<td><%=h.getTensach() %> </td>
						<td><%=h.getSoluongmua() %> </td>
						<td><%=h.getGia() %> </td>
						<td><%=h.getThanhtien() %> </td>
						<td>
							<form action="SuaController?ms=<%=h.getMasach() %>" method="post">
								<input type="number" name="txtsl" style="width: 40px">
								<input type="submit" name="but1" value="Sửa" class="btn-link">
							</form>
						</td>
						<td>
							<a href="XoaController?ms=<%=h.getMasach()%>&x=1">Xóa</a>
						</td>
					</tr>
				<% 	} if(gh.Tong()!=0){%>
					<tr>
						<td colspan="8"> Tổng tiền: <%=gh.Tong() %></td>
					</tr>
					<%}%>
				</table>
				<% if (gh.Tong() != 0) { %>
				<form class="d-inline" onsubmit="xoaChon(); return false;">
					<input type="submit" name="xc" value="Xóa chọn" class="btn-primary me-3">
				</form>
				<form class="d-inline" action="XoaController?xh=1">
					<input type="submit" name="xh" value="Xóa hết" class="btn-primary me-3">
				</form>
				<form class="d-inline" action="XacNhanController" >
					<input type="submit" name="b1" value="Xác nhận đặt mua" class="btn-primary">
				</form>
				<%}
			} %>
			</td>
			<td class="p-0 col-md-3 d-none d-md-block">
				<form class="text-center" action="sachController">
					<input type="text" name="txttim" class="form-control" placeholder="Nhập key cần tìm">
					<input type="submit" name="but1" class="btn-primary mt-2 mx-50"> 
				</form>
			</td>
		</tr>
	</table>
	<script>
		function xoaChon() {
			var checkboxes = document.getElementsByName("check");
			var masachList = [];
			const n = checkboxes.length;

			for (var i = 0; i < n; i++) {
				if (checkboxes[i].checked) {
					masachList.push(checkboxes[i].value);
				}
			}

			// Chuyển danh sách các masach đã được chọn thành một chuỗi dạng query string
			var queryString = "?masachList="
					+ encodeURIComponent(masachList.join(","));

			// Chuyển hướng đến trang XoaController và truyền danh sách masach đã được chọn
			window.location.href = "XoaController" + queryString;
		}
	</script>
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>