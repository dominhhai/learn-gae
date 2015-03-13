<%@page pageEncoding="UTF-8" isELIgnored="false" session="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@taglib prefix="f" uri="http://www.slim3.org/functions"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>twitter Edit</title>
</head>
<body>
	<p><b>Tweet</b></p>
	<form action="${f:url('update') }" method="post">
		<input type="hidden" ${f:hidden("key") } />
		<input type="hidden"${f:hidden("version") } />
		<textarea name="content"> ${content}</textarea>
		<%-- <input type="text" ${f:text("content")}
			class="${f:errorClass('content', 'err') }" /> --%>
			<br /><br />
		<input type="submit" value="編集" />
	</form>
</body>
</html>
