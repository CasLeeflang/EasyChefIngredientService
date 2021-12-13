package io.getarrays.secondService.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Slf4j
@RestController @RequestMapping("/api") @RequiredArgsConstructor
public class testResource {

    @GetMapping("/public")
    public ResponseEntity<String> publicEndpoint(){
        log.info("Public endpoint triggered!");
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/public").toUriString());
        return ResponseEntity.created(uri).body("Public endpoint triggered");
    }

    @GetMapping("/private")
    public ResponseEntity<String> privateEndpoint(){
        log.info("Private endpoint triggered!");
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/private").toUriString());
        return ResponseEntity.created(uri).body("Private endpoint triggered");
    }
}
