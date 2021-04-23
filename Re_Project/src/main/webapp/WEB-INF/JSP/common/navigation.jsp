<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>

 <script src="js/jquery-2.2.3.min.js"></script>

        <nav style="margin-bottom: 0">
            <div>
                <a href="index">Test board</a>

	            <ul>
	                <li>
	                    <ul>
	                        <li><a href="memberForm"><c:out value="${sessionScope.usernm}"/></a></li>
	                        <li><a href="searchMember"> 사용자 조회</a></li>
	                        <li><a href="memberLogout">Logout</a></li>
	                    </ul>
	                </li>
	            </ul>
            </div>
            <!-- /.navbar-header -->
            <div role="navigation">
                <div>
                    <ul id="side-menu">
                        <li>
                           	<form id="searchForm" name="searchForm"  method="post" action="boardList">
                                <input type="hidden" name="searchType" value="BRDTITLE">
								<div>
	                                <input type="text" name="searchKeyword" id="globalKeyword" placeholder="Search...">
	                                <span class="input-group-btn">
	                                    <button type="button" onclick="fn_search()">
	                                        <i class="fa fa-search">최유경똥떙이</i>
	                                    </button>
	                                </span>
	                            </div>                           	
                            </form>
	                                <script>
	                                	function fn_search(){
	                                		if ($("#globalKeyword").val()!=="") {
		                                		$("#searchForm").submit();
	                                		}
	                                	}
	                                </script>                            <!-- /input-group -->
                        </li>
                        <li>
                            <a href="boardList"><i class="fa fa-files-o fa-fw"></i>게시판</a>
                        </li>
                        <c:if test='${sessionScope.userrole == "A"}'>
	                        <li>
	                            <a href="#"> 관리자</a>
	                        </li>
	                	</c:if>
	                	<li>
	                		<a href="Notice">공지사항</a>
	                	</li>	        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
        </nav>

