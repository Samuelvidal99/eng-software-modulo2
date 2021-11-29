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

function cadastrarInquilino(){

    const name = document.getElementById("nameField").value
    const cpf = document.getElementById("cpfField").value
    const rg = document.getElementById("rgField").value
    const cellphone = document.getElementById("cellphoneField").value
    const email = document.getElementById("emailField").value

    var obj = new Object()
    obj.nome = name
    obj.cpf = cpf
    obj.rg = rg
    obj.telefone = cellphone
    obj.email = email

    var teste = JSON.stringify(obj)

    console.log(teste)
      fetch("http://localhost:8080/inquilino/new", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: teste,
        })
          .then((response) => response.json())
          .then((data) => {
            if (data.message == undefined) {
              console.log("Success: \n", data);
              alertaSuccess("Success: Inquilino Cadastrado.")
            }else {
              console.log(data.message)
              alertaError(data.message)
            }
          })
  }