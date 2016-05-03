/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {

    var mod = ng.module('itinerarioMock', ['ngMockE2E']);


    mod.run(['$httpBackend', function ($httpBackend) {
            var ignore_regexp = new RegExp('^((?!api).)*$');
            /*
             * @type RegExp
             * recordUrl acepta cualquier url con el formato
             * api/(cualquierpalabra)/(numero)
             */
            var recordUrl = new RegExp('api/itinerarios/([0-9]+)');
            var recordUrlDos = new RegExp('api/itinerarios/id/paradas/([0-9]+)');

            /*
             * @type Array
             * records: Array con un itinerario por defecto
             */
            var records = [
                {
                    idItinerario:1,
                    nombreItinerario:"nombre 2",
                    fechaInicio:"01/01/2001",
                    fechaFin:"02/02/2002",

                    nombreParadaUno: "buu",
                    ciudadParadaUno: "Cali",
                    actividadParadaUno: "parque",
                    fechaInicioParadaUno: '2015-02-24',
                    fechaFinParadaUno: '2015-03-24'
                },
                {
                    idItinerario:2,
                    nombreItinerario:"nombre 2",
                    fechaInicio:"01/01/2001",
                    fechaFin:"02/02/2002",

                    nombreParadaUno: "Salsodromo",
                    ciudadParadaUno: "Cali",
                    actividadParadaUno: "parque",
                    fechaInicioParadaUno: '2015-02-23',
                    fechaFinParadaUno: '2015-03-24'
                }


            ];

            var recordsDos = [
                {
                    nombreParadaUno: "buu",
                    ciudadParadaUno: "Cali",
                    actividadParadaUno: "parque",
                    fechaInicioParadaUno: '2015-02-24',
                    fechaFinParadaUno: '2015-03-24'}
            ];

            function getQueryParams(url) {
                var vars = {}, hash;
                var hashes = url.slice(url.indexOf('?') + 1).split('&');
                for (var i = 0; i < hashes.length; i++) {
                    hash = hashes[i].split('=');
                    vars[hash[0]] = hash[1];
                }
                return vars;
            }


            /*
             * Ignora las peticiones GET, no contempladas en la Exp regular ignore_regexp
             */
            $httpBackend.whenGET(ignore_regexp).passThrough();

            /*
             * Esta funcion se ejecuta al invocar una solicitud GET a la url "api/books"
             * Obtiene los parámetros de consulta "queryParams" para establecer
             * la pagina y la maxima cantida de records. Con los anteriores parametros
             * se realiza la simulacion de la paginacion.
             * Response: 200 -> Status ok, array de libros y los headers.
             */
            $httpBackend.whenGET('api/itinerarios').respond(function (method, url) {
                var queryParams = getQueryParams(url);
                var responseObj = [];
                var page = queryParams.page;
                var maxRecords = queryParams.maxRecords;
                var headers = {};
                if (page && maxRecords) {
                    var start_index = (page - 1) * maxRecords;
                    var end_index = start_index + maxRecords;
                    responseObj = records.slice(start_index, end_index);
                    headers = {"X-Total-Count": records.length};
                } else {
                    responseObj = records;
                }
                return [200, responseObj, headers];
            });

            /*
             * Esta funcion se ejecuta al invocar una solicitud GET a la url "api/books"
             * Obtiene los parámetros de consulta "queryParams" para establecer
             * la pagina y la maxima cantida de records. Con los anteriores parametros
             * se realiza la simulacion de la paginacion.
             * Response: 200 -> Status ok, array de libros y los headers.
             */
            $httpBackend.whenGET('api/itinerarios/idItinerario/paradas').respond(function (method, url) {
                var queryParams = getQueryParams(url);
                var responseObj = [];
                var page = queryParams.page;
                var maxRecords = queryParams.maxRecords;
                var headers = {};
                if (page && maxRecords) {
                    var start_index = (page - 1) * maxRecords;
                    var end_index = start_index + maxRecords;
                    responseObj = recordsDos.slice(start_index, end_index);
                    headers = {"X-Total-Count": recordsDos.length};
                } else {
                    responseObj = recordsDos;
                }
                return [200, responseObj, headers];
            });

            /*
             * Esta funcion se ejecuta al invocar una solicitud GET a la url "api/books/[numero]"
             * Obtiene el id de la url y el registro asociado dentro del array records.
             * Response: 200 -> Status ok, record -> libro y ningún header.
             */
            $httpBackend.whenGET(recordUrl).respond(function (method, url) {
                var id = parseInt(url.split('/').pop());
                var record;
                ng.forEach(records, function (value) {
                    if (value.id === id) {
                        record = ng.copy(value);
                    }
                });
                return [200, record, {}];
            });

            /*
             * Esta funcion se ejecuta al invocar una solicitud GET a la url "api/itinerarios/[numero]/parada"
             * Obtiene el id de la url y el registro asociado dentro del array records.
             * Response: 200 -> Status ok, record -> libro y ningún header.
             */
            $httpBackend.whenGET(recordUrlDos).respond(function (method, url) {
                var id = parseInt(url.split('/').pop());
                var recordDos;
                ng.forEach(recordsDos, function (value) {
                    if (value.id === id) {
                        record = ng.copy(value);
                    }
                });
                return [200, recordDos, {}];
            });
            /*
             * Esta funcion se ejecuta al invocar una solicitud POST a la url "api/books"
             * Obtiene el record de libro desde el cuerpo de la peticion
             * Genera un id aleatorio y lo asocia al record de libro y lo guarda en el
             * array de records.
             * Response: 201 -> Status created, record -> libro y ningún header.
             */
            $httpBackend.whenPOST('api/itinerarios').respond(function (method, url, data) {
                var record = ng.fromJson(data);
                record.idItinerario = Math.floor(Math.random() * 10000);
                records.push(record);
                return [201, record, {}];
            });

            /*
             * Esta funcion se ejecuta al invocar una solicitud POST a la url "api/books"
             * Obtiene el record de libro desde el cuerpo de la peticion
             * Genera un id aleatorio y lo asocia al record de libro y lo guarda en el
             * array de records.
             * Response: 201 -> Status created, record -> libro y ningún header.
             */
            $httpBackend.whenPOST('api/itinerarios/idItinerario/paradas').respond(function (method, url, data) {
                var record = ng.fromJson(data);
                record.idParada = Math.floor(Math.random() * 10000);
                recordsDos.push(record);
                return [201, record, {}];
            });

            /*
             * Esta funcion se ejecuta al invocar una solicitud DELETE a la url "api/books/[numero]"
             * Obtiene el id del la url y el registro asociado dentro del array records.
             * Luego realiza un splice "eliminar registro del array".
             * Response: 204, no retorna ningun dato ni headers.
             */

            $httpBackend.whenDELETE(recordUrl).respond(function (method, url) {
                var id = parseInt(url.split('/').pop());
                ng.forEach(records, function (value, key) {
                    if (value.id === id) {
                        records.splice(key, 1);
                    }
                });
                return [204, null, {}];
            });

            $httpBackend.whenDELETE(recordUrlDos).respond(function (method, url) {
                var id = parseInt(url.split('/').pop());
                ng.forEach(recordsDos, function (value, key) {
                    if (value.id === id) {
                        recordsDos.splice(key, 1);
                    }
                });
                return [204, null, {}];
            });

            /*
             * Esta funcion se ejecuta al invocar una solicitud PUT a la url "api/books/[numero]"
             * Obtiene el id del la url y el record de libro desde el cuerpo de la peticion
             * Busca y reemplaza el anterior registro por el enviado en el cuerpo de la solicitud
             * Response: 204, no retorna ningun dato ni headers.
             *
             */
            $httpBackend.whenPUT(recordUrl).respond(function (method, url, data) {
                var id = parseInt(url.split('/').pop());
                var record = ng.fromJson(data);
                ng.forEach(records, function (value, key) {
                    if (value.id === id) {
                        records.splice(key, 1, record);
                    }
                });
                return [204, null, {}];
            });

            $httpBackend.whenPUT(recordUrlDos).respond(function (method, url, data) {
                var id = parseInt(url.split('/').pop());
                var record = ng.fromJson(data);
                ng.forEach(recordsDos, function (value, key) {
                    if (value.id === id) {
                        recordsDos.splice(key, 1, record);
                    }
                });
                return [204, null, {}];
            });
        }]);
})(window.angular);






