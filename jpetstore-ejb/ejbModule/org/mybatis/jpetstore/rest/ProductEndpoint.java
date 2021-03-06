package org.mybatis.jpetstore.rest;


import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.mybatis.jpetstore.exceptions.QueryParamInvalidException;
import org.mybatis.jpetstore.facades.Product;
import org.mybatis.jpetstore.facades.ProductBean;

@Path("/products")
@Produces("application/json")
@Consumes("application/json")
public class ProductEndpoint {
	
	@Inject
	ProductBean productBean;
	
	@GET
	public Response listAll()
	{
		List<Product> produtos = productBean.getProducts();
		Map<String, List<Product>> response = new WeakHashMap<String, List<Product>>();
		response.put("produtos", produtos);
		
		return Response.status(Response.Status.OK).entity(response).build();
	}
	
	@GET
	@Path("/query")
	public Response paginated(@QueryParam("start") final Integer startPosition, 
			                  @QueryParam("max") final Integer maxResult) 
	{
		if(maxResult == 0 || startPosition == 0) {
		   	
		   	throw new QueryParamInvalidException("Parâmetro não pode ser igual a 0");
		   	
		}
		
		List<Product> produtos = productBean.getProductsPaginated(startPosition, maxResult);		
		
		return Response.status(Response.Status.OK).entity(produtos).build();
	}
	
}
