$(document).ready(function(){
    var jenis_kelamin, $jenis_kelamin, agama, $agama, golongan_darah, $golongan_darah, jalur_masuk, $jalur_masuk, prodi, $prodi;

    $jenis_kelamin = $("#jenis_kelamin").selectize({
        options: [
            {id: 1, text: 'Laki - Laki'},
            {id: 0, text: 'Perempuan'}
        ],
        labelField: 'text',
        valueField: 'id',
   });

    $agama = $("#agama").selectize({
        options: [
            {id: 'Islam', text: 'Islam'},
            {id: 'Protestan', text: 'Protestan'},
            {id: 'Katolik', text: 'Katolik'},
            {id: 'Budha', text: 'Budha'},
            {id: 'Hindu', text: 'Hindu'},
            {id: 'Konghucu', text: 'Konghucu'}
        ],
        labelField: 'text',
        valueField: 'id',
       
    });

    $golongan_darah = $("#golongan_darah").selectize({
        options: [
            {id: 'AB-', text: 'AB-'},
            {id: 'AB+', text: 'AB+'},
            {id: 'A-', text: 'A-'},
            {id: 'A+', text: 'A+'},
            {id: 'B-', text: 'B-'},
            {id: 'B+', text: 'B+'},
            {id: 'C-', text: 'C-'},
            {id: 'C+', text: 'C+'},
            {id: 'O-', text: 'O-'},
            {id: 'O+', text: 'O+'}
        ],
        labelField: 'text',
        valueField: 'id',
    });

    $jalur_masuk = $("#jalur_masuk").selectize({
        options: [
            {id: 'Undangan Olimpiade', text: 'Undangan Olimpiade'},
            {id: 'Undangan Reguler/SNMPTN', text: 'Undangan Reguler/SNMPTN'},
            {id: 'Undangan Paralel/PPKB', text: 'Undangan Paralel/PPKB'},
            {id: 'Ujian Tulis Bersama/SBMPTN', text: 'Ujian Tulis Bersama/SBMPTN'},
            {id: 'Ujian Tulis Mandiri', text: 'Ujian Tulis Mandiri'}
        ],
        labelField: 'text',
        valueField: 'id',
      
    });

    jenis_kelamin = $jenis_kelamin[0].selectize;
    agama = $agama[0].selectize;
    golongan_darah = $golongan_darah[0].selectize;
    jalur_masuk = $jalur_masuk[0].selectize;
    load_dropdown_prodi();

    $("#tahun_masuk").datepicker({
        format: "yyyy",
        minViewMode: 2,
        autoclose: true
    });

    $("#tanggal_lahir").datepicker({
        format: "yyyy-mm-dd",
        autoclose: true
    });

   

  
    $("#formAdd").validate({
        ignore: ':hidden:not([class~=selectized]),:hidden > .selectized, .selectize-control .selectize-input input',
        rules: {
            'nama': {
                required: true
            },
            'jenis_kelamin': {
                required: true
            },
            'tempat_lahir': {
                required: true
            },
            'tanggal_lahir': {
                required: true
            },
            'agama': {
                required: true
            },
            'golongan_darah': {
                required: true
            },
            'tahun_masuk': {
                required: true
            },
            'jalur_masuk': {
                required: true
            },
            'id_prodi': {
                required: true
            }
        },
        highlight: function(element){
            $(element).closest('.help-block').remove();
        },
        unhighlight: function (element) {
            $(element).closest('.help-block').remove();
        },
        errorElement: 'span',
        errorClass: 'invalid-feedback',
        errorPlacement: function (error, element) {
            element.parents('.form-group > div').append(error);
            if ($(element).hasClass('selectized'))
            {
               error.insertAfter($(element).nextAll('.selectize-control'));
            }
            else
            {
                error.insertAfter(element);
            }
        }
    })

    $("#formUpdate").validate({
        ignore: ':hidden:not([class~=selectized]),:hidden > .selectized, .selectize-control .selectize-input input',
        rules: {
            'nama': {
                required: true
            },
            'jenis_kelamin': {
                required: true
            },
            'tempat_lahir': {
                required: true
            },
            'tanggal_lahir': {
                required: true
            },
            'agama': {
                required: true
            },
            'golongan_darah': {
                required: true
            },
            'tahun_masuk': {
                required: true
            },
            'jalur_masuk': {
                required: true
            },
            'id_prodi': {
                required: true
            }
        },
        highlight: function(element){
            //$(element).closest('.form-group > .col-md-4 > input').removeClass('is-valid is-invalid').addClass('is-invalid');
            $(element).closest('.help-block').remove();
        },
        unhighlight: function (element) {
            //$(element).closest('.form-group > .col-md-4 > input').removeClass('is-valid is-invalid');
            $(element).closest('.help-block').remove();
        },
        errorElement: 'span',
        errorClass: 'invalid-feedback',
        errorPlacement: function (error, element) {
            element.parents('.form-group > div').append(error);
            if ($(element).hasClass('selectized'))
            {
               error.insertAfter($(element).nextAll('.selectize-control'));
            }
            else
            {
                error.insertAfter(element);
            }
        }
    })

});

