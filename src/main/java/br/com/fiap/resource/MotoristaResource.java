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

import br.com.fiap.bo.MotoristaBO;
import br.com.fiap.to.MotoristaTO;

@Path("/motorista")
public class MotoristaResource {
	
	MotoristaBO mb = new MotoristaBO();

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<MotoristaTO> buscar() {
		return mb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public MotoristaTO buscar(@PathParam("id") int id) {
		return mb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(MotoristaTO motorista, @Context UriInfo uriInfo) {
		mb.cadastrar(motorista);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(motorista.getId()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(MotoristaTO motorista, @PathParam("id") int id) {
		motorista.setId(id);
		mb.atualiza(motorista);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		mb.remover(id);
	}

}
