// JavaScript Document
var persona = new Object;
var storage = $.localStorage;
var datepicker; 

function SaveNameAndRedirect()
{
	//alert($("#firstname").val());
	persona.firstname = $("#firstname").val();
	persona.lastname = $("#lastname").val();
	storage.set('persona',persona);
	location.href = "Datanascita.html";
}

function CostruisciData(datepicker)
{
	var elementiData = datepicker.value();
	var date = (elementiData.getYear() + 1900);
	date += "-" + (elementiData.getMonth()+1);
	date += "-" + elementiData.getDate();
	//birthdate += " " + elementiData.getHours() + elementiData.getMinutes() + elementiData.getSeconds()  ;
	date += " " + "00:00:00";
	return date;	
}

function SaveBirthdateAndRedirect()
{
	persona = storage.get('persona');
	datepicker = $("#datepicker").data("kendoDatePicker"); 
	
	persona.birthdate = CostruisciData(datepicker);
	
	//alert(birthdate);
	storage.set('persona',persona);
	location.href = "Luogonascita.html";
}

function SavePlaceAndRedirect()
{
	persona = storage.get('persona');
	
	//persona.birthplaceId = $("#dove").val();
	var i = 0;
	while($("#dove").val()!=cities[i])
	{
		i++;
	}
	persona.birthplaceId = idCities[i];
	//alert(persona.birthplaceId);
	
	storage.set('persona',persona);
	location.href = "registraMailPass.html";
	
}

function SavePersonAndRedirect()
{
	persona = storage.get('persona');
	
	var dataSignup = new Object;
	
	dataSignup.email = $("#mail").val();
	dataSignup.password = $("#mail").val();
	dataSignup.repeatPassword = $("#mail").val();
	dataSignup.name = persona.firstname + persona.lastname;
	dataSignup.person = persona;
	//alert(JSON.stringify(dataSignup));
    	$.ajax({
        	type: "POST",

        	url: "http://test.reminiscens.me/lifeapi/user/signup",

        	data: JSON.stringify(dataSignup),
			
			//data:{"email":"reminiscensapp+4@gmail.com","password":"testing-password"},

        	async: false,

        	success: function (data) {
					//alert("yeeee");
					SetSessionKey(data.sessionKey);
					SetPersonId(data.person.personId);
					SetBirthDate(data.birthdateAsString);	
					//alert(data.sessionKey);
					location.href = "main.html";
					//alert(data);

        	},
        	error: function (data) {
        	    alert("error");

        	},
        	dataType: "json",
			
			contentType: "application/json"

        });
}