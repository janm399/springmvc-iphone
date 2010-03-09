<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link type="text/css" rel="stylesheet" href="/styles/main.css" />
	<link type="text/css" rel="stylesheet" href="/styles/effects.css" />
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.3.2/jquery.min.js" type="text/javascript"></script>
	<script src="http://cdn.jquerytools.org/1.1.2/tiny/jquery.tools.min.js" type="text/javascript"></script>
	<script src="/js/tools.overlay.apple-1.0.1.min.js" type="text/javascript"></script>
	<script src="/js/jquery.jbind-1.5.7.js" type="text/javascript"></script>
	<title>SpringMVC &amp; iPhone</title>
</head>
<body>
<c:forEach items="${recipes}" var="r">
	<a href="/recipes/${r.id}.html" rel="#overlay">${r.name}</a><br/>
</c:forEach>
<div class="apple_overlay" id="overlay"> 
	<div style="clear:both;"></div>
	<div class="contentWrap"></div>
	<div style="clear:both;"></div>
</div>
<form action="/recipes/generate.html" method="post">
	<input type="submit" value="Generate new one"/>
</form>
<script type="text/javascript">
$(function() {
    $("a[rel]").overlay({ 
        effect: 'apple', 
        onBeforeLoad: function() { 
            // grab wrapper element inside content 
            var wrap = this.getContent().find(".contentWrap"); 
            // load the page specified in the trigger 
            wrap.load(this.getTrigger().attr("href")); 
        } 
    });
});
</script>
</body>
</html>