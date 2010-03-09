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
<div id="home" class="current">
	<div class="toolbar">
		<h1>${recipe.name}</h1>
		<a class="button back" href="#">Back</a>
	</div>
	<div class="info">
		${recipe.steps}
	</div>
</div>
</body>
</html>