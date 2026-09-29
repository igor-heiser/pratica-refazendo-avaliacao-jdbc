package org.ctw.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AlertaMotor {
    private Integer id;
    private Integer motorId;
    private LocalDateTime dataAlerta;
    private String tipoAnomalia;
    private String criticidade;
    private String descricao;
    private boolean resolvido;

    public AlertaMotor() {
    }

    public AlertaMotor(Integer id, Integer motorId, LocalDateTime dataAlerta, String tipoAnomalia, String criticidade, String descricao, boolean resolvido) {
        this.id = id;
        this.motorId = motorId;
        this.dataAlerta = dataAlerta;
        this.tipoAnomalia = tipoAnomalia;
        this.criticidade = criticidade;
        this.descricao = descricao;
        this.resolvido = resolvido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMotorId() {
        return motorId;
    }

    public void setMotorId(Integer motorId) {
        this.motorId = motorId;
    }

    public LocalDateTime getDataAlerta() {
        return dataAlerta;
    }

    public void setDataAlerta(LocalDateTime dataAlerta) {
        this.dataAlerta = dataAlerta;
    }

    public String getTipoAnomalia() {
        return tipoAnomalia;
    }

    public void setTipoAnomalia(String tipoAnomalia) {
        this.tipoAnomalia = tipoAnomalia;
    }

    public String getCriticidade() {
        return criticidade;
    }

    public void setCriticidade(String criticidade) {
        this.criticidade = criticidade;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isResolvido() {
        return resolvido;
    }

    public void setResolvido(boolean resolvido) {
        this.resolvido = resolvido;
    }

    @Override
    public String toString() {
        return "AlertaMotor{" +
                "id=" + id +
                ", motorId=" + motorId +
                ", dataAlerta=" + dataAlerta +
                ", tipoAnomalia='" + tipoAnomalia + '\'' +
                ", criticidade='" + criticidade + '\'' +
                ", descricao='" + descricao + '\'' +
                ", resolvido=" + resolvido +
                '}';
    }
}