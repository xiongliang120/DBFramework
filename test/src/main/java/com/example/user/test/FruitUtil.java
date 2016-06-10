package com.example.user.test;

import java.lang.reflect.Field;


public class FruitUtil {
    public static void getFruitInfo(Class clazz){
       Field[] files=clazz.getDeclaredFields(); //获取类的所有字段,包括所有私有字段
       if(files == null || files.length == 0){
    	   return;
       }
       
       for(int i=0;i<files.length;i++){
    	   Field field = files[i];
    	   //判断字段是否声明某一类型的注解
    	   if(field.isAnnotationPresent(FruitName.class)){ //FruitName
    		   FruitName fruitName = field.getAnnotation(FruitName.class);
    		   System.out.println("水果的名字="+fruitName.value());
    	   }else if(field.isAnnotationPresent(FruitColor.class)){ //FruitColor
    		   FruitColor fruitColor = field.getAnnotation(FruitColor.class);
    		   System.out.println("水果的颜色="+fruitColor.getColor());
    	   }else if(field.isAnnotationPresent(FruitProvider.class)){
    		   FruitProvider fruitProvider = field.getAnnotation(FruitProvider.class);
    		   System.out.println("提供者的地址="+fruitProvider.id()+"..."+fruitProvider.name()+"..."+fruitProvider.address());
    	   }
       }
    }
}
