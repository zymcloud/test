package view;
import File.CopyOfReadFile;
import com.alibaba.druid.pool.DruidDataSource;
import csv.Csv;
import dao.oilDao;
import daomain.oil;
import org.w3c.dom.ls.LSOutput;
import view.util.border.*;
import view.util.*;
import view.util.layout.*;

import javax.sql.DataSource;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class MyFrame extends JFrame{
    // 单行文本框
    ColorfulLabel maintitle=new ColorfulLabel("CSV文件存入数据库系统",Color.green);
    AfPanel message=new AfPanel();
    AfPanel body=new AfPanel();
    private JLabel text2;
    private JLabel text3;
    private JLabel text4;
    private JLabel text5;
    private JLabel text6;
    private JTextField scvtext2;
    private JTextField url_text1;
    private JTextField url_text2;
    private JTextField url_text3;
    private JTextField schema_text1;
    private JTextField schema_text2;
//    // 多行文本框
//    JTextArea a2 = new JTextArea();
//    // 按钮
//    JButton sendButton = new JButton("发送");
    private ArrayList<String> scvfiles=null;
    private String scvaddress=null;
    private String url=null;
    private String username=null;
    private String password=null;
    private String dsname=null;
    private String table=null;

    public MyFrame(String title) {
        super(title);
        // 根容器
        AfPanel root = new AfPanel();
        this.setContentPane(root);
        root.padding(30);
        // 总体上使用 BorderLayout
        root.setLayout(new AfYLayout());
        maintitle.setFont(new Font("微软雅黑",0,30));
        root.add(maintitle,"10%");
        root.add(new AfPanel(),"3%");
        root.add(message,"44%");
        message.setBorder(BorderFactory.createLineBorder(Color.green,1));
        message.setLayout(new AfYLayout());
        message.preferredWidth(400);
        message.padding(0,30,0,0);
        JLabel text1=new ColorfulLabel("当前信息",Color.green);
        text1.setFont(new Font("微软雅黑",0,22));
        message.add(text1,"20%");
        if(scvaddress==null) {
                   text2 =new ColorfulLabel("CSV:还没有录入csv文件地址" , Color.green);
        }else{
            text2=new ColorfulLabel("SCV:"+ scvaddress, Color.green);
        }
        text2.setFont(new Font("微软雅黑",0,20));
        message.add(text2,"14%");
        message.add(new AfPanel(),"2%");

        if(url==null) {
            text3 =new ColorfulLabel("url:还没有录入url地址" , Color.green);
        }else{
            text3=new ColorfulLabel("url:"+ url, Color.green);
        }
        text3.setFont(new Font("微软雅黑",0,20));
        message.add(text3,"14%");
        message.add(new AfPanel(),"2%");
        if(username==null) {
            text4 =new ColorfulLabel("Username:还没有录入username" , Color.green);
        }else{
            text4=new ColorfulLabel("Username:"+ username, Color.green);
        }
        text4.setFont(new Font("微软雅黑",0,20));
        message.add(text4,"14%");
        message.add(new AfPanel(),"2%");
        if(dsname==null) {
            text5 =new ColorfulLabel("Schema:还没有录入schema" , Color.green);
        }else{
            text5=new ColorfulLabel("Schema:"+ dsname, Color.green);
        }
        text5.setFont(new Font("微软雅黑",0,20));
        message.add(text5,"14%");
        message.add(new AfPanel(),"2%");
        if(table==null) {
            text6 =new ColorfulLabel("Table:还没有录入table" , Color.green);
        }else{
            text6=new ColorfulLabel("Table:"+ dsname, Color.green);
        }
        text6.setFont(new Font("微软雅黑",0,20));
        message.add(text6,"14%");
        text2.setHorizontalAlignment(SwingConstants.LEFT);
        text3.setHorizontalAlignment(SwingConstants.LEFT);
        text4.setHorizontalAlignment(SwingConstants.LEFT);
        text5.setHorizontalAlignment(SwingConstants.LEFT);
        text6.setHorizontalAlignment(SwingConstants.LEFT);
        message.add(new AfPanel(),"2%");
        root.add(new AfPanel(),"3%");
        root.add(body,"46%");
        body.setLayout(new CardLayout());
        AfPanel body1=new AfPanel();
        body.add(body1,"body1");
        body1.setLayout(new AfXLayout());
        body1.add(new AfPanel(),"27%");
        AfPanel body1center =new AfPanel();
        body1.add(body1center,"46%");
        body1.add(new AfPanel(),"27%");
        body1center.setLayout(new AfYLayout());
        JButton button1=new JButton("修改csv地址信息");
        button1.setFont(new Font("微软雅黑",0,20));
        button1.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cardLayout=(CardLayout)body.getLayout();
                        cardLayout.show(body,"scv");
                        System.out.println("成功点击");
                    }
                }
        );
        JButton button2=new JButton("修改数据库信息");
        button2.setFont(new Font("微软雅黑",0,20));
        button2.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cardLayout=(CardLayout)body.getLayout();
                        cardLayout.show(body,"datasource");
                        System.out.println("成功点击button2");
                    }
                }
        );
        JButton button3=new JButton("录入数据库");
        button3.setFont(new Font("微软雅黑",0,20));
        button3.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        mythread2 mythread=new mythread2();
                        mythread.start();
                        //save();
                        System.out.println("成功点击button3");
                    }
                }
        );
        body1center.add(button1,"20%");
        body1center.add(new AfPanel(),"10%");
        body1center.add(button2,"20%");
        body1center.add(new AfPanel(),"10%");
        body1center.add(button3,"20%");
        AfPanel scv=new AfPanel();
        body.add(scv,"scv");
