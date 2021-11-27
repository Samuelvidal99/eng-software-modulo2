
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
    var imovel = document.getElementById("contratos").value

    cidade = document.getElementById("cidadeField")
    logradouro = document.getElementById("logradouroField")
    cep = document.getElementById("cepField")
    condominio = document.getElementById("condominioField")

    if(imovel == "Imóvel 01") {
        cidade.value = "Cidade Imóvel 01"
        logradouro.value = "Logradouro Imóvel 01"
        cep.value = "CEP Imóvel 01"
        condominio.value = "Condomínio Imóvel 01"
    } else if (imovel == "Imóvel 02") {
        cidade.value = "Cidade Imóvel 02"
        logradouro.value = "Logradouro Imóvel 02"
        cep.value = "CEP Imóvel 02"
        condominio.value = "Condomínio Imóvel 02"
    } else {
        cidade.value = "Cidade Imóvel 03"
        logradouro.value = "Logradouro Imóvel 03"
        cep.value = "CEP Imóvel 03"
        condominio.value = "Condomínio Imóvel 03"
    }
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
        if (data.message == undefined) {
            console.log("Success: \n", data)
        } else {
            console.log(data.message)
            alertaError(data.message)
        }
    })
}