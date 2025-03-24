package ru.atc.smartbudget.services;

import org.springframework.stereotype.Service;
import ru.atc.smartbudget.model.User;
import ru.atc.smartbudget.repository.UserRepository;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

}
