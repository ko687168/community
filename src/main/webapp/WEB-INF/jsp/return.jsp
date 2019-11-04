<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" buffer="none" %>
<html>
<head>
    <title>Title</title>
    <meta http-equiv="Expires" content="0">
    <meta http-equiv="Cache-Control", content="no-cache">
    <meta http-equiv="Progma" content="no-cache">
</head>
<body>

<tr>
<td>
<img id="infoIcon" style="height:30%; weight:30%;" src="${sessionScope.http}?rand=<%=Math.random()%>"/>
        <a href="delete?fileName=${sessionScope.http}">删除</a>
</td>
    <td><img id="infoIcon1" style="height:30%; weight:30%;" src="${sessionScope.http0}?rand=<%=Math.random()%>">
        <a href="delete?fileName=${sessionScope.http0}">删除</a>
    </td>
</tr>
<tr>
</td>
    <td><img id="infoIcon2" style="height:30%; weight:30%;" src="${sessionScope.http1}?rand=<%=Math.random()%>">
        <a href="delete?fileName=${sessionScope.http1}">删除</a>
    </td>
</tr>
<tr>
</td>
    <td><img id="infoIcon3" style="height:30%; weight:30%;" src="${sessionScope.http2}?rand=<%=Math.random()%>">
        <a href="delete?fileName=${sessionScope.http2}">删除</a>
    </td>
</tr>
<tr>
</td>    <td><img id="infoIcon4" style="height:30%; weight:30%;" src="${sessionScope.http3}?rand=<%=Math.random()%>">
        <a href="delete?fileName=${sessionScope.http3}">删除</a>
    </td>
</tr>

</body>
</html>