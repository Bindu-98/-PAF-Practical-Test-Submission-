$(payument).ready(function() 
{  
	if ($("#alertSuccess").text().trim() == "")  
	{   
		$("#alertSuccess").hide();  
	}  
	$("#alertError").hide(); }); 
 
// SAVE ============================================ 
$(payument).on("click", "#btnSave", function(event) 
{  
	// Clear alerts---------------------  
	$("#alertSuccess").text("");  
	$("#alertSuccess").hide();  
	$("#alertError").text("");  
	$("#alertError").hide(); 
 
	// Form validation-------------------  
	var status = validateItemForm();  
	if (status != true)  
	{   
		$("#alertError").text(status);   
		$("#alertError").show();   
		return;  
	} 
 
	// If valid------------------------  
	var type = ($("#hidItemIDSave").val() == "") ? "POST" : "PUT"; 
	
	$.ajax( 
	{  
		url : "http://localhost:8080/PafProj/paf/Pay/Payment/Insert",  
		type : type,  
		data : $("#formItem").serialize(),  
		dataType : "text",  
		complete : function(response, status)  
		{   
			onItemSaveComplete(response.responseText, status);  
		} 
	}); 
}); 

function onItemSaveComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			$("#alertSuccess").text("Successfully saved.");    
			$("#alertSuccess").show(); 

			$("#divItemsGrid").html(resultSet.data);   
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		} 

	} else if (status == "error")  
	{   
		$("#alertError").text("Error while saving.");   
		$("#alertError").show();  
	} else  
	{   
		$("#alertError").text("Unknown error while saving..");   
		$("#alertError").show();  
	} 

	$("#hidItemIDSave").val("");  
	$("#formItem")[0].reset(); 
} 
 
// UPDATE========================================== 
$(payument).on("click", ".btnUpdate", function(event) 
{     
	$("#hidItemIDSave").val($(this).closest("tr").find('#hidItemIDUpdate').val());     
	$("#payment_id").val($(this).closest("tr").find('td:eq(0)').text());     
	$("#patient_id").val($(this).closest("tr").find('td:eq(1)').text());     
	$("#prescription").val($(this).closest("tr").find('td:eq(2)').text());
	$("#pay_notes").val($(this).closest("tr").find('td:eq(3)').text()); 
}); 







//REMOVE===========================================
$(payument).on("click", ".btnRemove", function(event) 
{  
	$.ajax(  
	{   
		url : "PaymentHadler",   
		type : "DELETE",   
		data : "app_id=" + $(this).data("app_id"),   
		dataType : "text",   
		complete : function(response, status)   
		{    
			onItemDeleteComplete(response.responseText, status);   
		}  
	}); 
}); 

function onItemDeleteComplete(response, status) 
{  
	if (status == "success")  
	{   
		var resultSet = JSON.parse(response); 

		if (resultSet.status.trim() == "success")   
		{    
			$("#alertSuccess").text("Successfully deleted.");    
			$("#alertSuccess").show(); 
		
			$("#divItemsGrid").html(resultSet.data);   
		} else if (resultSet.status.trim() == "error")   
		{    
			$("#alertError").text(resultSet.data);    
			$("#alertError").show();   
		}

	} else if (status == "error")  
	{   
		$("#alertError").text("Error while deleting.");   
		$("#alertError").show();  
	} else  
	{   
		$("#alertError").text("Unknown error while deleting..");   
		$("#alertError").show();  
	}
}

// CLIENT-MODEL========================================================================= 
function validateItemForm() 
{  
	// payment id  
	if ($("#payment_id").val().trim() == "")  
	{   
		return "Insert payment ID.";  
	} 
 
	// patient id  
	if ($("#patient_id").val().trim() == "")  
	{   
		return "Insert patient Id.";  
	} 
	// prescription  
	if ($("#description").val().trim() == "")  
	{   
		return "Insert payment prescription.";  
	}   
	
	// pay notes  
	if ($("#pay_notes").val().trim() == "")  
	{   
		return "Insert payment Notes.";  
	} 


	return true; 
}