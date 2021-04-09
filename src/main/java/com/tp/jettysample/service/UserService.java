package com.tp.jettysample.service;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.tp.jettysample.model.User;
import com.tp.jettysample.storage.UserStorage;
import com.tp.jettysample.storage.UserStorageImpl;

@Singleton
@Path("/users")
public class UserService {

	@Inject
	private UserStorageImpl userStorage;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserInfo(@QueryParam("username") String username) {
		return Response.status(Response.Status.OK).entity(username).build();
	}

	@POST
	@Path("insertCsv")
	@Produces(MediaType.APPLICATION_JSON)
	public Response insertCsv() {
		return userStorage.insertCsv();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response resgisterUser(User user) {
		try {
			userStorage.insertUser(user);
			return Response.status(Response.Status.OK).entity(user).build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.notModified(e.getMessage()).build();
		}
	}

	@DELETE
	@Produces(MediaType.APPLICATION_JSON)
	public Response deleteUser(@QueryParam("username") String username) {
		try {
			userStorage.deleteUser(username);
			return Response.status(Response.Status.OK).entity("Deleted!").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.notModified(e.getMessage()).build();
		}
	}
}
