<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <title>관리자</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=10"/>
    <meta http-equiv="imagetoolbar" content="no"/>
    <link href="${pageContext.request.contextPath}/static/css/contents.css" rel="stylesheet" type="text/css"/>
    <link href="${pageContext.request.contextPath}/static/css/comment.css" rel="stylesheet" type="text/css"/>
    <script>
      window.addEventListener('DOMContentLoaded', () => {
        document.getElementById("re_reply_btn").addEventListener("click", function() {
          var form = document.getElementById("re_reply_form");
          if (form.style.display === "none") {
            form.style.display = "block";
          } else {
            form.style.display = "none";
          }
        });
      });
    </script>
</head>
<body>
<div id="wrapper">
    <div id="header">
        <div class="topInfoWrap">
            <div class="topInfoArea clfix">
                <div class="loginWrap">
                    <span class="fir">2022.05.17</span>
                    <span>13:30:22</span>
                    <span><em>OOO님</em> 좋은 하루 되세요</span>
                    <a href="" class="btnLogout"><img
                            src="${pageContext.request.contextPath}/static/img/common/btn_logout.gif" alt="로그아웃"
                    /></a>
                </div>
            </div>
        </div>
        <div class="gnbSubWrap">

        </div>
    </div>
    <div id="container">
        <div id="contentsWrap" class="contentsWrap">
            <div class="contents">
                <h1 class="title">게시판 상세보기</h1>
                <div class="btnSet clfix mgb15">
						<span class="fr">
							<span class="button"> <a href="">수정</a></span>
							<span class="button"><a href="">삭제</a></span>
							<span class="button"><a href="">목록</a></span>
						</span>
                </div>
                <table class="bbsList">
                    <colgroup>
                        <col width="400"/>
                        <col width="100"/>
                        <col width=""/>
                    </colgroup>
                    <tr>
                        <th scope="col" class="fir">이미지</th>
                        <th scope="col">글번호</th>
                        <td>${findCrudApp.no}</td>
                    </tr>
                    <tr>

                        <td class="fir" rowspan="7">
                            <c:choose>
                                <c:when test="${not empty findCrudApp.fileName}">
                                    <img src="/static/upload/${findCrudApp.fileName}" alt="real file" width="400"
                                         height="400"/>
                                </c:when>
                                <c:otherwise>
                                    <img src="${pageContext.request.contextPath}/static/upload/default.png"
                                         alt="default file" width="400"
                                         height="400"/>
                                </c:otherwise>
                            </c:choose>
                        </td>

                        <th scope="col">작성자</th>
                        <td>${findCrudApp.writer}</td>
                    </tr>
                    <tr>
                        <th scope="col">제목</th>
                        <td>${findCrudApp.title}</td>
                    </tr>
                    <tr>
                        <th scope="col">내용</th>
                        <td height="200">${findCrudApp.contents}</td>
                    </tr>
                    <tr>
                        <th scope="col">등록일</th>
                        <td>${findCrudApp.regDate}</td>
                    </tr>
                    <tr>
                        <th scope="col">조회수</th>
                        <td>${findCrudApp.hit}</td>
                    </tr>

                </table>

                <div class="cmt_comm">
                    <form action="${pageContext.request.contextPath}/comment-insert.do?cmd=comment-insert"
                          method="post">
                        <input type="hidden" name="boardNo" value="${findCrudApp.no}">
                        <input type="hidden" name="writer" value="${findCrudApp.writer}">
                        <fieldset class="fld_cmt" style="width: 1000px;">
                            <legend class="screen_out">댓글 작성</legend>
                            <textarea class="tf_cmt" name="contents" cols="115" rows="5"
                                      title="한줄 토크를 달아주세요"></textarea>
                            <input class="tf_pwd" name="password" type="password" placeholder="비밀번호를 입력해주세요">
                            <button type="submit" class="btn_cmt">등록</button>
                            <p class="info_append">
                                <span class="screen_out">입력된 바이트 수 : </span>
                                <span class="txt_byte">55</span> / 300자
                                <span class="txt_bar">|</span>
                                <a href="#none">댓글 운영원칙</a>
                            </p>
                        </fieldset>
                    </form>
                    <br>

                    <c:forEach items="${comments}" var="comment">
                        <div class="list_cmt" style="width: 1000px; float: left;">
                            <div class="cmt_head"></div>
                            <div class="cmt_body">
                        <span class="info_append">
                            <span class="txt_name">${comment.writer}</span>
                            <span class="txt_bar">|</span>
                            <span class="txt_time">${comment.regDate}</span>
                        </span>
                                <p class="txt_desc">${comment.contents}</p>
                            </div>
                            <div class="cmt_foot">
                                <button id="re_reply_btn">대댓글</button>
                                <span class="txt_bar">|</span>
                                <button
                                        id="reply_modify_btn">수정
                                </button>
                                <span class="txt_bar">|</span>
                                <button id="reply_delete_btn">삭제</button>
                            </div>
                        </div>
                        <div id="re_reply_form" style="display: none;">
                            <form action="${pageContext.request.contextPath}/comment-insert.do?cmd=comment-insert" method="post">
                                <input type="hidden" name="boardNo" value="${findCrudApp.no}"/>
                                <input type="hidden" name="parentCommentNo" value="${comment.commentNo}"/>
                                <label for="username">사용자 이름:</label>
                                <input type="text" id="username" name="writer"><br><br>
                                <label for="password">비밀번호:</label>
                                <input type="password" id="password" name="password"><br><br>
                                <label for="re_contents">대댓글:</label><br>
                                <textarea id="re_contents" name="contents"></textarea><br><br>
                                <button type="submit">제출</button>
                                <button type="reset">취소</button>
                            </form>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>






