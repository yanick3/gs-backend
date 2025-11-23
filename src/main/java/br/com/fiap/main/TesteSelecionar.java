package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import java.util.List;

public class TesteSelecionar {

    public static void main(String[] args) {

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();

            List<Usuario> listaUsuarios = usuarioDAO.listar();

            if (listaUsuarios != null) {
                for (Usuario usuario : listaUsuarios) {
                    System.out.println(
                            usuario.getId() + " " +
                                    usuario.getNome() + " " +
                                    usuario.getIdade() + " " +
                                    usuario.getAreaInteresse() + " " +
                                    usuario.getHorasSemanais() + "\n"
                    );
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Erro ao selecionar usuários.");
        }
    }
}
