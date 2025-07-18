package com.ecom.userDetails.userDetailsMicro.service;

import com.ecom.userDetails.userDetailsMicro.clientInterfaces.CartClient;
import com.ecom.userDetails.userDetailsMicro.entity.UserDetails;
import com.ecom.userDetails.userDetailsMicro.entity.cartItems;
import com.ecom.userDetails.userDetailsMicro.repository.UserDetailsRespository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class UserService {
    @Autowired
    UserDetailsRespository userDetailsRespository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private CartClient cartClient;

    public UserDetails createUser(UserDetails userDetails){
    return  userDetailsRespository.save(userDetails);
    }

    public UserDetails getUserById(Integer id){
        return  userDetailsRespository.findById(id).orElseThrow(() -> {
            return new RuntimeException("Ivalid User Id");
        });
    }
    public UserDetails updateUserById(Integer Id , UserDetails userDetails){

    UserDetails  updateUserDetails =  userDetailsRespository.findById(Id).orElseThrow(() -> {
         return new RuntimeException("Ivalid User Id");
     });

        updateUserDetails.setName(userDetails.getName());
        updateUserDetails.setAddress(userDetails.getAddress());
        updateUserDetails.setEmail(userDetails.getEmail());
        updateUserDetails.setPassword(userDetails.getPassword());
        updateUserDetails.setPhoneNumber(userDetails.getPhoneNumber());
        updateUserDetails.setUpdatedAt(new Date());
        userDetailsRespository.save(updateUserDetails);
        return updateUserDetails;
    }

    public void deleteById(Integer id) {
        userDetailsRespository.deleteById(id);
    }

    /*@CircuitBreaker(name = "cartDetailsMicro", fallbackMethod = "cartFallBackMethod")*/
    @Retry(name = "cartDetailsMicro", fallbackMethod = "cartFallBackMethod")
public List<cartItems> getCartItemsByUserId(Integer userId){
        System.out.println("In User service method");
        /* Using Feign Client*/
        return cartClient.getCartItemsByUserId(userId);

        /* Using RestTemplate */
        /*cartItems[] cartItems = restTemplate.getForObject("http://localhost:8082/api/cartitems/" + userId, cartItems[].class);
List<cartItems> cartItemsfin = Arrays.asList(cartItems);
        return cartItemsfin;*/
}

public List<cartItems> cartFallBackMethod(Exception e) {
    System.out.println("FallBack Method called -  " + e.getMessage());
    return null;
}

}
