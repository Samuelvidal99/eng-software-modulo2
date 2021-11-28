
function alertaError(message) {
  var alerta = `
  <div class="alert alert-warning alert-dismissible fade show" id="alerta" role="alert">
    <strong>${message}</strong>
    <button type="button" class="close" data-dismiss="alert" onfocus aria-label="Close">
      <span aria-hidden="true">&times;</span>
    </button>
  </div>
  `
  div = document.getElementById("div01")
  $(div).append(alerta)
  window.scrollTo(0, 0)
}

function enviarEmail(){

  const email = document.getElementById("cadastrarEmailField")
  
    fetch("localhost:8080/email", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(email),
      })
        .then((response) => response.json())
        .then((email) => {
          console.log("Success:", email);
        })
        .catch((error) => {
          console.error("Error:", error);
        });

}

function preencherSelectContratos() {
  var select = document.getElementById("contratos")
  fetch("http://localhost:8080/contrato/", {
    method: "GET",
    headers: {
      "Content-Type": "application/json",
    },
  })
  .then((response) => response.json())
  .then((data) => {
    if(data.length == 0) {
      var option = "<option>Não existem Contratos cadastrados no sistema.</option>"
      $(select).append(option)
    }else {
      var aux = "<option>Selecione um Contrato</option>"
      $(select).append(aux)
      for(var i = 0; i < data.length; i++) {
        var option = `<option value="${data[i]["id"]}">Contrato ${data[i]["num_contrato"]}</option>`
        $(select).append(option)
      }
    }
  })
}

