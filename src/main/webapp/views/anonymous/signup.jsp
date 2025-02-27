<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-anonymous title="Sign In">

	<main>
		<h3>
			Sign Up
		</h3>
		
		<form action="">
		
			<app:form-group label="Name" cssClass="mb-3">
				<input name="username" type="text" placeholder="Enter Name" class="form-control">
			</app:form-group>
		
			<app:form-group label="login ID" cssClass="mb-3">
				<input name="username" type="text" placeholder="Enter login ID" class="form-control">
			</app:form-group>
			
			<app:form-group label="Password" cssClass="mb-3">
				<input name="password" type="password" placeholder="Enter Password" class="form-control">
			</app:form-group>
			
			<div>
			
					<a href="${root}/signin" class="btn btn-outline-primary">
						<i class="bi-unlock"></i> Sign In
					</a>
				
					<button class="btn btn-primary">
						<i class="bi-person-plus"></i> Sign Up
					</button>
				
			</div>
		
		</form>
		
	</main>

</app:layout-anonymous>