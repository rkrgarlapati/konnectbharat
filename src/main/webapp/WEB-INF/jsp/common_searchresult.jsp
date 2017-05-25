<!DOCTYPE html>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Guest Page</title>
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="/css/main.css"/>
    <link rel="stylesheet" type="text/css" href="/css/pikaday.css"/>
    <script src="https://code.jquery.com/jquery-1.10.2.js"></script>
    <script src="js/main.js"></script>
    <script src="/js/moment.min.js"></script>
    <script src="/js/pikaday.js"></script>

</head>
<body>

<div class="conatiner" style="width: 100%; margin-bottom: 15%">

    <!-- HEADER -->
    <jsp:include page="header.jsp"></jsp:include>

    <div id="section1" class="container"
         style="margin-left: 35px; width: 100%">

        <div class="row">

            <jsp:include page="search_menu.jsp"></jsp:include>

            <!-- </div> -->
            <div class="col-sm-9" id="searchDataDiv">
                <c:if test="${pagetype == 'TENANT' || pagetype=='OWNER' || pagetype=='SELL' || pagetype=='BUY'}">
                    <div class="col-sm-9 no-float">
                        <div class="page-header"
                             style="color: #337ab7; text-align: center;">
                            <h3>Rental or Sale</h3>
                        </div>
                        <div>
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th width="5%">Agreement Id</th>
                                    <th width="8%">Location</th>
                                    <th width="8%">Referral Status</th>
                                    <th width="8%">Phone Number</th>
                                    <th width="8%">Start Date</th>
                                    <th width="9%">Referred Party Name</th>
                                    <th width="9%">Referred Party Number</th>
                                    <th width="8%">Amount/Rent</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty searchResultList}">
                                    <c:forEach var="agreement" items="${searchResultList}">
                                        <tr>
                                            <td width="5%"><a href="#"
                                                              onclick="getDrilldownPg('${pagetype}','${agreement.saID}')">${agreement.saID}</a>
                                            </td>
                                            <td width="8%">${agreement.area}</td>
                                            <td width="8%"><c:if test="${not empty agreement.statusFlg}"><spring:message code="${agreement.statusFlg}"/></c:if></td>
                                            <td width="8%">${agreement.mobile}</td>
                                            <td width="8%">${agreement.startDate}</td>
                                            <td width="9%">${agreement.actualPartyName}</td>
                                            <td width="9%">${agreement.actualPartyConotact}</td>
                                            <td width="8%">${agreement.amount}</td>
                                        </tr>
                                    </c:forEach>
                                </c:if>

                                </tbody>
                            </table>
                        </div>
                    </div>

                </c:if>
                <c:if test="${pagetype == 'GROOM' || pagetype=='BRIDE'}">
                    <div class="col-sm-9 no-float">
                        <div class="page-header"
                             style="color: #337ab7; text-align: center;">
                            <h3>Matrimony</h3>
                        </div>
                        <div>
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th width="5%">Agreement Id</th>
                                    <th width="10%">Location</th>
                                    <th width="10%">Referral Status</th>
                                    <th width="10%">Phone Number</th>
                                    <th width="10%">Start Date</th>
                                    <th width="10%">Referred Party Name</th>
                                    <th width="10%">Referred Party Number</th>
                                    <th width="10%">DOB</th>
                                    <th width="10%">Religion</th>
                                    <th width="10%">Employment</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty searchResultList}">
                                    <c:forEach var="agreement" items="${searchResultList}">
                                        <tr>
                                            <td width="5%"><a href="#"
                                                              onclick="getDrilldownPg('${pagetype}','${agreement.saID}')">${agreement.saID}</a>
                                            </td>
                                            <td width="10%">${agreement.area}</td>
                                            <td width="10%"><c:if test="${not empty agreement.statusFlg}"><spring:message code="${agreement.statusFlg}"/></c:if></td>
                                            <td width="10%">${agreement.mobile}</td>
                                            <td width="10%">${agreement.startDate}</td>
                                            <td width="10%">${agreement.actualPartyName}</td>
                                            <td width="10%">${agreement.actualPartyConotact}</td>
                                            <td width="10%">${agreement.dob}</td>
                                            <td width="10%"><c:if test="${not empty agreement.religion}"><spring:message code="${agreement.religion}"/></c:if></td>
                                            <td width="10%"><c:if test="${not empty agreement.employment}"><spring:message code="${agreement.employment}"/></c:if></td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>

                </c:if>
                <c:if test="${pagetype == 'contact'}">
                    <div class="col-sm-9 no-float">
                        <div class="page-header"
                             style="color: #337ab7; text-align: center;">
                            <h3>Contact</h3>
                        </div>
                        <div>
                            <table class="table table-bordered">
                                <thead>
                                <tr>
                                    <th width="5%">Contact Id</th>
                                    <th width="15%">Contact Status</th>
                                    <th width="15%">Contact Class</th>
                                    <th width="15%">Contact Type</th>
                                    <th width="15%">Contact Date</th>
                                    <th width="15%">Assigned Date</th>
                                    <th width="15%">Assigned To</th>
                                </tr>
                                </thead>
                                <tbody>
                                <c:if test="${not empty searchResultList}">
                                    <c:forEach var="contact" items="${searchResultList}">
                                        <tr>
                                            <td width="5%"><a href="#"
                                                              onclick="getDrilldownPg('${pagetype}','${contact.contactId}')">${contact.contactId}</a>
                                            </td>
                                            <td width="15%"><c:if test="${not empty contact.contactStatus}"><spring:message code="${contact.contactStatus}"/></c:if></td>
                                            <td width="15%"><c:if test="${not empty contact.contactClass}"><spring:message code="${contact.contactClass}"/></c:if></td>
                                            <td width="15%"><c:if test="${not empty contact.contactType}"><spring:message code="${contact.contactType}"/></c:if></td>
                                            <td width="15%">${contact.contactDate}</td>
                                            <td width="15%">${contact.assignedDate}</td>
                                            <td width="15%">${contact.assignedTo}</td>
                                        </tr>
                                    </c:forEach>
                                </c:if>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </c:if>
            </div>
        </div>
    </div>
</div>
<input type="hidden" id="ispopup" value="${activate}">
<!-- FOOTER -->
<jsp:include page="footer.jsp"></jsp:include>
<div class="modal fade" id="drilldownModel" role="dialog">
    <div class="modal-dialog modal-sm" style="width: 50%">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header alert-info">
                <button type="button" class="close modalclosebtn" data-dismiss="modal">&times;</button>
                <h4 class="modal-title text-center"></h4>
            </div>
            <div class="modal-body">
                <div id="drilldown_popup"></div>
            </div>
        </div>

    </div>
</div>

<!-- Modal -->

<!-- jQuery library -->
<script
        src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script
        src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


</body>
<style>
    #message {
        position: fixed;
        top: 57px;
        left: 0;
        width: 100%;
    }

    #inner-message {
        margin: 0 auto;
    }

</style>
<script type="text/javascript">
 //   $("#success-alert").hide();
</script>
</html>