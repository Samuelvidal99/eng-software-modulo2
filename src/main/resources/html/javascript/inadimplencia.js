
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

function alertaSuccess(message) {
    var alerta = `
    <div class="alert alert-success alert-dismissible fade show" id="alerta" role="alert">
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

function carregarTabela() {
    var tableBody = document.getElementById("tableBody")

    fetch("http://localhost:8080/contrato", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((data) => {
        if(data.length == 0) {
            var tr = document.createElement("tr")
            var td1 = document.createElement("td")
            td1.innerHTML = "Não existem cliente cadastrados ou inadimplentes no sistema."
            $(tr).append(td1)
            $(tableBody).append(tr)
        }else { 
            for(var i = 0; i < data.length; i++) {
                var tr = document.createElement("tr")
                var td1 = document.createElement("td")
                var td2 = document.createElement("td")
                var td3 = document.createElement("td")
                td1.style = "text-align: center;"
                td2.style = "text-align: center;"
                td3.style = "text-align: center;"
                td1.innerHTML = data[i]["inquilino"]["cpf"]
                td2.innerHTML = data[i]["valor_aluguel"]
                td3.innerHTML = data[i]["inquilino"]["email"]
                $(tr).append(td1)
                $(tr).append(td2)
                $(tr).append(td3)
                $(tableBody).append(tr)
            }
        }
    })
}

function enviarEmail() {
    fetch("http://localhost:8080/email/send-email", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => alertaSuccess("E-mail enviado."))
}