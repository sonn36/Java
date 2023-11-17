package modelo;

import DAL.EstacaoDAO;

public class Controle
{

    public String mensagem;
    
    public Controle(){
        
        
        
    }


    public Estacao pesquisarEstacao(){
        
        Estacao estacao = new Estacao();
        EstacaoDAO estacaoDAO = new EstacaoDAO();
        estacao = estacaoDAO.pesquisarEstacao(estacao);
        
        
        return estacao;
        
    }

}
