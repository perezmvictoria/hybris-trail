<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html>
<title>Stadium Listing</title>
<body>
<h1>Stadium Listing</h1>
<ul>
    <c:forEach var="stadium" items="${stadiums}">
        <li >
            <a href="./stadiums/${stadium.name}">${stadium.name}</a>
            <img style="margin-left:20px;vertical-align:top;margin-bottom:20px" src="${stadium.imageUrl}"/>
        </li>
    </c:forEach>
</ul>
</body>
</html>