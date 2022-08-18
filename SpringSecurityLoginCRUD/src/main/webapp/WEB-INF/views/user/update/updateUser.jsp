<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<link rel="stylesheet"
  href='<c:url value="/resources/css/adminlte.css"/>'>
<style>
.btn-reset {
  background-color: #28a745 !important;
}
</style>
<div class="content-wrapper">
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="forms-mr">
          <div class="col-sm-6 col-md-6 form-detail">
            <c:url var="updateUser" value="/editUser"></c:url>
            <form:form class="form-create" action="editUser"
              method="POST" id="form" modelAttribute="editedUserForm">
              <input type="hidden" name="id"
                value="${editedUserForm.id }" />
              <div class="card card-primary card-outline">
                <div class="card-body box-profile">
                  <h4 class="text-center forms-header">
                    <b>User Edition</b>
                  </h4>
                  <c:if test="${errorMsg != null }">
                    <div class="alert alert-danger">
                      <strong>${errorMsg }</strong>
                    </div>
                  </c:if>

                  <div class="form-group">
                    <label for="username">Name</label> <input
                      class="form-control" name="username"
                      value="${editedUserForm.username }">
                    <form:errors path="username" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="phone">Phone</label> <input
                      class="form-control" name="phone"
                      value="${editedUserForm.phone }" />
                    <form:errors path="phone" class="text-danger" />
                  </div>

                  <div class="form-group">
                    <label for="email">Email</label> <input
                      class="form-control" name="email"
                      value="${editedUserForm.email }" />
                    <form:errors path="email" class="text-danger" />
                  </div>
                  <div class="form-group">
                    <label for="authority">Authority Role</label>
                    <form:select path="authority.id"
                      value="${editedUserForm.authority.id}"
                      class="form-select">
                      <c:forEach items="${AuthorityList}"
                        var="authority" varStatus="loop">
                        <option value="${authority.id }"
                          <c:if test="${editedUserForm.authority.id == authority.id }"> selected</c:if>>
                          ${authority.name}</option>
                      </c:forEach>
                    </form:select>
                  </div>

                  <button type="submit" class="btn btn-info"
                    name="update">Update</button>
                  <a class="btn btn-secondary"
                    href="${pageContext.request.contextPath}/userList">Back</a>
                  <a class="btn btn-secondary"
                    href="${pageContext.request.contextPath}/updateUser?id=${user.id}">Reset</a>
                </div>
              </div>
            </form:form>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>