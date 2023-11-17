package modelo;

//https://fazecast.github.io/jSerialComm/
//https://github.com/Fazecast/jSerialComm/wiki/Usage-Examples

import DAL.EstacaoDAO;
import com.fazecast.jSerialComm.*;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Serial implements Runnable
{
    

    @Override
    public void run()
    {
        executar();
    }

    public void executar()
    {
        String leitura = "";
        
            String[] valores = new String[3];
            SerialPort comPort = SerialPort.getCommPort("COM4");
            comPort.openPort();
            comPort.setComPortTimeouts(SerialPort.TIMEOUT_READ_SEMI_BLOCKING, 0, 0);
            InputStream in = comPort.getInputStream();
            while(Estaticos.coletaSerial){
                     try
        {
                leitura += (char) in.read();
                if (leitura.charAt(leitura.length()-1) == '\n')
                {
               
                    valores = leitura.split(",");
                    System.out.print(valores[0] + " - " + valores [1] + " - " + valores[2]);
                    Estaticos.umidade = valores[0];
                    Estaticos.temperatura = valores[1];
                    Estaticos.precipitacao = valores[2];
                    
                    leitura = "";
                    
                    cadastrarEstacao();
                    
                    
                }
        }
                    catch (SerialPortInvalidPortException e)
        {
            System.out.println("Erro");
        }   catch (IOException ex) {
                Logger.getLogger(Serial.class.getName()).log(Level.SEVERE, null, ex);
            }
            }
            
            comPort.closePort();
        }
        
        
    
    
    
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
