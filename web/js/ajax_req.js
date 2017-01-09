window.onload = function () {
    try {  // for Firefox, IE7, Opera
        request = new XMLHttpRequest()
    }
    catch (exc) {
        try {  // for IE6
            request = new ActiveXObject('MSXML2.XMLHTTP.5.0')
        }
        catch (e) {
            request = false
        }
    }
    if (!request) {
        alert("Error initializing XMLHttpRequest!");
    }
}

function jaxAddTask()
{
    var newTaskDiv = document.getElementById("newTaskName");
    var name = newTaskDiv.value;
    if (!request)
        return false;
    var url = "/TimeBoxer/jaxAddTask?name=" + name;
    request.open("POST", url, true)
    request.send()
    newTaskDiv.value = '';
    return true;
}