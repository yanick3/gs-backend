package br.com.fiap.main;

import br.com.fiap.beans.Usuario;
import br.com.fiap.dao.UsuarioDAO;

import javax.swing.*;

public class TesteInserir {

    static String texto(String j){
        return JOptionPane.showInputDialog(j);
    }

    static int inteiro(String j){
        return Integer.parseInt(JOptionPane.showInputDialog(j));
    }

    public static void main(String[] args) {

        try {
            UsuarioDAO usuarioDAO = new UsuarioDAO();
            Usuario objUsuario = new Usuario();

            objUsuario.setNome(texto("Nome do usuário"));
            objUsuario.setIdade(inteiro("Idade do usuário"));
            objUsuario.setAreaInteresse(texto("Área de Interesse"));
            objUsuario.setHorasSemanais(inteiro("Horas Semanais"));

            usuarioDAO.inserir(objUsuario);

            System.out.println("Usuário inserido com sucesso.");

        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao inserir: " + e.getMessage());
        }
    }
}
