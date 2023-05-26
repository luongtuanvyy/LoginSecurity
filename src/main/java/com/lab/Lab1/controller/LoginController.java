package com.lab.Lab1.controller;

import com.lab.Lab1.entities.User;
import com.lab.Lab1.repository.UserRepository;
import com.lab.Lab1.utils.CookiesUtil;
import com.lab.Lab1.utils.EncodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.io.IOException;

@Controller
public class LoginController {

    @Autowired
    HttpServletRequest request;

    @Autowired
    HttpServletResponse response;

    @Autowired
    UserRepository userRepository;

    EncodeUtil encodeUtil = new EncodeUtil();

    CookiesUtil cookiesUtil = new CookiesUtil();

    @GetMapping("/login")
    public String view(Model model) {
        String username = cookiesUtil.get("username", request);
        String password = cookiesUtil.get("password", request);
        if (!username.equals("")) {
            model.addAttribute("remember", true);
        }
        model.addAttribute("user", new User(username, password));
        return "login";
    }

    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("user") User user, @RequestParam(name = "remember", required = false) boolean remember) throws IOException {
        User userLogin = userRepository.findById(user.getUsername()).orElse(new User("", ""));

        if (encodeUtil.Encryption(user.getPassword()).equalsIgnoreCase(userLogin.getPassword())) {
            if (remember) {
                cookiesUtil.add(response, "username", user.getUsername(), 1);
                cookiesUtil.add(response, "password", user.getPassword(), 1);
            }
            return "home";
        }else {
            System.out.println("Sai pass");
        }
        return "login";
    }

    @GetMapping("/register")
    public String viewRegister(Model model){
        model.addAttribute("user",new User());
        return "register";
    }

    @PostMapping("/register")
    public String saveAccount(){
        return "register";
    }
}
