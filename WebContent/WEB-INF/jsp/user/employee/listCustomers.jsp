
<nav class="ui fixed menu teal inverted navbar">
	<a href="${pageContext.request.contextPath}/employee/employee"	class="item">Home</a> 
	<a href="${pageContext.request.contextPath}/employee/newCustomer" class="item">New Customer</a>
	<a href="${pageContext.request.contextPath}/employee/listCustomers" class="item">All Customers</a>
	<a href="${pageContext.request.contextPath}/login/employeeLogin" class="item">Log Out</a>
</nav>
<!-- end nav -->

<div class="ui segment">
	<h3>Customers List</h3>

	<!--  add our html table here -->
	<table class="ui celled  striped table">
		<thead>
			<th>A.F.M.</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Bonus</th>
		</thead>
		<!-- loop over and print our customers -->
		<c:forEach var="tempCustomer" items="${customers}">

			<tr>
				<td>${tempCustomer.afm}</td>
				<td>${tempCustomer.firstName}</td>
				<td>${tempCustomer.lastName}</td>
				<td>${tempCustomer.bonus}</td>
			</tr>
		</c:forEach>
	</table>
</div>