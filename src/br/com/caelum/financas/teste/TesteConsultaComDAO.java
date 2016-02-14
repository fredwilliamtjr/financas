/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDao;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author fredw
 */
public class TesteConsultaComDAO {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        EntityManager manager = new JPAUtil().getEntityManager();
        Conta conta = manager.find(Conta.class, 2);//id 2 deve existir no banco


        MovimentacaoDao dao = new MovimentacaoDao(manager);
        Double media = dao.mediaDaConta(conta);
        System.out.println("Media da conta: "+conta.getNumero()+" de: "+conta.getTitular()+" é: R$ "+media);
        System.exit(0);

    }

}
