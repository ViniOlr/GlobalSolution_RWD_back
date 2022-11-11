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

import br.com.fiap.bo.CarroBO;
import br.com.fiap.to.CarroTO;

@Path("/carro")
public class CarroResource {
	
	CarroBO cb = new CarroBO();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<CarroTO> buscar() {
		return cb.listar();
	}

	@GET
	@Path("/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public CarroTO buscar(@PathParam("id") int id) {
		return cb.listar(id);
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response cadastrar(CarroTO carro, @Context UriInfo uriInfo) {
		cb.cadastrar(carro);
		UriBuilder builder = uriInfo.getAbsolutePathBuilder();
		builder.path(Integer.toString(carro.getId()));
		return Response.created(builder.build()).build();
	}

	@PUT
	@Path("/{id}")
	@Consumes(MediaType.APPLICATION_JSON)
	public Response atualiza(CarroTO carro, @PathParam("id") int id) {
		carro.setId(id);
		cb.atualiza(carro);
		return Response.ok().build();
	}

	@DELETE
	@Path("/{id}")
	public void excluir(@PathParam("id") int id) {
		cb.remover(id);
	}

}
