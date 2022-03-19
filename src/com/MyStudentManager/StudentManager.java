package com.MyStudentManager;

/*
  @author :珠代
 * @description :
 * @create :2022-03-03 17:05:06
 */

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) throws ClassNotFoundException,IOException{
        //创建集合对象，用于存放学生对象
        ArrayList<Student> array = new ArrayList<>();
        //加载本地数据
        File file = new File("data.txt");
        if (file.exists() && file.length() > 0) {
            // 本地数据存在则加载数据(文件内容也不能为空)
            array = load();
        } else {
            // 如果本地不存在数据,则创建文件
            file.createNewFile();
        }

        while (true) {
            System.out.println("\n");
            System.out.println("-----欢迎来到学生管理系统-----");
            System.out.println("1、添加学生");
            System.out.println("2、删除学生");
            System.out.println("3、修改学生");
            System.out.println("4、查看所有学生");
            System.out.println("5、退出");
            System.out.println("请输入你的选择：");
            Scanner sc = new Scanner(System.in);

            String line = sc.nextLine();

            switch (line) {
                case "1":
                   // System.out.println("添加学生");
                    addStudent(array);
                    store(array);
                    break;
                case "2":
                    //System.out.println("删除学生");
                    deleteStudent(array);
                    break;
                case "3":
                    //System.out.println("修改学生");
                    updateStudent(array);
                    break;
                case "4":
                    //System.out.println("查看所有学生");
                    findAllStudent(array);
                    break;
                case "5":
                    //System.out.println("退出系统");
                    store(array);
                    System.out.println("感谢使用");
                    System.exit(0);
                default:
                    System.out.println("你的输入有误，请重新输入");
                    break;
            }
        }
    }


    //添加学生
    public static void addStudent(ArrayList<Student> array){

        //键盘录入数据
        Scanner sc =new Scanner(System.in);
        String sid;
        while (true) {
            System.out.println("请输入学生学号");
            sid = sc.nextLine();
            if (isUsed(array, sid)) {
                System.out.println("学号重复，请核对后重试！");
            }
            else {
                break;
            }
        }
        System.out.println("请输入学生姓名");
        String name = sc.nextLine();
        System.out.println("请输入学生性别");
        String sex = sc.nextLine();
        System.out.println("请输入学生年龄");
        String age = sc.nextLine();
        System.out.println("请输入学生专业");
        String major = sc.nextLine();
//        System.out.println("请输入位置");
//        String location = sc.nextLine();
//        System.out.println("请输入长度");
//        String length = sc.nextLine();
        //创建学生对象，利用构造方法赋值给成员变量
        Student s = new Student(sid,name,sex,age,major);
        System.out.println("添加学生成功");
        //将学生对象添加到集合中
        array.add(s);

    }
    //删除学生
    public static void deleteStudent(ArrayList<Student> array){

        //集合类内无学生信息时不能删除信息
        if(array.size() == 0){
            System.out.println("请先添加学生信息后再删除学生！");
            return;
        }
        //提示信息
        System.out.println("请输入要删除学生的学号：");
        //键盘输入学号
        Scanner sc = new Scanner(System.in);
        String sid = sc.nextLine();
        //索引初始为-1
        int index = -1;
        //遍历集合内的学生信息
        for(int i = 0;i < array.size();i++){
            if(array.get(i).getSid().equals(sid)){
                index = i;
            }
        }
        //遍历后未找到
        if(index == -1) {
            System.out.println("没有在数据库中查到此学号的学生信息，请核对正确后再次输入！");
        }
        else {
            array.remove(index);
            System.out.println("删除成功！");
        }
    }
    //修改学生信息
    public static void updateStudent(ArrayList<Student> array){

        if(array.size() == 0){
            System.out.println("数据库为空，请先添加学生信息！");
            return;
        }
        //提示信息
        System.out.println("请输入你要修改的学生的学号：");
        Scanner sc = new Scanner(System.in);
        String sid = sc.nextLine();
        //索引初始为-1
        int index = -1;
        //遍历学生集合
        for (int i = 0;i < array.size();i++){
            if(array.get(i).getSid().equals(sid)){
                index = i;
            }

        }
        if(index == -1) {
            System.out.println("未找到该学号的学生信息，请核对后重新输入");
        }
        else {
            while (true) {
                System.out.println("\n");
                System.out.println("请选择你需要修改的信息");
                System.out.println("1、学号");
                System.out.println("2、姓名");
                System.out.println("3、性别");
                System.out.println("4、年龄");
                System.out.println("5、专业");
                System.out.println("6、退出");
                System.out.println("输入序号按回车结束");
                //键盘输入选择
                String line = sc.nextLine();
                switch (line) {
                    case "1":
                        String updateSid;
                        while (true) {
                            System.out.println("请输入修改后的学生学号");
                            updateSid = sc.nextLine();
                            if (isUsed(array, updateSid)) {
                                System.out.println("学号重复，请核对后重试！");
                            }
                            else {
                                break;
                            }
                        }
                        array.get(index).setSid(updateSid);
                        System.out.println("学号修改成功");
                        break;
                    case "2":
                        System.out.println("请输入要修改的姓名：");
                        String updateName = sc.nextLine();
                        array.get(index).setName(updateName);
                        System.out.println("姓名修改成功");
                        break;
                    case "3":
                        System.out.println("请输入要修改的性别：");
                        String updateSex = sc.nextLine();
                        array.get(index).setSex(updateSex);
                        System.out.println("性别修改成功");
                        break;
                    case "4":
                        System.out.println("请输入要修改的年龄：");
                        String updateAge = sc.nextLine();
                        array.get(index).setAge(updateAge);
                        System.out.println("年龄修改成功");
                        break;
                    case "5":
                        System.out.println("请输入要修改的专业：");
                        String updateAddress = sc.nextLine();
                        array.get(index).setMajor(updateAddress);
                        System.out.println("专业修改成功");
                        break;
                    case "6":
                        return;
                    default:
                        System.out.println("您的输入有误，请重新输入！");

                }

            }

        }
    }
    //查看所有学生信息
    public static void findAllStudent(ArrayList<Student> array){

        if(array.size() == 0){
            System.out.println("数据库为空，请先添加学生信息");
            return;//使程序不再往下执行
        }
        //显示表头
        //\t与tab键作用相同
        System.out.println("学号\t\t\t姓名\t\t性别\t\t年龄\t\t专业");
        for (Student student : array) {
            System.out.println(student.getSid() + "\t" + student.getName() + "\t" + student.getSex() + "\t\t" + student.getAge() + "\t\t" + student.getMajor());
        }

    }
    //判断学号是否重复
    public static boolean isUsed(ArrayList<Student> array,String sid){
        for (Student student : array) {
            if (student.getSid().equals(sid)) {
                return true;
            }
        }
        return false;
    }
    //存储数据
    public static void store(ArrayList<Student> array) throws IOException{
//        ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream("Data.txt"));
//        oos.writeObject(array);
//        oos.flush();
//        oos.close();
       BufferedWriter bw =new BufferedWriter(new FileWriter("data.txt"));
       for (Student s:array){
           StringBuilder sb=new StringBuilder();
           sb.append(s.getSid()).append(",").append(s.getName()).append(",")
                   .append(s.getSex()).append(",").append(s.getAge()).append(",").append(s.getMajor());
           bw.write(sb.toString());
           bw.newLine();
           bw.flush();
       }

       bw.close();
    }
    //加载数据
    public static ArrayList<Student> load( ) throws IOException, ClassNotFoundException {
//        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Data.txt"));
//        Object obj = ois.readObject();
//        ois.close();
//        return (ArrayList<Student>) obj;
        BufferedReader br=new BufferedReader(new FileReader("data.txt"));
        ArrayList<Student> array =new ArrayList<>();
        String line;
        while ((line=br.readLine())!=null){
            String[] str=line.split(",");
            Student s=new Student();
            s.setSid(str[0]);
            s.setName(str[1]);
            s.setSex(str[2]);
            s.setAge(str[3]);
            s.setMajor(str[4]);

            array.add(s);
        }
        br.close();
        return array;
    }
}
