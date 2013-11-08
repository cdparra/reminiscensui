// JavaScript Document


/*var personalQuestion = [];
var decadeQuestione = [];*/

var vettIdQuestions = [];
var vettQuestion = [];
var idQuestion;
var cameToQuestion = false;

function newQuestion(clicked_id)
{
    if (vettQuestion.length > 0) {
        document.getElementById(clicked_id).innerHTML = vettQuestion.pop();
        idQuestion = vettIdQuestions.pop();
    }
    else {
        downloadQuestion(birthYear, decade, clicked_id);
    }
}

function downloadQuestion(birthYear, decade, clicked_id)
{	
	$.ajax({
	        type: "GET",
			beforeSend: function (request) {
                request.setRequestHeader("PLAY_SESSION", sessionKey);
            },
	        url: GetBaseUrl() + "/lifeapi/question/" + birthYear + "/" + decade + "/",
            processData: false,
            dataType: "json",
        	error: function (data) {

        	    alert("error");

        	},
			success: function(questions) 
			{
				document.getElementById(clicked_id).innerHTML = questions[0].translations[0].question_text;
			    idQuestion = questions[0].questionId;
			    for(var i = 1; i< 6; i++)
			    {
			        vettQuestion.push(questions[i].translations[0].question_text);
			        vettIdQuestions.push(questions[i].questionId);
			    }
            }
   		});
}