<%--
  Created by IntelliJ IDEA.
  User: toannh
  Date: 10/9/14
  Time: 5:03 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h2>Contact Manager</h2>
<form:form method="post" action="addUser.html">
  <table>
    <tr>
      <td><form:label path="username">username</form:label></td>
      <td><form:input path="username" /></td>
    </tr>
    <tr>
      <td><form:label path="password">password</form:label></td>
      <td><form:input path="password" /></td>
    </tr>
    <tr>
      <td><form:label path="passwordConfirm">Re type</form:label></td>
      <td><form:input path="passwordConfirm" /></td>
    </tr>
    <tr>
      <td><form:label path="enable">Enable</form:label></td>
      <td><form:input path="enable" /></td>
    </tr>
    <tr>
      <td colspan="2">
        <input type="submit" value="Add Contact"/>
      </td>
    </tr>
  </table>

</form:form>