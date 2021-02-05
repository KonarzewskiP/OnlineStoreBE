package com.app.service;

import com.app.entity.Role;
import com.app.entity.User;
import com.app.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static java.util.Objects.nonNull;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User findOrCreateUser(String name, String surname, String phone, String email, String address) {
        User user = userRepository.findByEmail(email);

        if (nonNull(user)) {
            return user;
        }

        user = new User();
        user.setRole(Role.CUSTOMER.name());
        user.setAddress(address);
        user.setSurname(surname);
        user.setName(name);
        user.setPhone(phone);
        user.setEmail(email);
        return userRepository.save(user);
    }
}
