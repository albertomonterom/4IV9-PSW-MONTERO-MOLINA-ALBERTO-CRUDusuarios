function validar(){
    var nombres, appat, apmat, cumple, edad, dom, telfij, cel, password, expresion1;
    nombres = document.getElementById('nombres').value;
    appat = document.getElementById('appat').value;
    apmat = document.getElementById('apmat').value;
    cumple = document.getElementById('cumple').value;
    edad = document.getElementById('edad').value;
    dom = document.getElementById('dom').value;
    telfij = document.getElementById('telfij').value;
    cel = document.getElementById('cel').value;
    password = document.getElementById('password').value;

    expresion1 = /[a-zA-Z]/;


    if(nombres === "" || appat ==="" || apmat ==="" || cumple ==="" || edad ==="" || dom === "" || telfij === "" || cel === "" || password ===""){
        alert("Para poder comprar tus helados, el llenado todos de los campos es obligatorio para llevar a cabo el registro, verifica que todos estén completados.");
        return false;
    }
    else if(nombres.length>30){
        alert("El nombre es demasiado largo :(");
        return false;
    }
    else if(!expresion1.test(nombres)){
        alert("Ingresa unicamente letras en el nombre :)");
        return false;
    }
    else if (appat.length>20){
        alert("El apelido paterno es muy largo :(");
        return false;
    }
    else if(!expresion1.test(appat)){
        alert("Ingresa unicamente letras en el apellido paterno :)");
        return false;
    }
    else if (apmat.length>20){
        alert("El apellido materno es muy largo :(");
        return false;
    }
    else if(!expresion1.test(apmat)){
        alert("Ingresa unicamente letras en el apellido materno :)");
        return false;
    }
    else if (dom.length>50){
        alert("El domicilio es muy largo :(");
        return false;
    }
    else if(!expresion1.test(dom)){
        alert("Ingresa unicamente letras en el domicilio (CIUDAD COLONIA CALLE)  :)");
        return false;
    }
    else if(!NaN.test(edad)){
        alert("Ingresa solo números en la edad :)");
        return false;
    }
    else if (edad.length>2){
        alert("¿De verdad eres tan viejo?");
        return false;
    }
    else if (telfij.length>10){
        alert("El teléfono fijo es muy largo :(");
        return false;
    }
    else if(!NaN.test(telfij)){
        alert("El teléfono fijo no es valido, srry :(");
        return false;
    }
    else if (cel.length>10){
        alert("El celular es muy largo :(");
        return false;
    }
    else if(!NaN.test(cel)){
        alert("El cel no es valido, srry :(");
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