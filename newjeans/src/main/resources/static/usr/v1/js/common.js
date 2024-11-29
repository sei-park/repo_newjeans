// 로그아웃
document.getElementById("logoutBtn").onclick = function () {
   	   $.ajax({  
  			async: true   
  			,cache: false
  			,type: "post"
  			/* ,dataType:"json" */
  			,url: "/v1/infra/usrmember/usrSignoutProc"
  			/* ,data : $("#formLogin").serialize() */
  			,success: function(response) {
  				if(response.rt == "success") {
  					location.href="/v1/infra/usrmember/usrIndex";  
  				} else {        
  					// by pass  
  				}
  			  }      
            }); // ajax end
            
 } // logoutBtn end