package social.twitter;
import java.security.Timestamp;

/**
 * Created by anuj on 11/23/2015.
 */
public class TweetTemplate {
    String email;
    String firstname;
    String tweets;
    Timestamp tweettimestamp;
    public String getFirstname() {
        return firstname;
    }
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }
    public String getTweets() {
        return tweets;
    }
    public void setTweets(String tweets) {
        this.tweets = tweets;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public Timestamp getTweettimestamp() {
        return tweettimestamp;
    }
    public void setTweettimestamp(Timestamp tweettimestamp) {
        this.tweettimestamp = tweettimestamp;
    }
}
