
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div class="ui segment">

	<h3>Login As Administrator</h3>

	<c:if test="${not empty errorMessage}">
		<div style="color:red">${errorMessage}</div>
	</c:if>

	<form:form action="checkAdminLogin" modelAttribute="appUser"
		method="POST" class="ui form">
		<div class="field">
			<label>Username</label>
			<form:input path="username" type="text" />
		</div>
		<div class="password">
			<label>Password</label>
			<form:input path="password" type="password" />
		</div>
		<input class="ui button" value="Login" name="Login" type="submit">
	</form:form>
	<a href="${pageContext.request.contextPath}"><button
			class="ui button" type="button">Back</button></a>

</div>
