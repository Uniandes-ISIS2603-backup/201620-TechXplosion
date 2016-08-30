(function (ng) {
    console.log("hola")
     var mod = ng.module("usuarioModule", ["ui.router"]);
     
            mod.controller("user",function($scope){
                 console.log("hihi")
    $scope.user = [];
    $scope.actual;
     console.log("controler 2")
    $scope.agregar= function(actual){
      $scope.user.push(actual);
      console.log(actual);
      
      $scope.borrar =function(){
          $scope.user.pop();
      }
  }
  
  
});
})(window.angular);