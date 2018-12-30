package com.goffity.demo.restfulbestpractices.services;

import com.goffity.demo.restfulbestpractices.controllers.UsersController;
import com.goffity.demo.restfulbestpractices.model.Devices;
import com.goffity.demo.restfulbestpractices.model.Users;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class UsersServices {
    private Log logger = LogFactory.getLog(UsersServices.class);

    public List<Users> getUsersAll() {
        logger.info("getUsersAll()");

        Users users = new Users(1, "Gof", "Nonthaburi");
        Link link = ControllerLinkBuilder.linkTo(UsersController.class).slash(users.getUserId()).withSelfRel();
        users.add(link);

        Users users1 = new Users(2, "Goffity", "Bangkok");
        Link link1 = ControllerLinkBuilder.linkTo(UsersController.class).slash(users1.getUserId()).withSelfRel();

        Devices devices = new Devices(1, "mobile", 1);
        Link deviceLink = new Link("https://localhost:8080/devices/api/v1/1");
        devices.add(deviceLink);
        users.setDevices(devices);
        users1.add(link1);

        return Arrays.asList(users, users1);
    }

    public Users getUser(int id) {
        return new Users(1, "Gof", "Nonthaburi");
    }
}
