// A word of notice: avoid alerts as much as possible. 
// use console.log instead

function initializePublicMementoConnection() {	
    	
	$("#salvaPublic").submit(function (event) {
		  event.preventDefault();
		  PostMemento();
	});
	
	$( "#monthPublic").change(function( event ) {
		updatedayPublicSelect();
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
	
	var countryPublic = $("#countryPublic").val();
	var regionPublic = $("#regionPublic").val();
	var cityPublic = $("#cityPublic").val();
	publicMemento.startLocation.locale = "it_IT";	
	
	if (countryPublic != null && countryPublic!="") {
		publicMemento.startLocation.countryPublic = countryPublic;
	}
		
	if (regionPublic != null && regionPublic!="") {
		publicMemento.startLocation.regionPublic = regionPublic;
	}
	
	if (cityPublic != null && cityPublic!="") {
		publicMemento.startLocation.cityPublic = cityPublic;
	}
	
	publicMemento.startLocation.locale = "it_IT";	
	
	publicMemento.startDate = new Object;
	
	var yearPublic = $("#yearPublic").val();
	var monthPublic = $("#monthPublic").val();
	var dayPublic = $("#dayPublic").val();
	
	if (yearPublic != null && yearPublic!="") {
		publicMemento.startDate.yearPublic = yearPublic;
		publicMemento.startDate.decade = yearPublic - yearPublic%10;
	}
	if (monthPublic != null && monthPublic !="") {
		publicMemento.startDate.monthPublic = monthPublic;
	}
	if (dayPublic != null && dayPublic!="") {
		publicMemento.startDate.dayPublic = $("#dayPublic").val();
	}
	publicMemento.startDate.locale = "it_IT";
		
	
	publicMemento.resourceUrl = $("#resourceUrl").val();
	publicMemento.source = $("#source").val();
	publicMemento.sourceUrl = $("#sourceUrl").val();
	publicMemento.category = $("#category").val();
	publicMemento.resourceType = $("#resourceType").val();
	
    //var contextId = $("#contextId").val();
	var contextId = GetContextId();
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
	if (publicMemento.startLocation.countryPublic != null && publicMemento.startLocation.countryPublic.toLowerCase()=="italia") {
		if (publicMemento.startLocation.regionPublic !=null && publicMemento.startLocation.regionPublic!="") {
			if (publicMemento.startLocation.cityPublic !=null && publicMemento.startLocation.cityPublic!="") {
				contextMemento.level="cityPublic";
			} else {
				contextMemento.level="regionPublic";
			}
		} else {
			contextMemento.level="countryPublic";
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
        	    alert("success");
				$("#postMementoResult").html("<div class='alert alert-success'>Salvato!</div>");
				headline = $("#headline").val("");
				$("#text").val("");
				$("#countryPublic").val("");
				$("#regionPublic").val("");
				$("#cityPublic").val("");
				$("#yearPublic").val("");
				$("#monthPublic").val("");
				$("#dayPublic").val("");
				$("#resourceUrl").val("");
				$("#author").val("");
				$("#category").val("SONG");
				$("#sourceUrl").val("");
				$("#resourceType").val("IMAGE");
        	},
        	error: function (data) {
        	    alert("error");
				$("#postMementoResult").html("<div class='alert alert-danger'>E' successo un errore "
				+data+"</div>");
        	},
        	dataType: "json",
			contentType: "application/json"
        });

	return false;
}

function updateDaySelect() {
    //alert("1");
	var monthPublic = $("#monthPublic").val();
    if (monthPublic != 0) {
        var monthPublicInt = parseInt(monthPublic);
        var j = 1;
        var selectHTML = "<select id='dayPublic' name='dayPublic' class='form-control'><option value='" + 0 + "'>" + "giorno" + "</option>";
        switch (monthPublicInt) {
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
        $("#dayPublic").html(selectHTML);
        $('#dayPublic').fadeIn('slow');
    }
}

function updateContentIframe()
{
    document.getElementById("iframeAnteprima").src = document.getElementById("resourceUrl").value;
}