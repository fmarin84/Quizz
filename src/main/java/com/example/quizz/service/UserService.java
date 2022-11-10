package com.example.quizz.service;

import com.example.quizz.entity.User;
import com.example.quizz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Optional<User> getById(int id){
        return userRepository.findById(id);
    }

    public User postUser(User user) { return userRepository.save(user); }

    public void add(User user){
        userRepository.save(user);
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
