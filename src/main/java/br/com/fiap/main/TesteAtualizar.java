package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;

public class TesteAtualizar {

    // String
    static String texto(String j) {
        return JOptionPane.showInputDialog(j);
    }

    // int
    static int inteiro(String j) {
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) {

        try {
            Usuario objUsuario = new Usuario();
            UsuarioDAO usuarioDao = new UsuarioDAO();

            objUsuario.setId(inteiro("Informe o ID do usuário a ser atualizado"));
            objUsuario.setNome(texto("Atualize o Nome"));
            objUsuario.setIdade(inteiro("Atualize a Idade"));
            objUsuario.setAreaInteresse(texto("Atualize a Área de Interesse"));
            objUsuario.setHorasSemanais(inteiro("Atualize as Horas Semanais"));

            usuarioDao.atualizar(objUsuario);

            System.out.println("Usuário atualizado com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + e.getMessage());
        }

    }
}
