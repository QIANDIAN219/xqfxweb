window.onload = function(){
    document.getElementById("student").onclick = function(){
        document.getElementById("student").style.background = "white";
        document.getElementById("teacher").style.background = "rgb(233, 231, 231)";
        document.getElementById("username").value = "";
        document.getElementById("password").value = "";
        document.getElementById("username").placeholder = "学号";
        userType = 0;
    }

    document.getElementById("teacher").onclick = function(){
        document.getElementById("student").style.background = "rgb(233, 231, 231)";
        document.getElementById("teacher").style.background = "white";
        document.getElementById("username").value = "";
        document.getElementById("password").value = "";
        document.getElementById("username").placeholder = "工号";
        userType = 1;
    }
    document.getElementById("loginButton").onclick = function() {
        var value1 = document.getElementById("username").value;
        var value2 = document.getElementById("password").value;
        console.log("username: " + value1);
        console.log("password: " + value2);
        if(value1.length == 0) {
            react(0);
        }else {
            if(value2.length == 0) {
                react(1);
            }else {
                if(userType == 0) {
                    document.getElementById("formBox").action = "student";
                }else {
                    document.getElementById("formBox").action = "teacher";
                }
            }
        }
    }

}
var userType = 0;

function react(i){
    var reacts = document.getElementsByClassName("react");
    reacts[i].style.visibility = "visible";
    setTimeout(function() {
        reacts[i].style.visibility = "hidden";
    }, 3000)
}
