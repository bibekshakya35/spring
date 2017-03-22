package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.model.User;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author Bibek Shakya
 */
@RestController
@RequestMapping(value = "users")
public class UserController {
    
    private static final Logger LOG = Logger.getLogger(UserController.class.getName());
    
    @Autowired
    EhealthService<User> userEhealthService;
    
    @RequestMapping(method = RequestMethod.GET, produces = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<User> getList() {
        return userEhealthService.getList();
    }
    
    @RequestMapping(value = "/{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUser(@PathVariable("username") String username) {
        LOG.info("INSIDE GET USER......");
        Optional<User> user = Optional.ofNullable(userEhealthService.findOne(username));
        if (!user.isPresent()) {
            LOG.info("No user found NPE.....");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
        
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        LOG.info("inside create user...");
        if (userEhealthService.findOne(user.getUserName()) != null) {
            LOG.info("user with that username is already found");
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        LOG.info(user.toString());
        userEhealthService.add(user);
        //location header containning the location of newly created user
        /**
         * Content-Length →0 Date →Thu, 29 Dec 2016 18:29:29 GMT Location
         * →http://localhost:8080/ehealth-revised/user/ksaaavccvsshakysssssa35
         * Server →Apache TomEE
         */
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uriComponentsBuilder.path("/user/{username}").buildAndExpand(user.getUserName()).toUri());
        
        return new ResponseEntity<>(httpHeaders, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<User> editUser(@RequestBody User user) {
        LOG.info("----------------------Inside edit user-----------------------------");
        Optional<User> unEditedUser = Optional.ofNullable(userEhealthService.findOne(user.getUserName()));
        if (!unEditedUser.isPresent()) {
            LOG.info("----------------------NO USER EXISTS WITH THAT USERNAME-------------------------------");
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        userEhealthService.edit(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
