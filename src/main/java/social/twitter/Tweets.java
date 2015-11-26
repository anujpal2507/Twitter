package social.twitter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by anuj on 11/19/2015.
 */
@Entity
@Table(name = "tweet")
public class Tweets {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name="email")
    private String email;

    @Column(name="tweets")
    private String tweets;

    @Column(name = "tweettimestamp")
    Timestamp tweettimestamp;

    public Long getId() {
        return id;
    }

    public Timestamp getTweettimestamp() {
        return tweettimestamp;
    }

    public void setTweettimestamp(Timestamp tweettimestamp) {
        this.tweettimestamp = tweettimestamp;
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

    public Tweets(){

    }

    public Tweets(String tweets, String email, Timestamp tweettimestamp) {
        this.tweets = tweets;
        this.email = email;
        this.tweettimestamp = tweettimestamp;
    }
}
