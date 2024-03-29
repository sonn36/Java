/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import DAL.EstacaoDAO;
import java.util.Date;

/**
 *
 * @author dudus
 */
public class Controle {
    
    
    public void cadastrarEstacao(){        
        Validacao validacao = new Validacao();
        validacao.validardadosEstacao();
        if(validacao.mensagem.isEmpty()){
            Estacao estacao = new Estacao();
            estacao.setTemperatura(validacao.temperatura);
            estacao.setUmidade(validacao.umidade);
            estacao.setPrecipitacao(Estaticos.precipitacao);
            
            long millis = System.currentTimeMillis();
            estacao.setHorarioCadastro(new Date(millis));
            
            EstacaoDAO estacaoDAO = new EstacaoDAO();
            estacaoDAO.cadastroEstacao(estacao);
        }
    }
}
