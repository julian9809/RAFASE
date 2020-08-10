/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
function validatePassword() {
    var password, confirme_password;
    password = document.getElementById("password");
    confirme_password = document.getElementById("confirme_password");
    if (password === confirme_password) {
        return true;
    } else {
        alertify.alert("Error", "Las contraseñas no coinciden", function () {
            alertify.message('Las contraseñas no coinciden');
        });
        return false;
    }
}
