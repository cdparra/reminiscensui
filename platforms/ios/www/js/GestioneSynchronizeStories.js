// JavaScript Document

function SaveStoryWithConnection(newStory)
{
	//alert("ciao");
	$.ajax({
        	type: "POST",
			
			beforeSend: function (request)
            {
                request.setRequestHeader("PLAY_SESSION", sessionKey);
            },

			url:GetBaseUrl() + "/lifeapi/lifestory",
        	//url: "http://test.reminiscens.me/lifeapi/lifestory",

        	data: JSON.stringify(newStory),

        	async: false,

        	success: function (data) {
					//alert("yeeee");
					//alert(data.lifeStoryId);

        	},
        	error: function (data) {
        	    alert("error");

        	},
        	dataType: "json",
			
			contentType: "application/json"

        });
}

function ModifyStoryWithConnection(newStory, idStoryModify)
{
	//alert("ciao");
	$.ajax({
        	type: "PUT",
			
			beforeSend: function (request)
            {
                request.setRequestHeader("PLAY_SESSION", sessionKey);
            },

			url: GetBaseUrl() + "/lifeapi/lifestory/" + idStoryModify,
        	//url: "http://test.reminiscens.me/lifeapi/lifestory/" + idStoryModify,

        	data: JSON.stringify(newStory),

//        	async: false,

        	success: function (data) {
					//alert("yeeee");
					//alert(data.lifeStoryId);

        	},
        	error: function (data) {
        	    alert("error");

        	},
        	dataType: "json",
			
			contentType: "application/json"

        });
}