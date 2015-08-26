package br.edu.cesufoz.aulaejb.quick.session;

import javax.ejb.Stateless;

/**
 * 
 */
@Stateless
public class UsuarioSession implements 
							UsuarioSessionRemote, 
							UsuarioSessionLocal {
	
    @Override
    public void salvar() {
    	System.out.println("Usuario Salvo com sucesso. :D ");
    }

	@Override
	public void remove() {
		System.out.println("Usuario removido com sucesso.");
	}

	@Override
	public void list() {
		System.out.println("Listando usuarios...");
	}

	@Override
	public void relatorio() {
		System.out.println("Relatorios de usuarios. :) -> ");
	}
}
