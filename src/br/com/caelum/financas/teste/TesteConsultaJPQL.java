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
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author fredw
 */
public class TesteConsultaJPQL {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(2);

        Query query = manager.createQuery("select m from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo ");

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.SAIDA);

        List<Movimentacao> movimentacoes = query.getResultList();

        for (Movimentacao mov : movimentacoes) {
            System.out.println("Descrição:.......: " + mov.getDescricao());
            System.out.println("Valor:...........: " + mov.getValor());
            System.out.println("Tipo:............: " + mov.getTipoMovimentacao());
        }

//            int i = 0;
//            do {
//                System.out.println("Descrição:.......: " + movimentacoes.get(i).getDescricao());
//                System.out.println("Valor:...........: " + movimentacoes.get(i).getValor());
//                i = i + 1;
//            } while (i < movimentacoes.size());

//        int i = 0;
//        while (i < movimentacoes.size()) {
//            System.out.println("Descrição:.......: " + movimentacoes.get(i).getDescricao() + "");
//            System.out.println("Valor:...........: " + movimentacoes.get(i).getValor() + "");
//            i = i +1;
//        }

        
        
        
        
        
        
        
        System.exit(0);
    }

}
