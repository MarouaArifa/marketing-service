package com.bfi.marketing.restApi;


import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Parameter;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fb")
public class FBController {

FacebookClient fbclient;


    private String pageAccessToken="EAAJcJSpleogBACVpfDUqu1b1ZCNcWWMGDJWiiEMH3cOvZBoWTDzNLpyHL6BHTby65onAB3oXs1UfmZA7B59ZCsXAcG6dIHljJK6qK0ffUnLF1nk2EKETPCxVAKZAOoAua0ZBhSxaTV7G9nalnjxUo1vbybtGbELESPBRAjwN2O8pZAqu4YsHHcH01tfeRZAKP2A83BwcZCaRJ6IT6axjHmokAfZAfb1nO7OZAgZD";
    @GetMapping("/facebook")
    public void createFacebookAccessToken(){
        fbclient=new DefaultFacebookClient(this.pageAccessToken, Version.VERSION_6_0);
        fbclient.publish("/MyRizik-105730425331099/feed", //
                FacebookType.class, //
                Parameter.with("message", "My first Post from by Java App"));
    }




}
