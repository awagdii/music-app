package com.zakzouk.music;

import com.zakzouk.music.service.TopTrackService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendApplication.class, args);
    }
    @Bean
    CommandLineRunner runner(TopTrackService topTrackService) {
        return args -> {
            topTrackService.getTopTrackBasedOnCountry("Egypt");
        };
    }
}
