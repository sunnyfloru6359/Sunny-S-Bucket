<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Task Management Application</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
</head>
<body>

    <header>
        <nav class="navbar navbar-expand-md navbar-dark" style="background-color: #3366FF">
            <div>
                <a href="#" class="navbar-brand">Task Management</a>
            </div>

            <ul class="navbar-nav" style="background-color: #6699FF">
                <li><a href="#" class="nav-link">Tasks</a></li>
                <li><a href="#" class="nav-link">Reports</a></li>
            </ul>
        </nav>
    </header>
    <br>
    <div class="container col-md-6">
        <div class="card">
            <div class="card-body">
                <c:if test="${task != null}">
                    <form action="updateTask" method="post">
                </c:if>
                <c:if test="${task == null}">
                    <form action="addTask" method="post">
                </c:if>

                <caption>
                    <h2>
                        <c:if test="${task != null}">
                            Edit Task
                        </c:if>
                        <c:if test="${task == null}">
                            Add New Task
                        </c:if>
                    </h2>
                </caption>

                <c:if test="${task != null}">
                    <input type="hidden" name="taskId" value="<c:out value='${task.taskId}' />" />
                </c:if>

                <fieldset class="form-group">
                    <label>Task Name</label>
                    <input type="text" value="<c:out value='${task.taskName}' />" class="form-control" name="taskName" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Due Date</label>
                    <input type="date" value="<c:out value='${task.dueDate}' />" class="form-control" name="dueDate" required="required">
                </fieldset>

                <fieldset class="form-group">
                    <label>Task Description</label>
                    <textarea class="form-control" name="taskDescription"><c:out value='${task.taskDescription}' /></textarea>
                </fieldset>

                <button type="submit" class="btn btn-primary">Save</button>
                
            </div>
        </div>
    </div>
</body>
</html>
