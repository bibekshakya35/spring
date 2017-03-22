package io.github.bibekshakya35.ehealth.controller;

import io.github.bibekshakya35.ehealth.dto.request.UserRequest;
import io.github.bibekshakya35.ehealth.dto.response.UserResponse;
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
//@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/login", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
public class loginController {
     
    public ResponseEntity<UserResponse> login(@RequestBody UserRequest userRequest) {
        UserResponse userResponse = new UserResponse();
        userResponse.setFullName("Bibek");
        userResponse.setLastName("Shakya");
        userResponse.setToken("1122333");
        userResponse.setId(12);
        return new ResponseEntity<>(userResponse, HttpStatus.OK);
    }
}
