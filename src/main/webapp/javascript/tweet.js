//defining controller
twitterApp.controller('tweet',function($scope,UserService,$http) {
    console.log("tweet controller");
    $scope.name=UserService.getName();
   // console.log("My name is"+$scope.name);
    console.log("In Dashboard");
    $http.post("/following")
        .then(function(response){
            console.log(response.data);
            $scope.folloinglist=response.data;
            console.log(  $scope.followinglist);
        }, function(response){
            console.log("failed to show followers");
        });
    $http.post("/followusers")
        .then(function(response){
            console.log(response);
            $scope.nonfollowlist=response.data.followinglist;
        },function(response){
            console.log("failed to show non-followers");
        });
//tweet saving
    $scope.users={};
    $scope.tweeting=function(){
        $http.post(value="/tweet",$scope.users)
            .then(function(response)
            {
                $http.post("/displaytweets")
                    .then(function(response){
                        $scope.tweetlist=response.data;
                    }, function (error) {
                    });
                $scope.users={};
                console.log("tweet saved");
            }, function(response){
                console.log("oop's tweet failed!");
            });
    };
//display tweet
    $http.post(value="/displaytweets")
        .then(function(response){
            $scope.tweetlist=response.data;
        }, function(error){

        });
//follow users
    $scope.follow=function(data){
    $scope.followdata = {"email":data};
        console.log($scope.followdata);
        $http.post("/follow",$scope.followdata)
            .then(function(response){
                console.log(response);
                $http.post("/followusers")
                    .then(function(response){
                        $scope.nonfollowlist=response.data;
                    }, function(response){
                        console.log("failed to display users list");
                    });
                $http.post("/following")
                    .then(function(response){
                        $scope.followinglist=response.data.followlist;
                    }, function(response){
                        console.log("failed to show follows list");
                    });
            }, function(response){
                console.log("failed suggestions");
            });
    }
//to follow users list
    $scope.nonfollowlist={};
    $http.post(value="/followusers",$scope.nonfollowlist)
        .then(function (response)
        {  console.log();
            $scope.nonfollowlist=response.data;
        }, function(response){
            console.log("follow list not displayed correctly!")
        });
// following users
    $scope.unfollow=function(data){
        console.log(data);
        $scope.unfollowdata = {"email":data};
        $http.post("/unfollow",$scope.unfollowdata)
            .then(function(response){
                $http.post("/following")
                    .then(function(response){
                        $scope.followinglist=response.data.followlist;
                    }, function(response){
                        console.log("failed to show followers");
                    });
                $http.post("/followuser")
                    .then(function(response){
                        $scoope.nonfollowlist=response.data;
                    },function(response){
                        console.log("failed to show non-followers");
                    });
            },function(response){
                console.log(response);
            });
    }
// following users list
      $http.post("/following",$scope.followinglist)
        .then(function (response){
            $scope.followinglist=response.data.followlist;
        }, function(response){
            console.log("failed to display followers");
        })
});