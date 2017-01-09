<%-- 
    Document   : scripts
    Created on : Jan 8, 2017, 11:00:41 PM
    Author     : vice
--%>

<!-- Bootstrap core JavaScript and other default files included in Dashboard template
    ================================================== -->
<!-- Placed at the end of the document so the pages load faster -->
<script src="./js/jquery-3.1.1.slim.min.js" integrity="sha384-A7FZj7v+d/sdmMqp/nOQwliLvUsJfDHW+k9Omg/a/EheAdgtzNs3hpfag6Ed950n" crossorigin="anonymous"></script>
<!-- I don't think the following script is able to do anything as the assets folder isn't in the template example -->
<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
<script src="./js/tether.min.js" integrity="sha384-DztdAPBWPRXSA/3eYEEUWrWCy7G5KFbe8fFjk5JAIxUYHKkDx6Qin1DkWx51bBrb" crossorigin="anonymous"></script>
<script src="./js/bootstrap.min.js"></script>
<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="./js/ie10-viewport-bug-workaround.js"></script>

<script aria-hidden="true" type="application/x-lastpass" id="hiddenlpsubmitdiv" style="display: none;"></script>
<script>try {
        (function () {
            for (var lastpass_iter = 0; lastpass_iter < document.forms.length; lastpass_iter++) {
                var lastpass_f = document.forms[lastpass_iter];
                if (typeof (lastpass_f.lpsubmitorig2) == "undefined") {
                    lastpass_f.lpsubmitorig2 = lastpass_f.submit;
                    if (typeof (lastpass_f.lpsubmitorig2) == 'object') {
                        continue;
                    }
                    lastpass_f.submit = function () {
                        var form = this;
                        var customEvent = document.createEvent("Event");
                        customEvent.initEvent("lpCustomEvent", true, true);
                        var d = document.getElementById("hiddenlpsubmitdiv");
                        if (d) {
                            for (var i = 0; i < document.forms.length; i++) {
                                if (document.forms[i] == form) {
                                    if (typeof (d.innerText) != 'undefined') {
                                        d.innerText = i.toString();
                                    } else {
                                        d.textContent = i.toString();
                                    }
                                }
                            }
                            d.dispatchEvent(customEvent);
                        }
                        form.lpsubmitorig2();
                    }
                }
            }
        })()
    } catch (e) {
    }
</script>

<!-- Loads the clock with the default time -->
<script src="./js/clock.js"></script>
