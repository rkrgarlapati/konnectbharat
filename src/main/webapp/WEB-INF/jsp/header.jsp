<!-- Start Header Section -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse"
                    data-target="#myNavbar">
                <span class="icon-bar"></span> <span class="icon-bar"></span> <span
                    class="icon-bar"></span>
            </button>
            <a id="logo_id" class="navbar-brand" href="/guestFormController">
                <img class="img-responsive" src="" alt="Logo"/>
            </a>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
            <ul class="nav navbar-nav">
                <li><a id="options_header1" class="dropdown-toggle"
                       data-toggle="dropdown" href="#">ABOUT</a></li>
                <li><a id="options_header2" class="dropdown-toggle"
                       data-toggle="dropdown" href="#">CONTACT</a></li>

            </ul>
            <c:if test="${sessionScope.LOGGEDIN_USER != null}">
                <ul class="nav navbar-nav navbar-right">
                    <li>
                        <table border="0" height="50" width="200px" align="Right">
                            <tr align="left">
                                <td><font color="#FF9900">Name: ${LOGGEDIN_USER}</font></td>
                            </tr>
                            <c:if test="${sessionScope.USERTYPE eq 'customer'}">
                                <tr align="left">
                                    <td><font color="#FF9900">Mobile:
                                            ${LOGGEDIN_USER_MOBILE}</font></td>
                                </tr>
                            </c:if>
                        </table>
                    </li>
                    <li><a href="/logout"><span
                            class="glyphicon glyphicon-log-out"></span> LOGOUT</a></li>

                </ul>
            </c:if>
        </div>
    </div>
</nav>