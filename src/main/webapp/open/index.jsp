<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>

<!DOCTYPE HTML>
<html>
<head>
    <title>Cards</title>

    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        /* Remove the navbar's default margin-bottom and rounded borders */
        .navbar {
            margin-bottom: 0;
            border-radius: 0;
        }
        /* Set height of the grid so .sidenav can be 100% (adjust as needed) */
        .row.content {height: 450px}
        /* Set gray background color and 100% height */
        .sidenav {
            padding-top: 20px;
            background-color: #f1f1f1;
            height: 100%;
        }
        /* Set black background color, white text and some padding */
        footer {
            background-color: #555;
            color: white;
            padding: 15px;
        }
        /* On small screens, set height to 'auto' for sidenav and grid */
        @media screen and (max-width: 767px) {
            .sidenav {
                height: auto;
                padding: 15px;
            }
            .row.content {height:auto;}
        }
        hr.style8 {
            border-top: 1px solid dimgray;
            border-bottom: 1px solid dimgray;
        }
        hr.style8:after {
            content: '';
            display: block;
            margin-top: 2px;
            border-top: 1px solid dimgray;
            border-bottom: 1px solid dimgray;
        }
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="#">
                <img style="width: 40px;" src="https://www.theironyard.com/etc/designs/theironyard/icons/iron-yard-logo.svg" alt="The Iron Yard" />
            </a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li class="active"> <a href="#">Cards</a></li>
            </ul>
            <ul class="nav navbar-nav navbar-right">

            </ul>
        </div>
    </div>
</nav>

<div class="container text-center">
    <div class="row">
        <div class="col-sm-1"></div>
        <div class="col-sm-9 text-left">
            <h3>Cards APIs</h3>

            <hr />
            <form method="get" action="/mvc/cards/drawcard" class="form-horizontal" role="form">
                <input type="hidden" id="page" name="page" value="0" />
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="deck_id">Deck ID:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="deck_id" name="deck_id" placeholder="Enter Deck Id" value="<c:out value="${deck_id}"/>" />
                    </div>
                </div>
                <div class="form-group">
                    <label class="col-sm-4 control-label" for="deck_count">Deck Count:</label>
                    <div class="col-sm-8">
                        <input type="text" class="form-control" id="deck_count" name="deck_count" placeholder="Enter Deck Count" value="<c:out value="${deck_count}"/>" />
                    </div>
                </div>
                <div class="=form-group">
                    <div class="col-sm-4"></div>
                    <div class="col-sm-8">
                        <input type="submit" class="btn btn-primary" value="Draw Cards" />
                    </div>
                </div>
            </form>

            <hr />

            <div class="row">
                <br />
                <div class="col-sm-1"></div>
                <div class="col-sm-2">
                    <c:if test="${listOfCards.hasPrevious()}">
                        <a href="/mvc/cards/show?page=<c:out value="${listOfCards.number - 1}"/>&deck_id=<c:out value="${deck_id}"/>&deck_count=<c:out value="${deck_count}"/>">Previous Page <</a>
                    </c:if>
                </div>
                <div class="col-sm-2">
                    <c:if test="${listOfCards.hasNext()}">
                        <a href="/mvc/cards/show?page=<c:out value="${listOfCards.number + 1}"/>&deck_id=<c:out value="${deck_id}"/>&deck_count=<c:out value="${deck_count}"/>">> Next Page</a>
                    </c:if>
                </div>
                <div class="col-sm-1"></div>
            </div>

            <hr />

            <div class="col-sm-12">
                <ul class="list-unstyled">
                    <c:forEach items="${listOfCards.iterator()}" var="aCards">
                        <li>
                            <div class="row">
                                <div class="col-sm-3">
                                    <img src="<c:out value="${aCards.image} "/>" style="width: 50px;" />
                                </div>
                                <div class="col-sm-3">
                                    <c:out value="${aCards.value} "/>
                                </div>
                                <div class="col-sm-3">
                                    <c:out value="${aCards.suit} "/>
                                </div>
                                <div class="col-sm-3">
                                    <c:out value="${aCards.code} "/>
                                </div>
                            </div>
                            <div class="row"><hr /></div>
                        </li>
                    </c:forEach>
                </ul>
            </div>

            <hr />
        </div>
    </div>

    <hr class="style8" />
</div>

<footer class="container-fluid text-center">
    <p>Cards App</p>
</footer>

</body>
</html>
