package org.sparta.mytaek1.domain.user.dto;

import lombok.Getter;

@Getter
public class LoginRequestDto {
    private String userEmail;
    private String password;
}