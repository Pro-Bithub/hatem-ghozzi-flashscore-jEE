  <jsp:include page="../head.jsp" />
<style>
.f:hover{
color: #fab900;}</style>
</head>

<body>
<script type="text/javascript">
function test(id,username,favorilist){
	  
	  
	 

	     $.ajax({
	     url: "saveIt",
	     type: "get",
	     url: 'http://localhost:8080/crud/saveIt',
	     data:  {idmatch: id, username: username,favorilist:favorilist},
	     cache: false,
	     success: function(data) {
	    	
	    	 if(favorilist=='unfavori'){
	    		 document.getElementById(id).remove();
	    		
		  
	    	 }else if(favorilist=='favori'){
	    		 document.getElementById("star"+id).className = "fas fa-star";
	    		 document.getElementById("star"+id).style.color = "#fab900";
	    		
	    	  	 console.log("success unfavori"); 
	    	 }
	    	    
	    	 
	     }
	     });
	     
}


</script>
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
<!-- Search form -->
<div class="md-form mt-0">
<script>
    (function() {
        var search = document.getElementById('search');
        if(search){
        	 
        	  search.addEventListener('keypress', function(event) {
                  if (event.keyCode == 13) {
                      event.preventDefault();
                   console.log(search.value);
                  }
              });
        	}
      
    }());
</script>
<form role="form" method="get" action="${pageContext.request.contextPath}/match">
 <input class="form-control" type="text" name="search" placeholder="Search" aria-label="Search">

</form>

</div>
<ul class="nav nav-tabs" id="myTab" role="tablist">
  <li class="nav-item">
    <a class="nav-link active"   id="home-tab" data-toggle="tab" href="#home" role="tab" aria-controls="home" aria-selected="true">Games</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" id="profile-tab" style="    color: red;" data-toggle="tab" href="#profile" role="tab" aria-controls="profile" aria-selected="false">My favorites </a>
  </li>

</ul>
<div class="tab-content" id="myTabContent">
  <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
    <input type="hidden" name="login" id="login"  value="${login}" size="30" />
<table class="table table-sm">
  <thead>
    <tr>
      <th scope="col" style="width: 5.66%;">#</th>
      <th scope="col" style="    width: 6.66%;">statue</th>
      <th  class="text-right" scope="col" style="width: 12.66%;">equipe one </th>
      <th class="text-center"  scope="col" style="    width: 7.66%;">Score</th>
         <th class="text-left" scope="col" style="width: 15%;">equipe tow </th>
            <th class="text-center" scope="col" style="width: 5%;">favorites Games </th>
         
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${matchs}" var="item">
 


    <tr>
      <th scope="row" style="width: 5.66%;">  ${item.idmatch} </th>
      <td style="    width: 6.66%;">${item.statue}</td>
           <td class="text-right" style="width: 12.66%;">${item.nameequipeone}</td>
      <td class="text-center" style="    width: 7.66%;">${item.scoreequipeone}-${item.scoreequipetwo}</td>
   <td class="text-left" style="width: 15%;">${item.nameequipetow}</td>
   <td>
    <form name="sub" action="saveIt" id="sub">
     <label for="id-of-input" class="custom-checkbox" id="ibutton" onclick="test( ${item.idmatch},'${login}','favori')">
 
  
  <i class="far fa-star f"  id="star${item.idmatch}" style="    color: gray;"></i>
  <span class=" f">Favorite</span>
</label>

    
     <input type="hidden" name="country" id="country"  value="${item.idmatch}" size="30" />
    
   </form>
   


</td>
    </tr>
    
  
     
    
    </c:forEach>
  </tbody>
</table>
</div>
  <div class="tab-pane fade" id="profile" role="tabpanel" aria-labelledby="profile-tab">


<table class="table table-sm">
  <thead>
    <tr>
      <th scope="col" style="width: 5.66%;">#</th>
      <th scope="col" style="    width: 6.66%;">statue</th>
      <th  class="text-right" scope="col" style="width: 12.66%;">equipe one </th>
      <th class="text-center"  scope="col" style="    width: 7.66%;">Score</th>
         <th class="text-left" scope="col" style="width: 15%;">equipe tow </th>
                 <th class="text-center" scope="col" style="width: 5%;">favorites Games </th>
           
         
    </tr>
  </thead>
  <tbody>
  
  <c:forEach items="${favoris}" var="item">
 


    <tr id="${item.idmatch}">
      <th scope="row" style="width: 5.66%;">  ${item.idmatch} </th>
      <td style="    width: 6.66%;">${item.statue}</td>
           <td class="text-right" style="width: 12.66%;">${item.nameequipeone}</td>
      <td class="text-center" style="    width: 7.66%;">${item.scoreequipeone}-${item.scoreequipetwo}</td>
   <td class="text-left" style="width: 15%;">${item.nameequipetow}</td>


    
     <td >
    <form name="sub" action="saveIt" id="sub">
     <label for="id-of-input" class="custom-checkbox" id="ibutton" onclick="test( ${item.idmatch},'${login}','unfavori')">
 
  
  <i class="fas fa-star"  style="    color: #fab900;"></i>
  <span class=" f">UnFavorite</span>
</label>

    
     <input type="hidden" name="country" id="country"  value="${item.idmatch}" size="30" />
    
   </form>
   


</td>
      </tr>
    
    </c:forEach>
  </tbody>
</table>



</div>

</div>



</div>


  <jsp:include page="../footer.jsp" />