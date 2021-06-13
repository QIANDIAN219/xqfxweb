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
                    // document.getElementById("formBox").action = "student";showUsers
                    document.getElementById("formBox").action = "showUsers";
                }else {
                    // document.getElementById("formBox").action = "teacher";
                    document.getElementById("formBox").action = "showUsers";
                }
            }
        }
    }

/*     document.getElementById("student").onclick = function(){
        document.getElementById("student").style.background = "white";
        document.getElementById("teacher").style.background = "rgb(233, 231, 231)";
        document.getElementById("teacherBox").style.visibility = "hidden";
        document.getElementById("studentBox").style.visibility = "visible";
        document.getElementById("tusername").value = "";
        document.getElementById("tpassword").value = "";
        k = 0;
    }
    document.getElementById("teacher").onclick = function(){
        document.getElementById("student").style.background = "rgb(233, 231, 231)";
        document.getElementById("teacher").style.background = "white";
        document.getElementById("studentBox").style.visibility = "hidden";
        document.getElementById("teacherBox").style.visibility = "visible";
        document.getElementById("susername").value = "";
        document.getElementById("spassword").value = "";
        k = 1;
    } */
/*     document.getElementById("sloginButton").onclick = function() {
        var value1 = document.getElementById(userType[k][0]).value;
        var value2 = document.getElementById(userType[k][1]).value;
        console.log(document.getElementById(userType[k][0]).id + ": " + value1);
        console.log(document.getElementById(userType[k][1]).id + ": " + value2);
        if(value1.length == 0) {
            react(0);
        }else {
            if(value2.length == 0) {
                react(1);
            } else {
            }
        }
    } */
/*     document.getElementById("tloginButton").onclick = function() {
        var value1 = document.getElementById(userType[k][0]).value;
        var value2 = document.getElementById(userType[k][1]).value;
        console.log(document.getElementById(userType[k][0]).id + ": " + value1);
        console.log(document.getElementById(userType[k][1]).id + ": " + value2);
        if(value1.length == 0) {
            react(0);
        }else {
            if(value2.length == 0) {
                react(1);
            }
        }
    } */
}
var userType = 0;
// var userType = [["susername", "spassword"], ["tusername", "tpassword"]];

function react(i){
    var reacts = document.getElementsByClassName("react");
    reacts[i].style.visibility = "visible";
    setTimeout(function() {
        reacts[i].style.visibility = "hidden";
    }, 3000)
}
