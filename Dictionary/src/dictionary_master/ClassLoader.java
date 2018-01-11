/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_master;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 *
 * @author HP
 */
public class ClassLoader {
    
     
    private Class cls;
    private Field[] fields;
    private int nbFields;
    
    public ClassLoader(String className) throws ClassNotFoundException{
            cls=Class.forName("dictionary_master."+className);
            fields=cls.getDeclaredFields();
            nbFields=cls.getDeclaredFields().length;
}
    
    
    public static Class loadClass(String packageName,String className) throws ClassNotFoundException{
           return Class.forName(packageName+"."+className);    
    }
    
    
    public int getNumberOfFields(){
        return nbFields;
    }


public Field[] getFields(){
      return fields;
}     
    
public Object createInstance(Object ...objects) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
          Class[] clses=new Class[fields.length];
          
          int i=0;
          
          for(Field field:fields){
             clses[i]=field.getType();
             i++;
          }
          return cls.getConstructor(clses).newInstance(objects);
}   
    
}
