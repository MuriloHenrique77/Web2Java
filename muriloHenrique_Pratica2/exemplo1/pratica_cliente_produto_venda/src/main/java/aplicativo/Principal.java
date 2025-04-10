package aplicativo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dominio.Cliente;
import dominio.Produto;
import dominio.Venda;

public class Principal {

    public static void main(String[] args) {
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula-jpa");;
        EntityManager em = null;
        
        try {
            
            
            em = emf.createEntityManager();
            
            em.getTransaction().begin();
    
            
            Produto p1 = new Produto("Memoria Ram (8gb)", 230);
            Produto p2 = new Produto("GTX 1650", 610);
            Produto p3 = new Produto("Processador i5", 450);
            Produto p4 = new Produto("Mouse Gamer", 190);
            
            
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);

            
            Cliente c1 = new Cliente("Murilo");
            Cliente c2 = new Cliente("Marcelo");
            Cliente c3 = new Cliente("Marcos");
            Cliente c4 = new Cliente("Mario");
            
            
            em.persist(c1);
            em.persist(c2);
            em.persist(c3);
            em.persist(c4);

            
            Venda v1 = new Venda(230 + 610); 
            Venda v2 = new Venda(230 + 190); 
            Venda v3 = new Venda(190); 
            Venda v4 = new Venda(230 + 450); 
            
            
            v1.setProdutos(Arrays.asList(p1, p2));
            v2.setProdutos(Arrays.asList(p2, p4));
            v3.setProdutos(Arrays.asList(p4));
            v4.setProdutos(Arrays.asList(p3, p1));
            
            
            v1.setCliente(c1);
            v2.setCliente(c2);
            v3.setCliente(c3);
            v4.setCliente(c4);
            
           
            c1.setVendas(Arrays.asList(v1));
            c2.setVendas(Arrays.asList(v2));
            c3.setVendas(Arrays.asList(v3));
            c4.setVendas(Arrays.asList(v4));

            
            em.persist(v1);
            em.persist(v2);
            em.persist(v3);
            em.persist(v4);
            
            em.getTransaction().commit(); 
            
        } catch (Exception e) {
            if (em.getTransaction() != null) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            if (em != null) {
                em.close();
            }
            if (emf != null) {
                emf.close();
            }
        }
    }
}

