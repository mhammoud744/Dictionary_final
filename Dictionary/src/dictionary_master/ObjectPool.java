/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dictionary_master;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;

/**
 *
 * @author HP
 *///pool bsayev objects bl map uses  flyweight pattern berga3 objc of same name different content
public class ObjectPool {

    private static final HashMap<Integer, Object> objectMap = new HashMap();

    public static Object getObject(int hash, ClassLoader loader, Object... objects) throws NoSuchMethodException, InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        Object object = objectMap.get(hash);
        if (object == null || !object.getClass().equals(loader.getLoadedClass())) {
            object = loader.createInstance(objects);
            objectMap.put(hash, loader.getLoadedClass().cast(object));

            System.out.println("Object " + loader.getLoadedClass().cast(object) + " created");
        } else {
            System.out.println("the class type is " + object.getClass());
        }
        return object;
    }
}
