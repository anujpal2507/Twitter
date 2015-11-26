package social.twitter;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.Console;
import java.util.ArrayList;
import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by anuj on 11/16/2015.
 */
@RestController
public class RequestController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    TweetRepository tweetRepository;

    @Autowired
    FollowRepository followRepository;

    @Autowired
    InfoContainer infoContainer;

    @RequestMapping(value = "/start", method = RequestMethod.POST)
    private HttpStatus signUpUser(@RequestBody Users user) {
        System.out.println("Request Received");
        userRepository.save(user);
        Follow follow = new Follow(user.getEmail(), user.getEmail());
        followRepository.save(follow);
        return HttpStatus.ACCEPTED;


    }

    @RequestMapping("/login ")
    private ResponseEntity loginUser(@RequestBody String json) {
        System.out.println("Login Credentials : " + json);

        try {
            JSONObject loginUser = new JSONObject(json);
            Users user = userRepository.findByEmail(loginUser.getString("username"));
            System.out.println(user);
            if (user != null) {
                if (loginUser.getString("username").equals(user.getEmail()) && loginUser.getString("password").equals(user.getPassword())) {
                    infoContainer.setEmail(loginUser.getString("username"));
                    infoContainer.setPassword(loginUser.getString("password"));
                    JSONObject obj = new JSONObject();
                    obj.put("name", user.getFirstname());
                    System.out.print(user.getFirstname());
                    return new ResponseEntity(obj.toString(), HttpStatus.OK);
                }


            }
        } catch (Exception e) {

            System.out.println("Error is " + e);
        }
        return new ResponseEntity(HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(value = "/tweet", method = RequestMethod.POST)
    private ResponseEntity tweeting(@RequestBody String twet) {
        Tweets tweets;
        JSONObject newTweet = null;
        try {
            newTweet = new JSONObject(twet);
            newTweet.put("timestamp", new Timestamp(new Date().getTime()));
            tweets = new Tweets(newTweet.getString("tweet"), infoContainer.getEmail(), new Timestamp(new Date().getTime()));
            System.out.println("JSONOBJECT" + newTweet);
            System.out.println(infoContainer.getEmail());

            System.out.println(tweets);
            tweetRepository.save(tweets);
            System.out.println();
            System.out.println("call till here");
        } catch (Exception e) {

        }
        return new ResponseEntity(newTweet.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/displaytweets", method = RequestMethod.POST)
    private ResponseEntity returnTweets() {
        List list2 = tweetRepository.getTweets(infoContainer.getEmail());
        return new ResponseEntity(list2, HttpStatus.ACCEPTED);
    }

    @RequestMapping(value = "/followusers", method = RequestMethod.POST)
    private ResponseEntity follow() {
        JSONObject follow = new JSONObject();
        JSONArray followList = new JSONArray();
        try {
            List<Users> usersList = userRepository.whoToFollow(infoContainer.getEmail());
            System.out.println("user list" + usersList);
            for (Users u : usersList) {
                System.out.println("in for");
                JSONObject jsobj = new JSONObject();
                jsobj.put("name", u.getFirstname());
                jsobj.put("email", u.getEmail());
                System.out.println("Follow user " + u.getFirstname());
                followList.put(jsobj);
            }
        } catch (Exception e) {
        }
        return new ResponseEntity(followList.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/following", method = RequestMethod.POST)
    private ResponseEntity followinglist() {
        JSONObject following = new JSONObject();
        JSONArray followingList = new JSONArray();
        try {
            List<Users> userList = userRepository.whoToUnfollow(infoContainer.getEmail());
            for (Users u : userList) {
                JSONObject jsnobj = new JSONObject();
                jsnobj.put("name", u.getFirstname());
                jsnobj.put("email", u.getEmail());
                System.out.println("Following user " + u.getFirstname());
                followingList.put(jsnobj);
            }
        } catch (Exception e) {
        }
        return new ResponseEntity(followingList.toString(), HttpStatus.OK);
    }

    @RequestMapping(value = "/follow", method = RequestMethod.POST)
    private ResponseEntity follow(@RequestBody String tofollow) {
        Follow follow;
        try {
            JSONObject jsnobj = new JSONObject(tofollow);
            follow = new Follow(jsnobj.getString("email"), infoContainer.getEmail());
            followRepository.save(follow);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(tofollow, HttpStatus.OK);
    }

    @RequestMapping(value = "/unfollow", method = RequestMethod.POST)
    private ResponseEntity unfollow(@RequestBody String tounfollow) {
        Follow follow;
        try {
            JSONObject jsnobj = new JSONObject(tounfollow);
            followRepository.deleteFollowerRecord(infoContainer.getEmail(), jsnobj.getString("email"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity(tounfollow, HttpStatus.OK);
    }
}



