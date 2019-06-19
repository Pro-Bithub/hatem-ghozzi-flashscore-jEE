  <jsp:include page="../head.jsp" />

</head>

<body>

<header>

    <nav class="navbar navbar-expand-lg navbar-dark default-color">
        <a class="navbar-brand" href="#"><strong>FlashScore</strong></a>
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
             <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link" href="http://localhost:8080/crud/authentication/login">Login <span class="sr-only">(current)</span></a>
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

	<div class="container mt-5">
		
		<form role="form" method="post" action="${pageContext.request.contextPath}/authentication/register">
			<!-- Login -->
			<div class="form-group">
				<label for="login">Login:</label>
				<input type="text" class="form-control" name="login" id="login" placeholder="Insert your login" autocomplete="off" autofocus="true" required />
			</div>
			<!-- Password -->
			<div class="form-group">
				<label for="password">Password:</label>
				<input type="password" class="form-control" name="password" id="password" placeholder="Insert your password" required/>
			</div>
			<div class="form-group">
				<label for="confirm">confirm password:</label>
				<input type="password" class="form-control" name="confirm" id="confirm" placeholder="Insert your confirm password" required/>
			</div>
			<!-- Send this form to server -->
			<div class="form-group" align="center">
				<button type="submit" class="btn btn-default btn-lg">
					register
				</button>
				<button type="reset" class="btn btn-default btn-lg">
					Cancel
				</button>
			</div>
		</form>
		
	


		
		<div><br></div>

		<div class="alert alert-danger" role="alert">
		  	<span class="glyphicon glyphicon-exclamation-sign" aria-hidden="true"></span>
		  	<span class="sr-only">Error:</span>
		  	Please, try to use login/password/confirm password valid!
		</div>
	</div>
  <jsp:include page="../footer.jsp" />
