const btnGuardar = id('btnGuardar')
listar()

btnGuardar.onclick = (e) => {
    e.preventDefault()
    let id_producto = btnGuardar.getAttribute('data-id')
    if(id_producto != null && id_producto != '0'){
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
    const tblProductos = q('#tblProductos tbody')
    let url = `${URL}productos?opcion=listar`
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(json => {
        log(json)
        tblProductos.innerHTML = ''
        json.forEach((producto, index) => {
            tblProductos.innerHTML += `
                <tr>
                    <td>${++index}</td>
                    <td>${producto.descripcion}</td>
                    <td>${producto.precio}</td>
                    <td>${producto.stock}</td>
                    <td>
                        <a class='btn btn-outline-success btn-sm btnEditar' data-id='${producto.id_producto}'>
                            <i class='fas fa-edit btnEditar' data-id='${producto.id_producto}'></i>
                        </a>
                        <a class='btn btn-outline-danger btn-sm btnEliminar' data-id='${producto.id_producto}'>
                            <i class='fas fa-trash-alt btnEliminar' data-id='${producto.id_producto}'></i>
                        </a>
                    </td>
                </tr>
            `
        })
    })
    .catch(err => log('Error: ', err))
}

const registrar = () => {
    const txtDescripcion = q('#txtDescripcion')
    const txtPrecio = q('#txtPrecio')
    const txtStock = q('#txtStock')

    let producto = {
        descripcion: txtDescripcion.value,
        precio: txtPrecio.value,
        stock: txtStock.value
    }
    
    let url = `${URL}productos`
    fetch(url, {
        method: 'POST',
        body: JSON.stringify(producto),
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
    let id_producto = element.getAttribute('data-id')
    let url = `${URL}productos?opcion=editar&id_producto=${id_producto}`
    fetch(url, {
        method: 'GET',
        headers: {
            'Content-Type': 'application/json'
        }
    }).then(res => res.json())
    .then(producto => {
        log(producto)
        const txtDescripcion = q('#txtDescripcion')
        const txtPrecio = q('#txtPrecio')
        const txtStock = q('#txtStock')
        txtDescripcion.value = producto.descripcion
        txtPrecio.value = producto.precio
        txtStock.value = producto.stock

        btnGuardar.innerHTML = 'Actualizar'
        btnGuardar.setAttribute('data-id', id_producto)
    })
    .catch(err => log('Error: ', err))
}

const actualizar = () => {
    const txtDescripcion = q('#txtDescripcion')
    const txtPrecio = q('#txtPrecio')
    const txtStock = q('#txtStock')

    let id_producto = btnGuardar.getAttribute('data-id')

    let producto = {
        id_producto: id_producto,
        descripcion: txtDescripcion.value,
        precio: txtPrecio.value,
        stock: txtStock.value
    }
    
    let url = `${URL}productos`
    fetch(url, {
        method: 'PUT',
        body: JSON.stringify(producto),
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
    let id_producto = element.getAttribute('data-id')
    let url = `${URL}productos?id_producto=${id_producto}`
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
    q('#txtDescripcion').value = ''
    q('#txtPrecio').value = ''
    q('#txtStock').value = ''
    btnGuardar.innerHTML = 'Guardar'
    btnGuardar.removeAttribute('data-id')
}