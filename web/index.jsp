<%-- 
    Document   : home
    Created on : Jan 7, 2017, 12:07:55 AM
    Author     : vice
--%>

<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <h1>Tasks</h1>
        <s:bean name="bean.TaskList">
            <s:iterator value="tasks" var="curTask">
                <s:property value="name"/>
            </s:iterator>
        </s:bean>
    </body>
</html>
