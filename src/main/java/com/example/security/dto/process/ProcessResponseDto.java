package com.example.security.dto.process;

import com.example.security.entities.Status;

public class ProcessResponseDto {
    private String nome_rpa;
    private Status status;
    private String data_hora_agendada;
    private String data_hora_inicio;
    private String data_hora_finalizacao;
    private String msg_erro;
    private String idioma;
}
