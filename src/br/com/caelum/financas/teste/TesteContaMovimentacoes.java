package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;

public class TesteContaMovimentacoes {

	public static void main(String[] args) {

		EntityManager manager = new JPAUtil().getEntityManager();

		Conta conta = manager.find(Conta.class, 2); // id deve existir
		
		manager.createNativeQuery("select c from Conta c join fetch c.movimentacoes ");
		
		
		System.out.println(conta.getMovimentacoes().size());
		
		manager.close();

	}
}
