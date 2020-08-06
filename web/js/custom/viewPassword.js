/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {
    $('#show_password').click(function () {
        if (document.getElementById("password").type === "password") {
            $('#password').attr('type', 'text');
            $('#show_password').removeClass('fa-eye-slash').addClass('fa-eye');
        } else {
            $('#password').attr('type', 'password');
            $('#show_password').removeClass('fa-eye').addClass('fa-eye-slash');
        }
    });
    $('#show_confirme_password').click(function () {
        if (document.getElementById("confirme_password").type === "password") {
            $('#confirme_password').attr('type', 'text');
            $('#show_confirme_password').removeClass('fa-eye-slash').addClass('fa-eye');
        } else {
            $('#confirme_password').attr('type', 'password');
            $('#show_confirme_password').removeClass('fa-eye').addClass('fa-eye-slash');
        }
    });
});
