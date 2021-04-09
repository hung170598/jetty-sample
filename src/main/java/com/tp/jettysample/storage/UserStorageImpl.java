package com.tp.jettysample.storage;


import javax.ws.rs.core.Response;

import com.tp.jettysample.model.User;
import com.tptech.mysql.MysqlUtility;
import com.zaxxer.hikari.HikariConfig;

public class UserStorageImpl implements UserStorage{

	private MysqlUtility mysqlUtility;

	public UserStorageImpl() {
		try {
			HikariConfig inConfig = new HikariConfig();
			inConfig.setUsername("admin");
			inConfig.setPassword("17598Hung!");
			// inConfig.getDataSourceProperties().setProperty("url",
			// "jdbc:mysql://127.0.0.1:3306/");
			mysqlUtility = new MysqlUtility(inConfig, "guice", true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public Response insertCsv() {
		try {
			mysqlUtility.importDataCSV("/home/hungpq/java/workspace/user.csv", "user");
			return Response.ok("Inserted!").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.notModified("Error!").build();
		}
	}

	@Override
	public Response insertUser(User user)   {
		String sql = "INSERT INTO `user`(username, `password`, fullname, age, balance) VALUES('USERNAME', 'PASSWORD', 'FULLNAME', AGE, BALANCE)";
		try {
			mysqlUtility.executeUpdate(sql.replace("USERNAME", user.getUsername())
					.replace("PASSWORD", user.getPassword())
					.replace("FULLNAME", user.getFullname())
					.replace("AGE", "" + user.getAge())
					.replace("BALANCE", "" + user.getBalance()));
			return Response.ok("Inserted!").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.notModified("Error!").build();
		}
	}
	
	@Override
	public Response deleteUser(String username) {
		String sql = "DELETE FROM `user` WHERE username = 'USERNAME'";
		try {
			mysqlUtility.executeUpdate(sql.replace("USERNAME", username));
			return Response.ok("Deleted!").build();
		} catch (Exception e) {
			e.printStackTrace();
			return Response.notModified("Error!").build();
		}
	}
}
