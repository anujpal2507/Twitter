/**
 * Created by anuj on 11/20/2015.
 */
<<<<<<< HEAD
twitterApp.service('UserService',function($localStorage){
    this.setName=function(uname){
        $localStorage.name=uname;
        console.log("User name "+uname+" or "+$localStorage.name);
    }
    this.getName=function(){
        return $localStorage.name;
=======
twitterApp.service('UserService',function(){
    this.name=null;
    this.setName=function(uname){
        this.name=uname;
        console.log("User name "+uname+" or "+this.name);
    }
    this.getName=function(){
        return this.name;
>>>>>>> 567e617b039c7e01e851f8adfcc74ebc41ff0db9
    }
});