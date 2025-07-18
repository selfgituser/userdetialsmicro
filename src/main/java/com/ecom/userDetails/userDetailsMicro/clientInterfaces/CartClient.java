package com.ecom.userDetails.userDetailsMicro.clientInterfaces;

import com.ecom.userDetails.userDetailsMicro.entity.cartItems;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "cartDetailsMicro" , url = "http://localhost:8082/api")
public interface CartClient
{
    @GetMapping("/cartitems/{userId}")
    List<cartItems> getCartItemsByUserId(@PathVariable Integer userId);
}
