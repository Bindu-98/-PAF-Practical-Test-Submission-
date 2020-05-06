<%@ page import="com.paf.PafProj.PaymentHadler"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="Views/bootstrap.min.css"> 
<script src="Components/jquery-3.4.1.min.js"></script> 
<script src="Components/appointment.js"></script> 
</head>
<body>
<div class="container"> 
	<div class="row">  
		<div class="col-6"> 
			<h1>APPOINTMENT SERVICE</h1>
				<form id="formItem" name="formItem" method="post" action="Appointment.jsp">  
					Doctor Id: 
					<input id="doctor_id" name="doctor_id" type="text" class="form-control form-control-sm">  
					<br> Patient Id:  
					<input id="patient_id" name="patient_id" type="text" class="form-control form-control-sm">  
					<br> Prescription:  
					<input id="prescription" name="prescription" type="text" class="form-control form-control-sm">  
					<br> Doctor Notes:  
					<input id="doc_notes" name="doc_notes" type="text" class="form-control form-control-sm"> 
					<br>  
					<input id="btnSave" name="btnSave" type="button" value="Save" class="btn btn-primary">  
					<input type="hidden" id="hidItemIDSave" name="hidItemIDSave" value=""> 
				</form>
				
				<div id="alertSuccess" class="alert alert-success">
					<%
						out.print(session.getAttribute("statusMsg"));
					%>
				</div>
				<div id="alertError" class="alert alert-danger"></div>
				
				<br>
				<div id="divItemsGrid">
					<%
					com.paf.PafProj.PaymentHadler appoObj = new com.paf.PafProj.PaymentHadler();
						out.print(appoObj.SelectAll());
					%>
				</div>
				
				 
			</div>
		</div>
</div>
</body>
</html>