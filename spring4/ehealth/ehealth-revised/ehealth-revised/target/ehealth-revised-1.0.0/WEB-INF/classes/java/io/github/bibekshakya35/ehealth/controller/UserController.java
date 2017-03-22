package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.model.User;
import io.github.bibekshakya35.ehealth.service.EhealthService;
import java.util.List;
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
    public ResponseEntity<List<User>> getList() {
        return new ResponseEntity<>(userEhealthService.getList(), HttpStatus.OK);
    }

    @RequestMapping(value = "{username}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> getUserByUserName(@PathVariable("username") String username) {
        LOG.info("INSIDE GET USER......");
        return new ResponseEntity<>(this.userEhealthService.findOne(username), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Void> createNewUser(@RequestBody User user, UriComponentsBuilder uriComponentsBuilder) {
        LOG.info("inside create user...");
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

    @RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.PUT)
    public ResponseEntity<User> editUser(@RequestBody User user) {
        LOG.info("----------------------Inside edit user-----------------------------");
        userEhealthService.edit(user);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
