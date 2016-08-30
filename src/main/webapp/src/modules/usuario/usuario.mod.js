(function (ng) {
    
     var mod = ng.module("usuarioModule", ["ui.router"]);
    console.log("controler");
    mod.controller("userCtrl",function($scope){
    $scope.user = [];
    $scope.actual;
     console.log("controler 2")
    $scope.agregar= function(actual){
      $scope.user.push(actual);
      console.log(actual);
  }
  
  
});
})(window.angular);