//        CardLayout cardLayout=(CardLayout)body.getLayout();
////        cardLayout.show(body,"scv");
        scv.setLayout(new AfYLayout());
        scv.add(new AfPanel(),"20%");
        AfPanel scvmain=new AfPanel();
        scv.add(scvmain,"20%");
        scv.add(new AfPanel(),"3%");
        scvmain.setLayout(new AfXLayout());
        ColorfulLabel scvtext=new ColorfulLabel("csv文件地址：",Color.black);
        scvtext.setFont(new Font("微软雅黑",0,18));
        scvmain.add(scvtext,"25%");
        scvtext2= new JTextField();
        scvtext2.setEnabled(false);
        scvtext2.setFont(new Font("微软雅黑",0,16));
        scvmain.add(scvtext2,"50%");
        JButton button4=new JButton("选择");
        button4.setFont(new Font("微软雅黑",0,15));
        button4.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JFileChooser jfc=new JFileChooser();
                        jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES );
                        jfc.showDialog(new JLabel(), "选择");
                        if(jfc.APPROVE_OPTION==0) {
                            File file = jfc.getSelectedFile();
                            if (file.isDirectory()) {
                                String newscvaddress=file.getAbsolutePath();
                                changescvaddress(newscvaddress);
//                                System.out.println("文件夹:" + file.getAbsolutePath());
                            } else if (file.isFile()) {
                                String newscvaddress=file.getAbsolutePath();
                                changescvaddress(newscvaddress);
//                                System.out.println(file.getAbsolutePath());
                            }
                        }//System.out.println(jfc.getSelectedFile().getName());
//                    }

