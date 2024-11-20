package by.swiftbuild.service;

import by.swiftbuild.entity.Role;
import by.swiftbuild.entity.User;
import by.swiftbuild.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    //@PreAuthorize("hasRole('ADMIN')") // аннотация даёт доступ к этой функции только пользователям с ролью ROLE_ADMIN
    public void save(User user) {
        user.setPassword(new BCryptPasswordEncoder(11).encode(user.getPassword())); // достаём пришедший пароль, шифруем его и устанавливаем обратно
        user.setRoles(Set.of(Role.ROLE_ADMIN));
        userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> byUsername = userRepository.findByUsername(username);
        if (byUsername.isPresent()) {
            return byUsername.get();
        }
        throw new UsernameNotFoundException(username);

    }
}