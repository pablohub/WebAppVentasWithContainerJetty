const btnConsultar = id('btnConsultar')

btnConsultar.onclick = () => {
    registrar()
}

const registrar = () => {
    let url = `${URL}productos`
    let data = {descripcion: 'Parlantes'}
    fetch(url, {
        method: 'POST',
        body: JSON.stringify(data),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(json => log(json))
    .catch(err => log('Error: ', err))
}