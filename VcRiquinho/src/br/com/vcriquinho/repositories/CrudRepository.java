package br.com.vcriquinho.repositories;

import java.util.List;

public interface CrudRepository<T> {
	
	void salvar(T dado);
	T lerDadoId(int id);
	List<T> listarDados();
	void atualizarDado(T produto);
	void deletarDado(int id);
}
