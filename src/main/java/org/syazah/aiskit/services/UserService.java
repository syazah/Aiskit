package org.syazah.aiskit.services;

import org.springframework.stereotype.Service;
import org.syazah.aiskit.models.User;
import org.syazah.aiskit.repositories.UserRepository;

import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElse(null);
    }

    public Optional<User> updateUserById(String id, Optional<User> user) {
        return userRepository.findById(id).map(existingUser -> {
            user.ifPresent(update -> {
                if (update.getUsername() != null) existingUser.setUsername(update.getUsername());
                if (update.getEmail() != null) existingUser.setEmail(update.getEmail());
                if (update.getBio() != null) existingUser.setBio(update.getBio());
            });
            return userRepository.save(existingUser);
        });
    }
}
