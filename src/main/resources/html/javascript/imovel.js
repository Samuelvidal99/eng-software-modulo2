
function alertaError(message) {
    var alerta = `
    <div class="alert alert-warning alert-dismissible fade show" id="alerta" role="alert">
      <strong>${message}</strong>
      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
        <span aria-hidden="true">&times;</span>
      </button>
    </div>
    `
    div = document.getElementById("div01")
    $(div).append(alerta)
}

function preencherCampos() {
    var imovel = document.getElementById("imoveis").value

    cidade = document.getElementById("cidadeField")
    logradouro = document.getElementById("logradouroField")
    cep = document.getElementById("cepField")
    condominio = document.getElementById("condominioField")

    if(imovel != "Selecione um Imóvel") {
        var url = `http://localhost:8080/imovel/${imovel}`
        fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            cidade.value = data["cidade"]
            logradouro.value = data["logradouro"]
            cep.value = data["cep"]
            condominio.value = data["valorCondominio"]
        })
    }
}

// Falta a interação do banco não ter imoveis cadastrados
function preencherSelect() {
    var select = document.getElementById("imoveis")
    console.log(select.options)
    fetch("http://localhost:8080/imovel/", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((data) => {
        for(var i = 0; i < data.length; i++) {
            var option = `<option value="${data[i]["id"]}">${data[i]["logradouro"]}</option>`
            console.log(data[i]["id"])
            $(select).append(option)
        }
    })
}

function cadastrarImovel() {
    var cidade = document.getElementById("cidadeField").value
    var logradouro = document.getElementById("logradouroField").value
    var cep = document.getElementById("cepField").value
    var condominio = document.getElementById("condominioField").value

    var obj = new Object()
    obj.cidade = cidade
    obj.logradouro = logradouro
    obj.cep = cep
    obj.valorCondominio = parseFloat(condominio) 

    var body = JSON.stringify(obj)

    console.log(body)

    fetch("http://localhost:8080/imovel/new", {
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
        } else {
            var string = data.message.replace('<', '')
            console.log(string.replace('>', ''))
            alertaError(string.replace('>', ''))
        }
    })
}

// ver como pegar o id da option
function alterarImovel() {
    var cidade = document.getElementById("cidadeField").value
    var logradouro = document.getElementById("logradouroField").value
    var cep = document.getElementById("cepField").value
    var condominio = document.getElementById("condominioField").value
    var imovel = document.getElementById("imoveis").value

    var obj = new Object()
    obj.id = imovel
    obj.cidade = cidade
    obj.logradouro = logradouro
    obj.cep = cep
    obj.valorCondominio = parseFloat(condominio) 

    var body = JSON.stringify(obj)


    if(imovel != "Selecione um Imóvel") {
        fetch("http://localhost:8080/imovel/update", {
            method: "PUT",
            headers: {
                "Content-Type": "application/json",
            },
            body: body,
        })
        .then((response) => response.json())
        .then((data) => {
            if(data.message == undefined) {
                console.log("Success: \n", data)
            } else {
                console.log(data.message)
                alertaError(data.message)
            }
        })
    }
}