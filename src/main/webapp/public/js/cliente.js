const btnGuardar = id('btnGuardar')
const URL_BASE = `${URL}clientes`

listar()

btnGuardar.onclick = (e) => {
    e.preventDefault()
    let id_cliente = btnGuardar.getAttribute('data-id')
    if(id_cliente != null && id_cliente != '0'){
        actualizar()
    }else{
        registrar()
    }
}

document.onclick = (e) => {
    if (e.target.matches('.btnEditar')) {
        editar(e.target)
        return;
    }
    
    if (e.target.matches('.btnEliminar')) {
        eliminar(e.target)
        return;
    }
}
function listar(){
    const tblClientes = q('#tblClientes tbody')
    let url = `${URL_BASE}?opcion=listar`
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(json => {
        log(json)
        tblClientes.innerHTML = ''
        json.forEach((cliente, index) => {
            tblClientes.innerHTML += `
                <tr>
                    <td>${++index}</td>
                    <td>${cliente.dni}</td>
                    <td>${cliente.nombre}</td>
                    <td>
                        <a class='btn btn-outline-success btn-sm btnEditar' data-id='${cliente.id_cliente}'>
                            <i class='fas fa-edit btnEditar' data-id='${cliente.id_cliente}'></i>
                        </a>
                        <a class='btn btn-outline-danger btn-sm btnEliminar' data-id='${cliente.id_cliente}'>
                            <i class='fas fa-trash-alt btnEliminar' data-id='${cliente.id_cliente}'></i>
                        </a>
                    </td>
                </tr>
            `
        })
    })
    .catch(err => log('Error: ', err))
}

const registrar = () => {
    const txtDni = q('#txtDni')
    const txtNombre = q('#txtNombre')

    let cliente = {
        dni: txtDni.value,
        nombre: txtNombre.value
    }
    
    let url = `${URL_BASE}`
    fetch(url, {
        method: 'POST',
        body: JSON.stringify(cliente),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(json => {
        log(json)
        listar()
        limpiarFormulario()
    })
    .catch(err => log('Error: ', err))
}

const editar = (element) => {
    let id_cliente = element.getAttribute('data-id')
    let url = `${URL_BASE}?opcion=editar&id_cliente=${id_cliente}`
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(cliente => {
        log(cliente)
        const txtDni = q('#txtDni')
        const txtNombre = q('#txtNombre')
        txtDni.value = cliente.dni
        txtNombre.value = cliente.nombre

        btnGuardar.innerHTML = 'Actualizar'
        btnGuardar.setAttribute('data-id', id_cliente)
    })
    .catch(err => log('Error: ', err))
}

const actualizar = () => {
    const txtDni = q('#txtDni')
    const txtNombre = q('#txtNombre')

    let id_cliente = btnGuardar.getAttribute('data-id')

    let cliente = {
        id_cliente: id_cliente,
        dni: txtDni.value,
        nombre: txtNombre.value
    }
    
    let url = `${URL_BASE}`
    fetch(url, {
        method: 'PUT',
        body: JSON.stringify(cliente),
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(json => {
        log(json)
        listar()
        limpiarFormulario()
    })
    .catch(err => log('Error: ', err))
}

const eliminar = (element) => {
    let id_cliente = element.getAttribute('data-id')
    let url = `${URL_BASE}?id_cliente=${id_cliente}`
    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(json => {
        log(json)
        listar()
    })
    .catch(err => log('Error: ', err))
}

const limpiarFormulario = () => {
    q('#txtDni').value = ''
    q('#txtNombre').value = ''
    btnGuardar.innerHTML = 'Guardar'
    btnGuardar.removeAttribute('data-id')
}