//                        String newscvaddress=scvtext2.getText();
//                        changescvaddress(newscvaddress);
                        System.out.println("button4点击");
                    }
                }
        );
        scvmain.add(button4,"20%");
        AfPanel bottom=new AfPanel();
        scv.add(new AfPanel(),"5%");
        scv.add(bottom,"20%");
        bottom.setLayout(new AfXLayout());
        bottom.add(new AfPanel(),"30%");
        JButton button5=new JButton("返回");
        button5.setFont(new Font("微软雅黑",0,20));
        button5.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        scvtext2.setText("");
                        CardLayout cardLayout=(CardLayout)body.getLayout();
                        cardLayout.show(body,"body1");
                        System.out.println("成功点击");
                    }
                }
        );
        bottom.add(button5,"30%");
        bottom.add(new AfPanel(),"30%");
        AfPanel datasource=new AfPanel();
        body.add(datasource,"datasource");
        datasource.setLayout(new AfXLayout());
        datasource.add(new AfPanel(),"20%");
        AfPanel datasourcecenter=new AfPanel();
        datasource.add(datasourcecenter,"60%");
        datasource.add(new AfPanel(),"20%");
        datasourcecenter.setLayout(new AfYLayout());
        datasourcecenter.add(new AfPanel(),"5%");
        JButton button6=new JButton("修改数据库连接");
        button6.setFont(new Font("微软雅黑",0,20));
        button6.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cardLayout=(CardLayout)body.getLayout();
                        cardLayout.show(body,"url");
                        System.out.println("成功点击button6");
                    }
                }
        );
        datasourcecenter.add(button6,"20%");
        datasourcecenter.add(new AfPanel(),"5%");
        JButton button7=new JButton("修改关系或表名");
        button7.setFont(new Font("微软雅黑",0,20));
        button7.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(url==null||username==null||password==null) {
                            showwarning();
                            return;
                        }
                        CardLayout cardLayout=(CardLayout)body.getLayout();
                        cardLayout.show(body,"schema");
                        System.out.println("成功点击button7");
                    }
                }
        );
        datasourcecenter.add(button7,"20%");
        datasourcecenter.add(new AfPanel(),"5%");
        JButton button8=new JButton("返回");
        button8.setFont(new Font("微软雅黑",0,20));
        button8.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cardLayout=(CardLayout)body.getLayout();
                        cardLayout.show(body,"body1");
                        System.out.println("成功点击button8");
                    }
                }
        );
        datasourcecenter.add(button8,"20%");
        AfPanel url=new AfPanel();
        body.add(url,"url");
        url.setLayout(new AfYLayout());
        AfPanel urltext1=new AfPanel();
        url.add(new AfPanel(),"2%");
        url.add(urltext1,"20%");
        urltext1.setLayout(new AfXLayout());
        ColorfulLabel urltext1_1=new ColorfulLabel("url:",Color.green);
        urltext1_1.setFont(new Font("微软雅黑",0,18));
        urltext1.add(new AfPanel(),"15%");
        urltext1.add(urltext1_1,"10%");
        url_text1=new JTextField();
        url_text1.setFont(new Font("微软雅黑",0,16));
        urltext1.add(url_text1,"50%");
        AfPanel urltext2=new AfPanel();
        url.add(new AfPanel(),"2%");
        url.add(urltext2,"20%");
        urltext2.setLayout(new AfXLayout());
        ColorfulLabel urltext2_1=new ColorfulLabel("Username:",Color.green);
        urltext2_1.setFont(new Font("微软雅黑",0,18));
        urltext2.add(new AfPanel(),"2%");
        urltext2.add(urltext2_1,"23%");
        url_text2=new JTextField();
        url_text2.setFont(new Font("微软雅黑",0,16));
        urltext2.add(url_text2,"50%");
        AfPanel urltext3=new AfPanel();
        url.add(new AfPanel(),"2%");
        url.add(urltext3,"20%");
        urltext3.setLayout(new AfXLayout());
        ColorfulLabel urltext3_1=new ColorfulLabel("Password:",Color.green);
        urltext3_1.setFont(new Font("微软雅黑",0,18));
        urltext3.add(new AfPanel(),"2%");
        urltext3.add(urltext3_1,"23%");
        url_text3 = new JPasswordField();
//        url_text3=new JTextField();
        url_text3.setFont(new Font("微软雅黑",0,16));
        urltext3.add(url_text3,"50%");
        url.add(new AfPanel(),"7%");
        AfPanel urlbottom=new AfPanel();
        url.add(urlbottom,"20%");
        urlbottom.setLayout(new AfXLayout());
        urlbottom.add(new AfPanel(),"20%");
        JButton button9=new JButton("提交");
        button9.setFont(new Font("微软雅黑",0,20));
        button9.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String url=url_text1.getText();
                        String name=url_text2.getText();
                        String password=url_text3.getText();
                        changeurl(url,name,password);
                        System.out.println("成功点击button9");
                    }
                }
        );
        urlbottom.add(button9,"20%");
        urlbottom.add(new AfPanel(),"15%");
        JButton button10=new JButton("返回");
        button10.setFont(new Font("微软雅黑",0,20));
        button10.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cardLayout=(CardLayout)body.getLayout();
                        cardLayout.show(body,"datasource");
                        System.out.println("成功点击button10");
                    }
                }
        );
        urlbottom.add(button10,"20%");
