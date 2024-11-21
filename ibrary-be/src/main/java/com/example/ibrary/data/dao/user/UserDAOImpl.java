package com.example.ibrary.data.dao.user;

import com.example.ibrary.data.entity.user.User;
import com.example.ibrary.data.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserDAOImpl implements UserDAO {

  private final UserRepository userRepository;


}
