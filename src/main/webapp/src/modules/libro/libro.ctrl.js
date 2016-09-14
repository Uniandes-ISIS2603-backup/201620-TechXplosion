(function (ng){
    var mod = ng.module("libroModule");
    
    mod.controller("libroCtrl",['$scope','$state','$stateParams', '$http', 'libroContext', function ($scope, $state, $stateParams, $http, context)
        { 
    
        $scope.records = {};
        
        $http.get(context).then(function(response)
        {
            $scope.records = response.data;    
        }, responseError);
        
    if ($stateParams.libroIsbn !== null && $stateParams.libroIsbn !== undefined)
    {
                
                isbn = $stateParams.libroIsbn;
                $http.get(context + "/" + isbn)
                    .then(function (response) 
                       {
                        // $http.get es una promesa
                        // cuando llegue el dato, actualice currentRecord
                        $scope.currentRecord = response.data;
                    }, responseError);
      }
      
      else
            
        {
                $scope.currentRecord = {
                    isbn: undefined ,
                   nombre: '' ,
                   tipo:'',
                   autor:'',
                   editorial:'',
                   edicion:'',
                   
                };
              
                $scope.alerts = [];
            }


            this.saveRecord = function (isbn) 
            {
                currentRecord = $scope.currentRecord;
                
                if (isbn == null) {

                    // ejecuta POST en el recurso REST
                    return $http.post(context, currentRecord)
                        .then(function () 
                {
                            $state.go('libroList');
                        }, responseError);
                        
                
                } else {
                    
                    // ejecuta PUT en el recurso REST
                    return $http.put(context + "/" + currentRecord.isbn, currentRecord)
                        .then(function () {
                            // $http.put es una promesa
                            // cuando termine bien, cambie de estado
                            $state.go('libroList');
                        }, responseError);
                };
            };
            this.deleteRecord = function (record) {
                currentRecord = record;
                
                
          
                    
                    // ejecuta DELETE en el recurso REST
                   return $http.delete(context + "/" + currentRecord.isbn)
                        .then(function () {
                            // $http.delete es una promesa
                            // cuando termine bien, cambie de estado
                            $state.reload();
                        }, responseError);
              
            };



            // -----------------------------------------------------------------
            // Funciones para manejra los mensajes en la aplicación


            //Alertas
            this.closeAlert = function (index) {
                $scope.alerts.splice(index, 1);
            };

            // Función showMessage: Recibe el mensaje en String y su tipo con el fin de almacenarlo en el array $scope.alerts.
            function showMessage(msg, type) {
                var types = ["info", "danger", "warning", "success"];
                if (types.some(function (rc) {
                    return type === rc;
                })) {
                    $scope.alerts.push({type: type, msg: msg});
                }
            }

            this.showError = function (msg) {
                showMessage(msg, "danger");
            };

            this.showSuccess = function (msg) {
                showMessage(msg, "success");
            };

            var self = this;
            function responseError(response) {

                self.showError(response.data);
            }
}]);

})(window.angular);