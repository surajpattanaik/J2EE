/**
 * 
 */
function validate(frm){
	//empty the form validation error messages if any
	document.getElementById("nameErr").innerHTML="";
	document.getElementById("ageErr").innerHTML="";
	
	//read from data
	let name=frm.pname.value;
	let age=frm.page.value;
	let flag=true;
	//client side form validation logic
	if(name==""){
		document.getElementById("nameErr").innerHTML="name is required boss";
		frm.pname.focus();//text box gains the focus
		flag=false;
		
	} else if(age==""){
		document.getElementById("ageErr").innerHTML="age is also required boss";
		frm.page.focus();
		flag=false;
	}
	if(isNaN(age)){
		document.getElementById("ageErr").innerHTML="age must be numeric boss";
		frm.page.focus();
		flag=false;
	}
	else if(age<1 || age>125){
		document.getElementById("ageErr").innerHTML="age must be in between 1 to 125 boss";
		frm.page.focus();
		flag=false;
	}
	frm.vflag.value="yes";
	return flag; // if true, no form validations,false for form validation errors
}//function