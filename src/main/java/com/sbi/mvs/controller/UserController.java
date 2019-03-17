package com.sbi.mvs.controller;

import com.sbi.mvs.entity.Pfhrms;
import com.sbi.mvs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static java.util.stream.Collectors.toList;

@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("user/{userId}")
    public ResponseEntity<?> getUserByUserId(@PathVariable String userId){
        return new ResponseEntity<>(userService.getUserByUserId(userId), HttpStatus.OK);
    }

    @GetMapping("userSearch/{userId}")
    public ResponseEntity<?> searchUsersByIdPart(@PathVariable String userId)
    {
//        List<String> users = userService.getUsersByPart(userId).stream().map(el -> el.getPfId() + " - " + el.getName()).collect(toList());
        List<Pfhrms> users = userService.getUsersByPart(userId);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }
}
