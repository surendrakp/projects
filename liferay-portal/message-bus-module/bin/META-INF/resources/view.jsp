<%@ include file="init.jsp" %>

<liferay-portlet:actionURL name="messageListnerTest" var="messageListnerTestUrl">
</liferay-portlet:actionURL>


<aui:form action="<%=messageListnerTestUrl %>" name="messageListnerTestForm" method="post">


	<aui:input name="testStr"></aui:input>
	
	<aui:button type="submit" value="Test"></aui:button>

</aui:form>