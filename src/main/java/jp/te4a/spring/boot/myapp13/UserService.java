package jp.te4a.spring.boot.myapp13;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public UserForm create(UserForm userForm) {
        userForm.setPassword(new BCryptPasswordEncoder().encode(userForm.getPassword()));
        UserBean userBean = new UserBean();
        BeanUtils.copyProperties(userForm, userBean);
        userRepository.save(userBean);
        return userForm;
    }
}