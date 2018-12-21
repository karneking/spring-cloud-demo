package com.carney.movie.cloudmovieuser.dao;

import com.carney.movie.cloudmovieuser.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Joe
 * @version V1.0
 * @Description: TODO
 * @date 2018/12/17
 */
@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
