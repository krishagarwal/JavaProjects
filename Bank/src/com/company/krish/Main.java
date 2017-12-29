package com.company.krish;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    private static ExecutorService pool = Executors.newFixedThreadPool(5);

    public static void main (String[] args) {

    }

    private static void doWork(Object o){
        Class<?> c = o.getClass();
        showName(c);
    }

    private static void showName(Class<?> theClass){
        System.out.println(theClass.getSimpleName());
    }

    private static void getClassInfo(Object o){
        Class<?> theClass = o.getClass();
        System.out.println(theClass.getSimpleName());
        Class<?> superClass = theClass.getSuperclass();
        System.out.println(superClass.getSimpleName());
        Class<?> [] interfaces = theClass.getInterfaces();

        for(Class<?> anInterface : interfaces){
            System.out.println(anInterface.getSimpleName());
        }
    }

    private static void getTypeModifiers(Object o){
        Class<?> theClass = o.getClass();
        int modifiers = theClass.getModifiers();

        if(Modifier.isFinal(modifiers)){
            System.out.println("final");
        }

        if(Modifier.isPublic(modifiers)){
            System.out.println("public");
        }

        if(Modifier.isProtected(modifiers)){
            System.out.println("public");
        }

        if(Modifier.isPrivate(modifiers)){
            System.out.println("public");
        }
    }

    private static void getFieldInfo(Object o){
        Class<?> theClass = o.getClass();

        Field [] fields = theClass.getFields();
        displayFields(fields);

        Field[] declaredFields = theClass.getDeclaredFields();
        displayFields(declaredFields);
    }

    private static void displayFields(Field[] arr){
        for(Field f : arr){
            System.out.println(f.getName() + " - " + f.getType());
        }
    }

    private static void getMethodInfo(Object o){
        Class<?> theClass = o.getClass();
        Method[] methods = theClass.getMethods();

        for(Method m : methods){

            if(m.getDeclaringClass() != Object.class) {
                System.out.println(m.getName());
            }
        }

        Method[] declMethods = theClass.getDeclaredMethods();
        for(Method m : declMethods){
            System.out.println(m.getName());
        }
    }

    private static void callGetId(Object o){

        try {
            Class<?> theClass = o.getClass();
            Method m = theClass.getMethod("getId");
            System.out.println(m.invoke(o));

        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void callDeposit(Object o, int amt) {

        try {
            Class<?> theClass = o.getClass();
            Method m = theClass.getMethod("deposit", int.class);
            m.invoke(o, amt);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void startWork (Object target){
        try {
            Class<?> targetType = target.getClass();

            ProcessedBy pb = targetType.getAnnotation(ProcessedBy.class);
            Class<?> workerType = pb.value();

            TaskWorker worker = (TaskWorker) workerType.newInstance();
            worker.setTarget(target);

            WorkHandler wh = workerType.getAnnotation(WorkHandler.class);

            if(wh.value()){
                pool.submit(new Runnable(){
                    public void run(){
                        worker.doWork();
                    }
                });
            }
            worker.doWork();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void saveAccount (BankAccount bankAcct, String filename){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))){
            outputStream.writeObject(bankAcct);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static BankAccount loadAccount(String filename){
        BankAccount bankAcct = null;

        try(ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))){
            bankAcct = (BankAccount)inputStream.readObject();
         } catch(Exception e){
            e.printStackTrace();
        }

        if(bankAcct instanceof HighVolumeAccount){
             return (HighVolumeAccount)bankAcct;
        }

        return bankAcct;
    }

    private static void saveGroup (AccountGroup group, String filename){
        try(ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(Paths.get(filename)))){
            outputStream.writeObject(group);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static AccountGroup loadGroup(String filename){
        AccountGroup group = null;

        try(ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(Paths.get(filename)))){
            group = (AccountGroup) inputStream.readObject();
        } catch(Exception e){
            e.printStackTrace();
        }

        return group;
    }


}
