<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<link rel="stylesheet" href="/resources/css/upload.css" />
<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Board Read</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>            
            <div class="row">
                <div class="col-lg-12">
                	<div class="panel panel-default">
                        <div class="panel-heading">
                           Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
                			<form action="" role="form">
                				<div class="form-group">
                					<label>Bno</label>
                					<input class="form-control" name="bno" readonly="readonly" value="${read.bno}">                				
                				</div> 
                				<div class="form-group">
                					<label>Title</label>
                					<input class="form-control" name="title" readonly="readonly" value="${read.title}">                				
                				</div>  
                				<div class="form-group">
                					<label>Content</label>
                					<textarea class="form-control" rows="3" name="content" readonly="readonly">${read.content}</textarea>               				
                				</div> 
                				<div class="form-group">
                					<label>Writer</label>
                					<input class="form-control" name="writer" readonly="readonly" value="${read.writer}">                				
                				</div>  
                				<!-- 로그인 한 사용자가 글을 작성한 작성자냐?를 따져야함 -->
								<sec:authentication property="principal" var="info"/>   
								<sec:authorize access="isAuthenticated()">
									<c:if test="${info.username == read.writer}">             				
	                					<button type="button" class="btn btn-default">Modify</button>     			
	                				</c:if>
                				</sec:authorize>
                				<button type="reset" class="btn btn-info">List</button>          			
                			</form>
                		</div>
                	</div>
                </div>
      
      
      
      
            </div>
<!-- 첨부파일 등록  -->
<div class="bigPictureWrapper">
	<div class="bigPicture"></div>
</div>
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading"><i class="fa fa-files-o"></i>파일첨부</div>
			<div class="panel-body">
				<div class="uploadResult">
					<ul></ul>
				</div>
			</div>
		</div>
	</div>
</div>  
<!-- 댓글 리스트  -->
<div class="row">
	<div class="col-lg-12">
		<div class="panel panel-default">
			<div class="panel-heading">
				<i class="fa fa-comments fa-fw"></i>
				Reply
				<sec:authorize access="isAuthenticated()"> 
					<button id="addReplyBtn" class="btn btn-primary btn-xs pull-right">New Reply</button>
		    	</sec:authorize>
		    </div>
			<div class="panel-body">
				<ul class="chat">
					<li class="left clearfix" data-rno='1'>
						<div>
							<div class="header">
								<strong class="primary-font">user00</strong> <!-- 댓글 작성자 -->
								<small class="pull-right text-muted">2021-06-15 14:25</small> <!-- 댓글 작성 시간 -->
								<p>Good Job!!</p><!-- 댓글 작성 내용 -->
							</div>
						</div>
					</li>
				</ul>
			</div>
			<div class="panel-footer">
				
			
			</div><!-- 댓글 페이지 나누기 -->
		</div><!-- panel-default close -->
	</div><!-- col-lg-12 close -->
</div><!-- row close -->  
<!-- 댓글 작성 폼  -->
<div class="modal" tabindex="-1" id="replyModal">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
        <h5 class="modal-title">Reply</h5>
      </div>
      <div class="modal-body">
        <div class="form-group">
        	<label for="">댓글 내용</label>
        	<input type="text" name="reply" class="form-control" value="댓글내용"/>
        </div>
        <div class="form-group">
        	<label for="">작성자</label>
        	<input type="text" name="replyer" class="form-control" value="작성자"/>
        </div>
        <div class="form-group">
        	<label for="">작성일</label>
        	<input type="text" name="replyDate" class="form-control" value="작성일"/>
        </div>        
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-success" id="modalRegisterBtn">등록</button>
        <button type="button" class="btn btn-warning" id="modalModifyBtn">수정</button>
        <button type="button" class="btn btn-danger" id="modalRemoveBtn">삭제</button>
        <button type="button" class="btn btn-primary" data-dismiss="modal" id="modalCloseBtn">종료</button>
      </div>
    </div>
  </div>
</div>




<!-- 페이지 나누기를 위한 form -->            
<form action="" id="actionForm">
	<input type="hidden" name="pageNum" value="${cri.pageNum}" />
	<input type="hidden" name="amount" value="${cri.amount}" />
	<input type="hidden" name="type" value="${cri.type}" />
	<input type="hidden" name="keyword" value="${cri.keyword}" />
	<input type="hidden" name="bno" value="${read.bno}" />
</form>  
<script>
	//현재 글번호 가져오기
	let bno = ${read.bno};	
	
	//스프링 시큐리티 설정으로 인한 추가
	//댓글 작성 시 작성자 란에 현재 로그인한 사용자 보여주기
	
	let replyer = null;
	<sec:authorize access="isAuthenticated()">
	   replyer = '<sec:authentication property="principal.username"/>';
	</sec:authorize>
	
	let csrfHeaderName = "${_csrf.headerName}";
	let csrfTokenValue = "${_csrf.token}";
</script>          
<script src="/resources/js/reply.js"></script>
<script src="/resources/js/read.js"></script>
<%@include file="../includes/footer.jsp" %>














      