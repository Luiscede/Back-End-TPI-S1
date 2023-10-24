window.addEventListener('load', function () {
    (function(){

      //con fetch invocamos a la API de peliculas con el método GET
      //nos devolverá un JSON con una colección de peliculas
      const url = '/cars/listar';
      const settings = {
        method: 'GET'
      }

      fetch(url,settings)
      .then(response => response.json())
      .then(data => {
      //recorremos la colección de peliculas del JSON
         for(car of data){
            //por cada pelicula armaremos una fila de la tabla
            //cada fila tendrá un id que luego nos permitirá borrar la fila si eliminamos la pelicula
            var table = document.getElementById("carTable");
            var carRow =table.insertRow();
            let tr_id = 'tr_' + car.id;
            carRow.id = tr_id;

            //por cada pelicula creamos un boton delete que agregaremos en cada fila para poder eliminar la misma
            //dicho boton invocara a la funcion de java script deleteByKey que se encargará
            //de llamar a la API para eliminar una pelicula
            let deleteButton = '<button' +
                                      ' id=' + '\"' + 'btn_delete_' + car.id + '\"' +
                                      ' type="button" onclick="deleteBy('+car.id+')" class="btn rounded-circle btn-outline-danger btn_delete">' +
                                      '&times' +
                                      '</button>';

            //por cada pelicula creamos un boton que muestra el id y que al hacerle clic invocará
            //a la función de java script findBy que se encargará de buscar la pelicula que queremos
            //modificar y mostrar los datos de la misma en un formulario.
            let updateButton = '<button' +
                                      ' id=' + '\"' + 'btn_id_' + car.id + '\"' +
                                      ' type="button" onclick="findBy('+car.id+')" class="btn  rounded-circle  btn-outline-success btn_id">' +
                                      car.id +
                                      '</button>';

            //armamos cada columna de la fila
            //como primer columna pondremos el boton modificar
            //luego los datos del auto
            //como ultima columna el boton eliminar
           carRow.innerHTML = '<table class="table table-dark table-striped-columns">'+ '<td >' + updateButton + '</td>' +
                    '<td class=\"td_marca\">' + car.marca.toUpperCase() + '</td>' +
                    '<td class=\"td_modelo\">' + car.modelo.toUpperCase() + '</td>' +
                    '<td class=\"td_patente\">' + car.patente.toUpperCase() + '</td>' +
                    '<td>' + deleteButton + '</td>'+'</table>';

        };

    })
    })

    (function(){
      let pathname = window.location.pathname;
      if (pathname == "/funciones-cars.html") {
          document.querySelector(".nav .nav-item a:last").addClass("active");
      }
    })


    })