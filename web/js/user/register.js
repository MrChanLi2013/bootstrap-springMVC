$(document).ready(function () {
    $("#register-from").find("input[name='username']").focus(function () {
        $("#checklist-username").show();
    }).focusout(function () {
            $("#checklist-username").hide();
        });
    $("#register-from").find("input[name='password']").focus(function () {
        $("#checklist-pwd").show();
    }).focusout(function () {
            $("#checklist-pwd").hide();
        });
});