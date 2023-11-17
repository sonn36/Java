package managedBeans;

import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import modelo.Controle;
import modelo.Estacao;
import modelo.Estaticos;
import modelo.Serial;

@ManagedBean
@RequestScoped
public class brgIndex
{

    private String temperatura;
    private String umidade;
    private String precipitacao;
    private String resposta;
    
    
    

    public brgIndex()
    {     
        if(!Estaticos.coletaSerial){
            Estaticos.coletaSerial = true;
            Serial serial = new Serial();
            Thread s1 = new Thread(serial);
            s1.start();
            
            
            
        }
        Controle controle = new Controle();
        
        Estacao estacao  = new Estacao();
        estacao = controle.pesquisarEstacao();
        temperatura = String.valueOf(estacao.getTemperatura());
        umidade = String.valueOf(estacao.getUmidade());
        precipitacao = estacao.getPrecipitacao();
                
        
        
        
    }
    
    
    
    
    
    
   
    public String getTemperatura()
    {
        return temperatura;
    }

    public void setTemperatura(String temperatura)
    {
        this.temperatura = temperatura;
    }

    public String getUmidade()
    {
        return umidade;
    }

    public void setUmidade(String umidade)
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

    public String getResposta()
    {
        return resposta;
    }

    public void setResposta(String resposta)
    {
        this.resposta = resposta;
    }

}
