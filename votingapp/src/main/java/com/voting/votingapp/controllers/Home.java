package com.voting.votingapp.controllers;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

    @RestController
    public class Home {
        public String home() {
            return "Voting App Backend is Running";
        }
    }

