package apap.tutorial.traveloke.service;

import apap.tutorial.traveloke.model.UserModel;

import java.util.List;

public interface UserService {
    UserModel addUser(UserModel user);
    String encrypt(String password);
    UserModel getUserByUsername(String username);
    void updatePassword(UserModel user, String newPass);
    List<UserModel> findAll();
}
