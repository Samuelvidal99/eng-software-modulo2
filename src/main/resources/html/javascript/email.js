



function enviarEmail(){

  const email = document.getElementById("cadastrarEmailField")
  
    fetch("localhost:8080/email", {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify(email),
      })
        .then((response) => response.json())
        .then((email) => {
          console.log("Success:", email);
        })
        .catch((error) => {
          console.error("Error:", error);
        });

}

