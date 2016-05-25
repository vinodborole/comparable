package com.vinodborole.comparable.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DiffUtil {
    private static List<Attribute> difference(List<Attribute> sourceAttributes, List<Attribute> destinationAttributes) throws Exception  {
        List<Attribute> diff = new ArrayList<Attribute>();
        
        if(destinationAttributes.size()!=sourceAttributes.size())
            throw new Exception("Objects cannot be compared, number of fields varry!");
        
        Collections.sort(sourceAttributes);
        Collections.sort(destinationAttributes);
               
        for(Attribute destinationAttribute : destinationAttributes){
            if(!sourceAttributes.contains(destinationAttribute)){
                diff.add(destinationAttribute);
            }
        }
        return diff;
    }
    
   

    public static List<Attribute> getDiff(Object source, Object destination) throws Exception{
        List<DiffUtil.Attribute> sourceAttributes=DiffUtil.getAttributesAndValues(source);
        List<DiffUtil.Attribute> destinationAttributes = DiffUtil.getAttributesAndValues(destination);
        return difference(sourceAttributes, destinationAttributes);
    }

    private static List<Attribute> getAttributesAndValues(Object o) throws Exception {
        List<Attribute> attributes = new ArrayList<Attribute>();
        Field[] fields=o.getClass().getDeclaredFields();
        for(Field field : fields){
           field.setAccessible(true);
           String fieldValue=field.get(o)!=null?field.get(o).toString():null;
           Attribute attribute = new Attribute();;
           attribute.setFieldName(field.getName());
           attribute.setFieldType(field.getType());
           attribute.setFieldValue(fieldValue);
           attributes.add(attribute);
        }
        return attributes;
    }
    
    public static class Attribute implements Comparable<Attribute>{
        private String fieldName;
        private Class<?> fieldType;
        private String fieldValue;
        public String getFieldName() {
            return fieldName;
        }
        public void setFieldName(String fieldName) {
            this.fieldName = fieldName;
        }
        
        public Class<?> getFieldType() {
            return fieldType;
        }
        public void setFieldType(Class<?> fieldType) {
            this.fieldType = fieldType;
        }
        public String getFieldValue() {
            return fieldValue;
        }
        public void setFieldValue(String fieldValue) {
            this.fieldValue = fieldValue;
        }
        @Override
        public int compareTo(Attribute o) {
            return this.fieldName.compareTo(o.fieldName);
        }
        @Override
        public int hashCode() {
            final int prime = 31;
            int result = 1;
            result = prime * result + ((fieldName == null) ? 0 : fieldName.hashCode());
            result = prime * result + ((fieldValue == null) ? 0 : fieldValue.hashCode());
            result = prime * result + ((fieldType == null) ? 0 : fieldType.hashCode());
            return result;
        }
        @Override
        public boolean equals(Object obj) {
            if (this == obj)
                return true;
            if (obj == null)
                return false;
            if (getClass() != obj.getClass())
                return false;
            Attribute other = (Attribute) obj;
            if (fieldName == null) {
                if (other.fieldName != null)
                    return false;
            } else if (!fieldName.equals(other.fieldName))
                return false;
            if (fieldValue == null) {
                if (other.fieldValue != null)
                    return false;
            } else if (!fieldValue.equals(other.fieldValue))
                return false;
            if(fieldType == null){
                if(other.fieldType !=null)
                    return false;
            }else if(!fieldType.equals(other.fieldType))
                return false;
            
            return true;
        }
        
        
        
    }
}
