window.addEventListener('load', function () {


    const formulario = document.querySelector('#add_new_car');


    formulario.addEventListener('submit', function (event) {


        const formData = {
             marca: document.querySelector('#marca').value,
             modelo: document.querySelector('#modelo').value,
             anioModelo: document.querySelector('#anioModelo').value,
             patente:document.querySelector('#patente').value,
             motorCode:document.querySelector('#motorCode').value,
             imagen:document.querySelector('#imagen').value,
             fechaIngreso: document.querySelector('#fechaIngreso').value,

        };

        const url = '/cars';
        const settings = {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
            },
            body: JSON.stringify(formData)
        }

        fetch(url, settings)
            .then(response => response.json())
            .then(data => {
              let successAlert = '<div class="alert alert-success alert-dismissible">' +
                                 '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                 '<strong></strong> Auto Agregado </div>'

                             document.querySelector('#response').innerHTML = successAlert;
                             document.querySelector('#response').style.display = "block";
                             resetUploadForm();

                        })
                        .catch(error => {

                                let errorAlert = '<div class="alert alert-danger alert-dismissible">' +
                                                 '<button type="button" class="close" data-dismiss="alert">&times;</button>' +
                                                 '<strong> Error intente nuevamente</strong> </div>'

                                  document.querySelector('#response').innerHTML = errorAlert;
                                  document.querySelector('#response').style.display = "block";

                                 resetUploadForm();})
    });


    function resetUploadForm(){
         document.querySelector('#car_id').value = "";
         document.querySelector('#marca').value = "";
         document.querySelector('#modelo').value = "";
         document.querySelector('#anioModelo').value = "";
         document.querySelector('#patente').value = "";
         document.querySelector('#motorCode').value = "";
         document.querySelector('#fechaIgreso').value ="";
    }

    (function(){
        let pathname = window.location.pathname;
        if(pathname === "/"){
            document.querySelector(".nav .nav-item a:first").addClass("active");
        } else if (pathname == "./funciones-cars.html") {
            document.querySelector(".nav .nav-item a:last").addClass("active");
        }
    })();
});