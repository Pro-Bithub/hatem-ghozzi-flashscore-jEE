  <jsp:include page="../head.jsp" />

<script>
function home() {
	document.location.href = "${pageContext.request.contextPath}/";
}
</script>
</head>

<body>
<header>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <nav class="navbar navbar-expand-lg navbar-dark default-color">
        <a class="navbar-brand" href="#"><strong>FlashScore</strong></a>
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
                <h2>404 error not found :(</h2>
            </div>
        </div>
    </div>
</main>
<!--Main Layout-->


	<div class="container">
	

		<div class="list-group">
			<a href="#" class="list-group-item">
				<h4>
					<strong>Ops - 404 Error!!!</strong>
				</h4>
				<p>
					You are trying to access a page that does not exist or has been disabled!
				</p>
			</a>

			<a href="#" class="list-group-item">
			<h4>
				<strong></strong>
			</h4>
			<p align="center">
				<button type="button" class="btn btn-lg btn-info" onclick="home()">Let's go to home? Click-me!</button>
			</p>
			</a>
		</div>
	</div>
  <jsp:include page="../footer.jsp" />