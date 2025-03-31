package com.example.security.controllers;

import com.example.security.dto.process.CreateProcessDto;

import com.example.security.entities.Process;
import com.example.security.services.ProcessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/rpa")
public class ProcessController {

    @Autowired
    private ProcessService processService;

    @PostMapping
    public ResponseEntity<Process> createProcess(@RequestBody CreateProcessDto dto, Authentication authentication) {

        Process process = processService.createProcess(dto, authentication);

        return new ResponseEntity<>(process, HttpStatus.OK);
    }
}
