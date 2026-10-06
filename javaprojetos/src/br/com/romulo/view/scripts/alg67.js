const frm = document.querySelector("form")
const resp= document.querySelector("h5")

frm.addEventListener("submin",(e) => {
   const nome = frm.nome.value
   resp.textContent ='Aló, ${nome!}'
   e.preventDefault()
})

