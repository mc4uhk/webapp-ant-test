<%@ page language="java"  import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    // properties 配置文件名稱
    ResourceBundle res = ResourceBundle.getBundle("application");
	String svnRevision= res.getString("revision");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<h1>HELLO WORLD!</h1>
	<%=request.getContextPath()%>
	<% String val = request.getParameter("testParam"); %> 
	
	<ul>
		<li><span>testParam: <%=val%></span></li>
		<li><span>svn-revision: <%=svnRevision%></span></li>
		<li><a href="${pageContext.request.contextPath}/learn-jquery.html">learn-jquery</a></li>
		<li><a href="${pageContext.request.contextPath}/learn-jsgrid.html">learn-jsgrid</a></li>
		<li><a href="${pageContext.request.contextPath}/learn-jsgrid-02.html">learn-jsgrid-02</a></li>
		<li><a href="${pageContext.request.contextPath}/split-screen.html">split-screen</a></li>
	</ul>
</body>

<script>

var clients = [
		{ a: true }, 
		{ a: false }, 
]

function test(){
	clients.forEach((client) => console.log(client.a));
}

test();
</script>


</html>