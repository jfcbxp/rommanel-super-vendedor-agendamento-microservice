package com.jfcbxp.rommanel.agendamento.service;

import com.jfcbxp.rommanel.agendamento.dto.VendedorDTO;

public interface AppEventGateway {

    void sendAgendamentoFinishedEvent(VendedorDTO vendedorDTO);

}
