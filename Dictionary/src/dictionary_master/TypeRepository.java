package dictionary_master;

import java.util.HashMap;

public class TypeRepository {
	
	
	public static final String PRIMITIVE="primitive";
	private HashMap<String,Object> map;
	
	private static TypeRepository repository=null;
	private TypeRepository(){
		map=new HashMap();
		
		map.put("int", PRIMITIVE);
		map.put("String", new String());
		map.put("boolean", PRIMITIVE);
		map.put("double", PRIMITIVE);
		
	}
	
	
	
	public void add(String key,Object o){
		map.put(key, o);
	}
	
	
	
	public Object getType(String key){
		return map.get(key);
	}
	
	public static TypeRepository getRepository(){
		if(repository==null){
			repository=new TypeRepository();
		}
		return repository;
	}
	
	

}