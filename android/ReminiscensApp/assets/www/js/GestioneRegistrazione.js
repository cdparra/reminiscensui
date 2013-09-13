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
	while(i < cities.length)
	{
	    if ($("#dove").val() != cities[i])
	        i++;
	    else {
	        persona.birthplaceId = idCities[i];
	        break;
	    }
	}

	if (persona.birthplaceId == null) {
	    alert("Devi inserire una città presente nella lista!(prova almeno a inserire 3 lettere)");
	}
	else {
	    storage.set('persona', persona);
	    location.href = "registraMailPass.html";
	}
	
	//alert(persona.birthplaceId);	
	
}

function SavePersonAndRedirect()
{
	persona = storage.get('persona');
	
	var dataSignup = new Object;
	
	dataSignup.email = $("#mail").val();
	dataSignup.password = $("#pass").val();
	dataSignup.repeatPassword = $("#passRepeat").val();
	dataSignup.name = persona.firstname + persona.lastname;
	dataSignup.person = persona;
	//alert(JSON.stringify(dataSignup));
    	$.ajax({
        	type: "POST",

        	url: GetBaseUrl() + "/lifeapi/user/signup",
        	//url: "http://test.reminiscens.me/lifeapi/user/signup",

        	data: JSON.stringify(dataSignup),
			
			//data:{"email":"reminiscensapp+4@gmail.com","password":"testing-password"},

        	async: false,

        	success: function (data) {
					//alert("yeeee");
					SetSessionKey(data.sessionKey);
					SetPersonId(data.person.personId);
					SetPersonBirthDate(data.birthdateAsString);
					//alert(data.sessionKey);
					location.href = "main.html";
					//alert(data);

        	},
        	error: function (data) {
        	    alert("errore nella registrazione.\nControlla di aver inserito un indirizzo mail corretto. \nControlla di aver inserito una password lunga almeno 5 caratteri. \nControlla di non esserti già registrato con questa mail.");
        	    /*alert(data.sessionKey);
        	    if (data.indexOf("Minimumlengthis") != -1)
        	        alert("Inserire una password con almeno 5 caratteri");
        	    else if (datas.indexOf("Thisuseralreadyexists") != -1)
        	        alert("Questo utente esiste già!");*/
        	},
        	dataType: "json",
			
			contentType: "application/json"

        });
}