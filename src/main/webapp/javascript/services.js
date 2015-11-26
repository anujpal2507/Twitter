/**
 * Created by anuj on 11/20/2015.
 */
twitterApp.service('UserService',function($localStorage){
    this.setName=function(uname){
        $localStorage.name=uname;
        console.log("User name "+uname+" or "+$localStorage.name);
    }
    this.getName=function(){
        return $localStorage.name;
    }
});