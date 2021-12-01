
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
            td1.innerHTML = "Não existem cliente cadastrados no sistema."
            $(tr).append(td1)
            $(tableBody).append(tr)
        }else {
            console.log(data)
            
            for(var i = 0; i < data.length; i++) {
                var tr = document.createElement("tr")
                var td1 = document.createElement("td")
                var td2 = document.createElement("td")
                var td3 = document.createElement("td")
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