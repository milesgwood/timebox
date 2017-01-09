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
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <meta name="description" content="">
        <meta name="author" content="Miles Greatwood">
        <link rel="icon" href="http://myfaviconLocation">
        <title>Time Boxer</title>
        
        <!-- CSS newest-->
        <link rel="stylesheet" href="./css/bootstrap.css" media="screen">
        
        <!--Custom Stylesheet for this -->
        <link rel="stylesheet" href="./css/myCustomStyle.css" media="screen">
        
        <!-- Glyphcons from CSS 3 -->
        <link href="./css/glyphicons.css" rel="stylesheet" />
    </head>
    <body>
        <jsp:include page='menubar.jsp'/>
        <!--Start of main middle section-->
        <main class="col-sm-9 offset-sm-3 col-md-10 offset-md-2 pt-3">
            <h1>Time Boxer</h1>

            <!-- Top timer section  -->
            <section class="row text-center placeholders"></section>

            <!-- TASKS start here -->
            <div class="row justify-content-between">
                <div class="col-sm-6">
                    <h2>Tasks</h2>
                    <form>
                        <div class="form-group form-inline">
                            <input id="newTaskName" class="form-inline form-text form-control" type="text" name="newTask" placeholder="Enter new task">
                            <button class="btn btn-primary form-inline" type="submit">
                                <span class="glyphicon glyphicon-plus"></span>
                            </button>
                        </div>
                    </form>
                    <!-- List of tasks -->
                    <ul class="container-fluid" style="list-style-type: none;">
                        <s:bean name="bean.TaskList">
                            <s:iterator value="tasks" var="curTask">
                                <li class="mb-1">
                                    <div class="bg-danger border rounded row p-2 align-items-center">
                                        <div class="col col-2">
                                            <button class="btn btn-outline-secondary" type="submit">
                                                <span class="glyphicon glyphicon-check"></span>
                                            </button>
                                        </div>
                                        <div class="col col-8"><s:property value="name"/></div>
                                        <div class="col col-2 justify-content-end">
                                            <button class="btn btn-outline-secondary justify-content-end" type="submit">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </button>
                                        </div>
                                    </div>
                                </li>
                            </s:iterator>
                        </s:bean>
                    </ul>
                </div>

                <!-- REWARDS start here with the add form -->
                <div class="col-sm-6">
                    <h2>Rewards</h2>
                    <form>
                        <div class="form-group form-inline">
                            <input id="newRewardName" class="form-inline form-text form-control" type="text" name="newRewardName" placeholder="Enter new reward">
                            <button class="btn btn-primary form-inline" type="submit">
                                <span class="glyphicon glyphicon-plus"></span>
                            </button>
                        </div>
                    </form>
                    <!-- List of task items -->
                    <ul class="container-fluid" style="list-style-type: none;">
                        <s:bean name="bean.RewardList">
                            <s:iterator value="rewards" var="curReward">
                                <li class="mb-1">
                                    <div class="bg-success border rounded row p-2 align-items-center">
                                        <div class="col col-2">
                                            <button class="btn btn-outline-secondary" type="submit">
                                                <span class="glyphicon glyphicon-check"></span>
                                            </button>
                                        </div>
                                        <div class="col col-8"><s:property value="name"/></div>
                                        <div class="col col-2 justify-content-end">
                                            <button class="btn btn-outline-secondary justify-content-end" type="submit">
                                                <span class="glyphicon glyphicon-remove"></span>
                                            </button>
                                        </div>
                                    </div>
                                </li>
                            </s:iterator>
                        </s:bean>
                    </ul>
                </div>

            </div>
            <div class="table-responsive">
                <table class="table table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Header</th>
                            <th>Header</th>
                            <th>Header</th>
                            <th>Header</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1,001</td>
                            <td>Lorem</td>
                            <td>ipsum</td>
                            <td>dolor</td>
                            <td>sit</td>
                        </tr>
                    </tbody>
                </table>
            </div>
        </main>
        <!-- 2 divs below end the menubar.jsp included divs -->
        </div>
        </div>
        <jsp:include page='scripts.jsp' />
    </body>
</html>
