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

/**
 * Returns true if it is sucessful. False if it fails.
 * The success stops the form from submitting.
 * @returns {Boolean}
 */
function jaxAddReward()
{
    var newRewardDiv = document.getElementById("newRewardName");
    var name = newRewardDiv.value;
    if (!request)
        return false;
    var url = "/TimeBoxer/jaxAddReward?name=" + name;
    request.open("POST", url, true)
    request.send()
    newRewardDiv.value = '';
    return true;
}

/**
 * Returns true if it is sucessful. False if it fails.
 * The success stops the form from submitting.
 * @returns {Boolean}
 */
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
    globalAddTask(name);
    return true;
}