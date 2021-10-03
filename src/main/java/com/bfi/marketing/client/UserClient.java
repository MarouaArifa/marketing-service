package com.bfi.marketing.client;

import com.bfi.marketing.models.User;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="AUTHENTICATION-SERVICE", url="localhost:8089")
@RibbonClient("AUTHENTICATION-SERVICE")
public interface UserClient {
    @ApiOperation(value = "Get all users", response = ResponseEntity.class)
    @GetMapping("/api/test")
    public Iterable<User> getAllUsers();

    @GetMapping("/api/test/user/{userId}")
    public User getUserById(@PathVariable("userId") Long id);
}
