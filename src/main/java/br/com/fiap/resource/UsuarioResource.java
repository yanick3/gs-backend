package br.com.fiap.resource;

import br.com.fiap.beans.Usuario;
import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.dao.UsuarioDAO;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/usuarios")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class UsuarioResource {

    private UsuarioDAO dao = new UsuarioDAO();
    private UsuarioBO bo = new UsuarioBO();

    @GET
    public List<Usuario> listar() throws Exception {
        return dao.listar();
    }

    @GET
    @Path("/{id}")
    public Response buscar(@PathParam("id") int id) {
        try {
            Usuario u = dao.buscarPorId(id);
            if (u == null) return Response.status(404).build();
            return Response.ok(u).build();
        } catch (Exception e) {
            return Response.status(500).build();
        }
    }

    @POST
    public Response cadastrar(Usuario u) {
        try {
            bo.cadastrar(u);
            return Response.status(201).entity(u).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    @PUT
    @Path("/{id}")
    public Response atualizar(@PathParam("id") int id, Usuario u) {
        try {
            u.setId(id);
            bo.atualizar(u);
            return Response.ok(u).build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }

    @DELETE
    @Path("/{id}")
    public Response deletar(@PathParam("id") int id) {
        try {
            bo.deletar(id);
            return Response.ok().build();
        } catch (Exception e) {
            return Response.status(400).build();
        }
    }
}
