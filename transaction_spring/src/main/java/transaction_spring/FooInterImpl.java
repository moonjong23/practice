package transaction_spring;

import java.util.ArrayList;
import java.util.List;

public class FooInterImpl implements FooInter{

	@Override
	public List<FooDto> getFoo() {
		List<FooDto> list = new ArrayList<FooDto>()	;
		System.out.println("전체자료 select 수행함");
		return list;
	}

	@Override
	public FooDto getFoo(String name) {
		FooDto dto = new FooDto();
		System.out.println("일부 자료 select 처리함");
		return dto;
	}

	@Override
	public void insertFoo(FooDto fooDto) {
//		try {
//			System.out.println("insert 처리함");
//		} catch (Exception e) {
//			throw new WowException("insertFoo err");
//		}
		throw new WowException("insertFoo err");
	}

	@Override
	public void updateFoo(FooDto fooDto) {
//		try {
//			System.out.println("update 처리함");
//		} catch (Exception e) {
//			throw new WowException("updateFoo err");
//		}
		throw new WowException("updateFoo err");
	}
	
}
