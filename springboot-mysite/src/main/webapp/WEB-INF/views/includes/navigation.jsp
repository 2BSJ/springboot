<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>  
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
		<div id="navigation">
			<ul>
				<c:choose>
					<c:when test='${param.menu == "main" }'>
						<li class="selected"><a href="<%=request.getContextPath()%>/">메인페이지</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/guestbook/list">방명록</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/guestbook/timeline">방명록(timeline)</a></li>
						<li><a href="<%=request.getContextPath()%>/gallery/index">갤러리</a></li>
					</c:when>
					<c:when test='${param.menu == "guestbook" }'>
						<li><a href="<%=request.getContextPath()%>/">메인페이지</a></li>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/guestbook/list">방명록</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/guestbook/timeline">방명록(timeline)</a></li>
						<li><a href="<%=request.getContextPath()%>/gallery/index">갤러리</a></li>
					</c:when>
					<c:when test='${param.menu == "guestbooktimeline" }'>
						<li><a href="<%=request.getContextPath()%>/">메인페이지</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/guestbook/list">방명록</a></li>
						<li class="selected"><a href="${pageContext.servletContext.contextPath }/guestbook/timeline">방명록(timeline)</a></li>
						<li><a href="<%=request.getContextPath()%>/gallery/index">갤러리</a></li>
						
					</c:when>
					<c:otherwise>
						<li><a href="<%=request.getContextPath()%>/">메인페이지</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/guestbook/list">방명록</a></li>
						<li><a href="${pageContext.servletContext.contextPath }/guestbook/timeline">방명록(timeline)</a></li>
						<li class="selected"><a href="<%=request.getContextPath()%>/gallery/index">갤러리</a></li>
					</c:otherwise>					
				</c:choose>
			
			
			</ul>
		</div>