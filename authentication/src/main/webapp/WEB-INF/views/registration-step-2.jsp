<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<c:if test="${messages.containsKey('password')}">
		<c:set var="emailMessages" value="${messages['password']}" />
		<c:forEach items="${emailMessages}" var="message">
			${message}
		</c:forEach>
	</c:if>
	<form method="POST">
		<input type="password" name="password">
		<input type="password" name="confirm-password">
		<input type="submit" value="SEND">
	</form>
</body>
</html>