//        2
        AfPanel schema=new AfPanel();
        body.add(schema,"schema");
        schema.setLayout(new AfYLayout());
        AfPanel schematext1=new AfPanel();
        schema.add(new AfPanel(),"2%");
        schema.add(schematext1,"20%");
        schematext1.setLayout(new AfXLayout());
        ColorfulLabel schematext1_1=new ColorfulLabel("Schema:",Color.green);
        schematext1_1.setFont(new Font("微软雅黑",0,20));
        schematext1.add(new AfPanel(),"5%");
        schematext1.add(schematext1_1,"20%");
        schema_text1=new JTextField();
        schema_text1.setFont(new Font("微软雅黑",0,16));
        schematext1.add(schema_text1,"50%");
        AfPanel schematext2=new AfPanel();
        schema.add(new AfPanel(),"10%");
        schema.add(schematext2,"20%");
        schematext2.setLayout(new AfXLayout());
        ColorfulLabel schematext2_1=new ColorfulLabel("Table:",Color.green);
        schematext2_1.setFont(new Font("微软雅黑",0,20));
        schematext2.add(new AfPanel(),"10%");
        schematext2.add(schematext2_1,"15%");
        schema_text2=new JTextField();
        schema_text2.setFont(new Font("微软雅黑",0,16));
        schematext2.add(schema_text2,"50%");
        AfPanel schematext3=new AfPanel();
        schema.add(new AfPanel(),"2%");
