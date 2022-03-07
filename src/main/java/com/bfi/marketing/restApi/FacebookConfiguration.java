package com.bfi.marketing.restApi;

import com.restfb.DefaultFacebookClient;
import com.restfb.FacebookClient;
import com.restfb.Version;
import com.restfb.types.FacebookType;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FacebookConfiguration {

    private String pageAccessToken="";

    @Bean
    public FacebookClient configureFacebook() {
        return new DefaultFacebookClient(this.pageAccessToken, Version.VERSION_6_0);
    }





}
