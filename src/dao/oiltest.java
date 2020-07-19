package dao;

import File.Readfile;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SRC_OUTPeer;
import csv.Csv;
import daomain.Record;
import daomain.oil;

import java.util.ArrayList;
import java.util.List;

public class oiltest {
    public static void main(String[] args) {
//        Csv csv=new Csv();
//        Boolean a=csv.isexist("D:\\data\\Rec1510100422.csv");
//        System.out.println(a);
//        a=csv.isexist("D:\\data\\1.csv");
//        System.out.println(a);
//      ArrayList<oil> arrayList=null;
//      arrayList=csv.getimformation("D:\\data3\\Rec2006020002.csv");
//        oilDao oildao=new oilDao();
//        Boolean b=oilDao.checkconnection("jdbc:mysql://localhost/han","root","root");
//        System.out.println(b);//jdbc:mysql://localhost/laojia
//        if(b){
//            for(int i=0;i<arrayList.size();i++){
//                Boolean c=oildao.insertdata("jdbc:mysql://localhost/han","root","root",arrayList.get(i));
//            }
////            Boolean c=oildao.insertdata("jdbc:mysql://localhost/han","root","root",arrayList.get(0));
////            System.out.println(c);
//        }
//        oilDao oildao=new oilDao();
//        Boolean a=oildao.isSchemaExist("jdbc:mysql://localhost/han","root","root","school");
//        System.out.println(a);
//        Boolean b=oildao.isTableExist("jdbc:mysql://localhost/han","root","root","han","course");
//        System.out.println(b);
//        Boolean a=oildao.createSchema("jdbc:mysql://localhost/han","root","root","newzym");
//        System.out.println(a);
//        Boolean a=oildao.checkconnection("jdbc:mysql://localhost:3307/zym"+"?serverTimezone=GMT%2B8","root","root");
//        System.out.println(a);
        // 2020.5克深8-13井工况记录(2)
//        Csv csv=new Csv();
//        Boolean a=csv.isexist("D:\\data3\\2020.5克深8-13井工况记录(2).xls");
//        System.out.println(a);
//        try{
//            List<String> list= Readfile.getSheet("D:\\data3\\2020.5克深8-13井工况记录(2).xls");
//            List<String> list2=Readfile.getColumn("D:\\data3\\2020.5克深8-13井工况记录(2).xls","工况统计",1);
//            List<String> list3 = Readfile.getColumn("D:\\data3\\2020.5克深8-13井工况记录(2).xls","工况统计", 3);
//            List<String> list4 = Readfile.getColumn("D:\\data3\\2020.5克深8-13井工况记录(2).xls", "工况统计",6);
//            System.out.println(list);
//             System.out.println(list2);
//            System.out.println(list3);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        try {
//            List<String> list = FileTest.getColumn("D:\\data3\\1.xls", 3);
//            List<String> list2=FileTest.getColumn("D:\\data3\\1.xls", 2);
//            List<String> list3=FileTest.getColumn("D:\\data3\\1.xls", 3);
//            System.out.println(list);
//        }catch(Exception e){
//            e.printStackTrace();
//            System.out.println("存在错误");
//        }
        try {
            ArrayList<Record> array=Readfile.readSpecifyColumns("D:\\data3\\2020.5克深8-13井工况记录(2).xls", "工况统计");
//            System.out.println(array);
            Csv csv=new Csv();
            ArrayList<oil> arrayList=null;
            //Rec2006020002.csv Rec2006020506.csv
            arrayList=csv.getimformation("D:\\data3\\Rec2006020506.csv");
            Record record1=array.get(0);
            Record record2=array.get(array.size()-1);
            int i=0;
            for(oil s:arrayList){
                Record record=new Record(s.getDatetime());
                int n=record1.Compare(record);
                int m=record2.Compare(record);
                if(n*m>0){
                    System.out.println("该日期范围不在日志范围内");
                    continue;
                }
                for(;i<array.size();i++){
                    if(array.get(i).Compare(record)==-1){
                        record.setState(array.get(i-1).getState());
//                        System.out.println("找到了");
                        System.out.println(record);
                        break;
                    }
                }
//                System.out.println(s.getDatetime());
//                System.out.println(record);
//                int x=getstate(array,s.getDatetime());
            }

        } catch (Exception e){
            e.printStackTrace();
        }
    }
    static int getstate(ArrayList<Record> array,String time){
        return -1;
    }

}
