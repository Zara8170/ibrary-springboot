package com.example.ibrary.data.dto.user;


import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@ToString
@Builder
public class UserDTO {

  private Long id;

  private String email;
  private String name;
  private String password;
  private String phoneNumber;
  private Date birthday;
  private boolean loggedIn;
}
