package social.twitter;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;


/**
 * Created by anuj on 11/19/2015.
 */
@Repository
public interface TweetRepository extends JpaRepository<Tweets,Long> {
    @Query(value="select u.email, u.firstname, t.tweettimestamp, t.tweets from Users u, Tweets t where t.email IN (select f.followinguser from Follow f where f.email=:email) and u.email=t.email order by t.tweettimestamp desc ")
    List getTweets(@Param("email") String email);
}
