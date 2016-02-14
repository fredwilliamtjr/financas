/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author fredw
 */
public class TesteContaMovimentacoes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EntityManager manager = new JPAUtil().getEntityManager();

//        Conta conta = manager.find(Conta.class, 2); //id deve existir
        Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes where c.id = :pId");
        query.setParameter("pId", 2);
        Conta conta = (Conta) query.getSingleResult();

        manager.close();

        System.out.println(conta.getMovimentacoes().size());

    }

}
