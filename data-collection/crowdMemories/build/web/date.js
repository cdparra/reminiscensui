$(document).ready(function(){
              
    $("#datepicker").datepicker({
        changeMonth: true,
        changeYear: true,
        yearRange: "-150: +0"
    });
              
    $("#yes").click(function(){
        $("#eventdiv").slideUp();
        $("#almostdiv").slideUp();
        $("#nodiv").slideUp();
        $("#yesdiv").slideDown();
    });
                
    $("#almost").click(function(){
        $("#yesdiv").slideUp();
        $("#nodiv").slideUp();
        $("#eventdiv").slideUp();
        $("#almostdiv").slideDown();
     });
                
    $("#event").click(function(){
        $("#almostdiv").slideUp();
        $("#nodiv").slideUp();
        $("#yesdiv").slideUp();
        $("#eventdiv").slideDown();
    });
                
    $("#no").click(function(){
        $("#yesdiv").slideUp();
        $("#almostdiv").slideUp();
        $("#eventdiv").slideUp();
        $("#nodiv").slideDown();
    })
                
})

