package com.notify.NotifyEgerton.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.notify.NotifyEgerton.model.User;
import com.notify.NotifyEgerton.service.UserService;

@Component
public class CommandLineAppStartupRunner implements CommandLineRunner {

    @Autowired
    private UserService userService;

    public void run(String... args) throws Exception {

        User user = new User("Samuel", "Odhiambo", "Obunge", "sobunge", "samuel1995", "Male", "samuelobunge@gmail.com");

        userService.addAdmin(user);

    }

}
