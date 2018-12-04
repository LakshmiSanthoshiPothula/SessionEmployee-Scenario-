<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style>
.td {
    text-align: center;
    color: red;
}
</style>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Employee Registration</h2>
<form action="EmployeeAddServlet" >
<table>
<tr><td>Employee First Name</td><td><input name="firstName"></td><td class="td">${errorFname}</td></tr>
<tr><td>Employee Last Name</td><td><input name="lastName"></td><td class="td">${errorLname}</td></tr>
<tr><td>Employee Email</td><td><input name="email"></td><td class="td">${errorEmail}</td></tr>
<tr><td>Gender:</td><td><input type="radio" value="Male" name="gender"> Male</td></tr>
  <tr><td></td><td><input type="radio" value="Female" name="gender"> Female</td><td class="td">${errorGender}</td></tr> 
  <tr><td>Phone Number</td><td><input name="phone"></td><td class="td">${errorPhone}</td></tr> 
  <tr><td>Pan Card Id</td><td><input name="panId"></td><td class="td">${errorPan}</td></tr> 
<tr><td><input type="submit" value="Submit"></td></tr>
</table>
</form>

</body>
</html>