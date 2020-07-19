package daomain;

import java.util.Arrays;

public class oil {
   private String datetime;
   private double[] datas;
   private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public oil(){
       datetime="00:00:00";
       datas=new double[66];
       state=0;
   }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public double[] getDatas() {
        return datas;
    }

    public void setDatas(double[] datas) {
        this.datas = datas;
    }

    public void setdata(String[] datas){
       datetime=datas[0];
       for(int i=1;i<datas.length;i++){
           this.datas[i-1]=Double.valueOf(datas[i]);
       }
   }

    @Override
    public String toString() {
        return "oil{" +
                "datetime='" + datetime + '\'' +
                ", datas=" + Arrays.toString(datas) +
                '}';
    }
}
