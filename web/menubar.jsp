<%-- 
    Document   : menubar
    Created on : Jan 8, 2017, 10:32:50 PM
    Author     : vice
--%>

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
            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link active" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Overview <span class="sr-only">(current)</span></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Reports</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Analytics</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Export</a>
                </li>
            </ul>

            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Nav item</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Nav item again</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">One more nav</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Another nav item</a>
                </li>
            </ul>

            <ul class="nav nav-pills flex-column">
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Nav item again</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">One more nav</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="http://v4-alpha.getbootstrap.com/examples/dashboard/#">Another nav item</a>
                </li>
            </ul>
        </nav>
