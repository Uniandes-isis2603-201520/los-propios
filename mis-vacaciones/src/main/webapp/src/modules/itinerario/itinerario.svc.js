 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

(function (ng) {

    var mod = ng.module("itinerarioModule");
    mod.service("itinerarioService", ["$http", "itinerarioContext","$log", function($http, context, $log)
        {

            this.getItinerarios = function(id){
                return $http.get(context + "/" + id + "/itinerarios");
            };

            this.getItinerario = function (id, idIt){
              return $http.get(context + "/" + id + "/itinerarios/" + idIt);
            };

            this.createItinerario = function(id, it){
                return $http.post(context+ "/" + id + "/itinerarios", it);
            };

            this.updateItinerario = function (id, idIt, it) {
                return $http.put(context + "/" + id + "/itinerarios/" + idIt, it);
            };

            this.deleteItinerario = function (id, idIt) {
                return $http.delete(context + "/" + id + "/itinerarios/" + idIt);
            };

            this.saveItinerario = function(id, it){
                $log.log("id user: " + id);
                $log.log(it);
                $log.log(it.id);
                if(it.id){
                    return this.updateItinerario(id, it.id, it);
                }else{
                    return this.createItinerario(id, it);
                }
            };

        }]);
})(window.angular);

