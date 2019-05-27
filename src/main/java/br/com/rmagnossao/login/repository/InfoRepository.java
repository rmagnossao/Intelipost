package br.com.rmagnossao.login.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import br.com.rmagnossao.login.model.Info;


public interface InfoRepository {
	
	@Mapper(InfoMapper.class)
	@SqlQuery("Select name, address, telephone from info where id = :id")
	List<Info> getInfo(@Bind(value="id") int id);
	
	public static class InfoMapper implements ResultSetMapper<Info> {

		@Override
		public Info map(int arg0, ResultSet r, StatementContext arg2) throws SQLException {
			Info info =  new Info();
			info.setName(r.getString("name"));
			info.setAddress(r.getString("address"));
			info.setTelephone(r.getString("telephone"));
			return info;
					         
		}
		
		


		

}
}
