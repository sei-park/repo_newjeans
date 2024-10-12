//alert("확인!!!!");

// model 
const exampleModal = document.getElementById('exampleModal')
if (exampleModal) {
	exampleModal.addEventListener('show.bs.modal', event => {

		const button = event.relatedTarget
		const recipient = button.getAttribute('data-bs-whatever')

		const modalTitle = exampleModal.querySelector('.modal-title')
		const modalBodyInput = exampleModal.querySelector('.modal-body input')

		modalTitle.textContent = `New message to ${recipient}`
		modalBodyInput.value = recipient
	})  
}

// 로그아웃
document.getElementById("logoutBtn").onclick = function () {
   	alert("로그아웃되었습니다");
   	   $.ajax({  
  			async: true   
  			,cache: false
  			,type: "post"
  			/* ,dataType:"json" */
  			,url: "/xdm/v1/infra/hotelmember/signoutXdmProc"
  			/* ,data : $("#formLogin").serialize() */
  			,success: function(response) {
  				if(response.rt == "success") {
  					location.href="/xdm/v1/infra/hotelmember/signin";  
  				} else {        
  					// by pass
  				}
  			  }      
            }); // ajax end
 } // logoutBtn end
       

// 30분 후 강제로 로그아웃
//setTimeout(function() {
    //alert('세션이 만료되었습니다. 다시 로그인해주세요.');
    //window.location.href = '/xdm/v1/infra/hotelmember/signoutXdmProc'; // 로그아웃 처리하는 페이지로 이동
//}, 60000); // 30분(30 * 60 * 1000ms) = 1800000




   
         
   
   
   
   
   
   
   
   
   
   
   
   
   



