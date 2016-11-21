package pack.model;

import java.util.List;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pack.controller.MemBean;

@Component
public class MemDaoImpl implements MemDaoInter {

	@Autowired
	private MemAnnoInter inter;
	
	@Override
	public List<MemDto> getDataAll() {
		return inter.selectAll();
	}

	@Override
	public MemDto selectPart(String num) {
		return inter.selectPart(num);
	}

	@Override
	public boolean insertData(MemBean bean) {
		try {
			inter.insert(bean);
			return true;
		} catch (Exception e) {
			System.out.println("ins err : " + e);
			return false;
		}
	}

	@Override
	public boolean updateData(MemBean bean) {
		try {
			inter.update(bean);
			return true;
		} catch (Exception e) {
			System.out.println("up err : " + e);
			return false;
		}
	}

	@Override
	public boolean deleteData(String num) {
		boolean re = inter.delete(num);
		if(re){
			return true;
		}else{
			return false;
		}
	}

}
