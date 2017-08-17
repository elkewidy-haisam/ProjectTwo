	<!-- Header -->
	<jsp:include page="header_login.jsp" />
	
	<!-- 	Just some stuff you need -->
	<header>
	  <div class="container">
		
	<c:choose>
	<c:when test="${not empty message }">
	  <p class="alert ${messageClass}">${message }</p>
	<%
	  session.setAttribute("message", null);
	  session.setAttribute("messageClass", null);
	%>
	</c:when>
	</c:choose>
	
		<div id = "login">	
		
		<h1><small>Login Page - Users</small></h1>
		<hr class="book-primary">
			
			<form action="login.do" method="Post" class="form-horizontal"> 
				
				Username: <input type = "text" name = "username"><br/>
				Password: <input type = "password" name = "password"><br/>
				<input type = "submit" value = "Sign In" class="btn btn-success">
		
			</form>
		
		</div>
		
		</div>
		

	</div>
		
	</header>
	
	<!-- Footer -->
	<jsp:include page="footer.jsp" />
