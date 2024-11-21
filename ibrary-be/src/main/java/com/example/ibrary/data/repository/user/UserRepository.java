package com.example.ibrary.data.repository.user;

import com.example.ibrary.data.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
