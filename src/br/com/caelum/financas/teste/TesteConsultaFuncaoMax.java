/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author fredw
 */
public class TesteConsultaFuncaoMax {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EntityManager manager = new JPAUtil().getEntityManager();
        Conta conta = manager.find(Conta.class, 2);//id 2 deve existir no banco

        TypedQuery<BigDecimal> query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);

        query.setParameter("pConta", conta);
        BigDecimal valorTotal = query.getSingleResult();
        System.out.println("Total de movimentações: " + valorTotal);
    }

}
