package by.berdmival.bookstore.service.user;

import by.berdmival.bookstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("userService")
@Repository
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepository userRepository;
}
