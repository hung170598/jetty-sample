package com.tp.jettysample.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.tp.jettysample.model.User;

@Path("/users")
public class UserService {
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserInfo(@QueryParam("username") String username) {
		return Response
				.status(Response.Status.OK)
				.entity(username)
				.build();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response resgisterUser(User user) {
		System.out.println("Saved!");
		return Response
				.status(Response.Status.OK)
				.entity(user)
				.build();
	}
}
