/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;


import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author fredw
 */
public class TesteJPARelacionamento {

    public static void main(String[] args) {

        double inicio = System.currentTimeMillis();

        Conta conta = new Conta();
//        conta.setId(5);
        conta.setTitular("William");
        conta.setBanco("Caixa");
        conta.setNumero("270989-0");
        conta.setAgencia("0567");
//        conta.setSaldo(new BigDecimal(534.98));

        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de Telefone");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("100.99"));
        
        movimentacao.setConta(conta);

        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();
        
        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();
        manager.close();

        double fim = System.currentTimeMillis();
        System.out.println("Executado em: " + (fim - inicio) / 1000 + "s");
        
        System.exit(0);

    }

}
