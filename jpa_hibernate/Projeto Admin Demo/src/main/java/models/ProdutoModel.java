package models;

import entities.Produto;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProdutoModel {

    public void create(Produto p) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            System.out.println("Iniciando a transação");
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            System.out.println("Produto criado com sucesso !!!");
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao criar o produto !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
            System.out.println("Finalizando a transação");
        }
    }

    public void update(Produto p) {
        //TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Produto produtoRetornado = em.getReference(Produto.class, p.getId());
            em.getTransaction().begin();
            produtoRetornado.setNome(p.getNome());
            produtoRetornado.setPreco(p.getPreco());
            produtoRetornado.setQuantidade(p.getQuantidade());
            produtoRetornado.setStatus(p.isStatus());
            em.getTransaction().commit();
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public void delete(Produto p) {
        //TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Produto produtoNoBD = findById(p);
            em.getTransaction().begin();
            em.remove(produtoNoBD);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.close();
            System.err.println("Erro ao remover o produto !!!" + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
    }

    public Produto findById(Produto p) {
        //TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        try {
            Produto produtoRetornado = em.find(Produto.class, p.getId());
            return produtoRetornado;
        } catch (Exception e) {
            System.err.println("Erro: " + e.getMessage());
        } finally {
            em.close();
            emf.close();
        }
        return null;
    }

    public List<Produto> findAll() {

        List<Produto> produtos;
        //TODO
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("admin-jpa");
        EntityManager em = emf.createEntityManager();

        produtos = em.createQuery("FROM Produto").getResultList();

        em.close();
        emf.close();
        return produtos;
    }
}
