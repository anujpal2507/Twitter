package social.twitter;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by anuj on 11/20/2015.
 */
public interface FollowRepository extends JpaRepository<Follow,Long> {
    @Override
    List<Follow> findAll();

    @Modifying
    @Transactional
    @Query(value="delete from Follow f where f.email=?1 AND f.followinguser=?2")
    void deleteFollowerRecord(String email, String followinguser);
}

