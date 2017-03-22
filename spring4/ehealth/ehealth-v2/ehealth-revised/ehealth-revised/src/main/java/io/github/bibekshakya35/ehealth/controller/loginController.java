package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.dto.Response;
import io.github.bibekshakya35.ehealth.dto.request.UserRequest;
import io.github.bibekshakya35.ehealth.dto.response.UserResponse;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * {Insert class description here}
 *
 * @author bibek
 */
@RestController
@RequestMapping(value = "login")
public class loginController {
    
    private static final Logger LOG = Logger.getLogger(loginController.class.getName());
    
    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Response> login(@RequestBody UserRequest userRequest) {
        LOG.log(Level.INFO, "user Requets{0}", userRequest.getUsername());
        UserResponse userResponse = new UserResponse();
        userResponse.setFullName("Bibek");
        userResponse.setLastName("Shakya");
        userResponse.setToken("1122333");
        userResponse.setId(12);
        return new ResponseEntity<>(Response.okWithDataAndMessage("User Login success", userResponse), HttpStatus.OK);
    }
}
