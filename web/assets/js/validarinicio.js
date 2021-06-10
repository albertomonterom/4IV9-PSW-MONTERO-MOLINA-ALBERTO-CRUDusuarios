function validarlog(){
    var cel, password;
    cel = document.getElementById('cel').value;
    password = document.getElementById('password').value;

    if(cel === "" || password ===""){
        alert("Para poder comprar tus helados, el llenado todos de los campos es obligatorio para llevar a cabo el registro, verifica que todos estén completados.");
        return false;
    }

    if (cel.length>10){
        alert("El celular es muy largo :(");
        return false;
    }
    else if(!NaN.test(cel)){
        alert("El celular no es valido, srry :(");
        return false;
    }
    else if (password.length>20){
        alert("La clave solo debe tener máximo 20 caracteres :(");
        return false;
    }
}
function SoloNumeros(e){
    key = e.keyCode || e.which;
    var teclado = String.fromCharCode(key);
    var numero = "0123456789"
    var especiales = "8-37-38-46";
    var teclado_especial = false;

    for(var i in especiales){
        if(key==especiales[i]){
            teclado_especial = true;
        }
    }
    if(numero.indexOf(teclado)==-1 && !teclado_especial){
        return false;
    }
}