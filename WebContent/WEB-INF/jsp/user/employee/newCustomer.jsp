<nav class="ui fixed menu teal inverted navbar">
	<a href="${pageContext.request.contextPath}/employee/employee" class="item">Home</a>
	<a href="${pageContext.request.contextPath}/employee/newCustomer" class="item">New Customer</a>
	<a href="${pageContext.request.contextPath}/employee/listCustomers" class="item">All Customers</a>
	<a href="${pageContext.request.contextPath}/login/employeeLogin" class="item">Log Out</a>
</nav>
<!-- end nav -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Customer Information</h3>

	<form:form action="saveNewCustomer" modelAttribute="customer"
		method="POST" class="ui form">
		<fieldset>
			<legend>Customer Information</legend>
			<div class="field">
				<label>Last Name</label>
				<form:input path="lastName" />
			</div>
			<div class="field">
				<label> First Name</label>
				<form:input path="firstName" />
			</div>
			<div class="number">
				<label>A.F.M.</label>
				<form:input path="afm" />
			</div>
		</fieldset>
		<fieldset>
			<legend>Vehicle Information</legend>
			<div class="field">
				<label>Car Model</label>
				<form:input path="${cars.model}" name="model"/>
			</div>
			<div class="field">
				<label>License Plate</label><br>
				<form:input path="${cars.licensePlate}" name="licensePlate"/>
			</div>
			<div class="field">
				<label>Fuel Type: </label>
				<form:select path="${cars.fuelType}" name="fuelType">
					<form:option value="gasoline">Gasoline</form:option>
					<form:option value="gas">Gas</form:option>
					<form:option value="oil">Oil</form:option>
				</form:select>
			</div>
			<div class="number">
				<label>Release Year</label>
				<form:input path="${cars.releaseYear}" name="releaseYear"/>
			</div>
			<div class="field">
				<label>Vehicle Location</label><br>
				<form:input path="${cars.location}" name="location"/>
			</div>
		</fieldset>
		<input class="ui button" type="submit" value="Submit">
	</form:form>
	<a href="${pageContext.request.contextPath}/employee/employee"><button
			class="ui button" type="button">Back</button></a>
</div>
