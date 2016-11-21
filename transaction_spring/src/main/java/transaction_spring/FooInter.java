package transaction_spring;

import java.util.List;

public interface FooInter {
	List<FooDto> getFoo();
	FooDto getFoo(String name);
	void insertFoo(FooDto fooDto);
	void updateFoo(FooDto fooDto);
}
