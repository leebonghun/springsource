<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="../includes/header.jsp"%>

<table class="table table-striped">
  <thead>
    <tr>
      <th scope="col">Code</th>
      <th scope="col">Title</th>
      <th scope="col">Writer</th>
      <th scope="col">Price</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach var="item" items="${list}">
    <tr>
      <th scope="row">${item.code}</th>
      <td><a href="${item.code}" class="move">${item.title}</a></td>
      <td>${item.writer}</td>
      <td>${item.price}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<hr />
<div id='result'>

</div>
<script src="/resources/js/list.js"></script>
<%@include file="../includes/footer.jsp"%>