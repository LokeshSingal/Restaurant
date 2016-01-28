<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="testServlet" method="get">
<input type="submit" value="Add meal" name="addmeal"/><br>


<input type="submit" name="displayitems" value="Display Items" /><br>
<%=request.getAttribute("TextValue")%>
<br>
<br>
<br>
<input type="submit" name="displaymeal" value="Display Meal" /><br>
<%=request.getAttribute("TextValue1")%>
<br>
<br>
<br>
<input type="submit" name="displaymealdetail" value="Display Meal Detail" /><br>
<%=request.getAttribute("TextValue2")%>

</form>
</body>
</html>