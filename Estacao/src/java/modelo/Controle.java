package modelo;

import DAL.EstacaoDAO;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Controle
{

    public String mensagem;
    
    public Controle(){
        
        if(!Estaticos.coletaSerial){
            iniciarColeta();
        }
        
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask()
        {
            
            public void run()
            {
                cadastrarEstacao();
            }
        }, 1000, 60000);
    }
    
    public void iniciarColeta(){
        
        Estaticos.coletaSerial = true;
        Serial serial = new Serial();
        Thread s1 = new Thread(serial);
        s1.start();
    
    }
    
    public void cadastrarEstacao(){        
        Validacao validacao = new Validacao();
        validacao.validardadosEstacao();
        if(validacao.mensagem.isEmpty()){
            Estacao estacao = new Estacao();
            estacao.setTemperatura(validacao.temperatura);
            estacao.setUmidade(validacao.umidade);
            estacao.setPrecipitacao(Estaticos.precipitacao);
            
            EstacaoDAO estacaoDAO = new EstacaoDAO();
            estacaoDAO.cadastroEstacao(estacao);
            this.mensagem = estacaoDAO.mensagem;
        }
    }

    public void pesquisarEstacao(){
        
    }

}
