$(function () {
    var form;
    $('#fileUpload').change(function (event) {
        form = new FormData();
        form.append('file', event.target.files[0]); // para apenas 1 arquivo
    });

    $('#btnEnviar').click(function () {
        $.ajax({
            url: '/file', // Url do lado server que vai receber o arquivo
            data: form,
            processData: false,
            contentType: false,
            type: 'POST',
            success: function (data) {
                alert(data);
            }
        });
    });
});