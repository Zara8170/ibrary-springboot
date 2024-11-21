package com.example.ibrary.service.user;

import com.example.ibrary.data.dao.user.UserDAO;
import com.example.ibrary.data.dto.user.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

  private final UserDAO userDAO;

}
