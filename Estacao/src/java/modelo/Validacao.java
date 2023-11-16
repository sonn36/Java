package modelo;

import java.util.List;

public class Validacao
{
    
    public String mensagem;
    public Double temperatura;
    public Double umidade;
    
    
    public void validardadosEstacao()
    {
        this.mensagem = "";
        try {
            this.temperatura = Double.valueOf(Estaticos.temperatura);
            this.umidade = Double.valueOf(Estaticos.umidade);
        } catch (Exception e) {
            this.mensagem = "Erro ao validar dados";
        }
        
    }
    
}
