package br.com.fiap.resource;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;

import br.com.fiap.bo.UsuarioBO;
import br.com.fiap.to.UsuarioTO;

@Path("/usuario")
public class UsuarioResource {

	UsuarioBO ub = new UsuarioBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioTO> buscar() {
		return ub.listar();
	}

	@GET
	@Path("/{rm}")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioTO buscar(@PathParam("rm") int rm) {
		return ub.listar(rm);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(UsuarioTO usuario, @Context UriInfo uriInfo) {
		ub.cadastrar(usuario);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(usuario.getRM()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{rm}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(UsuarioTO usuario, @PathParam("rm") int rm) {
		usuario.setRM(rm);
		ub.atualiza(usuario);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{rm}")
	public void excluir(@PathParam("rm") int rm) {
		ub.remover(rm);
	}

}
