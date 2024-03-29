/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import modelo.Estacao;
import org.hibernate.Query;
import org.hibernate.Session;

/**
 *
 * @author dudus
 */
public class EstacaoDAO {
    
    public String mensagem;
    Session session = Conexao.getSessionFactory().openSession();
    
    public void cadastroEstacao(Estacao estacao)
    {
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            session.save(estacao);
            session.getTransaction().commit();
            session.close();
            this.mensagem = "Cadastro efetuado com sucesso!";
        } catch (Exception e)
        {
            this.mensagem = "Erro de Banco de dados!";
        }
    }
}
