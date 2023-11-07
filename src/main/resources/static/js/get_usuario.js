window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de peliculas con el método GET
      //nos devolverá un JSON con una colección de peliculas
      const url = '/user/{id}';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de peliculas del JSON
         for(user of data){
            //por cada pelicula armaremos una fila de la tabla
            //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pelicula
            var table = document.getElementById("userTable");
            var userRow =table.insertRow();
            let tr_id = 'tr_' + appUsuario.id;
            userRow.id = tr_id;

            //por cada pelicula creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
            //dicho boton invocara a la funcion de java script deleteByKey que se encargará
            //de llamar a la API para eliminar una pelicula
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + appUsuario.id + '\"' +
                                      ' type="button" onclick="deleteBy('+appUsuario.id+')" class="btn rounded-circle btn-outline-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            //por cada pelicula creamos un boton que muestra el id y que al hacerle clic invocará
            //a la función de java script findBy que se encargará de buscar la pelicula que queremos
            //modificar y mostrar los datos de la misma en un formulario.
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + appUsuario.id + '\"' +
                                      ' type="button" onclick="findBy('+appUsuario.id+')" class="btn  rounded-circle  btn-outline-success btn_id">' +
                                      appUsuario.id +
                                      '</button>';

            //armamos cada columna de la fila
            //como primer columna pondremos el boton modificar
            //luego los datos del auto
            //como ultima columna el boton eliminar
           userRow.innerHTML = '<table class="table table-dark table-striped-columns">'+ '<td >' + updateButton + '</td>' +
                    '<td class=\"td_nombre\">' + appUsuario.nombre.toUpperCase() + '</td>' +
                    '<td class=\"td_apellido\">' + appUsuario.apellido.toUpperCase() + '</td>' +
                    '<td class=\"td_email\">' + appUsuario.email.toUpperCase() + '</td>' +
                    '<td class=\"td_reserva\">' + appUsuario.reserva.toUpperCase() + '</td>' +
                    '<td>' + deleteButton + '</td>'+'</table>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/funciones-usuario.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })