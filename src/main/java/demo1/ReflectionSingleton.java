package demo1;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectionSingleton {
    public static void main(String[] args)  {

        Singleton objOne = Singleton.getInstance();
        Singleton objTwo = null;
            Constructor<Singleton> constructor = null;
			try {
				constructor = Singleton.class.getDeclaredConstructor();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
				System.exit(-1);
			} 
            constructor.setAccessible(true);
            try {
				objTwo = (Singleton) constructor.newInstance();
			} catch (InstantiationException e) {
				e.printStackTrace();
				System.exit(-1);
			} catch (IllegalAccessException e) {
				e.printStackTrace();
				System.exit(-1);
			}  catch (InvocationTargetException e) {
				e.printStackTrace();
				System.exit(-1);
			}

        System.out.println("Hashcode of Object 1 - "+objOne.hashCode());
        System.out.println("Hashcode of Object 2 - "+objTwo.hashCode());

    }
}