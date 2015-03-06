 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
 <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
 <%@ page isELIgnored="false"%>
<html>
<body>
<h1>Salesforce Integration Web Project Example</h1>
<table>
<th>ID</th>
<th>Name</th>
<th>Date of Joining</th>
<th>Department</th>


<c:forEach items="${emplist}" var="element"> 
  <tr>
    <td>${element.id}</td>
    <td>${element.name}</td>
    <td><fmt:formatDate pattern="dd-MMM-yyyy" value="${element.joiningDate}" /></td>
    <td>${element.department}</td>
  </tr>
</c:forEach>
</table>	
</body>
</html>