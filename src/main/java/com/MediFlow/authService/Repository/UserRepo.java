package com.MediFlow.authService.Repository;

import com.MediFlow.authService.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepo extends JpaRepository<User,Long> {
    @Query(value="Select * from users where email=?1",nativeQuery = true)
    User getUserDetails(String email);
}
