package com.ecom.userDetails.userDetailsMicro.controller;

import com.ecom.userDetails.userDetailsMicro.entity.UserDetails;
import com.ecom.userDetails.userDetailsMicro.entity.cartItems;
import com.ecom.userDetails.userDetailsMicro.service.UserService;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserDetailsController {
    @Autowired
    UserService userService;

    @PostMapping("/save")
    public UserDetails createUser(@RequestBody UserDetails userDetails){

        UserDetails createdUser = userService.createUser(userDetails);

        return createdUser;
    }

    @GetMapping("/{id}")
public UserDetails getUserById(@PathVariable Integer id) {
        return  userService.getUserById(id);
     }

     @PutMapping("/{id}")
    public UserDetails updateUserById(@PathVariable Integer id , @RequestBody UserDetails userDetails){

        return userService.updateUserById(id,userDetails);
     }

     @DeleteMapping("/{id}")
    public void deleteUserById(@PathVariable Integer id){

         userService.deleteById(id);
     }

     @GetMapping("/cartItems/{userId}")
    public List<cartItems> getCartItemsByUserId(@PathVariable Integer userId){

        return userService.getCartItemsByUserId(userId);

     }
}
