<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<div>
  <h2>Forgot Password</h2>
</div>

<form:form action="sendEmail" method="post" id="form"
  modelAttribute="rollBackEmailForm"
  style="max-width: 420px; margin: 0 auto;">
  <c:if test="${not empty errorMsg }">
    <span class="text text-danger"> ${errorMsg } </span>
  </c:if>
  <div class="border border-secondary rounded p-3">
    <div>
      <p>We will be sending a reset password link to your email.</p>
    </div>
    <div>
      <p>
        <form:input path="email" class="input input-box"
          value="${rollBackEmailForm.email}" placeholder="Enter Email"
          autocomplete="false" />
        <form:errors path="email" class="error text-danger user-error" />
      </p>
      <p class="text-center">
        <input type="submit" value="Send" class="btn btn-primary" />
      </p>
    </div>
  </div>
</form:form>

</body>
</html>