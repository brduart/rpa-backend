package com.example.security.services;

import com.example.security.dto.process.CreateProcessDto;
import com.example.security.entities.Process;
import com.example.security.entities.Status;
import com.example.security.entities.User;
import com.example.security.repositories.ProcessRepository;
import com.example.security.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class ProcessService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProcessRepository processRepository;

    public Process createProcess(CreateProcessDto dto, Authentication authentication) {

        User actualUser = (User) userRepository.findByName(authentication.getName());

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate dataAgendada = LocalDate.parse(dto.getDataHoraAgendada(), formatter);
        System.out.println("Data formatada: " + dataAgendada);


        Process process = new Process();
        process.setNomeRpa(dto.getNomeRpa());
        process.setStatus(Status.PENDENTE);
        process.setDataHoraAgendada(dataAgendada);
        process.setDataHoraInicio(null);
        process.setDataHoraFinalizacao(null);
        process.setMsgErro("");
        process.setIdioma(dto.getIdioma());
        process.setUser(actualUser);

        processRepository.save(process);

        return process;
    }
}
