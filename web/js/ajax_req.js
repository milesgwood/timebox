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

function updatePage() {
    if (request.readyState == 4) {
        if (request.status == 200) {
            var res = request.responseText
        }
        else {
            alert("Error: status code " + request.status)
        }
    }
}

function voteUpRequest(commentId)
{
    if (!request)
        return;
    var url = "/team27-JMU-Share/upvote?commentId=" + commentId;
    request.open("GET", url, true)
    request.send()
}

function voteDownRequest(commentId)
{
    if (!request)
        return;
    var url = "/team27-JMU-Share/downvote?commentId=" + commentId;
    request.open("GET", url, true)
    request.send()
}

function brightenUp(x) {
    x.style.borderBottom = "15px solid #66ff66";
}

function darkenUp(x) {
    x.style.borderBottom = "15px solid #008000";
}

function brightenDown(x) {
    x.style.borderTop = "15px solid #ff0000";
}

function darkenDown(x) {
    x.style.borderTop = "15px solid #990000";
}

function downVote(x) {
    var middle = x.previousElementSibling;
    var inner = middle.innerHTML;
    var score = parseInt(inner, 10) - 1;
    middle.innerHTML = score;
    var cIdArrSplit = middle.id.split('_');
    var commentId = cIdArrSplit[1];
    voteDownRequest(commentId);
}

function upVote(x) {
    var middle = x.nextElementSibling;
    var downArrow = middle.nextElementSibling;
    var inner = middle.innerHTML;
    var score = parseInt(inner, 10) + 1;
    middle.innerHTML = score;
    var cIdArrSplit = middle.id.split('_');
    var commentId = cIdArrSplit[1];
    voteUpRequest(commentId);
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
    globalAddReward(name);
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

function jaxDeleteTask(name)
{
    if (!request)
        return false;
    var url = "/TimeBoxer/jaxDeleteTask?name=" + name;
    request.open("POST", url, true)
    request.send()
    return true;
}

function jaxDeleteReward(name)
{
    if (!request)
        return false;
    var url = "/TimeBoxer/jaxDeleteReward?name=" + name;
    request.open("POST", url, true)
    request.send()
    return true;
}

/**
 * Function updates the view and calls the delete AJAX function
 * @param {type} x
 * @returns {undefined}
 */
function deleteTaskDiv(x){
    var youngSibDiv = x.parentNode;
    var nameDiv = youngSibDiv.previousElementSibling;
    var name = nameDiv.innerHTML;
    jaxDeleteTask(name);
    var parent = x.parentNode.parentNode.parentNode;
    var grandParentList = parent.parentNode;
    grandParentList.removeChild(parent);
    return;
}

function deleteRewardDiv(x){
    var youngSibDiv = x.parentNode;
    var nameDiv = youngSibDiv.previousElementSibling;
    var name = nameDiv.innerHTML;
    jaxDeleteReward(name);
    var parent = x.parentNode.parentNode.parentNode;
    var grandParentList = parent.parentNode;
    grandParentList.removeChild(parent);
    return;
}