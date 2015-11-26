package social.twitter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by anuj on 11/16/2015.
 */
//@Transactional
@Repository
public interface UserRepository extends JpaRepository<Users,String>{
    Users findByEmail(@Param("email") String email);

    @Transactional
    @Query("select u from Users u where u.email NOT IN (select f.followinguser from Follow f where f.email=:email) And u.email <> :email")
    List<Users> whoToFollow(@Param("email") String email);

    // @Query(value = "select u from User u where u.email not in (select f.followUser from Follow f) and u.email not in :email")
    @Query("select u from Users u where u.email IN (select f.followinguser from Follow f where f.email=:email AND NOT (f.email=:email AND f.followinguser=:email))")
    List<Users> whoToUnfollow(@Param("email") String email);
}