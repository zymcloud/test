package csv;


import com.csvreader.CsvReader;
import daomain.oil;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Csv {
    public Boolean isexist(String address){
        CsvReader cr = null;
       try {
           cr = new CsvReader(address);
           if(cr.readHeaders()) {
               return true;
           }
           return false;
       }catch(Exception e){
           return false;
       }
    }
    public ArrayList<oil>getimformation(String address){
        ArrayList<oil> arrayList=new ArrayList<oil>();
        CsvReader cr = null;
        try{
            cr = new CsvReader(address);
            cr.readHeaders();
            while (cr.readRecord()) {
                oil oil=new oil();
                String[] strings=cr.getValues();
//                strings[0]="20"+strings[0];
                oil.setdata(strings);
//                System.out.println(oil);
                arrayList.add(oil);
            }
        }catch(Exception e){

        }
        return arrayList;
    }
//    public static void main(String[] args) {
//        Csv csv=new Csv();
//        Boolean a=csv.isexist("D:\\data\\Rec1510100422.csv");
//        System.out.println(a);
//        a=csv.isexist("D:\\data\\1.csv");
//        System.out.println(a);
//        ArrayList<oil> arrayList=csv.getimformation("D:\\data\\Rec1510100422.csv");
//    }
}
