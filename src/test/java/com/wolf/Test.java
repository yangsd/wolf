package com.wolf;

import com.wolf.core.service.SqlConfigService;
import javassist.*;
import javassist.bytecode.AnnotationsAttribute;
import javassist.bytecode.ConstPool;
import javassist.bytecode.MethodInfo;
import javassist.bytecode.annotation.Annotation;
import javassist.bytecode.annotation.ArrayMemberValue;
import javassist.bytecode.annotation.StringMemberValue;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by sdyang on 2016/10/29.
 */

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = com.SpringBootStart.class)
public class Test {

    @Autowired
    private SqlConfigService sqlConfigService;

    @org.junit.Test
    public void ReadTest() throws NotFoundException, ClassNotFoundException {
        ClassPool pool = ClassPool.getDefault();
        //获取要修改的类的所有信息
        CtClass ct = pool.get("com.wolf.system.mapper.UserMapper");
        //获取类中的方法
        CtMethod[] cms = ct.getDeclaredMethods();
        //获取第一个方法（因为只有一个方法）
        CtMethod cm = cms[0];
        System.out.println("方法名称====" + cm.getName());

        //获取方法信息
        MethodInfo methodInfo = cm.getMethodInfo();

        ConstPool cp = methodInfo.getConstPool();

        //获取注解属性
        AnnotationsAttribute attribute = (AnnotationsAttribute) methodInfo.getAttribute(AnnotationsAttribute.visibleTag);

        Annotation annotation = attribute.getAnnotation("org.apache.ibatis.annotations.Select");
        System.out.println(annotation);
        ArrayMemberValue text =((ArrayMemberValue) annotation.getMemberValue("value"));

        String key = text.getValue()[0].toString();
        System.out.println("修改前的值:"+key);


        //--------------------修改---------------

        //修改名称为unitName的注解
        annotation.addMemberValue("value", new StringMemberValue("测试值", cp));

        attribute.setAnnotation(annotation);
        methodInfo.addAttribute(attribute);

        Annotation annotation3 = attribute.getAnnotation("org.apache.ibatis.annotations.Select");
        StringMemberValue text2 = ((StringMemberValue)annotation.getMemberValue("value"));

        System.out.println("修改后的注解名称===" + text2.toString());

    }
}
