
function clearDiv() {
    var divAux = document.getElementById("div02")
    $(divAux).empty()
}

function porImovel() {
    clearDiv()

    var div02 = document.getElementById("div02")
    var select = `<select onchange="preencherRelatorioPorImovel()" class=\"form-control\" id=\"inquilinos\" style=\"text-align: center;width: 250px;margin-top:10px;margin-right:527px\">
                  </select>`
    $(div02).append(select)

    fetch("http://localhost:8080/imovel", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((data) => {
        if(data.length == 0) {
            var select = document.getElementById("inquilinos")
            var option = "<option>Não existem imóveis no sistema.</option>"
            $(select).append(option)
        }else {
            var select = document.getElementById("inquilinos")
            var option = "<option>Selecione um Imóvel</option>"
            $(select).append(option)
            for(var i = 0; i < data.length; i++) {
                var option = `<option value="${data[i]["id"]}" >${data[i]["logradouro"]}</option>`
                $(select).append(option)
            }
        }
    })
}

function porInquilino() {
    clearDiv()

    var div02 = document.getElementById("div02")
    var select = `<select onchange="preencherRelatorioPorInquilino()" class=\"form-control\" id=\"inquilinos\" style=\"text-align: center;width: 250px;margin-top:10px;margin-right:527px\">
                  </select>`
    $(div02).append(select)

    fetch("http://localhost:8080/inquilino", {
        method: "GET",
        headers: {
            "Content-Type": "application/json",
        },
    })
    .then((response) => response.json())
    .then((data) => {
        if(data.length == 0) {
            var select = document.getElementById("inquilinos")
            var option = "<option>Não existem inquilinos no sistema.</option>"
            $(select).append(option)
        }else {
            var select = document.getElementById("inquilinos")
            var option = "<option>Selecione um Inquilino</option>"
            $(select).append(option)
            for(var i = 0; i < data.length; i++) {
                var option = `<option value="${data[i]["id"]}" >${data[i]["nome"]} (${data[i]["cpf"]})</option>`
                $(select).append(option)
            }
        }
    })
}

function preencherRelatorioPorImovel() {
    var select = document.getElementById("inquilinos")
    var div02 = document.getElementById("div02")
    $(div02).empty()
    $(div02).append(select)
    var table = `<table class="table" style="margin-top:10px;">
                    <thead>
                        <tr>
                            <!-- <th scope="col">#</th> -->
                            <th style="text-align: center;" scope="col">Cidade</th>
                            <th style="text-align: center;" scope="col">Logradouro</th>
                            <th style="text-align: center;" scope="col">CEP</th>
                            <th style="text-align: center;" scope="col">Valor Condomínio</th>
                        </tr>
                    </thead>
                    <tbody id="tableBody">
                    </tbody>
    	        </table>`

    $(div02).append(table)
    if(select.value != "Selecione um Imóvel" && select.value != "Não existem imóveis no sistema.") {
        var url = `http://localhost:8080/imovel/${select.value}`
        fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            var tableBody = document.getElementById("tableBody")

            var tr = document.createElement("tr")
            var td1 = document.createElement("td")
            var td2 = document.createElement("td")
            var td3 = document.createElement("td")
            var td4 = document.createElement("td")

            td1.innerHTML = data["cidade"]
            td2.innerHTML = data["logradouro"]
            td3.innerHTML = data["cep"]
            td4.innerHTML = data["valorCondominio"]

            $(tr).append(td1)
            $(tr).append(td2)
            $(tr).append(td3)
            $(tr).append(td4)

            $(tableBody).append(tr)
        })
    }
}

function preencherRelatorioPorInquilino() {
    var select = document.getElementById("inquilinos")
    var div02 = document.getElementById("div02")
    $(div02).empty()
    $(div02).append(select)
    var table = `<table class="table" style="margin-top:10px;">
                    <thead>
                        <tr>
                            <!-- <th scope="col">#</th> -->
                            <th style="text-align: center;" scope="col">Nome</th>
                            <th style="text-align: center;" scope="col">CPF</th>
                            <th style="text-align: center;" scope="col">RG</th>
                            <th style="text-align: center;" scope="col">Telefone</th>
                            <th style="text-align: center;" scope="col">E-mail</th>
                        </tr>
                    </thead>
                    <tbody id="tableBody">
                    </tbody>
    	        </table>`

    $(div02).append(table)
    if(select.value != "Selecione um Inquilino" && select.value != "Não existem inquilinos no sistema.") {
        var url = `http://localhost:8080/inquilino/${select.value}`
        fetch(url, {
            method: "GET",
            headers: {
                "Content-Type": "application/json",
            },
        })
        .then((response) => response.json())
        .then((data) => {
            var tableBody = document.getElementById("tableBody")

            var tr = document.createElement("tr")
            var td1 = document.createElement("td")
            var td2 = document.createElement("td")
            var td3 = document.createElement("td")
            var td4 = document.createElement("td")
            var td5 = document.createElement("td")

            td1.innerHTML = data["nome"]
            td2.innerHTML = data["cpf"]
            td3.innerHTML = data["rg"]
            td4.innerHTML = data["telefone"]
            td5.innerHTML = data["email"]

            $(tr).append(td1)
            $(tr).append(td2)
            $(tr).append(td3)
            $(tr).append(td4)
            $(tr).append(td5)


            $(tableBody).append(tr)
        })
    }
}