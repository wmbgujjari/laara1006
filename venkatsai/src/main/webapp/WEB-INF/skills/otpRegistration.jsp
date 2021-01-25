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

    <title>Create an account</title>

    <link href="${contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    
    <![endif]-->
</head>

<body>

<div class="container">

<br>  <p class="text-center">Get started with your free account</a></p>
<hr>

<div class="card bg-light ">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Create Account</h4>
	<p>
		<a href="" class="btn btn-block btn-twitter"> <i class="fab fa-twitter"></i>   Login via Twitter</a>
		<a href="" class="btn btn-block btn-facebook"> <i class="fab fa-facebook-f"></i>   Login via facebook</a>
	</p>
    <form:form method="POST" modelAttribute="otpForm" class="form-signin">
 <spring:bind path="fullname">
	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <form:input name="fullname" path="fullname" class="form-control" placeholder="Full name" type="text"></form:input>
    </div> <!-- form-group// -->
     
    </spring:bind>
    
    <spring:bind path="email">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <form:input name="email" path="email" class="form-control" placeholder="Email address" type="email"></form:input>
    </div> <!-- form-group// -->
    </spring:bind>
    <spring:bind path="phone_number">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-phone"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="">+971</option>
		    <option value="1">+972</option>
		    <option value="2">+198</option>
		    <option value="3">+701</option>
		</select>
    	<form:input name="phone_number" path="phone_number" class="form-control" placeholder="Phone number" type="text"></form:input>
    </div>
    </spring:bind>
    <spring:bind path="category">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<form:select name="category" path="category" class="form-control">
			<option selected=""> Select job type</option>
			<option>Fitter</option>
			<option>Welder</option>
			<option>Fabricator</option>
			<option>Foreman</option>
			<option>Helper</option>
		</form:select>
	</div>    
	</spring:bind>
         <button class="btn btn-lg btn-primary btn-block" type="submit">Next</button>
        <!-- <h4 class="text-center"><a href="${contextPath}/otpConfirm">Next</a></h4>-->
    </form:form>
</article>
</div>
</div>
<!-- /container -->
<br><br>
   <div class="col-sm-12" style="float:center">
    <div class="card">
    <div class="card-header text-center bg-warning"><h2>VENKAT SAI</h2>
    <p >Welding Works & Training Center</p>
    </div>
      <div class="card-body text-center">

<p class="text">We are Equipped with 14 Welding Booths <br> 4 Individuals Interviews Cabins <br> all Facilities for all Trades Test
<p><a class="btn btn-warning" target="_blank" href="http://venkatsai.com/"> venkatsai.com  
 <i class="fa fa-window-restore "></i></a></p>
      </div>
    </div>
  </div> 
 
<br>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
</body>
</html>
