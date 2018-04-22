<!DOCTYPE HTML>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Pragma" content="no-cache">
    <meta http-equiv="Cache-Control" content="no-cache">
    <meta http-equiv="Expires" content="Sat, 01 Dec 2001 00:00:00 GMT">

    <title>JSP TITLE</title>

    <link href="static/css/bootstrap.min.css" rel="stylesheet">
    <link href="static/css/style.css" rel="stylesheet">

    <!--[if lt IE 9]>
    <script src="static/js/html5shiv.min.js"></script>
    <script src="static/js/respond.min.js"></script>
    <![endif]-->
</head>
<body>
    Body space in index.jsp

    <div role="navigation">
        <div class="navbar navbar-inverse">
            <a href="#" class="navbar-brand">WebTaskManager</a>
            <div class="navbar-collapse collapse">
                <ul class="nav navbar-nav">
                    <li><a href="#">Manage Task</a> </li>
                    <li><a href="#">All Tasks</a> </li>
                    <li><a href="#">Update Task</a> </li>
                    <li><a href="#">Create Task</a> </li>
                    <li><a href="#">Delete Task</a> </li>
                </ul>
            </div>
        </div>

        <div class="container invisible-at-first" id="homeDiv">
            <div class="jumbotron text-center">
                <h1>Welcome to WebTaskManager</h1>
            </div>
        </div>

        <div class="container" id="taskDiv">
            <h3>My Tasks</h3>
            <hr>
            <div class="table-responsive">
                <table class="table table-striped table-bordered text-left">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Name</th>
                            <th>Description</th>
                            <th>Date Created</th>
                            <th>Finished</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="task" items="${tasks}">
                            <tr>
                                <td>${task.id}</td>
                                <td>${task.name}</td>
                                <td>${task.description}</td>
                                <td>${task.dateCreated}</td>
                                <td>${task.finished}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

    </div>





    <script src="static/js/jquery-1.11.1.min.js"></script>
    <script src="static/js/bootstrap.min.js"></script>
</body>
</html>
