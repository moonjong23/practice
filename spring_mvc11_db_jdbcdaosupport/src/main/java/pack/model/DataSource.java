package pack.model;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Repository;

@Repository("dataSource")
public class DataSource extends BasicDataSource {
	public DataSource() {
		setDriverClassName("org.mariadb.jdbc.Driver");
		setUrl("jdbc:mysql://localhost:3306/test");
		setUsername("root");
		setPassword("123");
	}
}
