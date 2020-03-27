<%-- 
    Document   : query
    Created on : Aug 11, 2019, 7:36:31 AM
    Author     : VitaKing
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:include page="Header.jsp" />
    <div>
      <h1>Query - ID: Pending</h1>
      <p>Status: Unassigned</p>
      <form action="query" method="Post">
          <Input hidden name="username" type="text" value="${currentSessionUser.getUsername()}"></Input>
          <Input hidden name="password" type="text" value="${currentSessionUser.getPassword()}"></Input>
        <div class="form-group">
          <label for="query_description">Query description</label>
          <input
            type="text"
            class="form-control"
            name="query-description"
            placeholder="..."
          />
        </div>
        <div class="form-group">
            
          <label for="critical-level">Critical level</label>
          <select class="form-control" id="critical-level" name="critical_level" multiple size="1">
            <option>Highly-critical-24-hours</option>
            <option>Critical-48-hours</option>
            <option>Normal-72-hours</option>
          </select>
        </div>
        <div class="form-group">
          <label for="assigned-to">Assigned to</label>
          
          <select class="form-control" name="assignedTo">   
              <option>. . .</option>
              <c:forEach items="${currentSessionUser.getFullName()}" var="name">
              <option value="${name}">${name}</option>   
              </c:forEach>
          </select>
          
        </div>
        <div class="form-group">
          <label for="query-resolution">Query resolution</label>
          <textarea
            class="form-control"
            name="query-resolution"
            rows="3"
          ></textarea>
        </div>
        <button name="save" type="submit" class="btn btn-primary">Save</button>
        
        <button name="cancel" type="button" class="btn btn-danger">Cancel</button>
      </form>
              
              
    </div>
  </body>
</html>
