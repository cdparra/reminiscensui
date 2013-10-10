// A word of notice: avoid alerts as much as possible. 
// use console.log instead

function initializePublicMementoConnection() {	
	$( "#postMemento" ).click(function( event ) {
		  event.preventDefault();
		  PostMemento();
	});
	
	$( "#postMemento" ).submit(function( event ) {
		  event.preventDefault();
		  PostMemento();
	});
	
	$( "#month").change(function( event ) {
		updateDaySelect();
	});
}

// JavaScript Document
function PostMemento(){
	console.log("posting the memento");
	var publicMemento = new Object;
	publicMemento.headline = $("#headline").val();
	
	if (publicMemento.headline==null || publicMemento.headline =="") {
		$("#headlineLabel").css( "class","form-group has-error");
		$("#postMementoResult").html("<div class='alert alert-danger'>Il titolo non puo' essere vuoto</div>");
		return false;
	} else {
		$("#headlineLabel").css( "class","form-group has-success");
	}

	publicMemento.contributorId = GetUserId();
	publicMemento.locale = "it_IT";
	publicMemento.text = $("#text").val();
	publicMemento.author = $("#author").val();
	publicMemento.startLocation = new Object;
	
	var country = $("#country").val();
	var region = $("#region").val();
	var city = $("#city").val();
	publicMemento.startLocation.locale = "it_IT";	
	
	if (country != null && country!="") {
		publicMemento.startLocation.country = country;
	}
		
	if (region != null && region!="") {
		publicMemento.startLocation.region = region;
	}
	
	if (city != null && city!="") {
		publicMemento.startLocation.city = city;
	}
	
	publicMemento.startLocation.locale = "it_IT";	
	
	publicMemento.startDate = new Object;
	
	var year = $("#year").val();
	var month = $("#month").val();
	var day = $("#day").val();
	
	if (year != null && year!="") {
		publicMemento.startDate.year = year;
		publicMemento.startDate.decade = year - year%10;
	}
	if (month != null && month !="") {
		publicMemento.startDate.month = month;
	}
	if (day != null && day!="") {
		publicMemento.startDate.day = $("#day").val();
	}
	publicMemento.startDate.locale = "it_IT";
		
	
	publicMemento.resourceUrl = $("#resourceUrl").val();
	publicMemento.source = $("#source").val();
	publicMemento.sourceUrl = $("#sourceUrl").val();
	publicMemento.category = $("#category").val();
	publicMemento.resourceType = $("#resourceType").val();
	
	var contextId = $("#contextId").val();
	if (contextId !=null && contextId != "") {
		PostContextMemento(publicMemento,contextId);
	} else {	
		SaveStoryWithConnection(publicMemento);
	}
		
	return false;
}

// JavaScript Document
function PostContextMemento(publicMemento,contextId){
	console.log("posting the memento to a context with Id "+contextId);
	var contextMemento = new Object;
	contextMemento.publicMemento = publicMemento;
	contextMemento.level = "WORLD";
	if (publicMemento.startLocation.country != null && publicMemento.startLocation.country.toLowerCase()=="italia") {
		if (publicMemento.startLocation.region !=null && publicMemento.startLocation.region!="") {
			if (publicMemento.startLocation.city !=null && publicMemento.startLocation.city!="") {
				contextMemento.level="CITY";
			} else {
				contextMemento.level="REGION";
			}
		} else {
			contextMemento.level="COUNTRY";
		}
	} 

	contextMemento.decade = publicMemento.startDate.decade;
	contextMemento.type = publicMemento.resourceType;
	contextMemento.category= publicMemento.category;	

	var sessionKey = GetSessionKey();
	$.ajax({
        	type: "POST",			
			beforeSend: function (request)
            {
				$("#postMementoResult").html("");
    			$("#postMementoResult").html("<div class='alert alert-warning'>Salvando...</div>");
                request.setRequestHeader("PLAY_SESSION", sessionKey);
            },
			url:GetBaseUrl() + "/lifeapi/context/"+contextId+"/memento",
        	data: JSON.stringify(contextMemento),
        	async: false,
        	success: function (data) {
				$("#postMementoResult").html("<div class='alert alert-success'>Salvato!</div>");
				headline = $("#headline").val("");
				$("#text").val("");
				$("#country").val("");
				$("#region").val("");
				$("#city").val("");
				$("#year").val("");
				$("#month").val("");
				$("#day").val("");
				$("#resourceUrl").val("");
				$("#author").val("");
				$("#category").val("SONG");
				$("#sourceUrl").val("");
				$("#resourceType").val("IMAGE");
        	},
        	error: function (data) {
				$("#postMementoResult").html("<div class='alert alert-danger'>E' successo un errore "
				+data+"</div>");
        	},
        	dataType: "json",
			contentType: "application/json"
        });

	return false;
}

function updateDaySelect() { 
	var month = $("#month").val();
    if (month != 0) {
        var monthInt = parseInt(month);
        var j = 1;
        var selectHTML = "<select id='day' name='day' class='form-control'><option value='" + 0 + "'>" + "giorno" + "</option>";
        switch (monthInt) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                for (var i = 1; i <= 31; i++) {
                   selectHTML += "<option value='" + i + "'>" + i + "</option>";
                   j++;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                for (var i = 1; i <= 30; i++) {
                	selectHTML += "<option value='" + i + "'>" + i + "</option>";
                    j++;
                }
                break;
            case 2:
                for (var i = 1; i <= 28; i++) {
                	selectHTML += "<option value='" + i + "'>" + i + "</option>";
                    j++;
                }
                break;
        }

        selectHTML += "</select>";
        $("#day").html(selectHTML);
        $('#day').fadeIn('slow');
    }
}