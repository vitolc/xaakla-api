package com.vitulc.portfolio.app.controllers;

import com.vitulc.portfolio.app.dtos.EmailDto;
import com.vitulc.portfolio.app.services.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public ResponseEntity<String> sendEmail(@RequestBody EmailDto emailDto) {
        emailService.sendEmail(emailDto);
        return ResponseEntity.ok("Email sent successfully");
    }
}
