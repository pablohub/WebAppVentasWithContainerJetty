const btnGuardar = id('btnGuardar')
const URL_BASE = `${URL}proveedores`

listar()

btnGuardar.onclick = (e) => {
    e.preventDefault()
    let id_proveedor = btnGuardar.getAttribute('data-id')
    if(id_proveedor != null && id_proveedor != '0'){
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
    const tblProveedores = q('#tblProveedores tbody')
    let url = `${URL_BASE}?opcion=listar`
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(json => {
        log(json)
        tblProveedores.innerHTML = ''
        json.forEach((proveedor, index) => {
            tblProveedores.innerHTML += `
                <tr>
                    <td>${++index}</td>
                    <td>${proveedor.ruc}</td>
                    <td>${proveedor.razon_social}</td>
                    <td>${proveedor.nombre_comercial}</td>
                    <td>
                        <a class='btn btn-outline-success btn-sm btnEditar' data-id='${proveedor.id_proveedor}'>
                            <i class='fas fa-edit btnEditar' data-id='${proveedor.id_proveedor}'></i>
                        </a>
                        <a class='btn btn-outline-danger btn-sm btnEliminar' data-id='${proveedor.id_proveedor}'>
                            <i class='fas fa-trash-alt btnEliminar' data-id='${proveedor.id_proveedor}'></i>
                        </a>
                    </td>
                </tr>
            `
        })
    })
    .catch(err => log('Error: ', err))
}

const registrar = () => {
    const txtRuc = q('#txtRuc')
    const txtRazonSocial = q('#txtRazonSocial')
    const txtNombreComercial = q('#txtNombreComercial')

    let proveedor = {
        ruc: txtRuc.value,
        razon_social: txtRazonSocial.value,
        nombre_comercial: txtNombreComercial.value
    }
    
    let url = `${URL_BASE}`
    fetch(url, {
        method: 'POST',
        body: JSON.stringify(proveedor),
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
    let id_proveedor = element.getAttribute('data-id')
    let url = `${URL_BASE}?opcion=editar&id_proveedor=${id_proveedor}`
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(proveedor => {
        log(proveedor)
        const txtRuc = q('#txtRuc')
        const txtRazonSocial = q('#txtRazonSocial')
        const txtNombreComercial = q('#txtNombreComercial')
        txtRuc.value = proveedor.ruc
        txtRazonSocial.value = proveedor.razon_social
        txtNombreComercial.value = proveedor.nombre_comercial

        btnGuardar.innerHTML = 'Actualizar'
        btnGuardar.setAttribute('data-id', id_proveedor)
    })
    .catch(err => log('Error: ', err))
}

const actualizar = () => {
    const txtRuc = q('#txtRuc')
    const txtRazonSocial = q('#txtRazonSocial')
    const txtNombreComercial = q('#txtNombreComercial')

    let id_proveedor = btnGuardar.getAttribute('data-id')

    let proveedor = {
        id_proveedor: id_proveedor,
        ruc: txtRuc.value,
        razon_social: txtRazonSocial.value,
        nombre_comercial: txtNombreComercial.value
    }
    
    let url = `${URL_BASE}`
    fetch(url, {
        method: 'PUT',
        body: JSON.stringify(proveedor),
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
    let id_proveedor = element.getAttribute('data-id')
    let url = `${URL_BASE}?id_proveedor=${id_proveedor}`
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
    q('#txtRuc').value = ''
    q('#txtRazonSocial').value = ''
    q('#txtNombreComercial').value = ''
    btnGuardar.innerHTML = 'Guardar'
    btnGuardar.removeAttribute('data-id')
}