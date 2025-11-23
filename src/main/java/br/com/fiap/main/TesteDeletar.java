package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;

public class TesteDeletar {

    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) {
        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario objUsuario = new Usuario();

            objUsuario.setId(inteiro("Informe o ID do usuário para ser deletado"));

            usuarioDAO.deletar(objUsuario.getId());

            System.out.println("Usuário deletado com sucesso.");
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao deletar: " + e.getMessage());
        }
    }
}
