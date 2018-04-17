package cache;

import java.util.ArrayList;
import java.util.List;

public class TestCache implements CacheInitializer {

	@Override
	public List<CacheContent> doInit() {
		// TODO Auto-generated method stub
		List<CacheContent> contents = new ArrayList<CacheContent>();
		for (int i = 0; i < 10; i++) {
			contents.add(new CacheContent("session", "123--"+i, i));
		}
		
		return contents;
	}
	
	public static void main(String[] args) {
		CacheInitializer initializers = new TestCache();
		initializers.doInit();
		List<CacheInitializer> list = new ArrayList<CacheInitializer>();
		list.add(initializers);
		CacheManager.refresh(list);
		
		for (int i = 0; i < 10; i++) {
			
			boolean value = CacheManager.contains("session", "123--"+i);
			System.out.println(value);
		}
	}

}
