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
      <td><a href="/book/read?code=${item.code}">${item.title}</a></td>
      <td>${item.writer}</td>
      <td>${item.price}</td>
    </tr>
    </c:forEach>
  </tbody>
</table>
<%@include file="../includes/footer.jsp"%>