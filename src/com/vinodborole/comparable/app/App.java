package com.vinodborole.comparable.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.vinodborole.comparable.message.Message;
import com.vinodborole.comparable.message.Protocol;
import com.vinodborole.comparable.model.Model;
import com.vinodborole.comparable.util.DiffUtil;

public class App {

	public static void main(String[] args) throws Exception {
		test1();
		test2();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8();
	}

    private static void test1() throws Exception{
        System.out.println("*** Test 1 ****");
        Message message = new Message();
        Model model = new Model();
        testDiff(message, model);
    }
    private static void test2() throws Exception {
        System.out.println("*** Test 2 ****");
        Message message1= new Message(Protocol.TCP,2L,"ttttt", "1.1.1.1","HG:DD:DD:WE","DELL");
        Model model1= new Model(Protocol.SSH,2L,"ttttt", "1.1.1.2","HG:DD:DD:WW","DELL");
        testDiff(message1, model1);
    }
    private static void test3() throws Exception {
        System.out.println("*** Test 3 ****");
        Message message1= new Message(Protocol.TCP,2L,"ttttt", "1.1.1.1","HG:DD:DD:WE","DELL");
        Model model1= new Model(Protocol.SSH,2L,"ttttt", "1.1.1.2","HG:DD:DD:WW","DELL");
        List<DiffUtil.Attribute> diffAttribute=DiffUtil.getDiff(message1, model1);
        if(diffAttribute.isEmpty()){
            System.out.println("Objects are EQUAL!");
        }else{
            System.out.println("Difference found");
            displayAttribute(diffAttribute);
        }
    }
    private static void test4() throws Exception {
        System.out.println("*** Test 4****");
        Message message= new Message(Protocol.TCP,2L,"ttttt", "1.1.1.1","HG:DD:DD:WE");
        Model model= new Model(Protocol.SSH,2L,"ttttt", "1.1.1.2","HG:DD:DD:WW","DELL");
        List<DiffUtil.Attribute> diffAttribute=DiffUtil.getDiff(message, model);
        if(diffAttribute.isEmpty()){
            System.out.println("Objects are EQUAL!");
        }else{
            System.out.println("Difference found");
            displayAttribute(diffAttribute);
        }
        
    }
    
    private static void test5() throws Exception{
        System.out.println("*** Test 5 ****");
        Message message = new Message();
        Model model = new Model();
        List<String> sr = new ArrayList<String>();
        sr.add("serv1");
        message.setServerList(sr);
        List<String> sr1 = new ArrayList<String>();
        sr1.add("serv1");
        model.setServerList(sr1);
        testDiff(message, model);
    }
    private static void test6() throws Exception{
        System.out.println("*** Test 6 ****");
        Message message = new Message();
        Model model = new Model();
        List<String> sr = new ArrayList<String>();
        sr.add("serv1");
        message.setServerList(sr);
        List<String> sr1 = new ArrayList<String>();
        sr1.add("serv1");
        sr1.add("serv2");
        model.setServerList(sr1);
        testDiff(message, model);
    }
    private static void test7() throws Exception{
        System.out.println("*** Test 7 ****");
        Message message = new Message();
        Model model = new Model();
        List<String> sr = new ArrayList<String>();
        sr.add("serv1");
        message.setServerList(sr);
        Map<String,String> netMap1 = new HashMap<String,String>();
        netMap1.put("key1", "val1");
        message.setNetMap(netMap1);
        List<String> sr1 = new ArrayList<String>();
        sr1.add("serv1");
        sr1.add("serv2");
        model.setServerList(sr1);
        
        Map<String,String> netMap2 = new HashMap<String,String>();
        netMap2.put("key1", "val1");
        netMap2.put("key2", "val2");
        model.setNetMap(netMap2);
        testDiff(message, model);
    }
    private static void test8() throws Exception{
        System.out.println("*** Test 8 ****");
        Message message = new Message();
        Model model = new Model();
        List<String> sr = new ArrayList<String>();
        sr.add("serv1");
        message.setServerList(sr);
        Map<String,String> netMap1 = new HashMap<String,String>();
        netMap1.put("key1", "val1");
        message.setNetMap(netMap1);
        List<String> sr1 = new ArrayList<String>();
        sr1.add("serv2");
        model.setServerList(sr1);
        
        Map<String,String> netMap2 = new HashMap<String,String>();
        netMap2.put("key1", "val1");
        model.setNetMap(netMap2);
        testDiff(message, model);
    }
    
    
    private static void testDiff(Message message1, Model model1) throws Exception {
        List<DiffUtil.Attribute> diffAttribute=DiffUtil.getDiff(message1, model1);
		if(diffAttribute.isEmpty()){
		    System.out.println("Objects are EQUAL!");
		}else{
		    System.out.println("Difference found");
		    displayAttribute(diffAttribute);
		}
    }
    private static void displayAttribute(List<DiffUtil.Attribute> messageAttributes) {
        for(DiffUtil.Attribute attr : messageAttributes){
		    System.out.println(attr.getFieldName()+","+attr.getFieldType()+","+attr.getFieldValue());
		}
    }

    
}
