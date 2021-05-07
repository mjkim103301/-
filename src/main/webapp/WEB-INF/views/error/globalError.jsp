<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Global Error Page</title>
</head>
<body>
  <h1>Global Error Page</h1>
  <p>죄송합니다. 서비스에 문제가 발생했습니다. 조속히 해결하겠습니다.</p>

    Failed URL: ${url}
    <br>
    Exception:  ${exception}
    <hr>
	<p>연락처 : 02-1234-1234</p>
</body>
</html>

