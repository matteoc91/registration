<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
	<c:if test="${messages.containsKey('email')}">
		<c:set var="emailMessages" value="${messages['email']}" />
		<c:forEach items="${emailMessages}" var="messageItem">
			${messageItem}
		</c:forEach>
	</c:if>
	<form method="post">
		<input type="email" name="email">
		<input type="email" name="confirm-email">
		<input type="submit" value="SEND">
	</form>
</body>
</html>