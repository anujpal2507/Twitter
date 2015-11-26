package social.twitter;

import javax.annotation.Generated;
import javax.persistence.*;

/**
 * Created by anuj on 11/20/2015.
 */
@Entity
@Table(name="following")
public class Follow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    long id;

    @Column(name = "email")
    String email;

    @Column(name="followinguser")
    String followinguser;

    public long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFollowinguser() {
        return followinguser;
    }

    public void setFollowinguser(String followinguser) {
        this.followinguser = followinguser;
    }

    public Follow(String followinguser, String email) {
        this.followinguser = followinguser;
        this.email = email;
    }
}
