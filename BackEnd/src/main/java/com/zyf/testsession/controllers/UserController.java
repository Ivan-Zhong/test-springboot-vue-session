package com.zyf.testsession.controllers;

import com.zyf.testsession.entities.User;
import com.zyf.testsession.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/login")
    //@CrossOrigin(value="http://localhost:8080", maxAge=1800, allowedHeaders = "*")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpServletRequest request){
        String truepasswd = userRepository.findPasswordByUsername(username);
        if(truepasswd != null && truepasswd.equals(password))
        {
            request.getSession().setAttribute("username", username);
            return "successful";
        }
        else
            return "failed";
    }

    @GetMapping("/username")
    //@CrossOrigin(value="http://localhost:8080", maxAge=1800, allowedHeaders = "*")
    public String getUsername(HttpServletRequest request){
        return (String)request.getSession().getAttribute("username");
    }

    @GetMapping("/logout")
    //@CrossOrigin(value="http://localhost:8080", maxAge=1800, allowedHeaders = "*")
    public void logout(HttpServletRequest request){
        if(request.getSession(false) != null)
            request.getSession().invalidate();
    }

}
