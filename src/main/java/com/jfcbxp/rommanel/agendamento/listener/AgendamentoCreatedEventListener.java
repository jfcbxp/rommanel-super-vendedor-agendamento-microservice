package com.jfcbxp.rommanel.agendamento.listener;

import com.jfcbxp.rommanel.agendamento.dto.VendedorDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Component
@Slf4j
@RequiredArgsConstructor
public class AgendamentoCreatedEventListener implements Consumer<VendedorDTO> {

    @Override
    public void accept(VendedorDTO vendedorDTO) {
        log.info("Recebido solicitação de processamento de agendamento para o vendedor {} ",vendedorDTO.getCodigo());
    }
}
