package dao;

import com.alibaba.druid.pool.DruidDataSource;
import csv.Csv;
import dao.util.JDBCUtils;
import daomain.oil;

import java.sql.*;
import java.util.ArrayList;

public class oilDao {
    public Boolean checkconnection(String url,String username,String password) {
        Connection conn=null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            url+="serverTimezone=GMT%2B8";
            conn= DriverManager.getConnection(url,username,password);
            if(conn!=null){
                return true;
            }else{
                return false;
            }
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public Boolean insertdata(String url,String username,String password,String schema,String table,oil oil){
        String sql="INSERT INTO `"+schema+"`.`"+table+"` (`DateTime`, `Time`, `WellDep`, `HangDownDeep`, `DepthOfTheDrillBit`, `DrillDownDeep`," +
                " `DrillingTime`, `BitPressure`, `HangingLoad`, `RotationRate`, `Torque`, `KellyDown`, `HookPosition`, " +
                "`HookSpeed`, `StandpipePressurelog`, `CasingPressure`, `PumpStroke1`, `PumpStroke2`, " +
                "`PumpStroke3`, `TotalPoolSize`, `LayTime`, `MudSpill`, `InletFlowlog`," +
                " `OutletFlowlog`, `InletDensitylog`, `OutletDensitylog`, `EntranceTempreture`, `ExitTempreture`, `TotalHydrocarbon`, " +
                "`H2S`, `C1`, `C2`, `PWDDepth`, `PWDHangDownDeep`, `PWD_zzyl`, `PWD_hkyl`, `PWD_hkwd`, `PWD_cl_ECD`, `PWDWellDeviation`, " +
                "`PWDLocation`, `qztj`, `UpturnDepth`, `OperatorSchema`, `StandpipePressure`, `MeasurementOfBackPressure`, `OutletFlow`, " +
                "`OutletDensity`, `BackPressurePumpFlow`, `LoopBackPressure`, `AdditionalBackPressure`, `InletFlow`, `FixDepth`," +
                " `FixPointDownDeep`, `FixPointPressure`, `WellMouthAdjustment`, `FixPointPressureLoss`, `BoDongYL`, `YaHaoXZ`, `QiXiaZuanSD`," +
                " `QiXiaZuanJSD`, `FixPointECD`, `DrillECD`, `DrillStringPressureDrop`, `DrillBitPressureDrop`, " +
                "`EnvironmentalControlPressureLoss`, `TargetBackPressure`, `HydrostaticPressure`, `State_1`, `State_2`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, null)";
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            conn=JDBCUtils.getconnection(url,username,password);
            ps=conn.prepareStatement(sql);
            ps.setString(1,oil.getDatetime());
            for(int i=0;i<oil.getDatas().length;i++){
                ps.setDouble(i+2,oil.getDatas()[i]);
            }
            ps.execute();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            JDBCUtils.closeResource(conn,ps);
        }
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn= DriverManager.getConnection(url,username,password);
//            ps=conn.prepareStatement(sql);
//            ps.setString(1,oil.getDatetime());
//            for(int i=0;i<oil.getDatas().length;i++){
//                ps.setDouble(i+2,oil.getDatas()[i]);
//            }
//            ps.execute();
//            return true;
//        }catch(Exception e){
//            e.printStackTrace();
//            return false;
//        }finally{
//            if(ps!=null){
//                try {
//                    ps.close();
//                }catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//        }
    }
    public Boolean insertdata(String url,String username,String password,String table,ArrayList<oil> arraylist){
        String sql="INSERT INTO `"+table+"` (`DateTime`, `Time`, `WellDep`, `HangDownDeep`, `DepthOfTheDrillBit`, `DrillDownDeep`," +
                " `DrillingTime`, `BitPressure`, `HangingLoad`, `RotationRate`, `Torque`, `KellyDown`, `HookPosition`, " +
                "`HookSpeed`, `StandpipePressurelog`, `CasingPressure`, `PumpStroke1`, `PumpStroke2`, " +
                "`PumpStroke3`, `TotalPoolSize`, `LayTime`, `MudSpill`, `InletFlowlog`," +
                " `OutletFlowlog`, `InletDensitylog`, `OutletDensitylog`, `EntranceTempreture`, `ExitTempreture`, `TotalHydrocarbon`, " +
                "`H2S`, `C1`, `C2`, `PWDDepth`, `PWDHangDownDeep`, `PWD_zzyl`, `PWD_hkyl`, `PWD_hkwd`, `PWD_cl_ECD`, `PWDWellDeviation`, " +
                "`PWDLocation`, `qztj`, `UpturnDepth`, `OperatorSchema`, `StandpipePressure`, `MeasurementOfBackPressure`, `OutletFlow`, " +
                "`OutletDensity`, `BackPressurePumpFlow`, `LoopBackPressure`, `AdditionalBackPressure`, `InletFlow`, `FixDepth`," +
                " `FixPointDownDeep`, `FixPointPressure`, `WellMouthAdjustment`, `FixPointPressureLoss`, `BoDongYL`, `YaHaoXZ`, `QiXiaZuanSD`," +
                " `QiXiaZuanJSD`, `FixPointECD`, `DrillECD`, `DrillStringPressureDrop`, `DrillBitPressureDrop`, " +
                "`EnvironmentalControlPressureLoss`, `TargetBackPressure`, `HydrostaticPressure`, `State_1`, `State_2`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null)";
        Connection conn=null;
        PreparedStatement ps=null;
        try{
            url+="&rewriteBatchedStatements=true";
            conn=JDBCUtils.getconnection(url,username,password);
            ps=conn.prepareStatement(sql);
            for(int j=0;j<arraylist.size();j++){
                ps.setString(1,arraylist.get(j).getDatetime());
                for(int i=0;i<arraylist.get(j).getDatas().length;i++){
                    ps.setDouble(i+2,arraylist.get(j).getDatas()[i]);
                }
                ps.setInt(68,arraylist.get(j).getState());
                ps.addBatch();
                if(j%500==0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            ps.executeBatch();
            ps.clearBatch();
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            JDBCUtils.closeResource(conn,ps);
        }
    }
    public Boolean  insertdata2(String url,String username,String password,String table,ArrayList<oil> arraylist){
        url+="?rewriteBatchedStatements=true";
        DruidDataSource datasource = new DruidDataSource();
        datasource.setUrl(url);
        datasource.setUsername(username);
        datasource.setPassword(password);
        datasource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        String sql="INSERT INTO `"+table+"` (`DateTime`, `Time`, `WellDep`, `HangDownDeep`, `DepthOfTheDrillBit`, `DrillDownDeep`," +
                " `DrillingTime`, `BitPressure`, `HangingLoad`, `RotationRate`, `Torque`, `KellyDown`, `HookPosition`, " +
                "`HookSpeed`, `StandpipePressurelog`, `CasingPressure`, `PumpStroke1`, `PumpStroke2`, " +
                "`PumpStroke3`, `TotalPoolSize`, `LayTime`, `MudSpill`, `InletFlowlog`," +
                " `OutletFlowlog`, `InletDensitylog`, `OutletDensitylog`, `EntranceTempreture`, `ExitTempreture`, `TotalHydrocarbon`, " +
                "`H2S`, `C1`, `C2`, `PWDDepth`, `PWDHangDownDeep`, `PWD_zzyl`, `PWD_hkyl`, `PWD_hkwd`, `PWD_cl_ECD`, `PWDWellDeviation`, " +
                "`PWDLocation`, `qztj`, `UpturnDepth`, `OperatorSchema`, `StandpipePressure`, `MeasurementOfBackPressure`, `OutletFlow`, " +
                "`OutletDensity`, `BackPressurePumpFlow`, `LoopBackPressure`, `AdditionalBackPressure`, `InletFlow`, `FixDepth`," +
                " `FixPointDownDeep`, `FixPointPressure`, `WellMouthAdjustment`, `FixPointPressureLoss`, `BoDongYL`, `YaHaoXZ`, `QiXiaZuanSD`," +
                " `QiXiaZuanJSD`, `FixPointECD`, `DrillECD`, `DrillStringPressureDrop`, `DrillBitPressureDrop`, " +
                "`EnvironmentalControlPressureLoss`, `TargetBackPressure`, `HydrostaticPressure`, `State_1`, `State_2`)" +
                " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, " +
                "?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, null, null)";
        PreparedStatement ps=null;
        Connection conn=null;
        try {
            conn=datasource.getConnection();
            ps=conn.prepareStatement(sql);
            for(int j=0;j<arraylist.size();j++){
                ps.setString(1,arraylist.get(j).getDatetime());
                for(int i=0;i<arraylist.get(j).getDatas().length;i++){
                    ps.setDouble(i+2,arraylist.get(j).getDatas()[i]);
                }
                ps.addBatch();
                if(j%500==0){
                    ps.executeBatch();
                    ps.clearBatch();
                }
            }
            ps.executeBatch();
            ps.clearBatch();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }finally{
            JDBCUtils.closeResource(conn,ps);
        }
    }
    public Boolean isSchemaExist(String url,String username,String password,String schema){
        Connection conn=null;
        ResultSet rs=null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn= DriverManager.getConnection(url,username,password);
            conn=JDBCUtils.getconnection(url,username,password);
            rs = conn.getMetaData().getCatalogs();
            while (rs.next()) {
                if(schema.equals(rs.getString("TABLE_CAT"))) {
                    return true;
                }
//             System.out.println("TABLE_CAT = " + rs.getString("TABLE_CAT") );
            }
            return false;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally {
            JDBCUtils.closeResource(conn,rs);
//            if(rs!=null){
//                try {
//                    rs.close();
//                }catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
//            if(conn!=null){
//                try {
//                    conn.close();
//                } catch (SQLException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
    public boolean isTableExist(String url,String username,String password,String schema,String tableName) {
        Connection conn = null;
        PreparedStatement ps=null;
        ResultSet rs = null;
        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            conn= DriverManager.getConnection(url,username,password);
            conn=JDBCUtils.getconnection(url,username,password);
            String sql="select count(*) from information_schema.TABLES t where t.TABLE_SCHEMA =? and t.TABLE_NAME =?";
            ps=conn.prepareStatement(sql);
            ps.setString(1,schema);
            ps.setString(2,tableName);
            rs=ps.executeQuery();
            if(rs.next()){
                int number=rs.getInt(1);
                if(number==1){
                    return true;
                }
            }
            return false;
//            rs = null;
//            DatabaseMetaData data = conn.getMetaData();
//            String[] types = {"TABLE"};
//            rs = data.getTables(null, null, tableName, types);
//            if(rs.next()){
//                return true;
//            }else{
//                return false;
//            }ssword);
//
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }finally{
          JDBCUtils.closeResource(conn,ps,rs);
        }
    }
    public Boolean createSchema(String url,String username,String password,String schema){
        String ddl="CREATE DATABASE ";
        Connection conn=null;
//        PreparedStatement ps=null;
        Statement stmt=null;
        try{
            conn=JDBCUtils.getconnection(url,username,password);
            stmt=conn.createStatement();
//            ps.setString(1,schema);
            stmt.executeUpdate(ddl+schema);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            JDBCUtils.closeResource(conn,stmt);
        }
    }
    public Boolean createTable(String url,String  username,String password,String tableName){
        String ddl=
                "create table `"+tableName+"`  (\n" +
                "  `id` double(255, 0) UNSIGNED not null AUTO_INCREMENT,\n" +
                "  `DateTime` varchar(255) CHARACTER SET gb2312 COLLATE gb2312_chinese_ci NULL DEFAULT NULL,\n" +
                "  `Time` double(255, 10) NOT NULL,\n" +
                "  `WellDep` double(255, 10) NULL DEFAULT NULL COMMENT '井深(m)',\n" +
                "  `HangDownDeep` double(255, 10) NULL DEFAULT NULL COMMENT '垂深(m)',\n" +
                "  `DepthOfTheDrillBit` double(255, 10) NULL DEFAULT NULL COMMENT '钻头深度(m)',\n" +
                "  `DrillDownDeep` double(255, 10) NULL DEFAULT NULL COMMENT '钻头垂深(m)',\n" +
                "  `DrillingTime` double(255, 10) NULL DEFAULT NULL COMMENT '钻时(min/m)',\n" +
                "  `BitPressure` double(255, 10) NULL DEFAULT NULL COMMENT '钻压(KN)',\n" +
                "  `HangingLoad` double(255, 10) NULL DEFAULT NULL COMMENT '悬重(KN)',\n" +
                "  `RotationRate` double(255, 10) NULL DEFAULT NULL COMMENT '转速(rpm)',\n" +
                "  `Torque` double(255, 10) NULL DEFAULT NULL COMMENT '扭矩(KN.m)',\n" +
                "  `KellyDown` double(255, 10) NULL DEFAULT NULL COMMENT '方入(m)',\n" +
                "  `HookPosition` double(255, 10) NULL DEFAULT NULL COMMENT '大钩位置(m)',\n" +
                "  `HookSpeed` double(255, 10) NULL DEFAULT NULL COMMENT '大钩速度(m/s)',\n" +
                "  `StandpipePressurelog` double(255, 10) NULL DEFAULT NULL COMMENT '立压log(MPa)',\n" +
                "  `CasingPressure` double(255, 10) NULL DEFAULT NULL COMMENT '套压(MPa)',\n" +
                "  `PumpStroke1` double(255, 10) NULL DEFAULT NULL COMMENT '泵冲1(spm)',\n" +
                "  `PumpStroke2` double(255, 10) NULL DEFAULT NULL COMMENT '泵冲2(spm)',\n" +
                "  `PumpStroke3` double(255, 10) NULL DEFAULT NULL COMMENT '泵冲3(spm)',\n" +
                "  `TotalPoolSize` double(255, 10) NULL DEFAULT NULL COMMENT '总池体积(m3)',\n" +
                "  `LayTime` double(255, 10) NULL DEFAULT NULL COMMENT '迟到时间(min)',\n" +
                "  `MudSpill` double(255, 10) NULL DEFAULT NULL COMMENT '泥浆溢漏(m3)',\n" +
                "  `InletFlowlog` double(255, 10) NULL DEFAULT NULL COMMENT '入口流量log(L/s)',\n" +
                "  `OutletFlowlog` double(255, 10) NULL DEFAULT NULL COMMENT '出口流量log(%)',\n" +
                "  `InletDensitylog` double(255, 10) NULL DEFAULT NULL COMMENT '入口密度log(g/cc)',\n" +
                "  `OutletDensitylog` double(255, 10) NULL DEFAULT NULL COMMENT '出口密度log(g/cc)',\n" +
                "  `EntranceTempreture` double(255, 10) NULL DEFAULT NULL COMMENT '入口温度(℃)',\n" +
                "  `ExitTempreture` double(255, 10) NULL DEFAULT NULL COMMENT '出口温度(℃)',\n" +
                "  `TotalHydrocarbon` double(255, 10) NULL DEFAULT NULL COMMENT '总烃(%)',\n" +
                "  `H2S` double(255, 10) NULL DEFAULT NULL COMMENT 'H2S(ppm)',\n" +
                "  `C1` double(255, 10) NULL DEFAULT NULL COMMENT 'C1(%)',\n" +
                "  `C2` double(255, 10) NULL DEFAULT NULL COMMENT 'C2(%)',\n" +
                "  `PWDDepth` double(255, 10) NULL DEFAULT NULL COMMENT 'PWD深度(m)',\n" +
                "  `PWDHangDownDeep` double(255, 10) NULL DEFAULT NULL COMMENT 'PWD垂深(m)',\n" +
                "  `PWD_zzyl` double(255, 10) NULL DEFAULT NULL COMMENT 'PWD钻柱压力(MPa)',\n" +
                "  `PWD_hkyl` double(255, 10) NULL DEFAULT NULL COMMENT 'PWD环空压力(MPa)',\n" +
                "  `PWD_hkwd` double(255, 10) NULL DEFAULT NULL COMMENT 'PWD环空温度(℃)',\n" +
                "  `PWD_cl_ECD` double(255, 10) NULL DEFAULT NULL COMMENT 'PWD测量ECD(g/cc)',\n" +
                "  `PWDWellDeviation` double(255, 10) NULL DEFAULT NULL COMMENT 'PWD井斜(°)',\n" +
                "  `PWDLocation` double(255, 10) NULL DEFAULT NULL COMMENT 'PWD方位(°)',\n" +
                "  `qztj` double(255, 10) NULL DEFAULT NULL COMMENT '注替体积(m3)',\n" +
                "  `UpturnDepth` double(255, 10) NULL DEFAULT NULL COMMENT '上返深度(m)',\n" +
                "  `OperatorSchema` double(255, 10) NULL DEFAULT NULL COMMENT '操作模式',\n" +
                "  `StandpipePressure` double(255, 10) NULL DEFAULT NULL COMMENT '立压(MPa)',\n" +
                "  `MeasurementOfBackPressure` double(255, 10) NULL DEFAULT NULL COMMENT '测量回压(MPa)',\n" +
                "  `OutletFlow` double(255, 10) NULL DEFAULT NULL COMMENT '出口流量(L/s)',\n" +
                "  `OutletDensity` double(255, 10) NULL DEFAULT NULL COMMENT '出口密度(g/cc)',\n" +
                "  `BackPressurePumpFlow` double(255, 10) NULL DEFAULT NULL COMMENT '回压泵流量(L/s)',\n" +
                "  `LoopBackPressure` double(255, 10) NULL DEFAULT NULL COMMENT '循环回压(MPa)',\n" +
                "  `AdditionalBackPressure` double(255, 10) NULL DEFAULT NULL COMMENT '附加回压(MPa)',\n" +
                "  `InletFlow` double(255, 10) NULL DEFAULT NULL COMMENT '入口流量(L/s)',\n" +
                "  `FixDepth` double(255, 10) NULL DEFAULT NULL COMMENT '定点深度(m)',\n" +
                "  `FixPointDownDeep` double(255, 10) NULL DEFAULT NULL COMMENT '定点垂深(m)',\n" +
                "  `FixPointPressure` double(255, 30) NULL DEFAULT NULL COMMENT '定点压力(MPa)',\n" +
                "  `WellMouthAdjustment` double(255, 10) NULL DEFAULT NULL COMMENT '井口调节压力(MPa)',\n" +
                "  `FixPointPressureLoss` double(255, 10) NULL DEFAULT NULL COMMENT '定点压耗(MPa)',\n" +
                "  `BoDongYL` double(255, 10) NULL DEFAULT NULL COMMENT '波动压力(MPa)',\n" +
                "  `YaHaoXZ` double(255, 10) NULL DEFAULT NULL COMMENT '压耗修正(MPa/km)',\n" +
                "  `QiXiaZuanSD` double(255, 10) NULL DEFAULT NULL COMMENT '起下钻速度(m/s)',\n" +
                "  `QiXiaZuanJSD` double(255, 10) NULL DEFAULT NULL COMMENT '起下钻加速度(m/s2)',\n" +
                "  `FixPointECD` double(255, 10) NULL DEFAULT NULL COMMENT '定点ECD(g/cm2)',\n" +
                "  `DrillECD` double(255, 10) NULL DEFAULT NULL COMMENT '钻头ECD(g/cc)',\n" +
                "  `DrillStringPressureDrop` double(255, 10) NULL DEFAULT NULL COMMENT '钻柱压降(MPa)',\n" +
                "  `DrillBitPressureDrop` double(255, 10) NULL DEFAULT NULL COMMENT '钻头压降(MPa)',\n" +
                "  `EnvironmentalControlPressureLoss` double(255, 10) NULL DEFAULT NULL COMMENT '环空压耗(MPa)',\n" +
                "  `TargetBackPressure` double(255, 10) NULL DEFAULT NULL COMMENT '目标回压(MPa)',\n" +
                "  `HydrostaticPressure` double(255, 10) NULL DEFAULT NULL COMMENT '静液压力(MPa)',\n" +
                "  `State_1` double(255, 0) NULL DEFAULT NULL COMMENT '工况1',\n" +
                "  `State_2` double(255, 0) NULL DEFAULT NULL COMMENT '工况2',\n" +
                "  PRIMARY KEY USING BTREE (`id`)\n" +
                ") ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = gb2312 COLLATE = gb2312_chinese_ci ROW_FORMAT = Compact;\n";

        Connection conn=null;
//        PreparedStatement ps=null;
        Statement stmt=null;
        try{
            conn=JDBCUtils.getconnection(url,username,password);
            stmt=conn.createStatement();
//            ps.setString(1,schema);
            stmt.executeUpdate(ddl);
            return true;
        }catch(Exception e){
            e.printStackTrace();
            return false;
        }finally{
            JDBCUtils.closeResource(conn,stmt);
        }
    }

//    public Boolean save(String scvaddress,String url,String  username,String password,String schema,String tableName, ArrayList<oil> arrayList){
//        Csv csv=new Csv();
//        ArrayList<oil> arrayList=null;
//        arrayList=csv.getimformation("D:\\data\\Rec1510100422.csv");
//        oil oil=new oil();
//
//    }
}
