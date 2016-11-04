package com.wolf.core.service;

import com.wolf.core.EntityClassLoader;
import com.wolf.core.enumeration.Dialect;
import com.wolf.core.mapper.SqlConfigMapper;
import com.wolf.core.model.SqlConfig;
import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.AnnotationsAttribute;
import org.apache.ibatis.javassist.bytecode.ConstPool;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.apache.ibatis.javassist.bytecode.annotation.Annotation;
import org.apache.ibatis.javassist.bytecode.annotation.ArrayMemberValue;
import org.apache.ibatis.javassist.bytecode.annotation.StringMemberValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;

/**
 * Created by sdyang on 2016/10/29.
 */
@Service
public class SqlConfigService {

    @Autowired
    private SqlConfigMapper sqlConfigMapper;

    public SqlConfig findByKey(String key, Dialect dialect, String client_id){
        return  sqlConfigMapper.findByKey(key,dialect.getValue(),client_id);
    }

    public void init() throws NotFoundException, CannotCompileException, IOException {
        ClassPool pool = ClassPool.getDefault();
        //获取要修改的类的所有信息
        CtClass ct = pool.get("com.wolf.auth.mapper.UserMapper");
        //获取类中的方法
        CtMethod[] cms = ct.getDeclaredMethods();
        //获取第一个方法
        CtMethod cm = cms[0];
        System.out.println("方法名称====" + cm.getName());

        //获取方法信息
        MethodInfo methodInfo = cm.getMethodInfo();

        ConstPool cp = methodInfo.getConstPool();

        //获取注解属性
        AnnotationsAttribute attribute = (AnnotationsAttribute) methodInfo.getAttribute(AnnotationsAttribute.visibleTag);

//        System.out.println(attribute.getName());
//        System.out.println(attribute.toString());

        Annotation annotation = attribute.getAnnotation("org.apache.ibatis.annotations.Select");
        System.out.println(annotation);

        ArrayMemberValue text =((ArrayMemberValue) annotation.getMemberValue("value"));
        String key = text.getValue()[0].toString();
        System.out.println("修改前注解的值:"+key);


        //--------------------修改---------------

        //修改名称为unitName的注解
        annotation.addMemberValue("value", new StringMemberValue("select * from sys_user", cp));
        attribute.setAnnotation(annotation);
        methodInfo.addAttribute(attribute);

        ct.writeFile();
        ct.defrost();
        EntityClassLoader loader = new EntityClassLoader(com.wolf.auth.mapper.UserMapper.class.getClassLoader());
        ct.toClass(loader , null);

        Annotation annotation3 = attribute.getAnnotation("org.apache.ibatis.annotations.Select");
        StringMemberValue text2 = ((StringMemberValue)annotation.getMemberValue("value"));

        System.out.println("修改后注解的值：" + text2.toString());
    }
}
