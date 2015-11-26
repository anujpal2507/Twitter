twitterApp.controller('mainController',function($scope, $http,$location,UserService) {
    $scope.user = {};
    console.log("entry");
    $scope.signUpUser = function() {
        console.log($scope.user);
        $http.post("/start",$scope.user)
            .then(function(response){
            alert("User Successfully Registered.");
            $scope.user = null;                                                      //Clearing input fields
        },function(response){
                alert("You are already registered !")
        });
    };
    $scope.cancel= function () {
        $scope.user=null;
    }
    $scope.user_cred = {};
    $scope.loginUser = function() {
        $http.post("/login",$scope.user_cred)
            .then(function(response) {
                if(response.statusText=="OK"){
<<<<<<< HEAD
                    UserService.setName(response.data.name);
                    console.log("check name"+response.data.name);
                $location.path("/dashboard");

=======
                $location.path("/dashboard");
                UserService.setName(response.data.name);
>>>>>>> 567e617b039c7e01e851f8adfcc74ebc41ff0db9
                }
            },function(response){
                alert("Authentication Failed!!!!")
            })
    }
});

