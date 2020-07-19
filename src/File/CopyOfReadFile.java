package File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;

public class CopyOfReadFile {
    public static ArrayList<String> readfile(String filepath) throws FileNotFoundException {
        ArrayList<String> filearray = null;
        File file = new File(filepath);
        if (!file.isDirectory()) {
//            System.out.println("文件");
//            System.out.println("path=" + file.getPath());
//            System.out.println("absolutepath=" + file.getAbsolutePath());
//            System.out.println("name=" + file.getName());
            String filename = file.getAbsolutePath();
            int j = 0;
            for (j = filename.length() - 1; j >= 0; j--) {
                if (filename.charAt(j) == '.') {
                    break;
                }
            }
            String s = filename.substring(j + 1);
            if (s.equals("csv")) {
                filearray = new ArrayList<String>();
                filearray.add(file.getAbsolutePath());
            }
            return filearray;
        } else if (file.isDirectory()) {
            System.out.println("文件夹");
            String[] filelist = file.list();
            for (int i = 0; i < filelist.length; i++) {
                File readfile = new File(filepath + "\\" + filelist[i]);
                if (!readfile.isDirectory()) {
                    //                       System.out.println("path=" + readfile.getPath());
                    String filename = readfile.getAbsolutePath();
                    int j = 0;
                    for (j = filename.length() - 1; j >= 0; j--) {
                        if (filename.charAt(j) == '.') {
                            break;
                        }
                    }
                    String s = filename.substring(j + 1);
                    if (s.equals("csv")) {
                        if (filearray == null) {
                            filearray = new ArrayList<String>();
                        }
                        filearray.add(readfile.getAbsolutePath());
                    }
                    //                        System.out.println("absolutepath=" + readfile.getAbsolutePath());
                    //                        System.out.println("name=" + readfile.getName());

                } else if (readfile.isDirectory()) {
                    System.out.println("该文件包含文件夹");
                    //                        readfile(filepath + "\\" + filelist[i]);
                }
            }
        }

//        } catch (FileNotFoundException e) {
//            System.out.println("readfile()   Exception:" + e.getMessage());
//        }
        return filearray;
    }
    public static Boolean readrecord(String filepath) throws FileNotFoundException {
        File file = new File(filepath);
        if (!file.isDirectory()) {
            String filename = file.getAbsolutePath();
            int j = 0;
            for (j = filename.length() - 1; j >= 0; j--) {
                if (filename.charAt(j) == '.') {
                    break;
                }
            }
            String s = filename.substring(j + 1);
            if (s.equals("xls")||s.equals("xlsx")) {
                return true;
            }
            return false;
        } else if (file.isDirectory()) {
            return false;
        }
        return false;
    }
    public static void main(String args[]){
        try {
            ArrayList<String> filearray=null;
            filearray=readfile("D:\\data");
            System.out.println(filearray);
            System.out.println(filearray.size());
        }
        catch(FileNotFoundException e){

        }catch(IOException e){

        }
    }
}
