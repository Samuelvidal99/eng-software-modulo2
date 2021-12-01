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

function preencherSelectInquilinos() {
    var select = document.getElementById("inquilinos")
    fetch("http://localhost:8080/inquilino/", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((data) => {
        if(data.length == 0) {
            var option = "<option>Não existem Inquilinos cadastrados no sistema.</option>"
            $(select).append(option)
        }else {
            var aux = "<option>Selecione um Inquilino</option>"
            $(select).append(aux)
            for(var i = 0; i < data.length; i++) {
                var option = `<option value="${data[i]["id"]}">${data[i]["nome"]} (${data[i]["cpf"]})</option>`
                $(select).append(option)
            }
        }
    })
}

function vincularContrato() {
    var selectImovel = document.getElementById("imoveis").value
    var selectInquilino = document.getElementById("inquilinos").value

    if(selectImovel == "Selecione um Imóvel" || selectImovel == "Não existem Imóveis cadastrados no sistema.") {
        alertaError("Imóvel Inválido")
    }else if(selectInquilino == "Selecione um Inquilino" || selectInquilino == "Não existem Inquilinos cadastrados no sistema.") {
        alertaError("Inquilino Inválido")
    }else {
        var url = `http://localhost:8080/inquilino/${selectInquilino}`

        var numContrato = document.getElementById("numContratoField").value
        var valorAluguel = document.getElementById("valorAluguelField").value
        var contratoEnergia = document.getElementById("contratoEnergiaField").value
        var contratoAgua = document.getElementById("contratoAguaField").value
        var dataInicio = document.getElementById("dataInicio").value
        var dataTermino = document.getElementById("dataTermino").value

        console.log(dataInicio)
        console.log(dataTermino)

        fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            var obj = new Object()
            obj.imovel = {"id":selectImovel}
            obj.inquilino = {"id":selectInquilino}
            obj.num_contrato = numContrato
            obj.valor_aluguel = valorAluguel
            obj.contrato_energia = contratoEnergia
            obj.contrato_agua = contratoAgua
            obj.dataInicio = dataInicio
            obj.dataTermino = dataTermino
            obj.emailContratante = data["email"]
            obj.pendente = true
    
            var body = JSON.stringify(obj)
            fetch("http://localhost:8080/contrato/new", {
                method: "POST",
                headers: {
                    "Content-Type": "application/json",
                },
                body: body,
            })
            .then((response) => response.json())
            .then((data) => {
                if(data.message == undefined) {
                    console.log("Success: \n", data)
                    alertaSuccess("Success: Contrato Vinculado.")
                }else {
                    console.log("Error: ", data.message)
                    alertaError(data.message)
                }
            })
        })
    }
}