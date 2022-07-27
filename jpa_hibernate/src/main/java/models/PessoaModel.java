package models;

import entities.Pessoa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class PessoaModel {
    public void create(Pessoa pessoa) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(pessoa);
            em.getTransaction().commit();
            System.out.println("Pessoa criada com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Pessoa pessoa) {
        //TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Pessoa pessoaRetornada = em.find(Pessoa.class, pessoa.getId());
            em.getTransaction().begin();
            pessoaRetornada.setNome(pessoa.getNome());
            pessoaRetornada.setEmail(pessoa.getEmail());
            pessoaRetornada.setCpf(pessoa.getCpf());
            pessoaRetornada.setIdade(pessoa.getIdade());
            pessoaRetornada.setDataDeNascimento(pessoa.getDataDeNascimento());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void delete(Pessoa pessoa) {
        //TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();
            em.remove(em.contains(pessoa) ? pessoa : em.merge(pessoa));
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro ao remover a pessoa !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public Pessoa findById(Pessoa pessoa) {
        //TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Pessoa pessoaRetornada = em.find(Pessoa.class, pessoa.getId());
            return pessoaRetornada;
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }

        return null;
    }

    public List<Pessoa> findAll() {

        List<Pessoa> pessoas;
        //TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        pessoas = em.createQuery("FROM Pessoa").getResultList();

        em.close();
        emf.close();
        return pessoas;
    }


}
