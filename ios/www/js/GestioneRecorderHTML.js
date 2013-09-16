// JavaScript Document
function timecode(ms) {
        var hms = {
          h: Math.floor(ms/(60*60*1000)),
          m: Math.floor((ms/60000) % 60),
          s: Math.floor((ms/1000) % 60)
        };
        var tc = []; // Timecode array to be joined with '.'

        if (hms.h > 0) {
          tc.push(hms.h);
        }

        tc.push((hms.m < 10 && hms.h > 0 ? "0" + hms.m : hms.m));
        tc.push((hms.s < 10  ? "0" + hms.s : hms.s));

        return tc.join(':');
      }
    
    
      $(document).ready(function() {
	  Recorder.initialize({
        swfSrc: "js/recorder.swf"
      });
	  });

      function record(){
		  document.getElementById("play").style.visibility="hidden";
		  document.getElementById("stop").style.visibility="hidden";
		  $('#overlay').fadeOut('fast');
            $('#box').hide();
        Recorder.record({
          start: function(){
            //alert("recording starts now. press stop when youre done. and then play or upload if you want.");
          },
          progress: function(milliseconds){
			ApriOverlay();
			document.getElementById("record").onclick = function() {stop()};
			document.getElementById("record").src = "button/buttonStopRecording.jpg";
            document.getElementById("time").innerHTML = timecode(milliseconds);
          }
        });
		
      }
      
      function play(){
		//Recorder.stop();
        Recorder.play({
          progress: function(milliseconds){
            document.getElementById("time").innerHTML = timecode(milliseconds);
          }
        });				
      }
      	  
      function stop(){
		document.getElementById("record").onclick = function() {record()};
		document.getElementById("record").src = "button/buttonMicrofono.jpg";
        document.getElementById("play").style.visibility="visible";
		document.getElementById("stop").style.visibility="visible";
		document.getElementById("time").innerHTML = "0:00";
		Recorder.stop();
      }
      
      function upload(){
		  //alert("ciao");
        Recorder.upload({
          url:        "http://localhost/sound",
          audioParam: "track[asset_data]",
          success: function(){
            alert("your file was uploaded!");
          }
        });
      }