<%-- 
    Document   : homepage
    Created on : Aug 1, 2019, 8:46:19 AM
    Author     : VitaKing
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="Header.jsp" />

    <div>
       
      <h1>Dashboard </h1>
      <ul class="nav nav-tabs" id="homepage-tabs" role="tablist">
        <li class="nav-item">
          <a
            class="nav-link active"
            id="queries-tab"
            data-toggle="tab"
            href="#queries"
            role="tab"
            aria-controls="queries"
            aria-selected="true"
            >Queries</a
          >
        </li>
        <li class="nav-item">
          <a
            class="nav-link"
            id="employees-tab"
            data-toggle="tab"
            href="#employees"
            role="tab"
            aria-controls="employees"
            aria-selected="false"
            >Employees</a
          >
        </li>
      </ul>
      <div class="tab-content" id="queries-tab-content">
          
        <div
          class="tab-pane fade show active"
          id="queries"
          role="tabpanel"
          aria-labelledby="queries-tab"
        >
          <ul class="list-group">
            <li class="list-group-item">
              <div>
               <c:forEach items="${currentSessionUser.getQueries()}" var="che"> 
                <h4>Query ID: ${che}</h4>
                
              </c:forEach> 
                            
<!--              <p>Created at: 30 July, 2019</p>-->
                  <button name="send" type="submit" class="btn btn-success" formaction="HqSend">Send to HQ</button>
              </div>
            </li>
          </ul>
        </div>
        <div
          class="tab-pane fade"
          
          id="employees"
          role="tabpanel"
          aria-labelledby="employees-tab"
        >
            <div id="error" class="jumbotron">
                <h1 >Oop! You are not authorized to view employee details</h1>
            </div>
            
            <ul id="Valid-emp" class="list-group">
            <li class="list-group-item">
              <div>
                  
                <a href="employee.html">
                  <h4>Employee ID: 0123456</h4>
                </a>
                <h5>Ajayi Solomon</h5>
                <p>Queries: 5</p>
                <p>Join date: 30 July, 2019</p>
              </div>
            </li>
          </ul>
        </div>
      </div>
    </div>
    <script type="text/javascript">
               var ValidRole = "${currentSessionUser.getRole()}";
               var check = document.getElementById("Valid-emp");
               var error = document.getElementById("error");
               var executive = "Executive Manager";
               var branch = "Branch Manager";
               if(ValidRole === executive || ValidRole === branch){
                   error.style.display = "none"
                   check.style.display = "Block";
               }else{
                   check.style.display = "none";
               }
              
    </script>
  </body>
</html>
