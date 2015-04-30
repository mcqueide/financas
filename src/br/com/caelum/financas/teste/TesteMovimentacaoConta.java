package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteMovimentacaoConta {

	public static void main(String[] args) {
		
		EntityManager manager = new JPAUtil().getEntityManager();
		
		Movimentacao movimentacao = manager.find(Movimentacao.class, 1);
		
		Query query = manager.createQuery("select m from Movimentacao m"
				+ " where m=:movimentacao");
		query.setParameter("movimentacao", movimentacao);
		
		List<Movimentacao> lista = query.getResultList();
		
		for (Movimentacao mov : lista) {
			System.out.println(mov.getConta().getTitular());
		}
				
	}
	
}
