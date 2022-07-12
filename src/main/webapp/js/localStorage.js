var contador = document.getElementById("contadorCarrito").value;

localStorage.setItem("countChart", contador);

var resultadoContador = localStorage.getItem("countChart");

//console.log(resultadoContador);

document.getElementById("mostrarContador").innerHTML = resultadoContador;