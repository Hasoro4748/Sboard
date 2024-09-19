package com.sboard.service;

import com.sboard.dto.UserDTO;
import com.sboard.entity.User;
import com.sboard.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public void insertUser(UserDTO userDTO) {
        String encoded = passwordEncoder.encode(userDTO.getPass());
        userDTO.setPass(encoded);

        User user = userDTO.toEntity();
        userRepository.save(user);
    }
    public boolean selectUserByUid(String uid) {
        return userRepository.existsByUid(uid);
    }
    public UserDTO selectUserByUsername(String username) {
        User user = userRepository.findByName(username);
        return user.toDTO();
    }
    public UserDTO selectUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return user.toDTO();
    }public UserDTO selectUserByNickname(String Nick) {
        User user = userRepository.findByNick(Nick);
        return user.toDTO();
    }
    public UserDTO selectUserByHp(String Hp) {
        User user = userRepository.findByHp(Hp);
        return user.toDTO();
    }

}
