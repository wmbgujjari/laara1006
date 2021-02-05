

<!DOCTYPE html>
<html lang="en">
<head>

    <style>
          
            .imageupload {
                margin: 20px 0;
            }
        </style>
</head>
<body>
<%@ include file = "recruiterDashboard.jsp" %>
 

<div class="container-fluid">
<div class="card bg-light ">
<article class="card-body mx-auto" style="max-width: 400px;">
	<h4 class="card-title mt-3 text-center">Register to Post a Job</h4>

    <form:form method="POST" modelAttribute="postingJob" class="form-signin" enctype="multipart/form-data">
    

	<div class="form-group input-group">
		<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-user"></i> </span>
		 </div>
        <input name="companyemail" class="form-control" placeholder="Full name" type="text">
    </div> <!-- form-group// -->
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-envelope"></i> </span>
		 </div>
        <input name="companyemail" class="form-control" placeholder="Email address" type="email">
    </div> <!-- form-group// -->
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
    	<input name="mobileno" class="form-control" placeholder="Phone number" type="text">
    </div>
    <div class="form-group input-group">
    	<div class="input-group-prepend">
		    <span class="input-group-text"> <i class="fa fa-building"></i> </span>
		</div>
		<select class="form-control" name="jobtype">
			<option selected=""> Select job type</option>
			<option>Fitter</option>
			<option>Welder</option>
			<option>Fabricator</option>
			<option>Foreman</option>
			<option>Helper</option>
		</select>
	</div>    
<div class="form-group input-group">
<textarea rows="5" cols="50" placeholder="Description"></textarea>
</div>
  <div class="container">
            <!-- bootstrap-imageupload. -->
            <div class="imageupload panel panel-default">
                <div class="panel-heading clearfix">
                    <h6 class="panel-title pull-left">Upload Image</h6>
                    <div class="btn-group pull-right">
                        <button type="button" class="btn btn-default active">File</button>
                       
                    </div>
                </div>
                <div class="file-tab panel-body">
                    <label class="btn btn-info btn-file">
                        <span>Browse</span>
                        <!-- The file is stored here. -->
                        <input type="file" name="file" >
                    </label>
                    <button type="button" class="btn btn-info">Remove</button>
                </div>
               
                   

                    <!-- The URL is stored here. -->
                  
                </div>
            </div>

            <!-- bootstrap-imageupload method buttons. -->
           <!--  <button type="button" id="imageupload-disable" class="btn btn-danger">Disable</button>
            <button type="button" id="imageupload-enable" class="btn btn-success">Enable</button>
            <button type="button" id="imageupload-reset" class="btn btn-primary">Reset</button>-->

        </div>

        <button class="btn btn-lg btn-primary btn-block" type="submit">Submit</button>
    </form:form>
</article>
</div>
<!-- /container -->
<%@ include file = "footer.jsp" %>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
<script src="${contextPath}/resources/js/bootstrap.min.js"></script>
        <script src="${contextPath}/resources/js/bootstrap-imageupload.js"></script>

        <script>
            var $imageupload = $('.imageupload');
            $imageupload.imageupload();

           /* $('#imageupload-disable').on('click', function() {
                $imageupload.imageupload('disable');
                $(this).blur();
            })

            $('#imageupload-enable').on('click', function() {
                $imageupload.imageupload('enable');
                $(this).blur();
            })

            $('#imageupload-reset').on('click', function() {
                $imageupload.imageupload('reset');
                $(this).blur();
            });*/
        </script>

</body>
</html>
