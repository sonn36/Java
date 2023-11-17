/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author dudus
 */
@Entity
@Table(name = "estacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Estacao.findAll", query = "SELECT e FROM Estacao e"),
    @NamedQuery(name = "Estacao.findByIdEstacao", query = "SELECT e FROM Estacao e WHERE e.idEstacao = :idEstacao"),
    @NamedQuery(name = "Estacao.findByTemperatura", query = "SELECT e FROM Estacao e WHERE e.temperatura = :temperatura"),
    @NamedQuery(name = "Estacao.findByUmidade", query = "SELECT e FROM Estacao e WHERE e.umidade = :umidade"),
    @NamedQuery(name = "Estacao.findByPrecipitacao", query = "SELECT e FROM Estacao e WHERE e.precipitacao = :precipitacao"),
    @NamedQuery(name = "Estacao.findByHorarioCadastro", query = "SELECT e FROM Estacao e WHERE e.horarioCadastro = :horarioCadastro")})
public class Estacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstacao")
    private Integer idEstacao;
    @Basic(optional = false)
    @Column(name = "Temperatura")
    private double temperatura;
    @Basic(optional = false)
    @Column(name = "Umidade")
    private double umidade;
    @Basic(optional = false)
    @Column(name = "Precipitacao")
    private String precipitacao;
    @Basic(optional = false)
    @Column(name = "HorarioCadastro")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horarioCadastro;

    public Estacao() {
    }

    public Estacao(Integer idEstacao) {
        this.idEstacao = idEstacao;
    }

    public Estacao(Integer idEstacao, double temperatura, double umidade, String precipitacao, Date horarioCadastro) {
        this.idEstacao = idEstacao;
        this.temperatura = temperatura;
        this.umidade = umidade;
        this.precipitacao = precipitacao;
        this.horarioCadastro = horarioCadastro;
    }

    public Integer getIdEstacao() {
        return idEstacao;
    }

    public void setIdEstacao(Integer idEstacao) {
        this.idEstacao = idEstacao;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getUmidade() {
        return umidade;
    }

    public void setUmidade(double umidade) {
        this.umidade = umidade;
    }

    public String getPrecipitacao() {
        return precipitacao;
    }

    public void setPrecipitacao(String precipitacao) {
        this.precipitacao = precipitacao;
    }

    public Date getHorarioCadastro() {
        return horarioCadastro;
    }

    public void setHorarioCadastro(Date horarioCadastro) {
        this.horarioCadastro = horarioCadastro;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstacao != null ? idEstacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacao)) {
            return false;
        }
        Estacao other = (Estacao) object;
        if ((this.idEstacao == null && other.idEstacao != null) || (this.idEstacao != null && !this.idEstacao.equals(other.idEstacao))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "modelo.Estacao[ idEstacao=" + idEstacao + " ]";
    }
    
}
