<%-- 
    Document   : menubar
    Created on : Jan 8, 2017, 10:32:50 PM
    Author     : vice
--%>
<%@taglib uri="/struts-tags" prefix="s" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--Navigation Bar at top -->
<nav class="navbar navbar-toggleable-md navbar-inverse bg-inverse fixed-top">
    <button class="navbar-toggler navbar-toggler-right hidden-lg-up" type="button" data-toggle="collapse" data-target="#navbarsExampleDefault" aria-controls="navbarsExampleDefault" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <a class="navbar-brand" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Dashboard</a>

    <div class="collapse navbar-collapse" id="navbarsExampleDefault">
        <ul class="navbar-nav mr-auto">

            <li class="nav-item active">
                <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Home <span class="sr-only">(current)</span></a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Settings</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Profile</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Help</a>
            </li>
        </ul>
        <form class="form-inline mt-2 mt-md-0">
            <input class="form-control mr-sm-2" type="text" placeholder="Search">
            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
        </form>
    </div>
</nav>

<!-- Sidbar Nav -->
<div class="container-fluid">
    <div class="row">
        <nav class="col-sm-3 col-md-2 hidden-xs-down bg-faded sidebar">
            <s:bean name="bean.CategoryList">
                <ul class="nav nav-pills flex-column">
                    <s:iterator value="taskCategories">
                        <li class="nav-item active">
                            <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">
                                <s:property /> 
                            </a>
                        </li>
                    </s:iterator>
                </ul>

                <ul class="nav nav-pills flex-column">
                    <s:iterator value="rewardCategories">
                        <li class="nav-item active">
                            <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">
                                <s:property /> 
                            </a>
                        </li>
                    </s:iterator>
                </ul>
            </s:bean>
        </nav>
