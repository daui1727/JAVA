<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%@include file="../includes/header.jsp" %>
            <div class="row">
                <div class="col-lg-12">
                    <h1 class="page-header">Tables</h1>
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            <div class="row">
                <div class="col-lg-12">
                    <div class="panel panel-default">
                        <div class="panel-heading">
                            Board Read Page
                        </div>
                        <!-- /.panel-heading -->
                        <div class="panel-body">
							<div class="form-group">
								<label>Bno</label>
								<input name="bno" class="form-control" readonly="readonly" value='<c:out value="${board.bno}"/>'><br>
							</div>
							<div class="form-group">
								<label>Title</label>
								<input name="title" class="form-control" readonly="readonly" value='<c:out value="${board.title}"/>'><br>
							</div>
							<div class="form-group">
								<label>Text area</label>
								<textarea class="form-control" rows="3" name="content" readonly="readonly">
								<c:out value="${board.content}" /></textarea><br>
							</div>
							<div class="form-group">
								<label>Writer</label>
								<input name="writer" class="form-control" readonly="readonly" value='<c:out value="${board.writer}"/>'><br>
							</div>
							
							<%-- <button data-oper="modify" class="btn btn-default"
							onclick="location.href='/board/modify?bno=<c:out value="${board.bno}"/>'">Modify</button>
							<button data-oper="list" class="btn btn-default"
							onclick="location.href='/board/list'">List</button> --%> 
							
							<button data-oper="modify" class="btn btn-default">Modify</button>
							<button data-oper="list" class="btn btn-default">List</button>
							
							<form id='operForm' action="/board/modify" method="get">
								<input type="hidden" id="bno" name="bno" value='<c:out value="${board.bno}" />'>
								<input type="hidden" name="pageNum" value='<c:out value="${cri.pageNum}"/>'>
								<input type="hidden" name="amount" value='<c:out value="${cri.amount}"/>'>
							</form>
							
                        </div>
                        <!-- /.panel-body -->
                    </div>
                    <!-- /.panel -->
                </div>
                <!-- /.col-lg-12 -->
            </div>
            <!-- /.row -->
            
            <script>
            	$(document).ready(function(){
            		
            		var operForm = $("#operForm");
            		
            		$("button[data-oper='modify']").on("click",function(){
            			operForm.attr("action", "/board/modify").submit();
            		});
            		
            		$("button[data-oper='list']").on("click",function(){
            			operForm.find("#bno").remove();
            			operForm.attr("action", "/board/list").submit();
            		});
            		
            	});
            </script>
            
            
            
            
            
            
            
            
            
            
      <%@include file="../includes/footer.jsp" %>
