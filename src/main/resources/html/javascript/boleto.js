
function carregarContratos() {
    var select01 = document.getElementById("contratos01")
    var select02 = document.getElementById("contratos02")

    fetch("http://localhost:8080/contrato", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((data) => {
        if(data.length == 0) {
            var option = "<option>Não existem contratos cadastrados no sistema.</option>"
            $(select01).append(option)
            $(select02).append(option)
        }else {
            for(var i = 0; i < data.length; i++) {
                var option = `<option>Contrato (${data[i]["inquilino"]["cpf"]}) (${data[i]["imovel"]["logradouro"]}).</option>`
                $(select01).append(option)
                $(select02).append(option)
            }
        }
    })
}