package com.jfcbxp.rommanel.agendamento.repository.impl;

import com.jfcbxp.rommanel.agendamento.repository.AgendamentoRepositoryCustom;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

public class AgendamentoRepositoryCustomImpl implements AgendamentoRepositoryCustom {
    @PersistenceContext(unitName = "agendamentoEntityManager")
    private EntityManager em;

    @Override
    @Transactional
    public void atualizarAgendamento(String codigoVendedor) {
        var updateCab = new StringBuilder()
                .append("UPDATE SL1010 SET ")
                .append("L1_ZFPGDES = :forma, ")
                .append("L1_ZPARDES = :parcela ")
                .append("WHERE L1_NUM = :numero AND L1_FILIAL = :empresa ");

        em.clear();

    }


}
