<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-management title="MEMBERS">

		<div class="d-flex justify-content-between align-items-start">
		<app:page-title title="Member Management" />
		<button id="statusChangeBtn" class="btn btn-danger">
			<i class="${result.status() eq 'Active' ? 'bi-x' : 'bi-check'}"></i> ${result.status() eq 'Active' ? 'Denined' : 'Activate'}
		</button>
		</div>
		
		
		<div class="row">
		
			<div class="col-3">
			
				<img class="img-fluid img-thumbnail profile-image" alt="Profile Image" src="${root}/resources/photos/profile.jpg">
				
			</div>
			
			<div class="col">
		
			<div class="row">
				<div class="col">
					<app:information-card label="Registered At" 
						icon="bi-person-plus" 
						bgColor="text-bg-info" 
						value="${dtf.formatDateTime(result.registeredAt())}" />
					
				</div>
				<div class="col">
					<app:information-card label="Last Access" 
						icon="bi-calendar-check" 
						bgColor="text-bg-secondary" 
						value="${dtf.formatDateTime(result.lastAccessAt())}" />

				</div>
				<div class="col">
					<app:information-card label="Status" 
						icon="bi-shield" 
						bgColor="text-bg-primary" 
						value="${result.status()}" />
				</div>
			</div>
			
			<div class="row mt-4 d-flex align-items-stretch">
				<div class="col">
					<app:personal-info 
					name="${result.name()}"
					dob="${result.dateOfBirth()}" 
					gender="${result.gender()}"
					/>
				</div>
				
				<div class="col">
					<app:contact-info
					phone="${result.phone()}"
					email="${result.email()}"
					address="${result.displayAddress}"
					 />
				</div>
			</div>			
		</div>
			
		</div>
	
</app:layout-management>