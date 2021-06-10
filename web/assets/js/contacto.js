function validar(){
    var nombres, email, telefono,asunto, mensaje, expresion;
    nombres = document.getElementById('nombres').value;
    email = document.getElementById('email').value;
    telefono = document.getElementById('telefono').value;
    mensaje = document.getElementById('mensaje').value;

    expresion = /\w+@\w+\.+[a-z]/;
    
    if(nombres === "" || email ==="" || telefono ==="" || asunto ==="" || mensaje ===""){
        alert("¡Aguas! El llenado todos de los campos es obligatorio para llevar a cabo el registro, verifica que todos estén completados.");
        return false;
    }
    else if(nombres.length>30){
        alert("El nombre es demasiado largo :(");
        return false;
    }
    else if(email.length>50){
        alert("El correo electrónico es demasiado largo :(");
        return false;
    }
    else if(!expresion.test(email)){
        alert("El correo no es valido, srry :(")
        return false;
    }
    else if(telefono.length>12){
        alert("El telefono es demasiado largo :(");
        return false;
    }
}
function SoloLetras(e){
    key = e.keyCode || e.which;
    var teclado = String.fromCharCode(key);
    var letras = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    var letrasch= "abcdefghijklmnñopqrstuvwxyz";
    var especiales = "8-37-38-46-164";
    var teclado_especial = false;

    for(var i in especiales){
        if(key==especiales[i]){
            teclado_especial = true;
        }
    }
    if(letras&&letrasch.indexOf(teclado)==-1 && !teclado_especial){
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