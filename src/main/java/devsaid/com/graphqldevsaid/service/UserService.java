package devsaid.com.graphqldevsaid.service;


import devsaid.com.graphqldevsaid.exception.UserNotFoundException;
import devsaid.com.graphqldevsaid.model.User;
import devsaid.com.graphqldevsaid.model.UserRequest;
import devsaid.com.graphqldevsaid.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserRepository userRepository;

    public List< User> getAllUsers(){
        return userRepository.findAll ();
    }

    public User getUserById(Long id){
        return userRepository.findById(id)
                .orElseThrow (()->new UserNotFoundException ("user not found"));
    }

    public User createUser(UserRequest userRequest){
        User user= User.builder ()
                .username (userRequest.getUsername ())
                .mail (userRequest.getMail ())
                .role (userRequest.getRole ())
                .build ();
        return userRepository.save (user);
    }

    public User updateUser(UserRequest userRequest) {
        User existing = getUserById(userRequest.getId());
        existing.setRole(userRequest.getRole());
        existing.setUsername(userRequest.getUsername());
        existing.setMail(userRequest.getMail());
        return userRepository.save(existing);
    }

    public void deleteUser(Long id) {
        User existing = getUserById(id);
        userRepository.delete(existing);
    }
}
