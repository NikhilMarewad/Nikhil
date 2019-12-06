// Include truYum form validation functions here
function validateForm() {
	 var x = document.forms["myForm"]["name1"].value;
	 var y = document.forms["myForm"]["number1"].value;
	 var z = document.forms["myForm"]["dates"].value;
		 
		  if (x == "") {
			  alert("Name must be filled out");
			 
		  } 
		  else if (y == "") {
			  alert("Number must be filled out");
			 
		  } 
		  
		  else if (z == "") {
			  alert("Date must be filled out");
			  return false;
		  } else {
			  return true;
		  }
		  
		  if (x.length>2 || x.length<60){
			 alert("Text is not upto the length 2to60 Characters");
			 return false;
		  } else {
			 return true;
		  }
		  if (/[^0-9/]/.test(y)){
			   alert("number is must");
		       return false;
		  } else {
			  return true;
		  }
		   if (/[^A-Za-z]/.test(x)){
			   alert("letter is must");
		       return false;
		  } else {
			  return true;
		  }
}