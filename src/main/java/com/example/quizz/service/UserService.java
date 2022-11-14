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

    public User registerNewUserAccount(UserDTO userDTO) throws Exception{

        if(!userDTO.getPassword().equals(userDTO.getConfirmParssword())){
            throw new Exception();
        }

        User u = new User();
        u.setEnabled(1);
        u.setUsername(userDTO.getUserName());
        u.setPassword(new BCryptPasswordEncoder().encode(userDTO.getPassword()));
        u.setRole("ROLE_USER");

        u.setFirstName(userDTO.getFirstName());
        u.setLastName(userDTO.getLastName());
        u.setEmail(userDTO.getEmail());

        return userRepository.save(u);
    }

    public Optional<User> getById(int id){
        return userRepository.findById(id);
    }

    public List<User> getAll(){ return userRepository.findAll();}

    public void deleteUser(int id) { userRepository.deleteById(id);}

    public Optional<User> getUser(int id){
        return userRepository.findById(id);
    }

    public void update(int id, User user) throws Exception{

        System.out.println("id");
        System.out.println(id);
        System.out.println(user);

        if(id != user.getId())
            throw new Exception();

        Optional<User> u = userRepository.findById(id);
        if(u.isPresent()) {
            //TODO Faire une fonction
            u.get().setFirstName(user.getFirstName());
            u.get().setLastName(user.getLastName());
            userRepository.save(user);
        } else {
            throw new Exception();
        }
    }

}
