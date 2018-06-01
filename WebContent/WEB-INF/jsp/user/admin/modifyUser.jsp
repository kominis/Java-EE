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

	<h3>ModiFy User with ID ${appUser.id}</h3>

	<form:form action="saveModifiedUser" modelAttribute="appUser" method="POST"
		class="ui form">
		<form:hidden path="id" />
		<div class="field">
			<label>Username</label>
			<form:input path="username"/>
		</div>
		<div class="field">
			<label>Password</label>
			<form:input path="password"/>
		</div>
		<div class="number">
			<label>Position</label>
			<form:input path="rights"/>
		</div>
		<input class="ui button" type="submit" value="Save Changes">
	</form:form>

</div>