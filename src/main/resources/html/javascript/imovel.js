
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