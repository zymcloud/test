package daomain;

public class Record {
    private int year;
    private int month;
    private int date;
    private int hour;
    private int minute;
    private int second;
    private int state;
    private final static String[] strings={"钻进","循环","接单根","起钻","下钻","下套管","电测"};
//    Record(String ){
//
//    }
    public Record (String val1,String val2,String val3){
        state=0;
        year=Integer.parseInt(val1.substring(0,4));
        month=Integer.parseInt(val1.substring(5,7));
        date=Integer.parseInt(val1.substring(8,10));
        hour=Integer.parseInt(val2.substring(0,2));
        minute=Integer.parseInt(val2.substring(3,5));
        second=Integer.parseInt(val2.substring(6,8));
        for(int i=0;i<strings.length;i++){
            if(val3.indexOf(strings[i])!=-1){
                state=i+1;
                break;
            }
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDate() {
        return date;
    }

    public void setDate(int date) {
        this.date = date;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public Record(String s){
        int i=0,j;
        for(j=0;j<s.length();j++){
            if(s.charAt(j)=='-'||s.charAt(j)=='/'){
                break;
            }
        }
        String yearString=s.substring(i,j);
        if(yearString.length()==2){
            yearString="20"+yearString;
        }
        year=Integer.parseInt(yearString);

        i=j+1;
        for(j=j+1;j<s.length();j++){
            if(s.charAt(j)=='-'||s.charAt(j)=='/'){
                break;
            }
        }
        month=Integer.parseInt(s.substring(i,j));
        i=j+1;
        for(j=j+1;j<s.length();j++){
            if(s.charAt(j)==' '){
                break;
            }
        }
       date=Integer.parseInt(s.substring(i,j));
        i=j+1;
        for(j=j+1;j<s.length();j++){
            if(s.charAt(j)==':'){
                break;
            }
        }
        hour=Integer.parseInt(s.substring(i,j));
        i=j+1;
        for(j=j+1;j<s.length();j++){
            if(s.charAt(j)==':'){
                break;
            }
        }
        minute=Integer.parseInt(s.substring(i,j));
        second=0;
        if(j==s.length()){
            second=0;
        }else{
            i=j+1;
            for(j=j+1;j<s.length();j++){
                if(s.charAt(j)==':'){
                    break;
                }
            }
            second=Integer.parseInt(s.substring(i,j));
        }
    }
    @Override
    public String toString() {
        return   year +"-"+month+"-"+date+" "+ hour +":"+minute+":"+second +
                ", state=" + state+"\n";
    }

    public int Compare(Record record){//返回为1表示record时间晚  返回-1表示record时间早 返回0表示时间相同
        if(record.year>this.year){
            return 1;
        }else if(record.year<this.year){
                return -1;
        }
        if(record.month>this.month){
            return 1;
        }else if(record.month<this.month){
            return -1;
        }
        if(record.date>this.date){
            return 1;
        }else if(record.date<this.date){
            return -1;
        }
        if(record.hour>this.hour){
            return 1;
        }else if(record.hour<this.hour){
            return -1;
        }
        if(record.minute>this.minute){
            return 1;
        }else if(record.minute<this.minute){
            return -1;
        }
        if(record.second>this.second){
            return 1;
        }else if(record.second<this.second){
            return -1;
        }
        return 0;
    }
}
