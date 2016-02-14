/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;


import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredw
 */
public class TesteJPA {

    public static void main(String[] args) {

        double inicio = System.currentTimeMillis();

        Conta conta = new Conta();
        conta.setId(4);
        conta.setTitular("William");
        conta.setBanco("Caixa");
        conta.setNumero("270989-0");
        conta.setAgencia("0567");
//        conta.setSaldo(new BigDecimal(534.98));

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();
        
        Conta contaARemover = manager.find(Conta.class, 4);

        manager.remove(contaARemover);

        manager.getTransaction().commit();

        manager.close();

        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");
        
        System.exit(0);

    }

}
