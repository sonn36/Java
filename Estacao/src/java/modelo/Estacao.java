/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author david
 */
@Entity
@Table(name = "estacao")
@XmlRootElement
@NamedQueries(
{
    @NamedQuery(name = "Estacao.findAll", query = "SELECT e FROM Estacao e"),
    @NamedQuery(name = "Estacao.findByIdEstacao", query = "SELECT e FROM Estacao e WHERE e.idEstacao = :idEstacao"),
    @NamedQuery(name = "Estacao.findByTemperatura", query = "SELECT e FROM Estacao e WHERE e.temperatura = :temperatura"),
    @NamedQuery(name = "Estacao.findByUmidade", query = "SELECT e FROM Estacao e WHERE e.umidade = :umidade"),
    @NamedQuery(name = "Estacao.findByPrecipitacao", query = "SELECT e FROM Estacao e WHERE e.precipitacao = :precipitacao")
})
public class Estacao implements Serializable
{
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idEstacao")
    private Integer idEstacao;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Temperatura")
    private Double temperatura;
    @Column(name = "Umidade")
    private Double umidade;
    @Column(name = "Precipitacao")
    private String precipitacao;

    public Estacao()
    {
    }

    public Estacao(Integer idEstacao)
    {
        this.idEstacao = idEstacao;
    }

    public Integer getIdEstacao()
    {
        return idEstacao;
    }

    public void setIdEstacao(Integer idEstacao)
    {
        this.idEstacao = idEstacao;
    }

    public Double getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(Double temperatura)
    {
        this.temperatura = temperatura;
    }

    public Double getUmidade()
    {
        return umidade;
    }

    public void setUmidade(Double umidade)
    {
        this.umidade = umidade;
    }

    public String getPrecipitacao()
    {
        return precipitacao;
    }

    public void setPrecipitacao(String precipitacao)
    {
        this.precipitacao = precipitacao;
    }

    @Override
    public int hashCode()
    {
        int hash = 0;
        hash += (idEstacao != null ? idEstacao.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object)
    {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Estacao))
        {
            return false;
        }
        Estacao other = (Estacao) object;
        if ((this.idEstacao == null && other.idEstacao != null) || (this.idEstacao != null && !this.idEstacao.equals(other.idEstacao)))
        {
            return false;
        }
        return true;
    }

    @Override
    public String toString()
    {
        return "modelo.Estacao[ idEstacao=" + idEstacao + " ]";
    }
    
}
