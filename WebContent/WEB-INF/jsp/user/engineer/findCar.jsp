<nav class="ui fixed menu teal inverted navbar">
	<a href="${pageContext.request.contextPath}/engineer/engineer" class="item">Home</a> 
	<a href="${pageContext.request.contextPath}/engineer/findVehicle" class="item">Update Vehicle</a>
	<a href="${pageContext.request.contextPath}/engineer/listVehicles" class="item">All Vehicles</a>
	<a href="${pageContext.request.contextPath}/login/engineerLogin" class="item">Log Out</a>
</nav>
<!-- end nav -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div class="ui segment">

	<h3>Search for Vehicle</h3>

	<form:form action="vehicle${car.plate}" modelAttribute="car" method="GET" class="ui form">
		<div class="field">
			<label>Vehicle Plate</label>
			<form:input path="plate" type="text"/>
		</div>
		<button class="ui button" type="submit">Search</button>
	</form:form>
</div>