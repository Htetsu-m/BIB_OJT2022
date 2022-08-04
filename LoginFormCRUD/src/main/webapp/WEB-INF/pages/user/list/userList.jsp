<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="content-wrapper">
  <section class="content">
    <div class="row">
      <div class="col-12">
        <div class="card">
          <div class="card-header">
            <h3 class="card-title">User List</h3>
          </div>
          <div class="card-body">
            <div class="row">
              <div class="col-sm-12 col-md-12">
                <div class="search-sec">
                  <c:url var="addAction" value="/searchUser"></c:url>

                  <a
                    href="${pageContext.request.contextPath}/createUser"
                    class="btn btn-info">Add</a>
                </div>
              </div>
            </div>
            <div class="row">
              <div class="col-sm-12">
                <table id="example1"
                  class="table table-bordered table-striped">
                  <thead>
                    <tr>
                      <th>ID</th>
                      <th>Name</th>
                      <th>Phone</th>
                      <th>Email</th>
                      <th>Actions</th>
                    </tr>
                  </thead>
                  <tbody>
                    <c:forEach items="${UserList}" var="user"
                      varStatus="loop">
                      <tr>
                        <td>${user.id }</td>
                        <td>${user.name}</td>
                        <td>${user.phone }</td>
                        <td>${user.email}</td>

                        <td class="text-right py-0 align-middle">
                          <div class="btn-group btn-group-sm">
                            <a
                              href="${pageContext.request.contextPath}/updateUser?id=${user.id}"
                              class="btn btn-secondary">edit</a> <a
                              href="#" data-toggle="modal"
                              data-href="${pageContext.request.contextPath}/deleteUser?id=${user.id }"
                              data-target="#myModal"
                              class="btn btn-danger btn-ok"> delete</a>


                          </div>
                        </td>
                      </tr>
                    </c:forEach>
                  </tbody>
                </table>
              </div>
            </div>
          </div>
        </div>
      </div>
    </div>
  </section>
</div>

<div class="modal fade" id="myModal" role="dialog" aria-hidden="true">
  <div class="modal-dialog">
    Modal content
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title">Delete User Confirmation!</h4>
      </div>
      <div class="modal-body">
        <p>Are You Sure Want to Delete!</p>
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-default"
          data-dismiss="modal">Cancel</button>
        <a class="btn btn-danger btn-ok">OK</a>
      </div>
    </div>
  </div>
</div>
<script>
	$('#myModal').on(
			'show.bs.modal',
			function(e) {
				$(this).find('.btn-ok').attr('href',
						$(e.relatedTarget).data('href'));
				$('.debug-url').html(
						'Delete URL: <strong>'
								+ $(this).find('.btn-ok').attr('href')
								+ '</strong>');
			});
</script>
