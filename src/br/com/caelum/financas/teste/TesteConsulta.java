package br.com.caelum.financas.teste;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;

public class TesteConsulta {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = new Conta();
		conta.setId(1);

		/*Query query = manager.createQuery("select m from Movimentacao m where m.conta=?1"
				+ " and m.tipoMovimentacao=?2");
		query.setParameter(1, conta);
		query.setParameter(2, TipoMovimentacao.ENTRADA);*/
		
		Query query = manager.createQuery("select m from Movimentacao m where m.conta=:conta"
				+ " and m.tipoMovimentacao=:tipoMovimentacao"
				+ " order by m.valor desc");
		query.setParameter("conta", conta);
		query.setParameter("tipoMovimentacao", TipoMovimentacao.SAIDA);
		
		List<Movimentacao> movimentacoes = query.getResultList();
		
		for (Movimentacao movimentacao : movimentacoes) {
			System.out.println("\nDescricao ..: " + movimentacao.getDescricao());
			System.out.println("Valor ......: R$ " + movimentacao.getValor());
		}
		
		manager.close();

	}

}
