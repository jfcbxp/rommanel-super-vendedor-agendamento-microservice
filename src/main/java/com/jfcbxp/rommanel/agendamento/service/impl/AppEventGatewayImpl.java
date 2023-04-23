package com.jfcbxp.rommanel.agendamento.service.impl;

import com.jfcbxp.rommanel.agendamento.dto.VendedorDTO;
import com.jfcbxp.rommanel.agendamento.service.AppEventGateway;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class AppEventGatewayImpl implements AppEventGateway {

    private final StreamBridge streamBridge;

    @Override
    public void sendAgendamentoFinishedEvent(VendedorDTO vendedorDTO) {
        log.info("Enviando mensagem de finalização de processamento do vendedor {}",vendedorDTO.getCodigo());
        streamBridge.send("agendamentoFinishedEvent-out-0",vendedorDTO);


    }
}
