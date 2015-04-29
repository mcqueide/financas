package br.com.caelum.financas.teste;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import br.com.caelum.financas.modelo.Conta;

public class TesteJPA {

	public static void main(String[] args) {

		Conta conta = new Conta();
		conta.setTitular("Joao Ferreira");
		conta.setBanco("HSBC");
		conta.setNumero("123345");
		conta.setAgencia("321");

		EntityManagerFactory entityManagerFactory = Persistence
				.createEntityManagerFactory("financas");

		EntityManager manager = entityManagerFactory.createEntityManager();

		manager.getTransaction().begin();
		manager.persist(conta);
		manager.getTransaction().commit();

		manager.close();

	}

}
