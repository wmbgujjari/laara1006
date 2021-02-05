

<%@ include file = "recruiterDashboard.jsp" %>
<div class="container">
  <h2>Profile</h2>

  <br>
  <div class="card bg-light text-dark">
    <div class="card-body">
    <table border="1" cellpadding="2" cellspacing="2">
		<tr>
			
			<th>CompanyName</th>
			<th>CompanyEmail</th>
			
		</tr>
		<c:forEach items="${products}" var="profile" >
			<tr>
				
				<td>${profile.companyName }</td>
				 <td>${profile.companyemail }</td>
				
				
          			
			</tr>
		</c:forEach>
	</table>
	
    
    </div>
  </div>
</div>



	
<%@ include file = "footer.jsp" %>


