package dictionary_master;

import java.util.HashMap;

public class TypeRepository {
	
	private HashMap<String,Object> map;
	private static TypeRepository repository=null;
	
        private TypeRepository(){
		map=new HashMap();
		map.put("int", new Integer(0));
		map.put("String", new String());
		map.put("boolean", new Boolean(true));
		map.put("double", new Double(0));
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
