
<%
	response.addHeader("Refresh", "20");
%>

<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>twitter Index</title>
<link rel="stylesheet" type="text/css" href="/css/global.css" />
<script>
	function editFunction(key, version, content) {
		var tweet = prompt("このつぶやきを編集", content);
		if (tweet != null) {
			var xmlhttp;
			if (window.XMLHttpRequest) {
				xmlhttp = new XMLHttpRequest();
			} else {
				xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
			}
			xmlhttp.open ("POST", "update", true);
			xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			var requestString = "key=" + key + "&version=" + version + "&content="+ tweet;
			xmlhttp.send(requestString);
		}
	}
</script>
</head>
<body>
	<p>
		<b>ようこそ：${myNickname}様; メール: ${myEmail}</b>
		<%-- <b>ようこそ：<%=user.getNickname()%>様; メール: <%=user.getEmail()%></b> --%>
	</p>
	<br />
	<p>今何をしている?</p>
	<form action="tweet" method="post">
		<textarea name="content"></textarea>
		<input type="hidden" name=email value="${myEmail}"> <br /> <input
			type="submit" value="投稿" />
	</form>
	<table>
		<c:forEach var="tween" items="${tweetList}" varStatus="loopStatus">
			<tr style="background-color: #FFFFCC">
				<td><p style="color: #339933">
						<b>${f:h(tween.email) }</b>
					</p></td>
				<td>${f:h(tween.content) }</td>
				<%-- <td>${f:h(tween.key) }</td> --%>
				<c:if test="${myIsAdmin || (myEmail==tween.email)}">
					<c:set var="editUrl"
						value="edit/${f:h(tween.key)}/${tween.version}" />
					<c:set var="deleteUrl"
						value="delete/${f:h(tween.key)}/${tween.version}" />
					<%-- <td><a href="${f:url(editUrl)}">編集</a></td> --%>
					<td><a href="#"
						onclick="editFunction('${f:h(tween.key)}', '${f:h(tween.version)}', '${f:h(tween.content)}')">編集</a></td>
					<td><a href="${f:url(deleteUrl)}"
						onclick="return confirm('このつぶやきを削除?')">削除</a></td>
				</c:if>
			<tr>
		</c:forEach>
	</table>
</body>
</html>