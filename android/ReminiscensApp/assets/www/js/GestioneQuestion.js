// JavaScript Document


/*var personalQuestion = [];
var decadeQuestione = [];*/

function downloadQuestion(birthYear,decade)
{
	
	$.ajax({
            type:"GET",
            url: "http://test.reminiscens.me/lifeapi/question/" + birthYear + "/" + decade + "/",
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
				
				document.getElementById("FirstDecadeQuestionEmpty").innerHTML =  questions[3].translations[0].question_text;
    document.getElementById("SecondDecadeQuestionEmpty").innerHTML =  questions[4].translations[0].question_text;
    document.getElementById("FirstPersonalQuestionEmpty").innerHTML =  questions[0].translations[0].question_text;
    document.getElementById("SecondPersonalQuestionEmpty").innerHTML =  questions[1].translations[0].question_text;
	
	document.getElementById("DecadeQuestionNotEmpty").innerHTML = questions[5].translations[0].question_text;
    document.getElementById("PersonalQuestionNotEmpty").innerHTML = questions[2].translations[0].question_text;
				
				
            }
        	
   		});
}