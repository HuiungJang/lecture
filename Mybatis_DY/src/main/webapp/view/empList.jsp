<%--
  Created by IntelliJ IDEA.
  User: jang
  Date: 2021/06/16
  Time: 10:31 오전
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set value="${pageContext.request.contextPath}" var="path"/>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <div id="search-container">
        <form action="${path}/searchEmp" method="post">
            <table>
                <tr>
                    <td>
                        <label>
                            <select name="searchType" >
                                <option value="검색타입" disabled selected>검색타입</option>
<%--                                <option value="emp_id" ${param.searchType eq 'emp_id'?"selected":""}>사번</option>--%>
<%--                                <option value="emp_name" ${param.searchType eq 'emp_name'?"selected":""}>이름</option>--%>
<%--                                <option value="email" ${param.searchType eq 'email'?"selected":""}>이메일</option>--%>
<%--                                <option value="phone" ${param.searchType eq 'phone'?"selected":""}>전화번호</option>--%>
                                <option value="emp_id">사번</option>
                                <option value="emp_name">이름</option>
                                <option value="email">이메일</option>
                                <option value="phone">전화번호</option>
                            </select>
                        </label>
                    </td>
                    <td>
                        <label>
<%--                            <input type="search" name="searchKeyword" value="${param.searchKeyword}">--%>
                                <input type="search" name="searchKeyword">
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>급여</th>
                    <td>
                        <label>
                            <input type="number" name="salary" min ="1800000" step="100000">
                        </label>
                        <label>
                            <input type="radio" name="le_ge" value="le">
                        </label>작다
                        <label>
                            <input type="radio" name="le_ge" value="ge">
                        </label>크다
                    </td>
                </tr>
                <tr>
                    <th>입사일</th>
                    <td>
                        <label>
                            <input type="date" name="hireDate">
                            <label>
                                <input type="radio" name="H_le_ge" value="le">
                            </label>작다
                            <label>
                                <input type="radio" name="H_le_ge" value="ge">
                            </label>크다
                        </label>
                    </td>
                </tr>
                <tr>
                    <th>성별</th>
                    <td>
                        <label><input type="radio" name="gender" value="M">남</label>
                        <label><input type="radio" name="gender" value="F">여</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="조회">
                    </td>
                </tr>
            </table>
        </form>
    </div>
    <table>
        <tr>
            <th>번호</th>
            <th>이름</th>
            <th>주민</th>
            <th>이메일</th>
            <th>폰</th>
            <th>뎊코드</th>
            <th>잡코드</th>
            <th>셀레벨</th>
            <th>급여</th>
            <th>보너스율</th>
            <th>관리자</th>
            <th>고용일</th>
            <th>입사일</th>
            <th>재직여부</th>
            <th>성별</th>
        </tr>
        <c:forEach items="${list}" var="e">
            <tr>
                <fmt:setLocale value="ko_KR"/>
                <td><c:out value="${e['EMP_ID']}"/></td>
                <td><c:out value="${e['EMP_NAME']}"/></td>
                <td><c:out value="${e['EMP_NO']}"/></td>
                <td><c:out value="${e['EMAIL']}"/></td>
                <td><c:out value="${e['PHONE']}"/></td>
                <td><c:out value="${e['DEPT_CODE']}"/></td>
                <td><c:out value="${e['JOB_CODE']}"/></td>
                <td><c:out value="${e['SAL_LEVEL']}"/></td>
                <td><fmt:formatNumber type="currency" value="${e['SALARY']}"/></td>
                <td><fmt:formatNumber type="percent" value="${e['BONUS']}"/></td>
<%--                직접접근 연산자를 사용해도 되고 [''] 이렇게 사용해도 된다.--%>
<%--                대소문자를 구분하기 때문에 확인하고 사용하자.--%>
                <td><c:out value="${e.MANAGER_ID}"/></td>
                <td><fmt:formatDate pattern="yyyy/MM/dd E" value="${e.HIRE_DATE}"/></td>
                <td><fmt:formatDate pattern="yyyy/MM/dd E" value="${e.ENT_DATE}"/></td>
                <td><c:out value="${e.ENT_YN}"/></td>
                <td><c:out value="${e['GENDER']}"/> </td>
            </tr>
        </c:forEach>
    </table>
    <ul>

    </ul>
</body>
</html>
