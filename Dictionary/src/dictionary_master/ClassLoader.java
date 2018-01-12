/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_master;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

/**
 *
 * @author HP
 */
public class ClassLoader {
    
     
    private Class cls;
    private Field[] fields;
    private int nbFields;
    private String className;
    
    public ClassLoader(String className) throws ClassNotFoundException{
            cls=Class.forName("dictionary_master."+className);
            fields=cls.getDeclaredFields();
            nbFields=cls.getDeclaredFields().length;
            this.className=className;
}
    
    
    public static Class loadClass(String packageName,String className) throws ClassNotFoundException{
           return Class.forName(packageName+"."+className);    
    }
    
    
    public Class getLoadedClass(){
        return cls;
    }
    
    
    public int getNumberOfFields(){
        return nbFields;
    }
    
    
    private int countParents(Class cs){
            if(cs==Object.class)return 0;
            return cs.getDeclaredFields().length+countParents(cs.getSuperclass());
    }
    
    
    public Field[] getParentFields(String parentClass) throws ClassNotFoundException{
        
          Class cs=loadClass("dictionary_master",parentClass);
           Field[] fields=new Field[countParents(cs)];
           int i=0;
           Class currentClass=cs;
           while(currentClass!=Object.class){
                for(Field f:currentClass.getDeclaredFields()){
                    fields[i]=f;
                    i++;
                }
         currentClass=currentClass.getSuperclass();
           }
           
           return fields;
    }
    
    
   public Field[] getAllFields() throws ClassNotFoundException{
       return getParentFields(this.className);
   }


public Field[] getFields(){
      return fields;
}


public static Class getTheGrandParent(Class cs){
         Class currentClass=cs;
         Class grandPa=cs;
        while(currentClass.getSuperclass()!=Object.class){
            grandPa=currentClass.getSuperclass();
            currentClass=currentClass.getSuperclass();
        }
        System.out.print(grandPa.getName());
        return grandPa;
}


public static String getTheGrandParentName(Class cs){
         Class currentClass=cs;
         Class grandPa=cs;
        while(currentClass.getSuperclass()!=Object.class){
            grandPa=currentClass.getSuperclass();
            currentClass=currentClass.getSuperclass();
        }
        return grandPa.getName();
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
