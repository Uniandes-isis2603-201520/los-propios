/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
(function (ng) {

    var mod = ng.module('eventoMock', ['ngMockE2E']);


    mod.run(['$httpBackend', function ($httpBackend) {
            var ignore_regexp = new RegExp('^((?!api).)*$');
            /*
             * @type RegExp
             * recordUrl acepta cualquier url con el formato
             * api/(cualquierpalabra)/(numero)
             * ej: api/books/1
             */
            var recordUrl = new RegExp('api/evento/([0-9]+)');

            /*
             * @type Array
             * records: Array con un evento por defecto
             */
            var records = [
                {
                    nombre: 'Concierto KSI',
                    descripción: 'Concierto del cantante y youtuber ingles',
                    tipo: 'Concierto',
                    lugar: 'O2 Brixton Academy, 211 Stockwell Rd, London SW9 9SL, United Kingdom',
                    fecha: '10/02/2016',
                    precio: '£20',
                    img: 'https://academymusicgroup.com/o2academybrixton/sites/default/files/artists/2bf94d27-34c5-4da3-8a42-32f843452c41.jpg',
                    clasificacion: 'evento'
                },
                {
                    nombre: 'The Color Run',
                    descripción: 'Los 5 kilometros más coloridos',
                    tipo: 'Maratón',
                    lugar: 'Parque Simón Bolivar, Bogotá, Colombia',
                    fecha: '11/04/2016',
                    precio: 'COP$35.000',
                    img: 'http://www.lafm.com.co/sites/default/files/imagecache/600xy/imagenes/thecolorrun.jpg',
                    clasificacion: 'evento'
                },
                {
                    nombre: 'Trafalgar Square',
                    descripción: 'Emblematico sitio turistico de londres',
                    tipo: 'Parque',
                    lugar: 'Trafalgar Square, Westminster, London WC2N 5DN, United Kingdom',
                    fecha: '',
                    precio: 'Gratis',
                    img: 'https://upload.wikimedia.org/wikipedia/commons/a/a6/Trafalgar_Square,_London_2_-_Jun_2009.jpg',
                    clasificacion: 'sitio'
                },
                {
                    nombre: 'Eiffel Tower',
                    descripción: 'Uno de los monumentos más visitados en el mundo, una de las maravillas del mundo',
                    tipo: 'Monumento',
                    lugar: 'Champ de Mars, 5 Avenue Anatole France, 75007 Paris, Francia',
                    fecha: '',
                    precio: 'Gratis',
                    img: 'http://mexico.cnn.com/media/2013/02/15/torre-eiffel.jpg',
                    clasificacion: 'sitio'
                }
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
            $httpBackend.whenGET('api/evento').respond(function (method, url) {
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
             * Esta funcion se ejecuta al invocar una solicitud POST a la url "api/books"
             * Obtiene el record de libro desde el cuerpo de la peticion
             * Genera un id aleatorio y lo asocia al record de libro y lo guarda en el
             * array de records.
             * Response: 201 -> Status created, record -> libro y ningún header.
             */
            $httpBackend.whenPOST('api/evento').respond(function (method, url, data) {
                var record = ng.fromJson(data);
                record.id = Math.floor(Math.random() * 10000);
                records.push(record);
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

        }]);
})(window.angular);



