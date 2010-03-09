<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<meta name="viewport" content="user-scalable=no, width=device-width" />
	<meta name="apple-mobile-web-app-status-bar-style" content="black" />
	<link type="text/css" rel="stylesheet" media="screen" href="/styles/jqtouch.css">
	<link type="text/css" rel="stylesheet" media="screen" href="/styles/themes/apple/theme.css">
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js"></script>
	<script src="/js/jqtouch.js" type="text/javascript"></script>
	<script type="text/javascript">
		var jQT = $.jQTouch({
			cacheGetRequests: false,
			statusBar: 'black'
		});
	</script>
</head>
<body>
	<div id="home">
		<div class="toolbar">
			<h1>Spring MVC</h1>
		</div>
		<h1>Top recipes</h1>
		<ul>
			<c:forEach items="${recipes}" var="r">
				<li class="arrow"><a href="/recipes/${r.id}.html">${r.name}</a></li>
			</c:forEach>
		</ul>
		<h1>Other Stuff</h1>
		<ul>
			<li class="arrow"><a href="#ingredients">Ingredients</a></li>
			<li class="arrow"><a href="#about">About</a></li>
		</ul>
	</div>
	<div id="ingredients">
		<div class="toolbar">
			<h1>Ingredients</h1>
			<a class="button back" href="#">Back</a>
		</div>
	</div>
	<div id="about">
		<div class="toolbar">
			<h1>About</h1>
			<a class="button back" href="#">Back</a>
		</div>
	</div>
</body>
</html>