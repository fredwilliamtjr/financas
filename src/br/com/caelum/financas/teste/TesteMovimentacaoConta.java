/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author fredw
 */
public class TesteMovimentacaoConta {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here

        EntityManager manager = new JPAUtil().getEntityManager();
        Movimentacao movimentacao = manager
                .find(Movimentacao.class, 2); // id 2 deve existir no banco
        
        System.out.println(movimentacao.getConta().getTitular());

    }

}
