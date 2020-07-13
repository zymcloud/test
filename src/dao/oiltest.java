package dao;

import csv.Csv;
import daomain.oil;

import java.util.ArrayList;

public class oiltest {
    public static void main(String[] args) {
        Csv csv=new Csv();
//        Boolean a=csv.isexist("D:\\data\\Rec1510100422.csv");
//        System.out.println(a);
//        a=csv.isexist("D:\\data\\1.csv");
//        System.out.println(a);
//        ArrayList<oil> arrayList=null;
//                arrayList=csv.getimformation("D:\\data\\Rec1510100422.csv");
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
        oilDao oildao=new oilDao();
//        Boolean a=oildao.isSchemaExist("jdbc:mysql://localhost/han","root","root","school");
//        System.out.println(a);
//        Boolean b=oildao.isTableExist("jdbc:mysql://localhost/han","root","root","han","course");
//        System.out.println(b);
//        Boolean a=oildao.createSchema("jdbc:mysql://localhost/han","root","root","newzym");
//        System.out.println(a);
        Boolean a=oildao.checkconnection("jdbc:mysql://localhost:3307/zym","root","root");
        System.out.println(a);
    }
}
