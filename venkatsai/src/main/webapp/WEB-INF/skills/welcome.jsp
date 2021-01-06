<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
        <link href="${contextPath}/resources/css/mdb.min.css" rel="stylesheet"> 
        
    <link href="${contextPath}/resources/css/common.css" rel="stylesheet">
    <link href="${contextPath}/resources/css/welcome.css" rel="stylesheet">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<style> 
        .navbar-nav { 
            margin-left: auto; 
        } 
#rowflex::-webkit-scrollbar {
  height: 8px;
    overflow: visible;
    width: 12px;
}

#rowflex::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(200,200,200,1);
    border-radius: 10px;
}

#rowflex::-webkit-scrollbar-thumb {
    border-radius: 10px;
    background-color:#fff;
    -webkit-box-shadow: inset 0 0 6px rgba(90,90,90,0.7);
    
}  

#rowflex {
  scrollbar-color: #7f7f7f white; /* thumb and track color */
  scrollbar-width: 1rem;
}
.offcanvas-header{ display:none; }

@media (max-width: 992px) {
  .offcanvas-header{ display:block; }
  .navbar-collapse {
    position: fixed;
    top:0; 
    bottom: 0;
    left: 100%;
    width: 100%;
    padding-right: 1rem;
    padding-left: 1rem;
    overflow-y: auto;
    visibility: hidden;
    background-color: black;
    transition: visibility .2s ease-in-out, -webkit-transform .2s ease-in-out;
    z-index: 1;
  }
  .navbar-collapse.show {
    visibility: visible;
    transform: translateX(-50%);
  }
}      
    </style>
</head>
<body>
<!--Navbar-->
<nav class="navbar navbar-expand-lg navbar-dark primary-color">
  <!-- Navbar brand -->
  <a class="navbar-brand" href="#">Harleeninfo.com</a>
      <form class="form-inline">
      <div class="md-form my-0">
        <input class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
      </div>
    </form>
  <!-- Collapse button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
    aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
    <span class="navbar-toggler-icon"></span>
  </button>
  <!-- Collapsible content -->
  <div class="collapse navbar-collapse navbar-dark primary-color" id="basicExampleNav">
    <!-- Links -->
        <div class="offcanvas-header mt-3">  
      <button class="btn fa fa-window-close btn-close float-left"></button>
      
    </div>
    <ul class="navbar-nav mr-auto">
      <li class="nav-item active">
        <a class="nav-link" href="#">Home
          <span class="sr-only">(current)</span>
        </a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Features</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="#">Pricing</a>
      </li>
      <li class="nav-item">
      <a class="nav-link" onclick="document.forms['logoutForm'].submit()">Logout</a>
      </li>

    </ul>
    <!-- Links -->

  </div>
  <!-- Collapsible content -->
</nav>

<!--/.Navbar-->
    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <form id="logoutForm" method="POST" action="${contextPath}/logout">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        </form>

       <!--  <h2>Welcome ${pageContext.request.userPrincipal.name} | </h2>-->

    </c:if>
    <section id="about">
      <div class="container" data-aos="fade-up">
        <div class="row about-container">
            <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
              <div class="icon"><img class="icon" src="${contextPath}/images/harleen.jpg" > </div>
              <p class="description">Welcome</p>
              <h6 class="title">${pageContext.request.userPrincipal.name}</h6>
            </div>
            </div>
            </div>
     </section>
            
 <h6>Latest Placements card details groups</h6>
 <div class="d-flex flex-row  overflow-auto " id="rowflex">
  <div class="col-sm-6" >
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Singapore&nbsp;Placements</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Apply</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6" >
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Dhubai&nbsp;Placements</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Apply</a>
      </div>
    </div>
  </div>
  <div class="col-sm-6" style="float:left">
    <div class="card">
      <div class="card-body">
        <h5 class="card-title">Kwait&nbsp;Placements</h5>
        <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
        <a href="#" class="btn btn-primary">Apply</a>
      </div>
    </div>
  </div>  
</div>            
<!-- /container -->

<br>
<div class="col-sm-6" style="float:left">
    <div class="card card-cascade wider">
                  <div class="icon-box" data-aos="fade-up" data-aos-delay="100">
              <div class="icon"><img class="icon" src="${contextPath}/images/prasad.jpg" > </div>
              <h4 class="description">Venkat Sai Institute</h4>
              <p class="description">Visakhapatnam</p>
              </div>
  	<div class="view view-cascade overlay">
    <img class="card-img-top" src="${contextPath}/images/img1.jpg" alt="Card image cap">
    <a href="#!">
      <div class="mask rgba-white-slight"></div>
    </a>
 	 </div>    
      <div class="card-body card-body-cascade text-center pb-0">
        <h5 class="card-title">Dhubai&nbsp;Placements</h5>
        <h6 class="title">Contact us: 9347039290</h6>
        <a href="#" class="btn btn-primary">Apply</a>
      </div>
   </div> 
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" ></script>
<script src="${contextPath}/resources/js/popper.min.js" ></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
<script src="${contextPath}/resources/js/mdb.min.js"></script> 
<script>
$("[data-trigger]").on("click", function(){
    var trigger_id =  $(this).attr('data-trigger');
    $(trigger_id).toggleClass("show");
    $('body').toggleClass("offcanvas-active");
    
});

// close button 
$(".btn-close").click(function(e){
    $(".navbar-collapse").removeClass("show");
    $("body").removeClass("offcanvas-active");
});
</script>
</body>
</html>
