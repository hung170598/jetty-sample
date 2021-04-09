package com.tp.jettysample.storage;

import javax.ws.rs.core.Response;

import com.google.inject.ImplementedBy;
import com.tp.jettysample.model.User;

public interface UserStorage {
	public Response insertCsv();
	public Response insertUser(User user);
	public Response deleteUser(String username);
}
