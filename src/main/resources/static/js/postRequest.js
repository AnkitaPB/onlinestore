$( document ).ready(function() {
	
	// SUBMIT FORM
    $("#productForm").submit(function(event) {
		// Prevent the form from submitting via the browser.
		event.preventDefault();
		ajaxPost();
	});
    
    
    function ajaxPost(){
    	
    	// PREPARE FORM DATA
    	var formData = {
    		id : $("#id").val(),
    		name :  $("#name").val()
    	}
    	
    	// DO POST
    	$.ajax({
			type : "POST",
			contentType : "application/json",
			url : window.location + "/add",
			data : JSON.stringify(formData),
			success : function(result) {
				if(result.status == "Done"){
					$("#postResultDiv").html("<p style='background-color:#7FA7B0; color:white; padding:20px 20px 20px 20px'>" + 
												"Post Successfully! <br>" +
												"---> product Info: Id = " + 
												result.data.id + " ,Product Name = " + result.data.name + "</p>");
				}else{
					$("#postResultDiv").html("<strong>Error</strong>");
				}
				console.log(result);
			},
			error : function(e) {
				alert("Error!")
				console.log("ERROR: ", e);
			}
		});
    	
    	// Reset FormData after Posting
    	resetData();

    }
    
    function resetData(){
    	$("#id").val("");
    	$("#name").val("");
    }
})