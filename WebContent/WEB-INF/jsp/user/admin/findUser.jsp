<nav class="ui fixed menu teal inverted navbar">
	<a href="${pageContext.request.contextPath}/admin/administrator" class="item">Home</a> 
	<a href="${pageContext.request.contextPath}/admin/createUser" class="item">Create new User</a>
	<a href="${pageContext.request.contextPath}/admin/findUser" class="item">Modify User</a>
	<a href="${pageContext.request.contextPath}/admin/deleteUser" class="item">Delete User</a>
	<a href="${pageContext.request.contextPath}/login/adminLogin" class="item">Log Out</a>
</nav>
<!-- end nav -->
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Search for User</h3>

	<form:form action="user" modelAttribute="appUser" method="GET" class="ui form">
		<div class="field">
			<label>User ID</label>
			<form:input path="id" type="number"/>
		</div>
		<button class="ui button" type="submit">Search</button>
	</form:form>
</div>