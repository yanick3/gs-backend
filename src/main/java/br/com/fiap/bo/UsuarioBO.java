package br.com.fiap.bo;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

public class UsuarioBO {

    private UsuarioDAO dao = new UsuarioDAO();

    public void cadastrar(Usuario u) throws Exception {
        if (u.getNome() == null || u.getNome().isEmpty()) {
            throw new Exception("Nome obrigatório");
        }
        if (u.getIdade() <= 0) {
            throw new Exception("Idade inválida");
        }
        dao.inserir(u);
    }

    public void atualizar(Usuario u) throws Exception {
        if (u.getId() <= 0) {
            throw new Exception("ID inválido");
        }
        dao.atualizar(u);
    }

    public void deletar(int id) throws Exception {
        if (id <= 0) {
            throw new Exception("ID inválido");
        }
        dao.deletar(id);
    }
}
