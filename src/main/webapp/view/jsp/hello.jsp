<%@ include file="/view/jsp/header.jsp"%>
<%@page import="java.util.Date"%>

<div class="container">
	<h1>Nginx cache for java application</h1>

	<p>
		<c:choose>
		<c:when test="${message}">
		<img src="Firefox.svg" width="77" height="80"/>
		<h4>VIP User</h4>
		
		</c:when>
		<c:when test="${!message}">
		<img src="Chrome.svg" width="77" height="80"/>
		<h4>Normal User</h4>
		</c:when>
		
		</c:choose>
	</p>

</div>

<%@ include file="/view/jsp/footer.jsp"%>
