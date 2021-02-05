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
    <link href="${contextPath}/resources/css/bootstrap-imageupload.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    
    <![endif]-->
            <style>
            body {
                padding-top: 70px;
            }

            .imageupload {
                margin: 20px 0;
            }
        </style>
</head>

<body>

<div class="container">
 <p class="text-center">Get started with your free account</a></p>

<div class="card bg-light ">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Register </h4>

    <form:form  modelAttribute="companyForm" class="form-signin">

 	
        <spring:bind path="companyName">
            <div class="form-group input-group ${status.error ? 'has-error' : ''}">
            		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
                <form:input type="text" path="companyName" class="form-control" placeholder="Company Name"
                            autofocus="true"></form:input>
                <form:errors path="companyName"></form:errors>
            </div>
        </spring:bind>
    <spring:bind path="companyemail">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <form:input path="companyemail" class="form-control" placeholder="Company Email " type="email"></form:input>
    </div> <!-- form-group// -->
    </spring:bind>
    <spring:bind path="country">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-paper-plane" style="color:green"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="">India</option>
		    <option value="1">Singapore</option>
		    <option value="2">Dubai</option>
		    <option value="3">Behran</option>
		</select>
    	<form:input path="country" class="form-control" placeholder="Select Country" type="text"></form:input>
    </div>
    </spring:bind>
    <spring:bind path="state">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-users"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="">AndhraPradesh</option>
		    <option value="1">Telangana</option>
		    <option value="2">Goa</option>
		    <option value="3">Kerala</option>
		</select>
    	<form:input path="state" class="form-control" placeholder="Select State" type="text"></form:input>
    </div>
    </spring:bind>
    <spring:bind path="city">
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		</div>
		<select class="custom-select" style="max-width: 120px;">
		    <option selected="">Visakahapatnam</option>
		    <option value="1">Viazanagaram</option>
		    <option value="2">Srikakulam</option>
		    <option value="3">Vijayawada</option>
		</select>
    	<form:input path="city" class="form-control" placeholder="Select City" type="text"></form:input>
    </div>
	</spring:bind>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</article>
</div>
</div>
<!-- /container -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap-imageupload.js"></script>

        <script>
            var $imageupload = $('.imageupload');
            $imageupload.imageupload();
        </script>
</body>
</html>
