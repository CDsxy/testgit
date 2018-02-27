package com.myweb.smis.util.template.handler;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BeanListHandler<T> implements IStudentResultSetHandler<List<T>> {
    private Class<T> classType = null;

    public BeanListHandler(Class<T> calssType){
        this.classType = calssType;
    }
    public List<T> handle(ResultSet res) throws Exception {
        List<T> list = new ArrayList<>();
        BeanInfo bf = Introspector.getBeanInfo(classType, Object.class);
        PropertyDescriptor[] pro = bf.getPropertyDescriptors();
        while(res.next()){
            T obj = classType.newInstance();
            list.add(obj);
            for(PropertyDescriptor p : pro){
                String columeName = p.getName();
                Object ob = res.getObject(columeName);
                p.getWriteMethod().invoke(obj, ob);
            }
        }
        return list;
    }
}
