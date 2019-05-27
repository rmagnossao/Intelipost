package br.com.rmagnossao.login.repository;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

public interface LoginRepository {
	
	//@Mapper(LoginMapper.class)
	@SqlQuery("Select id from login where user =:user and password=:password")
	Integer getInfo(@Bind(value = "user") String user, 
				    @Bind(value = "password") String password);
	
	public static class LoginMapper implements ResultSetMapper<Integer> {

		@Override
		public Integer map(int arg0, ResultSet r, StatementContext arg2) throws SQLException {
			
			return r.getInt("id");
					         
		}
		
		
	}

		



}
