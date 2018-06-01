<nav class="ui fixed menu teal inverted navbar">
	<a href="${pageContext.request.contextPath}/engineer/engineer" class="item">Home</a> 
	<a href="${pageContext.request.contextPath}/engineer/findVehicle" class="item">Update Vehicle</a>
	<a href="${pageContext.request.contextPath}/engineer/listVehicles" class="item">All Vehicles</a>
	<a href="${pageContext.request.contextPath}/login/engineerLogin" class="item">Log Out</a>
</nav>
<!-- end nav -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="ui segment">

	<h3>Update Vehicle's Condition with Plate ${car.plate}</h3>

	<form:form action="updateVehicle" modelAttribute="car" method="POST" class="ui form">
		<form:hidden path="plate" />
		<div class="field">
			<label>Vehicle Condition</label>
			<form:select path="vehicleCondition" name="vehicle_condition">
				<form:option value="bad">Bad</form:option>
				<form:option value="medium">Medium</form:option>
				<form:option value="good">Good</form:option>
			</form:select>
		</div>
		<button class="ui button" type="submit">Update</button>
	</form:form>

</div>