//        schema.add(schematext3,"20%");
//        schematext3.setLayout(new AfXLayout());
//        ColorfulLabel schematext3_1=new ColorfulLabel("Password:",Color.green);
//        schematext3_1.setFont(new Font("微软雅黑",0,18));
//        schematext3.add(new AfPanel(),"2%");
//        schematext3.add(schematext3_1,"23%");
//        schema_text3=new JTextField();
//        schema_text3.setFont(new Font("微软雅黑",0,16));
//        schematext3.add(schema_text3,"50%");
        schema.add(new AfPanel(),"7%");
        AfPanel schemabottom=new AfPanel();
        schema.add(schemabottom,"20%");
        schemabottom.setLayout(new AfXLayout());
        schemabottom.add(new AfPanel(),"20%");
        JButton button11=new JButton("提交");
        button11.setFont(new Font("微软雅黑",0,20));
        button11.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String schema=schema_text1.getText();
                        String table=schema_text2.getText();
                        changeschema(schema,table);
                        System.out.println("成功点击button11");
                    }
                }
        );
        schemabottom.add(button11,"20%");
        schemabottom.add(new AfPanel(),"15%");
        JButton button12=new JButton("返回");
        button12.setFont(new Font("微软雅黑",0,20));
        button12.addActionListener(
                new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        CardLayout cardLayout=(CardLayout)body.getLayout();
                        cardLayout.show(body,"datasource");
                        System.out.println("成功点击button12");
                    }
                }
        );
        schemabottom.add(button12,"20%");
    }
    void changescvaddress(String newscvaddress){
//        scvaddress=newscvaddress;
//        Csv csv=new Csv();
//        Boolean isexist=csv.isexist(newscvaddress);
//        if(isexist) {
//            JOptionPane.showMessageDialog(this, "修改成功", "提示",JOptionPane.WARNING_MESSAGE);
//            scvaddress=newscvaddress;
//            scvtext2.setText("");
//            text2.setText("CSV:" + scvaddress);
//        }
//        else{
//            JOptionPane.showMessageDialog(this, "未找到该文件，或者该文件为空", "提示",JOptionPane.WARNING_MESSAGE);
//        }
        try {
            scvfiles = CopyOfReadFile.readfile(newscvaddress);
            if(scvfiles==null){
                JOptionPane.showMessageDialog(this, "该文件夹下未找到csv文件", "提示",JOptionPane.WARNING_MESSAGE);
            }else{
                scvaddress=newscvaddress;
                scvtext2.setText(scvaddress);
                text2.setText("CSV:" + scvaddress);
                JOptionPane.showMessageDialog(this, "修改成功", "提示",JOptionPane.WARNING_MESSAGE);
            }
        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(this, "未找到该文件或文件夹", "提示",JOptionPane.WARNING_MESSAGE);
            e.printStackTrace();
        }

    }
    void changeurl(String url,String username,String password){
        oilDao oildao=new oilDao();
        String url2="jdbc:mysql://"+url+"/mysql";
        Boolean isconnect=oildao.checkconnection(url2,username,password);
        if(isconnect) {
            this.url = url;
            this.username = username;
            this.password = password;
            text3.setText("url:" + this.url);
            text4.setText("Username:" + this.username);
//            seturl();
            JOptionPane.showMessageDialog(this, "成功连接到数据库", "提示",JOptionPane.WARNING_MESSAGE);
        }else{
            JOptionPane.showMessageDialog(this, "修改失败，不能连接到数据库", "警告",JOptionPane.WARNING_MESSAGE);
        }
    }
    void changeschema(String schema,String table){
        oilDao oildao=new oilDao();
        if(url==null||username==null||password==null){
            JOptionPane.showMessageDialog(this, "请先连接数据库", "警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        String url2="jdbc:mysql://"+url+"/"+schema;
        Boolean isschemaexist=oildao.isSchemaExist(url2,username,password,schema);
        if(isschemaexist){
//           Boolean issame=check(schema);
//           if(!issame){
//             changeurl(schema);
//           }
            this.dsname=schema;
            text5.setText("Schema:"+this.dsname);
        }else{
            url2="jdbc:mysql://"+url+"/mysql";
            int choice=JOptionPane.showConfirmDialog(null, "数据库中没有该数据库的名字，是否要创建该数据库", "提示",JOptionPane.YES_NO_OPTION);
                if(choice==0){
                    Boolean createschema=oildao.createSchema(url2,username,password,schema);
                    if(createschema){
                        this.dsname=schema;
                        text5.setText("Schema:"+this.dsname);
                        JOptionPane.showMessageDialog(this, "创建数据库成功", "提示",JOptionPane.WARNING_MESSAGE);
//                        changeurl(schema);
                    } else{
                        JOptionPane.showMessageDialog(this, "创建数据库成功", "提示",JOptionPane.WARNING_MESSAGE);
                   return;
                }
            }else{
                return;
            }
        }
        Boolean istableexist=oildao.isTableExist(url2,username,password,schema,table);
        if(istableexist){
            this.table=table;
            text6.setText("Table:"+this.table);
        }else{
            int choice=JOptionPane.showConfirmDialog(null, "数据库"+schema+"中，没有"+table+"table"+"是否创建一个新表"+table, "提示",JOptionPane.YES_NO_OPTION);
            if(choice==0){
                Boolean createtable=oildao.createTable(url2,username,password,table);
                if(createtable){
                    this.table=table;
                    text6.setText("Table:"+this.table);
                    JOptionPane.showMessageDialog(this, "创建"+table+"table成功", "提示",JOptionPane.WARNING_MESSAGE);
                }else {
                    JOptionPane.showMessageDialog(this, "创建" + table + "table失败", "提示", JOptionPane.WARNING_MESSAGE);
                    return;
                }
            }else{
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "修改"+table+"table成功", "提示",JOptionPane.WARNING_MESSAGE);
//        this.table=table;
//        text5.setText("数据库关系名:"+this.dsname);
//        text6.setText("表格名:"+this.table);
    }
//    Boolean check(String schema){
//        int i=0;
//        for(i=url.length()-1;i>=0;i--){
//            if(url.charAt(i)=='/'){
//                break;
//            }
//        }
//        String s=this.url.substring(i+1);
//        System.out.println(s);
//        if(s.equals(schema))
//            return true;
//        return false;
//    }
//    void changeurl(String schema){
//        int i=0;
//        for(i=url.length()-1;i>=0;i--){
//            if(url.charAt(i)=='/'){
//                break;
//            }
//        }
//        String s=this.url.substring(0,i+1);
//        System.out.println(s);
//        s+=schema;
//        this.url=s;
//        text3.setText("url:" + this.url);
//    }
//    void seturl(){
//        int i=0;
//        for(i=url.length()-1;i>=0;i--){
//            if(url.charAt(i)=='/'){
//                break;
//            }
//        }
//        String s=this.url.substring(i+1);
//        this.dsname=s;
//        text5.setText("Schema:"+this.dsname);
//    }
    void save(){
        if(scvaddress==null){
            JOptionPane.showMessageDialog(this, "请先填写scv文件地址", "警告",JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(url==null||username==null||password==null||dsname==null|| table==null){
            JOptionPane.showMessageDialog(this, "请先填写数据库信息", "警告",JOptionPane.WARNING_MESSAGE);
            return;
        }

        //String scvaddress=this.scvaddress;
        String username=this.username;
        String password=this.password;
        String table=this.table;
        String url2="jdbc:mysql://"+url+"/"+dsname;
        ArrayList<String> scvs= (ArrayList<String>)this.scvfiles.clone();
        oilDao oildao=new oilDao();
        /**多线程操作
        Executor service= Executors.newFixedThreadPool(scvs.size());
        for(int i=0;i<scvs.size();i++){
            service.execute(new mythread(url,username,password,table,scvs.get(i)));
        }
         */
        /**单线程操作
         *
         */
        Csv csv=new Csv();
        ArrayList<oil> arraylist=null;
          for(int i=0;i<scvs.size();i++){
              arraylist=csv.getimformation(scvs.get(i));
              if(arraylist.size()==0){
                  JOptionPane.showMessageDialog(new JFrame(), scvs.get(i)+"文件为空", "警告", JOptionPane.WARNING_MESSAGE);
                  continue;
              }
              Boolean a=oildao.insertdata(url2,username,password,table,arraylist);
              if(a==false){
                  JOptionPane.showMessageDialog(new JFrame(), scvs.get(i)+"存入失败", "警告", JOptionPane.WARNING_MESSAGE);
              }else{
                  JOptionPane.showMessageDialog(new JFrame(), scvs.get(i)+"存入成功", "提示", JOptionPane.WARNING_MESSAGE);
              }
          }

/*
        ArrayList<oil> arrayList=csv.getimformation(scvaddress);
        Boolean issave=oildao.insertdata(url,username,password,dsname,table,arrayList);
        if(!issave) {
            JOptionPane.showMessageDialog(this, "录入数据库失败", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        for(int i=0;i<arrayList.size();i++){
            Boolean issave=oildao.insertdata(url,username,password,dsname,table,arrayList.get(i));
            if(!issave){
                JOptionPane.showMessageDialog(this, "录入数据库失败", "警告",JOptionPane.WARNING_MESSAGE);
                return;
            }
        }
        JOptionPane.showMessageDialog(this, "录入数据库成功", "提示",JOptionPane.WARNING_MESSAGE);
*/
    }
    void showwarning(){
        JOptionPane.showMessageDialog(this, "请先连接数据库", "警告", JOptionPane.WARNING_MESSAGE);
    }
    private static class ColorfulLabel extends JLabel{
        public void setboard(int width,int height){
            setPreferredSize(new Dimension(width,height));
        }
        public ColorfulLabel(String text,Color bgColor){
            super(text);
//            setOpaque(true);
//////            setBackground(bgColor);
            setHorizontalAlignment(SwingConstants.CENTER);
        }
    }
    class mythread2 extends Thread{
        public void run(){
            save();
        }
    }
}

class mythread implements Runnable{
    private static String url;
    private static String username;
    private static String password;
    private static String table;
    private String csvname;
    public mythread(String url,String username,String password,String table,String csv){
        if(url==null)
        this.url=url;
        if(username==null)
        this.username=username;
        if(password==null)
        this.password=password;
        if(table==null)
        this.table=table;
        csvname=csv;
    }
    @Override
    public void run() {
        Csv csv=new Csv();
        ArrayList<oil> arraylist=csv.getimformation(csvname);
        if(arraylist==null){
            JOptionPane.showMessageDialog(new JFrame(), csvname+"文件夹为空", "警告", JOptionPane.WARNING_MESSAGE);
            return;
        }
        oilDao oildao=new oilDao();
        Boolean a=oildao.insertdata(url,username,password,table,arraylist);
        if(a==false){
            JOptionPane.showMessageDialog(new JFrame(), csvname+"存入失败", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }
}
