package apap.tutorial.traveloke.controller;

import apap.tutorial.traveloke.model.UserModel;
import apap.tutorial.traveloke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/addUser",method = RequestMethod.POST)
    public String addUserSubmit(@ModelAttribute UserModel user, Model model){
        List<UserModel> listUser = userService.findAll();
        String text = "username sudah ada jadi tidak dapat digunakan lagi";
        for (UserModel check: listUser) {
            if(check.getUsername().equals(user.getUsername())){
                model.addAttribute("text",text);
                return "notif";
            }
        }
        userService.addUser(user);
        model.addAttribute("user",user);
        return "redirect:/";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.GET)
    private String updatePasswordForm(Model model){
        model.addAttribute("teks", "");
        return "form-update-password";
    }

    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    private String updatePasswordSubmit(@RequestParam String oldPass, String newPass, String confirmPass, String username, Model model){
        UserModel user = userService.getUserByUsername(username);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        if(encoder.matches(oldPass, user.getPassword())){
            if(newPass.equals(confirmPass)){
                userService.updatePassword(user, newPass);
                model.addAttribute("teks","Password berhasil diubah");
            }
            else{
                model.addAttribute("teks", "Password baru tidak sesuai");
            }
        }
        else{
            model.addAttribute("teks", "Password lama salah");
        }
        return "form-update-password";
    }
}
