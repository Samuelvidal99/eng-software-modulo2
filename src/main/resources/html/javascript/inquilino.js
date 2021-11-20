function cadastrarInquilino(){

    const name = document.getElementById("nameField")
    const cpf = document.getElementById("cpfField")
    const rg = document.getElementById("rgField")
    const cellphone = document.getElementById("cellphoneField")
    const email = document.getElementById("emailField")

      fetch("localhost:8080/email", {
          method: "POST",
          headers: {
            "Content-Type": "application/json",
          },
          body: JSON.stringify(name, cpf, rg, cellphone, email),
        })
          .then((response) => response.json())
          .then((email) => {
            console.log("Success:", email);
          })
          .catch((error) => {
            console.error("Error:", error);
          });
  
  }
  
  