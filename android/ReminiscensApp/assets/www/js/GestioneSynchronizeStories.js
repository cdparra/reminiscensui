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

        	url: "http://test.reminiscens.me/lifeapi/lifestory",

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