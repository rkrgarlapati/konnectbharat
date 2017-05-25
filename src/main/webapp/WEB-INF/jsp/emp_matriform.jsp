<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<form:form id="matrimony_form" class="matrimony_form_class"
           method="POST" action="/matrimonyAgreementupdated/${saId}"
           commandName="matrimonyAttributes">
    <div id="matri_form" class="container-fluid">
        <div class="row text-center matrimonyForm_head">
            <h3>Matrimony Form</h3>
        </div>
        <c:if test="${not empty fn:trim(errorMsg)}">
            <p class="text-center error_show">${errorMsg}</p>
        </c:if>
        <div class="row" style="margin-top: 5px">
            <div style="float: left">
                <p class="alert alert-info" style="margin-left: 12px">*
                    indicates mandatory fields</p>
            </div>
            <div>
                <c:if test="${updateFlag == 'update'}">
                    <form:label path="matri_party_name"
                                style="padding:1px 0% 0% 20%;color: #FF6600;">
                        <spring:message code="agreement_id"/> ${saId}
                    </form:label>
                </c:if>

            </div>
        </div>
        <div id="message" style="text-align: center">
            <div style="display: inline-block;">
                <div class="alert alert-success" id="success-alert"
                     style="padding: 15px">

                </div>
            </div>
        </div>
        <div class="row gropElements elementsBorder">

            <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                <form:label path="matri_party_name">
                    <spring:message code="matri_party_name"/>
                </form:label>
                <c:choose>
                    <c:when test="${updateFlag == 'update'}">
                        <form:input path="matri_party_name" id="matri_party_name"
                                    class="form-control" readonly="true"/>
                    </c:when>
                    <c:otherwise>
                        <form:input path="matri_party_name" id="matri_party_name"/>
                    </c:otherwise>
                </c:choose>
                <form:errors path="matri_party_name" cssClass="error"/>
                <br/>
            </div>
            <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                <form:label path="agreement_type">
                    <spring:message code="agreement_type"/>
                </form:label>
                <c:choose>
                    <c:when test="${updateFlag == 'update'}">
                        <form:input path="agreement_type" id="agreement_type"
                                    class="form-control" readonly="true"/>
                    </c:when>
                    <c:otherwise>
                        <form:input path="agreement_type" id="agreement_type"
                                    readonly="true" value="${agreement_type}"/>
                        <form:errors path="agreement_type" cssClass="error"/>
                        <br/>
                    </c:otherwise>
                </c:choose>
                <br/>
            </div>
            <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                <form:label path="matri_phone">
                    <spring:message code="matri_phone"/>
                </form:label>
                <div class="input-group input-group-pNumber">
                    <span class="input-group-addon pNumber">+91</span>
                    <c:choose>
                        <c:when test="${updateFlag == 'update'}">
                            <form:input path="matri_phone" id="matri_phone"
                                        class="form-control" readonly="true"/>
                        </c:when>
                        <c:otherwise>
                            <form:input path="matri_phone" id="matri_phone"
                                        class="form-control"/>
                        </c:otherwise>
                    </c:choose>
                </div>
                <form:errors path="matri_phone" cssClass="error"/>
                <br/>
            </div>
        </div>
        <div class="row gropElements elementsBorder">
            <div class="row address_section_row">

                <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                    <form:label path="address1">
                        <spring:message code="matri_address1"/>
                    </form:label>
                    <form:textarea path="address1" id="matri_address1"/>
                    <form:errors path="address1" cssClass="error"/>
                    <br/>
                </div>

                <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                    <form:label path="address2">
                        <spring:message code="address2"/>
                    </form:label>
                    <form:textarea path="address2" id="matri_address2"/>
                    <form:errors path="address2" cssClass="error"/>
                    <br/>

                </div>
            </div>

            <div class="row address_section_row">
                <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                    <form:label path="area">
                        <spring:message code="matri_area"/>
                    </form:label>
                    <form:input path="area" id="matri_area"/>
                    <form:errors path="area" cssClass="error"/>
                    <br/>
                </div>
                <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                    <form:label path="city">
                        <spring:message code="matri_city"/>
                    </form:label>
                    <form:input path="city" id="matri_city"/>
                    <form:errors path="city" cssClass="error"/>
                    <br/>
                </div>

                <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                    <form:label path="state">
                        <spring:message code="matri_state"/>
                    </form:label>
                    <form:input path="state" id="matri_state"/>
                    <form:errors path="state" cssClass="error"/>
                    <br/>
                </div>

            </div>
            <div class="row address_section_row">
                <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                    <form:label path="postal">
                        <spring:message code="matri_postal"/>
                    </form:label>
                    <form:input path="postal" id="matri_postal"/>
                    <form:errors path="postal" cssClass="error"/>
                    <br/>
                </div>

                <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                    <form:label path="country">
                        <spring:message code="matri_country"/>
                    </form:label>
                    <form:input path="country" id="matri_country"/>
                    <form:errors path="country" cssClass="error"/>
                    <br/>
                </div>
            </div>

        </div>

        <div class="row gropElements elementsBorder">

            <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                <form:label path="bride_name">
                    <spring:message code="matri_bride_name"/>
                </form:label>
                <form:input path="bride_name" id="matri_bride_name"/>
                <form:errors path="bride_name" cssClass="error"/>
                <br/>
            </div>

            <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                <div class="row">
                    <form:label path="dob">
                        <spring:message code="matri_dob"/>
                    </form:label>
                    <form:input path="dob" id="matri_dob"/>
                </div>
                <form:errors path="dob" cssClass="error"/>
                <br/>
            </div>

            <div class="col-xm-12 col-sm-12 col-md-4 col-lg-4">
                <form:label path="highest_education">
                    <spring:message code="matri_higher_edu"/>
                </form:label>
                    <%-- <form:input path="highest_education" id="matri_higher_edu" /> --%>
                <form:select path="highest_education" id="matri_higher_edu"
                             value="highest_education">
                    <form:option value="" label="Select..."/>
                    <form:option value="UD" label="Uneducated"/>
                    <form:option value="BS" label="Basic School"/>
                    <form:option value="BL" label="Bachelors"/>
                    <form:option value="MA" label="Masters"/>
                </form:select>
                <form:errors path="highest_education" cssClass="error"/>
                <br/>
            </div>
        </div>

        <div class="row gropElements elementsBorder">
            <div class="row address_section_row">
                <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                    <form:label path="religion">
                        <spring:message code="matri_religion"/>
                    </form:label>
                        <%-- <form:input path="religion" id="matri_religion" /> --%>
                    <form:select path="religion" id="matri_religion"
                                 value="religion">
                        <form:option value="" label="Select..."/>
                        <form:option value="HIN" label="Hindu"/>
                        <form:option value="CHR" label="Christian"/>
                        <form:option value="MUS" label="Muslim"/>
                        <form:option value="SIK" label="Sikh"/>
                        <form:option value="OTR" label="Other"/>
                    </form:select>
                    <form:errors path="religion" cssClass="error"/>
                    <br/>
                </div>
                <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                    <form:label path="caste">
                        <spring:message code="matri_caste"/>
                    </form:label>
                    <form:input path="caste" id="matri_caste"/>
                    <form:errors path="caste" cssClass="error"/>
                    <br/>
                </div>
                <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                    <form:label path="sub_caste">
                        <spring:message code="matri_sub_caste"/>
                    </form:label>
                    <form:input path="sub_caste" id="matri_sub_caste"/>
                    <form:errors path="sub_caste" cssClass="error"/>
                    <br/>
                </div>
                <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                    <form:label path="height">
                        <spring:message code="matri_height"/>
                    </form:label>
                    <form:input path="height" id="matri_height"/>
                    <form:errors path="height" cssClass="error"/>
                    <br/>
                </div>
            </div>
        </div>
        <div class="row gropElements elementsBorder">


            <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                <form:label path="family_details">
                    <spring:message code="matri_family_det"/>
                </form:label>
                <form:textarea path="family_details" id="matri_family_det"/>
                <form:errors path="family_details" cssClass="error"/>
                <br/>
            </div>
            <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                <form:label path="additional_details">
                    <spring:message code="matri_add_details"/>
                </form:label>
                <form:textarea path="additional_details" id="matri_add_details"/>
                <form:errors path="additional_details" cssClass="error"/>
                <br/>
            </div>
            <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                <form:label path="employment">
                    <spring:message code="matri_employment"/>
                </form:label>
                    <%-- <form:input path="employment" id="matri_employment" /> --%>
                <form:select path="employment" id="matri_employment"
                             value="employment">
                    <form:option value="" label="Select..."/>
                    <form:option value="UNE" label="Unemployed"/>
                    <form:option value="EMP" label="Employed"/>
                    <form:option value="SFE" label="Self-Employed"/>
                    <form:option value="BIS" label="Business"/>
                </form:select>
                <form:errors path="employment" cssClass="error"/>
                <br/>
            </div>


            <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                <form:label path="marital_status">
                    <spring:message code="matri_marital_status"/>
                </form:label>
                    <%-- <form:input path="marital_status" id="matri_marital_status" /> --%>
                <form:select path="marital_status" id="matri_marital_status"
                             value="marital_status">
                    <form:option value="" label="Select..."/>
                    <form:option value="NVM" label="Never married"/>
                    <form:option value="DIS" label="Divorced"/>
                    <form:option value="ANL" label="Annulled"/>
                    <form:option value="WID" label="Waiting for Divorce"/>
                </form:select>
                <form:errors path="marital_status" cssClass="error"/>
                <br/>
            </div>
        </div>

        <div class="row gropElements elementsBorder">


            <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                <form:label path="food">
                    <spring:message code="matri_food"/>
                </form:label>
                    <%-- <form:input path="food" id="matri_food" /> --%>
                <form:select path="food" id="matri_food" value="food">
                    <form:option value="" label="Select..."/>
                    <form:option value="VE" label="Vegetarian"/>
                    <form:option value="NV" label="Non-Vegetarian"/>
                    <form:option value="EG" label="Eggetarian"/>
                </form:select>
                <form:errors path="food" cssClass="error"/>
                <br/>
            </div>
            <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                <form:label path="smoking">
                    <spring:message code="matri_smoking"/>
                </form:label>
                    <%-- <form:input path="smoking" id="matri_smoking" /> --%>
                <form:select path="smoking" id="matri_smoking" value="smoking">
                    <form:option value="" label="Select..."/>
                    <form:option value="NONS" label="Non-Smoker"/>
                    <form:option value="LSMO" label="Light/Social-Smoker"/>
                    <form:option value="RSMO" label="Regular Smoker"/>
                </form:select>
                <form:errors path="smoking" cssClass="error"/>
                <br/>
            </div>

            <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                <form:label path="drinking">
                    <spring:message code="matri_drinking"/>
                </form:label>
                    <%-- <form:input path="drinking" id="matri_drinking" /> --%>
                <form:select path="drinking" id="drinking_status"
                             value="drinking">
                    <form:option value="" label="Select..."/>
                    <form:option value="NOND" label="Non-Drinker"/>
                    <form:option value="LIGD" label="Light/Social-Drinker"/>
                    <form:option value="REGD" label="Regular Drinker"/>
                </form:select>
                <form:errors path="drinking" cssClass="error"/>
                <br/>
            </div>

            <div class="col-xm-12 col-sm-12 col-md-6 col-lg-6">
                <form:label path="horoscope_available">
                    <spring:message code="matri_horoscope_available"/>
                </form:label>
                    <%-- <form:input path="horoscope_available"
                id="matri_horoscope_available" /> --%>
                <form:select path="horoscope_available"
                             id="matri_horoscope_available" value="horoscope_available">
                    <form:option value="" label="Select..."/>
                    <form:option value="NVRM" label="Never married"/>
                    <form:option value="DIVR" label="Divorced"/>
                    <form:option value="ANNL" label="Annulled"/>
                    <form:option value="WITD" label="Waiting for Divorce"/>
                </form:select>
                <form:errors path="horoscope_available" cssClass="error"/>
                <br/>
                <form:hidden path="sa_status_flg" id="sa_status_flg"/>
                <%
                    Object obj = request.getAttribute("start_dt");
                    session.setAttribute("start_dt", obj);
                %>
            </div>
        </div>

        <c:if test="${activate == 'activate'}">
            <input type="button" id="submit_matrimony_update"
                   class="btn  btn-primary"
                   style="width: 45%; margin: 2% 2% 1% 2%" value="Update"
                   formaction="/matrimonyAgreementupdated/${saId}"/>

        </c:if>

        <c:if test="${activate != 'activate'}">
            <input type="button" id="submit_matrimony_update"
                   class="btn  btn-primary"
                   style="width: 50%; margin: 2% 2% 1% 25%" value="Update"
                   formaction="/matrimonyAgreementupdated/${saId}"/>

        </c:if>

        <c:if test="${activate == 'activate'}">
            <input type="button" id="submit_matrimony_activate"
                   class="btn  btn-primary"
                   style="width: 45%; margin: 2% 2% 1% 2%" value="activate"
                   formaction="/activateUser/${saId}"/>
        </c:if>

    </div>
    <input type="hidden" id="matripopupflg" value="true">
    <input type="hidden" id="elementId" value="${saId}">
</form:form>
<div class="modal fade" id="emp_infobox" role="dialog" style="top:35%">
    <div class="modal-dialog modal-sm">

        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal">&times;</button>
                <h4 class="modal-title">Matrimony</h4>
            </div>
            <div class="modal-body">
                <p id="emp_infobox_msg"></p>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-default" data-dismiss="modal">OK</button>
            </div>
        </div>

    </div>
</div>
<script src="/js/main.js"></script>
<script>$("#success-alert").hide();</script>