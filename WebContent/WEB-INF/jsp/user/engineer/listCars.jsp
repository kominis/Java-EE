<nav class="ui fixed menu teal inverted navbar">
	<a href="${pageContext.request.contextPath}/engineer/engineer" class="item">Home</a> 
	<a href="${pageContext.request.contextPath}/engineer/findVehicle" class="item">Update Vehicle</a>
	<a href="${pageContext.request.contextPath}/engineer/listVehicles" class="item">All Vehicles</a>
	<a href="${pageContext.request.contextPath}/login/engineerLogin" class="item">Log Out</a>
</nav>
<!-- end nav -->

<div class="ui segment">
	<h3>Vehicles List</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>Plate</th>
			<th>Model</th>
			<th>Fuel Type</th>
			<th>Release Year</th>
			<th>Vehicle Condition</th>
			<th>Vehicle Location</th>
		</thead>
		<!-- loop over and print vehicles -->
		<c:forEach var="tempCar" items="${cars}">

			<tr>
				<td>${tempCar.plate}</td>
				<td>${tempCar.model}</td>	
				<td>${tempCar.fuelType}</td>			
				<td>${tempCar.releaseYear}</td>
				<td>${tempCar.vehicleCondition}</td>
				<td>${tempCar.location}</td>
			</tr>
		</c:forEach>
	</table>
</div>