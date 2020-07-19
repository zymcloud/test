package File;

import daomain.Record;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.*;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Readfile {
    public static List<String> getColumn(String filename, String sheetname,int columnIndex) throws IOException{
        File f= new File(filename) ;    // 声明File对象
        InputStream iStream = null ;    // 准备好一个输入的对象
        iStream = new FileInputStream(f)  ;    // 通过对象多态性，进行实例化
        List<String> columnList=new ArrayList<>();
        Workbook book = new HSSFWorkbook(iStream);
        Sheet sheet = book.getSheet(sheetname);
        for (int runNum =1; runNum <=sheet.getLastRowNum();runNum++) {
            Cell cell=  sheet.getRow(runNum).getCell(columnIndex);
            cell.setCellType(CellType.STRING);
            columnList.add(cell.getStringCellValue());
//                int minColIx=row.getFirstCellNum();
//                int maxColIx=row.getLastCellNum();
//                //遍历该行，获取每个cell元素
//                for (int colIx = minColIx; colIx <maxColIx; colIx++) {
//                    Cell cell=row.getCell(colIx);
//                    //获取指定的一列
//                    if (cell.getColumnIndex()==columnIndex) {
//                        cell.setCellType(CellType.STRING);
//                        columnList.add(cell.getStringCellValue());
//                    }else {
//                        continue;
//                    }
//                }
        }
        return columnList;
    }
    public static ArrayList<Record> readSpecifyColumns(String filename,String sheetname)throws Exception {
        ArrayList<Record> arrayList=new ArrayList<Record>();
        File f= new File(filename) ;    // 声明File对象
        InputStream io = null ;    // 准备好一个输入的对象
        io = new FileInputStream(f)  ;    // 通过对象多态性，进行实例化
        Workbook readwb=null;
        readwb = new HSSFWorkbook(io);
        Sheet readsheet = readwb.getSheet(sheetname);
        //int rsColumns = readsheet.getColumnWidth(1);  //获取表格列数
        int rsRows = readsheet.getLastRowNum();  //获取表格行数
        String val1=null;
        String val2=null;
        for (int i = 1; i < rsRows; i++) {
            Row row=readsheet.getRow(i);
            Cell cell=row.getCell(1);
//            if(i==614){
//                System.out.println("我到了");
//            }
            if(cell!=null) {
                if(cell.getCellType().toString().equals("NUMERIC")) {
                    if (cell.getDateCellValue() != null) {
                        Date theDate = cell.getDateCellValue();
                        SimpleDateFormat dff = new SimpleDateFormat("yyyy-MM-dd");
                        val1 = dff.format(theDate);
//                        System.out.println(val1);
                    }
                }else{
//                    System.out.println(cell.getCellType());
                    if (cell.getCellType().toString().equals("STRING")) {
                        val1 = "2020-"+cell.getStringCellValue();
//                        System.out.println(val1);
                    }
                }
            }else{
//                System.out.println(cell.getCellType());
                System.out.println(i+"日期为空");
            }
//            } else{
//                DecimalFormat df = new DecimalFormat("0");
//                String val = df.format(cell.getNumericCellValue());
//                System.out.println(val);
//            }
//            cell.setCellType(CellType.STRING);
//            System.out.println(cell.getCellType());
//            System.out.println(cell.getLocalDateTimeCellValue());
            Cell cell2=row.getCell(2);
//            System.out.println(cell2.getCellType());
//            cell2.setCellType(CellType.STRING);
//            System.out.println(cell2.getNumericCellValue());
            if(cell2!=null) {
//                System.out.println(cell2.getCellType());
                if (cell2.getCellType().toString().equals("NUMERIC")) {
                    Date theDate2 = cell2.getDateCellValue();
                    SimpleDateFormat dff2 = new SimpleDateFormat("HH:mm:ss");
                    val2 = dff2.format(theDate2);
//                    System.out.println(val2);
                } else {
                    if (cell2.getCellType().toString().equals("BLANK")) {
                        continue;
//                        String val2="00:00:00";
//                        System.out.println(val2);
                    }
                    if (cell2.getCellType().toString().equals("STRING")) {
                          val2 = cell2.getStringCellValue() + ":00";
//                        System.out.println(val2);
                    }
                }
            }
            else{
                System.out.println(i+"时间为空");
            }
            Cell cell3=row.getCell(5);
            if(cell3!=null) {
//                System.out.println(cell3.getCellType());
                if (cell3.getCellType().toString().equals("STRING")) {
                    String val3=cell3.getStringCellValue();
//                    System.out.println(val1+" "+val2+" "+val3);
                    Record record=new Record(val1,val2,val3);
                    arrayList.add(record);
                } else {
                    if (cell3.getCellType().toString().equals("BLANK")) {
                        continue;
//                        String val2="00:00:00";
//                        System.out.println(val2);
                    }
                }
            }
            else{
                System.out.println(i+"工况为空");
            }

//            else{
//                DecimalFormat df = new DecimalFormat("0");
//                String val = df.format(cell2.getNumericCellValue());
//                System.out.println(val);
//            }

////            for(int j=0;j<row.getLastCellNum();j++){
//                Cell cell=row.getCell(j);
//                cell.setCellType(CellType.STRING);
//                System.out.println(cell.getStringCellValue());
//            }

        }
        return arrayList;
    }
    public static ArrayList<String> getSheet(String filename) throws IOException {
        File f= new File(filename) ;    // 声明File对象
        InputStream iStream = null ;    // 准备好一个输入的对象
        iStream = new FileInputStream(f)  ;    // 通过对象多态性，进行实例化
        ArrayList<String> columnList=new ArrayList<>();
        Workbook book = new HSSFWorkbook(iStream);
        for(int i=0;i<book.getNumberOfSheets();i++){
            Sheet sheet = book.getSheetAt(i);
            columnList.add(sheet.getSheetName());
        }
        return columnList;
    }
}
