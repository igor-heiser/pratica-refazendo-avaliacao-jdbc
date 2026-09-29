package org.ctw.service;

import org.ctw.dao.AlertaMotorDAO;
import org.ctw.exception.EntidadeNaoEncontradaException;
import org.ctw.model.AlertaMotor;

import java.time.LocalDateTime;
import java.util.List;

public class AlertaMotorService {
    private static final List<String> CRITICIDADES_VALIDAS =
            List.of(
                    "Baixa",
                    "Média",
                    "Alta",
                    "Crítica"
            );

    private final AlertaMotorDAO alertaDAO;
    private final MotorService motorService;

    public AlertaMotorService(
            AlertaMotorDAO alertaDAO,
            MotorService motorService
    ) {
        this.alertaDAO = alertaDAO;
        this.motorService = motorService;
    }

    public AlertaMotor cadastrar(AlertaMotor alerta) {
        validarAlerta(alerta);
        motorService.buscarPorId(alerta.getMotorId());

        alerta.setId(null);
        alerta.setDataAlerta(LocalDateTime.now());

        return alertaDAO.inserir(alerta);
    }

    public List<AlertaMotor> listarTodos() {
        return alertaDAO.listarTodos();
    }

    public List<AlertaMotor> listarNaoResolvidos() {
        return alertaDAO.listarNaoResolvidos();
    }

    public List<AlertaMotor> buscarPorCriticidade(String criticidade) {
        validarCriticidade(criticidade);

        return alertaDAO.buscarPorCriticidade(criticidade);
    }

    public void marcarComoResolvido(Integer alertaId) {
        validarId(alertaId);

        alertaDAO.marcarComoResolvido(alertaId);
    }

    private void validarAlerta(AlertaMotor alerta) {
        if (alerta.getMotorId() == null
                || alerta.getMotorId() <= 0) {

            throw new IllegalArgumentException(
                    "O ID do motor é obrigatório."
            );
        }

        if (alerta.getTipoAnomalia() == null
                || alerta.getTipoAnomalia().isBlank()) {

            throw new IllegalArgumentException(
                    "O tipo da anomalia é obrigatório."
            );
        }

        if (alerta.getDescricao() == null
                || alerta.getDescricao().isBlank()) {

            throw new IllegalArgumentException(
                    "A descrição é obrigatória."
            );
        }
    }

    private void validarCriticidade(String criticidade) {
        if (!CRITICIDADES_VALIDAS.contains(criticidade)) {
            throw new IllegalArgumentException(
                    "Critividade inválida. Valores permitidos: "
                            + CRITICIDADES_VALIDAS
            );
        }
    }

    private void validarId(Integer id) {
        if (id == null || id <= 0) {
            throw new IllegalArgumentException(
                    "O ID deve ser positivo."
            );
        }
    }
}
