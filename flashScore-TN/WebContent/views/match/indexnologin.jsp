  <jsp:include page="../head.jsp" />
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
<!--Main Navigation-->

<!--Main Layout-->
<main>
    <div class="container-full mb-3" style="    background: #2bbb8c;
    padding-bottom: 23px;">
        <div class="row pt-5">
            <div class="col text-center">
                <h2> FlashScore-TN</h2>
                <h5>Own FlashScore is free live score service where you can follow 35 sports in real time including live scores results for all worldwide leagues in football</h5>
            </div>
        </div>
    </div>
</main>
<!--Main Layout-->
<div class="container mt-5 mb-5">

<table class="table table-sm">
  <thead>
    <tr>
      <th scope="col" style="width: 5.66%;">#</th>
      <th scope="col" style="    width: 6.66%;">statue</th>
      <th  class="text-right" scope="col" style="width: 12.66%;">equipe one </th>
      <th class="text-center"  scope="col" style="    width: 7.66%;">Score</th>
         <th class="text-left" scope="col" style="width: 25.66%;">equipe tow </th>
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${matchs}" var="item">
 


    <tr>
      <th scope="row" style="width: 5.66%;">  ${item.idmatch} </th>
      <td style="    width: 6.66%;">${item.statue}</td>
           <td class="text-right" style="width: 12.66%;">${item.nameequipeone}</td>
      <td class="text-center" style="    width: 7.66%;">${item.scoreequipeone}-${item.scoreequipetwo}</td>
   <td class="text-left" style="width: 25.66%;">${item.nameequipetow}</td>
    </tr>
    <tr>
     
    
    </c:forEach>
  </tbody>
</table>

</div>


  <jsp:include page="../footer.jsp" />