<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
  pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<div>
  <h2>Reset Your Password</h2>
</div>
<c:url value="/resetPassword/sendMail" var="resetUrl" />
<form:form action="${resetUrl}" method="post" modelAttribute="rollBackResetForm"
  style="max-width: 350px; margin: 0 auto;">
  <input type="hidden" name="token" value="${token}" />
  <div class="border border-secondary rounded p-3">
    <div>
      <p>
        <form:input path="password" type="password" name="password" id="password"
          class="form-control" placeholder="Enter your new password"
          required autofocus />
      </p>
      <p>
        <input type="password" class="form-control" name="confirmPassword"
          placeholder="Confirm your new password" required />
      </p>
      <form:input path="token" type="hidden"
        value="${rollBackUpdateForm.token}" />
      <p class="text-center">
        <input type="submit" value="Change Password"
          class="btn btn-primary" />
      </p>
    </div>
  </div>
</form:form>