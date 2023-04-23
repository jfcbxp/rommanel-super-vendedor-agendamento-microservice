package com.jfcbxp.rommanel.agendamento.repository;

import com.jfcbxp.rommanel.agendamento.domain.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgendamentoRepository extends JpaRepository<Agendamento, String>, AgendamentoRepositoryCustom {
    Optional<Agendamento> findByCodigoVendedor(String codigoVendedor);
}
