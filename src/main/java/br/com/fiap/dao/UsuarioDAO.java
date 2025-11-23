package br.com.fiap.dao;

import br.com.fiap.beans.Usuario;
import br.com.fiap.conexoes.ConexaoFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {

    public void inserir(Usuario usuario) throws Exception {
        String sql = "INSERT INTO USUARIO (NOME, IDADE, AREA_INTERESSE, HORAS_SEMANAIS) VALUES (?, ?, ?, ?)";

        Connection con = new ConexaoFactory().conexao();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getNome());
        ps.setInt(2, usuario.getIdade());
        ps.setString(3, usuario.getAreaInteresse());
        ps.setInt(4, usuario.getHorasSemanais());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public List<Usuario> listar() throws Exception {
        List<Usuario> lista = new ArrayList<>();

        String sql = "SELECT * FROM USUARIO";

        Connection con = new ConexaoFactory().conexao();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Usuario u = new Usuario();
            u.setId(rs.getInt("ID"));
            u.setNome(rs.getString("NOME"));
            u.setIdade(rs.getInt("IDADE"));
            u.setAreaInteresse(rs.getString("AREA_INTERESSE"));
            u.setHorasSemanais(rs.getInt("HORAS_SEMANAIS"));
            lista.add(u);
        }

        rs.close();
        ps.close();
        con.close();

        return lista;
    }

    public Usuario buscarPorId(int id) throws Exception {
        String sql = "SELECT * FROM USUARIO WHERE ID = ?";

        Connection con = new ConexaoFactory().conexao();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ResultSet rs = ps.executeQuery();

        Usuario u = null;

        if (rs.next()) {
            u = new Usuario();
            u.setId(rs.getInt("ID"));
            u.setNome(rs.getString("NOME"));
            u.setIdade(rs.getInt("IDADE"));
            u.setAreaInteresse(rs.getString("AREA_INTERESSE"));
            u.setHorasSemanais(rs.getInt("HORAS_SEMANAIS"));
        }

        rs.close();
        ps.close();
        con.close();

        return u;
    }

    public void atualizar(Usuario usuario) throws Exception {
        String sql = "UPDATE USUARIO SET NOME=?, IDADE=?, AREA_INTERESSE=?, HORAS_SEMANAIS=? WHERE ID=?";

        Connection con = new ConexaoFactory().conexao();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setString(1, usuario.getNome());
        ps.setInt(2, usuario.getIdade());
        ps.setString(3, usuario.getAreaInteresse());
        ps.setInt(4, usuario.getHorasSemanais());
        ps.setInt(5, usuario.getId());

        ps.executeUpdate();

        ps.close();
        con.close();
    }

    public void deletar(int id) throws Exception {
        String sql = "DELETE FROM USUARIO WHERE ID=?";

        Connection con = new ConexaoFactory().conexao();
        PreparedStatement ps = con.prepareStatement(sql);

        ps.setInt(1, id);

        ps.executeUpdate();

        ps.close();
        con.close();
    }
}
