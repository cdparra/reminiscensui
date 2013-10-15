// JavaScript Document


/*var personalQuestion = [];
var decadeQuestione = [];*/

var vettIdQuestions = [];
var idQuestion = null;

function newQuestion()
{
	downloadQuestion(birthYear,decade);
}

function downloadQuestion(birthYear,decade)
{
	
	$.ajax({
	        type: "GET",
	        url: GetBaseUrl() + "/lifeapi/question/" + birthYear + "/" + decade + "/",
            //url: "http://test.reminiscens.me/lifeapi/question/" + birthYear + "/" + decade + "/",
            processData: false,
            dataType: "json",
        	error: function (data) {

        	    alert("error");

        	},
			success: function(questions) 
			{
				//alert("a");
				//alert(questions[0].translations[0].question_text);
				/*personalQuestion.push(questions[0].translations[0].question_text);
				personalQuestion.push(questions[1].translations[0].question_text);
				personalQuestion.push(questions[2].translations[0].question_text);
				decadeQuestion.push(questions[3].translations[0].question_text);
				decadeQuestion.push(questions[4].translations[0].question_text);
				decadeQuestion.push(questions[5].translations[0].question_text);*/
			    IdQuestions = [];
				
			    document.getElementById("FirstDecadeQuestionEmpty").innerHTML = questions[3].translations[0].question_text;
			    vettIdQuestions.push(questions[3].questionId);
			    document.getElementById("SecondDecadeQuestionEmpty").innerHTML = questions[4].translations[0].question_text;
			    vettIdQuestions.push(questions[4].questionId);
			    document.getElementById("FirstPersonalQuestionEmpty").innerHTML = questions[0].translations[0].question_text;
			    vettIdQuestions.push(questions[0].questionId);
			    document.getElementById("SecondPersonalQuestionEmpty").innerHTML = questions[1].translations[0].question_text;
			    vettIdQuestions.push(questions[1].questionId);
	
			    document.getElementById("DecadeQuestionNotEmpty").innerHTML = questions[5].translations[0].question_text;
			    vettIdQuestions.push(questions[5].questionId);
			    document.getElementById("PersonalQuestionNotEmpty").innerHTML = questions[2].translations[0].question_text;
			    vettIdQuestions.push(questions[2].questionId);
				
				
            }
        	
   		});
}