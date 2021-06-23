<%-- 
    
    Author     : KBowe
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix = "fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Member Purchases</title>
    </head>
    <body>
        <h1>Transactions on File for: </h1>
        <h2>${m.memid}</h2>
        <h2>${m.firstname} ${m.lastname}</h2>
        <table border ="1"
            <tr>
                <th>Purchase Dt</th>
                <th>Purchase Type</th> 
                <th>Trans. Cd</th> 
                <th>Trans Desc</th> 
                <th>Amount</th> 
            </tr>
            <c:forEach var="p" items="${pur}">
                <tr>
                <td align="right"> ${p.purchdtS}</td>
                <td align="left"> ${p.purchtype}</td>    
                <td align="left"> ${p.transCd}</td>
                <td align="right"> ${p.transdesc}</td>
                <td align="center"> ${p.amtS} </td> 
                </tr>
            </c:forEach>
        </table>
        
    </body>
     <br>
    ${msg}
   
    <br>
    <a href="MemberScreen.jsp">Back to Member Screen </a>
</html>
