package com.goffity.demo.restfulbestpractices.controllers;

import com.goffity.demo.restfulbestpractices.model.Users;
import com.goffity.demo.restfulbestpractices.services.UsersServices;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("users/api")
public class UsersController {

    private Log logger = LogFactory.getLog(UsersController.class);

    @Autowired
    UsersServices usersServices;

    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Users> getAllUsers() {
        logger.info("getAllUsers()");

        return usersServices.getUsersAll();
    }

    @GetMapping(value = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Users getUser(@PathVariable("id") int id) {
        logger.info("getUser()");

        return usersServices.getUser(id);
    }
}
