package com.heeexy.example.config.cros;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@ConfigurationProperties( "server" )
public class CrossOrign extends WebMvcConfigurerAdapter {
    private String cors;

    public String getCors() {
		return cors;
	}

	public void setCors(String cors) {
		this.cors = cors;
	}

	@Override
    public void addCorsMappings( CorsRegistry registry ) {
		cors = StringUtils.isEmpty( cors ) ? "*" : cors;
        registry.addMapping( "/**" )
                .allowedOrigins( cors )
                .allowCredentials(true)
                .allowedMethods( "GET", "HEAD", "POST", "PUT", "DELETE", "OPTIONS" )
                .allowCredentials( true )
                .maxAge( 3600 );
    }
}
