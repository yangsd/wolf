package com.wolf.core;

/**
 * Created by sdyang on 2016/10/29.
 */
public class EntityClassLoader extends ClassLoader {

    private ClassLoader parent;

    public EntityClassLoader(ClassLoader parent){
        this.parent = parent;
    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
        return this.loadClass(name, false);
    }

    @Override
    protected synchronized Class<?> loadClass(String name, boolean resolve)
            throws ClassNotFoundException {
        Class<?> clazz = this.findLoadedClass(name);
        if(null != parent){
            clazz = parent.loadClass(name);
        }
        if(null == clazz){
            this.findSystemClass(name);
        }

        if(null == clazz){
            throw new ClassNotFoundException();
        }
        if(null != clazz && resolve){
            this.resolveClass(clazz);
        }

        return clazz;
    }

}
