  <jsp:include page="../head.jsp" />

<script>

function addmatch() {
	document.location.href = "${pageContext.request.contextPath}/admin?match=add";
}
function deletmatch(id) {
	document.location.href = "${pageContext.request.contextPath}/admin?match=delete&idmatch="
			+ id;
}
function editmatch(id) {
	document.location.href = "${pageContext.request.contextPath}/admin?match=edit&idmatch="
			+ id;
}
	function add() {
		document.location.href = "${pageContext.request.contextPath}/admin?action=add";
	}



	function edit(login) {
		document.location.href = "${pageContext.request.contextPath}/admin?action=edit&userid="
				+ login;
	}

	function delet(login) {
		document.location.href = "${pageContext.request.contextPath}/admin?action=delete&userid="
				+ login;
	}
	
	
</script>
</head>

<body>
<header>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <nav class="navbar navbar-expand-lg navbar-dark default-color">
        <a class="navbar-brand" href="http://localhost:8080/crud/match"><strong>FlashScore</strong></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/crud/logout">Logout <span class="sr-only">(current)</span></a>
                </li>
         
            </ul>
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item">
                    <a class="nav-link"><i class="fab fa-facebook-f"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"><i class="fab fa-twitter"></i></a>
                </li>
                <li class="nav-item">
                    <a class="nav-link"><i class="fab fa-instagram"></i></a>
                </li>
            </ul>
        </div>
    </nav>

</header>
<!--Main Layout-->
<main>
    <div class="container-full mb-3" style="    background: #2bbb8c;
    padding-bottom: 23px;">
        <div class="row pt-5">
            <div class="col text-center">
                <h2> FlashScore-TN</h2>
                <h5>Welcome Admin</h5>
            </div>
        </div>
    </div>
</main>
<!--Main Layout-->

	<div class="container">
		
        
		<h2>dashboard admin</h2>
		
		
		
		<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active" id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">User</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">Match</a>
  </li>
 
</ul>
<div class="tab-content" id="myTabContent">
  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">


		
				<h4 class="text-center mt-3">
					<strong>User Summary</strong>
				</h4>
				<p>
					<div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>Id</th>
									<th>Login</th>
									<th>Password</th>
									<th>Type</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${users}" var="user">
									<tr>
										<td>${user.userid}</td>
										<td>${user.name}</td>
										<td>${user.password}</td>
										<td>${user.type}</td>

										<td><a   class="btn btn-sm btn-info" onclick="edit('${user.userid}')">Edit</a>
											 <a class="btn btn-sm btn-danger" onclick="delet('${user.userid}')">Delete</a>
										<td>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</p>
		
		

			<!-- Logout -->
			<a href="#" class="list-group-item">
				<h4>
					<strong></strong>
				</h4>
				<p align="center">
					<button type="button" class="btn btn-lg btn-success"
						onclick="add()">New User</button>
					
				</p>
			</a>
	


</div>
  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">
  	<h4 class="text-center mt-3">
					<strong>match Summary</strong>
				</h4>
				<p>
					<div>
						<table class="table table-striped">
							<thead>
								<tr>
									<th>idmatch</th>
									<th>statue</th>
									<th>nameequipeone</th>
									<th>Score</th>
									
									<th>nameequipetwo</th>
								
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${matchs}" var="item">
									<tr>
										<td> ${item.idmatch}</td>
										<td>${item.statue}</td>
										<td>${item.nameequipeone}</td>
										<td>${item.scoreequipeone}-${item.scoreequipetwo}</td>
										
										<td>${item.nameequipetow}</td>

										<td><a   class="btn btn-sm btn-info" onclick="editmatch('${item.idmatch}')">Edit</a>
											 <a class="btn btn-sm btn-danger" onclick="deletmatch('${item.idmatch}')">Delete</a>
										<td>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
					</div>
				</p>
		
		

			<!-- Logout -->
			<a href="#" class="list-group-item">
				<h4>
					<strong></strong>
				</h4>
				<p align="center">
					<button type="button" class="btn btn-lg btn-success"
						onclick="addmatch()">New match</button>
					
				</p>
			</a>
	</div>
 
 

 
			
 
</div>
</div>
		
  <jsp:include page="../footer.jsp" />