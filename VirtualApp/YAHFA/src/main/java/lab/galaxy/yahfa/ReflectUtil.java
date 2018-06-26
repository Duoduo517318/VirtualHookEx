package lab.galaxy.yahfa;

import android.util.Log;

import java.lang.reflect.Field;
import java.util.Hashtable;

/**
 * Created by Gsang on 2018/6/21.
 */

public class ReflectUtil {

    private  static ReflectUtil sSelf = null;
    public static  ReflectUtil  self() {
        if (sSelf == null) {
            sSelf = new ReflectUtil();
        }
        return sSelf;
    }

    private ClassLoader mClassLoader;

    public void init(ClassLoader classLoader){
        mClassLoader = classLoader;
    }

    public Object getObjectFiled(Object object, String filedname) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
        Class clz = object.getClass();
        Field filed=clz.getField(filedname);
        return filed.get(object);

    }

    public int getIntFiled(Object object, String filedname)  throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException{
        Class clz = object.getClass();
        Field filed=clz.getField(filedname);
        return filed.getInt(object);

    }

    public long getLongFiled(Object object, String filedname)  throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException{
        Class clz = object.getClass();
        Field filed=clz.getField(filedname);
        return filed.getLong(object);

    }

    public double getDoubleFiled(Object object, String filedname)  throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException{
        Class clz = object.getClass();
        Field filed=clz.getField(filedname);
        return filed.getDouble(object);
    }


    public byte getByteFiled(Object object, String filedname)  throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException{
        Class clz = object.getClass();
        Field filed=clz.getField(filedname);
        return filed.getByte(object);
    }

    public char getCharFiled(Object object, String filedname)  throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException{
        Class clz = object.getClass();
        Field filed=clz.getField(filedname);
        return filed.getChar(object);
    }

    public float getFloatFiled(Object object, String filedname)  throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException{
        Class clz = object.getClass();
        Field filed=clz.getField(filedname);
        return filed.getFloat(object);
    }

    public boolean getBooleanFiled(Object object, String filedname)  throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException{
        Class clz = object.getClass();
        Field filed=clz.getField(filedname);
        return filed.getBoolean(object);
    }


    static Hashtable<String, String> trans;

    static {
        trans = new Hashtable<String, String>(9);
        trans.put("byte", "B");
        trans.put("char", "C");
        trans.put("short", "S");
        trans.put("int", "I");
        trans.put("long", "J");
        trans.put("float", "F");
        trans.put("double", "D");
        trans.put("void", "V");
        trans.put("boolean", "Z");
    }

    static String  getSignature(Class<?> clazz) {
        String result = "";
        String nextType = clazz.getName().replace(".", "/");
        if(trans.containsKey(nextType)) {
            result = trans.get(nextType);
        } else {
            if(clazz.isArray()) {
                result = "[" + getSignature(clazz.getComponentType());
            } else {
                result = "L" + nextType + ";";
            }
        }

        return result;
    }

    public  static  String getSignature(Class<?> returnType, Class<?>[] parameterTypes) {
        StringBuilder result = new StringBuilder();

        result.append('(');
        for (int i = 0; i < parameterTypes.length; i++) {
            result.append(getSignature(parameterTypes[i]));
        }
        result.append(')');
        result.append(getSignature(returnType));
        return result.toString();
    }

}
