const frm = document.querySelector("form")


frm.addEventListener("submit",(e) =>{
    const nomeFilme = frm.filme.value
    alert(`o filme escolhido foi: ${nomeFilme}`)

    const tempo = Number(frm.tempo.value)
    const horas = Math.floor(tempo / 60)
    const minutos = tempo % 60
    alert (`O filme tem ${horas} hora*(s) e ${minutos} ,minutos(s) de duração.`)
    e.preventDefault()
})