<%@ taglib prefix="app" tagdir="/WEB-INF/tags" %>

<app:layout-management title="ACCESS">

	<app:page-title title="Access History"></app:page-title>
	
	
	<form class="row">
		
		<app:form-group label="Status" cssClass="col-auto">
			<select name="status" class="form-select">
				<option value="">Search All</option>
				<option value="Success">Success</option>
				<option value="Fails">Fails</option>
			</select>
		</app:form-group>
		
		<app:form-group label="Date From" cssClass="col-auto">
				<input name="dateFrom" type="date" class="form-control">
		</app:form-group>
		
		<app:form-group label="Date To" cssClass="col-auto">
				<input name="dateTo" type="date" class="form-control">
		</app:form-group>
		
		<app:form-group label="Keyword" cssClass="col-auto">
				<input name="keyword" class="form-control" placeholder="Search Keyword">
		</app:form-group>
		
		<div class="col btn-wrapper">
			<button class="btn btn-primary">
				<i class="bi-search"></i>Search
			</button>
		</div>
	
	</form>
	
	<table class="table table-striped table-bordered table-hover my-2">
	
		<thead>
			<tr>
				<th>Member</th>
				<th>Access At</th>
				<th>Access Type</th>
				<th>Status</th>
				<th>Remark</th>
			</tr>
		</thead>
		
		
		<tbody>
			<tr>
				<td>Thidar Aung</td>
				<td>2025-02-24 10:00</td>
				<td>Login</td>
				<td>Success</td>
				<td></td>
			</tr>
		</tbody>
	
	
	</table>
	
	<app:pagination></app:pagination>
	
</app:layout-management>