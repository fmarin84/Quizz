package com.example.quizz.service;

import com.example.quizz.UserDTO;
import com.example.quizz.entity.User;
import com.example.quizz.entity.User;
import com.example.quizz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User getUser(String username) {
        return userRepository.findByUsername(username);
    }

    public User login(String email, String password) throws Exception {

        User user = userRepository.findByEmail(email).get();

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        if (encoder.matches(password, user.getPassword())){
            return user;
        }else{
            throw new Exception();
        }
    }

    public User registerNewUserAccount(UserDTO userDTO) throws Exception{

         //if(!userDTO.getPassword().equals(userDTO.getConfirmParssword())){
         //    throw new Exception();
         //}

        User u = new User();
        u.setEnabled(true);
        u.setUsername(userDTO.getUserName());
        u.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        u.setRole("ROLE_USER");

        u.setFirstName(userDTO.getFirstName());
        u.setLastName(userDTO.getLastName());
        u.setEmail(userDTO.getEmail());

        return userRepository.save(u);
    }

    public Optional<User> getById(int id){
        return userRepository.findOneById(id);
    }

    public List<User> getAll(){ return userRepository.findAll();}

    public void deleteUser(int id) { userRepository.deleteById(id);}

    public Optional<User> getUser(int id){
        return userRepository.findOneById(id);
    }

    public void update(int id, User user) throws Exception{

        if(id != user.getId())
            throw new Exception();

        Optional<User> u = userRepository.findOneById(id);
        if(u.isPresent()) {
            user.setEmail(u.get().getEmail());
            user.setPassword(u.get().getPassword());
            user.setRole(u.get().getRole());
            user.setUsername(u.get().getUsername());
            user.setAnswerList(u.get().getAnswerList());
            userRepository.save(user);
        } else {
            throw new Exception();
        }
    }

}
