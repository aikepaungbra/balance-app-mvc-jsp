<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="title" required="true" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Balance | ${title.toUpperCase()}</title>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

<c:set var="root" value="${pageContext.request.contextPath}" scope="request"/>

</head>
<body>

	<nav class="navbar navbar-expand navbar-dark bg-dark">
	
		<div class="container">
		
			<a href="${root}/admin/home" class="navbar-brand">
				<i class="bi-house"></i> Balance Admin
			</a>
			
			<ul class="navbar-nav">
			
				
			
				<li class="nav-item">
					<a href="${root}/admin/member" class="nav-link ${title eq 'MEMBERS' ? 'active' : ''}"><i class="bi-people"></i>Member</a>
				</li>
			
				<li class="nav-item">
					<a href="${root}/signin" class="nav-link"><i class="bi-lock"></i>Sign Out</a>
				</li>
			
			
			
			</ul>
		
		
		</div>
		
	
	</nav>

	<main class="container mt-4">
		<jsp:doBody/>
	</main>
</body>
</html>