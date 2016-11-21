package pack.model;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import pack.controller.MemBean;

public interface MemAnnoInter {
	@Select("select * from mem")
	public List<MemDto> selectAll();
	
	@Select("select * from mem where num=#{num}")
	public MemDto selectPart(String num);
	
	@Insert("insert into mem(name,addr) values(#{name},#{addr})")
	public boolean insert(MemBean bean);
	
	@Update("update mem set name=#{name}, addr=#{addr} where num=#{num}")
	public boolean update(MemBean bean);
	
	@Delete("delete from mem where num=#{num}")
	public boolean delete(String num);
}
