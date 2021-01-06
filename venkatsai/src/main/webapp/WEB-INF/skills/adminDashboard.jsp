<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
<title>Admin DashBoard</title>
</head>
<body>
<form:form  modelAttribute="adminForm" class="form-signin">
	<h3>Admin DashBoard</h3>
	<table border="1" cellpadding="2" cellspacing="2">
		<tr>
			<th>Id</th>
			<th>CompanyName</th>
			<th>CompanyEmail</th>
			<th>Country</th>
			<th>State</th>
			<th>City</th>
			<th>Status</th>
		</tr>
		<c:forEach items="${products}" var="profile" >
			<tr>
				<td><c:set var="id" value="${profile.id }" scope="request"></c:set> ${profile.id }</td>
				<td>${profile.companyName }</td>
				 <td>${profile.companyEmail }</td>
				<td>${profile.country }</td>
				<td>${profile.state }</td>
				<td>${profile.city }</td>
				
           <td>
           -   <!--  <form:form method="GET"  action="${contextPath}/adminDashboardupdate/${profile.id }" >
                <input type="submit" value="Enable" style="background:none;border:0px;cursor: pointer;"/>
              </form:form>-->
               <a href="<c:url value="/adminDashboardupdate/${profile.id }"/>" >Enable</a>
              
           </td>				
			</tr>
		</c:forEach>
	</table>
</form:form>
</body>
</html>