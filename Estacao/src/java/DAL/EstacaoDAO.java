package DAL;

import modelo.Estacao;
import org.hibernate.Query;
import org.hibernate.Session;

public class EstacaoDAO
{

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
    
    public Estacao pesquisarEstacao(Estacao estacao){
        
        this.mensagem = "";
        try
        {
            session.beginTransaction();
            Query query = session.createQuery("from Estacao order by horarioCadastro DESC");
            query.setMaxResults(1);
            estacao = (Estacao) query.uniqueResult();
            session.close();
            this.mensagem = "Cadastro efetuado com sucesso!";
        } catch (Exception e)
        {
            this.mensagem = "Erro de Banco de dados!";
        }
        
        return estacao;
    }

}
