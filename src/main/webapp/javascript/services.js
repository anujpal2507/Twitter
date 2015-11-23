/**
 * Created by anuj on 11/20/2015.
 */
twitterApp.service('UserService',function(){
    this.name=null;
    this.setName=function(uname){
        this.name=uname;
        console.log("User name "+uname+" or "+this.name);
    }
    this.getName=function(){
        return this.name;
    }
});