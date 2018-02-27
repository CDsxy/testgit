package com.myweb.smis.util.template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;

public class BeanHandler<T> implements IStudentResultSetHandler<T> {
    private Class<T> classType = null;

    public BeanHandler(Class<T> classType){
        this.classType = classType;
    }
    public T handle(ResultSet res) throws Exception {
        T obj = classType.newInstance();
        BeanInfo bf = Introspector.getBeanInfo(classType, Object.class);
        PropertyDescriptor[] pro = bf.getPropertyDescriptors();
        if(res.next()){
            for(PropertyDescriptor p : pro){
                String columeName =p.getName();
                Object ob =res.getObject(columeName);
                p.getWriteMethod().invoke(obj, ob);
            }
        }
        return obj;
    }
}
