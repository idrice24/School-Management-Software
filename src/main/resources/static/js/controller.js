var i;
var arr = [0, 1, 2, 3, 4, 5, 6, 7, 8, 9];

function send() {
    var NULL = "";
    var name = document.getElementById("fullname").value;
    var user = document.getElementById("username").value;
    var email = document.getElementById("email").value;
    var phone = document.getElementById("phone").value;
    var address = document.getElementById("address").value;
    var pass = document.getElementById("password").value;
    var conf = document.getElementById("confirm").value;
    if (conf != pass) {
        window.alert("Password Must be the same!!");
    }
    for (i = 1; i <= name.length; i++) {
        if (name.charAt(i) == arr || name.length <= 8) {
            window.alert("full name must not contian digit and should be greater than 8 character");
        }
    }
    for (i = 0; i <= user.length; i++) {
        if (user == NULL) {
            window.alert("user name is require!!");
        }
        if (user.charAt(i) == arr || user.length <= 4) {
            window.alert("Username must be greater than 4 character!!");
        }
    }
    for (i = 1; i <= phone.length; i++) {
        if (phone.length < 10 || phone.length >= 14) {
            window.alert("phone number must be greater than 8 and lest 14 numbers!!");
        }
    }
    var num = phone.split(",");

    for (i = 0; i <= num.length; i++) {
        if (num[i] != arr) {
            window.alert("phone number must have only numbers!!");
        }
    }
    window.alert(num[i]);

    var email_id = document.myForm.email.value;
    atpos = email_id.indexOf("@");
    dotpos = email_id.lastIndexOf(".");
    if (atpos < 1 || (dotpos - atpos < 2)) {
        alert("please enter a valide email ") + document.myForm.email.focus();
        return false;
    } else {
        return (true);
    }

}