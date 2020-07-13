package daomain;

public class Oil2 {
    private String DateTime;
    private double Time;
    private double WellDep;
    private double HangDownDeep;
    private double DepthOfTheDrillBit;
    private double DrillDownDeep;
    private double DrillingTime;
    private double BitPressure;
    private double HangingLoad;
    private double RotationRate;
    private double Torque;
    private double KellyDown;
    private double HookPosition;
    private double HookSpeed;
    private double StandpipePressurelog;
    private double CasingPressure;
    private double PumpStroke1;
    private double PumpStroke2;
    private double PumpStroke3;
    private double TotalPoolSize;
    private double LayTime;
    private double MudSpill;
    private double InletFlowlog;
    private double OutletFlowlog;
    private double InletDensitylog;
    private double OutletDensitylog;
    private double EntranceTempreture;
    private double ExitTempreture;
    private double TotalHydrocarbon;
    private double H2S;
    private double C1;
    private double C2;
    private double PWDDepth;
    private double PWDHangDownDeep;
    private double PWD_zzyl;
    private double PWD_hkyl;
    private double PWD_hkwd;
    private double PWD_cl_ECD;
    private double PWDWellDeviation;
    private double PWDLocation;
    private double qztj;
    private double UpturnDepth;
    private double OperatorSchema;
    private double StandpipePressure;
    private double MeasurementOfBackPressure;
    private double OutletFlow;
    private double OutletDensity;
    private double BackPressurePumpFlow;
    private double LoopBackPressure;
    private double AdditionalBackPressure;
    private double InletFlow;
    private double FixDepth;
    private double FixPointDownDeep;
    private double FixPointPressure;
    private double WellMouthAdjustment;
    private double FixPointPressureLoss;
    private double BoDongYL;
    private double YaHaoXZ;
    private double QiXiaZuanSD;
    private double QiXiaZuanJSD;
    private double FixPointECD;
    private double DrillECD;
    private double DrillStringPressureDrop;
    private double DrillBitPressureDrop;
    private double EnvironmentalControlPressureLoss;
    private double TargetBackPressure;
    private double HydrostaticPressure;
    private double State_1;
    private double State_2;
    private int new_column;
    public Oil2(){

    }
    public void setvalue(String[] strings){
        DateTime=strings[0];
    }
    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public double getTime() {
        return Time;
    }

    public void setTime(double time) {
        Time = time;
    }

    public double getWellDep() {
        return WellDep;
    }

    public void setWellDep(double wellDep) {
        WellDep = wellDep;
    }

    public double getHangDownDeep() {
        return HangDownDeep;
    }

    public void setHangDownDeep(double hangDownDeep) {
        HangDownDeep = hangDownDeep;
    }

    public double getDepthOfTheDrillBit() {
        return DepthOfTheDrillBit;
    }

    public void setDepthOfTheDrillBit(double depthOfTheDrillBit) {
        DepthOfTheDrillBit = depthOfTheDrillBit;
    }

    public double getDrillDownDeep() {
        return DrillDownDeep;
    }

    public void setDrillDownDeep(double drillDownDeep) {
        DrillDownDeep = drillDownDeep;
    }

    public double getDrillingTime() {
        return DrillingTime;
    }

    public void setDrillingTime(double drillingTime) {
        DrillingTime = drillingTime;
    }

    public double getBitPressure() {
        return BitPressure;
    }

    public void setBitPressure(double bitPressure) {
        BitPressure = bitPressure;
    }

    public double getHangingLoad() {
        return HangingLoad;
    }

    public void setHangingLoad(double hangingLoad) {
        HangingLoad = hangingLoad;
    }

    public double getRotationRate() {
        return RotationRate;
    }

    public void setRotationRate(double rotationRate) {
        RotationRate = rotationRate;
    }

    public double getTorque() {
        return Torque;
    }

    public void setTorque(double torque) {
        Torque = torque;
    }

    public double getKellyDown() {
        return KellyDown;
    }

    public void setKellyDown(double kellyDown) {
        KellyDown = kellyDown;
    }

    public double getHookPosition() {
        return HookPosition;
    }

    public void setHookPosition(double hookPosition) {
        HookPosition = hookPosition;
    }

    public double getHookSpeed() {
        return HookSpeed;
    }

    public void setHookSpeed(double hookSpeed) {
        HookSpeed = hookSpeed;
    }

    public double getStandpipePressurelog() {
        return StandpipePressurelog;
    }

    public void setStandpipePressurelog(double standpipePressurelog) {
        StandpipePressurelog = standpipePressurelog;
    }

    public double getCasingPressure() {
        return CasingPressure;
    }

    public void setCasingPressure(double casingPressure) {
        CasingPressure = casingPressure;
    }

    public double getPumpStroke1() {
        return PumpStroke1;
    }

    public void setPumpStroke1(double pumpStroke1) {
        PumpStroke1 = pumpStroke1;
    }

    public double getPumpStroke2() {
        return PumpStroke2;
    }

    public void setPumpStroke2(double pumpStroke2) {
        PumpStroke2 = pumpStroke2;
    }

    public double getPumpStroke3() {
        return PumpStroke3;
    }

    public void setPumpStroke3(double pumpStroke3) {
        PumpStroke3 = pumpStroke3;
    }

    public double getTotalPoolSize() {
        return TotalPoolSize;
    }

    public void setTotalPoolSize(double totalPoolSize) {
        TotalPoolSize = totalPoolSize;
    }

    public double getLayTime() {
        return LayTime;
    }

    public void setLayTime(double layTime) {
        LayTime = layTime;
    }

    public double getMudSpill() {
        return MudSpill;
    }

    public void setMudSpill(double mudSpill) {
        MudSpill = mudSpill;
    }

    public double getInletFlowlog() {
        return InletFlowlog;
    }

    public void setInletFlowlog(double inletFlowlog) {
        InletFlowlog = inletFlowlog;
    }

    public double getOutletFlowlog() {
        return OutletFlowlog;
    }

    public void setOutletFlowlog(double outletFlowlog) {
        OutletFlowlog = outletFlowlog;
    }

    public double getInletDensitylog() {
        return InletDensitylog;
    }

    public void setInletDensitylog(double inletDensitylog) {
        InletDensitylog = inletDensitylog;
    }

    public double getOutletDensitylog() {
        return OutletDensitylog;
    }

    public void setOutletDensitylog(double outletDensitylog) {
        OutletDensitylog = outletDensitylog;
    }

    public double getEntranceTempreture() {
        return EntranceTempreture;
    }

    public void setEntranceTempreture(double entranceTempreture) {
        EntranceTempreture = entranceTempreture;
    }

    public double getExitTempreture() {
        return ExitTempreture;
    }

    public void setExitTempreture(double exitTempreture) {
        ExitTempreture = exitTempreture;
    }

    public double getTotalHydrocarbon() {
        return TotalHydrocarbon;
    }

    public void setTotalHydrocarbon(double totalHydrocarbon) {
        TotalHydrocarbon = totalHydrocarbon;
    }

    public double getH2S() {
        return H2S;
    }

    public void setH2S(double h2S) {
        H2S = h2S;
    }

    public double getC1() {
        return C1;
    }

    public void setC1(double c1) {
        C1 = c1;
    }

    public double getC2() {
        return C2;
    }

    public void setC2(double c2) {
        C2 = c2;
    }

    public double getPWDDepth() {
        return PWDDepth;
    }

    public void setPWDDepth(double PWDDepth) {
        this.PWDDepth = PWDDepth;
    }

    public double getPWDHangDownDeep() {
        return PWDHangDownDeep;
    }

    public void setPWDHangDownDeep(double PWDHangDownDeep) {
        this.PWDHangDownDeep = PWDHangDownDeep;
    }

    public double getPWD_zzyl() {
        return PWD_zzyl;
    }

    public void setPWD_zzyl(double PWD_zzyl) {
        this.PWD_zzyl = PWD_zzyl;
    }

    public double getPWD_hkyl() {
        return PWD_hkyl;
    }

    public void setPWD_hkyl(double PWD_hkyl) {
        this.PWD_hkyl = PWD_hkyl;
    }

    public double getPWD_hkwd() {
        return PWD_hkwd;
    }

    public void setPWD_hkwd(double PWD_hkwd) {
        this.PWD_hkwd = PWD_hkwd;
    }

    public double getPWD_cl_ECD() {
        return PWD_cl_ECD;
    }

    public void setPWD_cl_ECD(double PWD_cl_ECD) {
        this.PWD_cl_ECD = PWD_cl_ECD;
    }

    public double getPWDWellDeviation() {
        return PWDWellDeviation;
    }

    public void setPWDWellDeviation(double PWDWellDeviation) {
        this.PWDWellDeviation = PWDWellDeviation;
    }

    public double getPWDLocation() {
        return PWDLocation;
    }

    public void setPWDLocation(double PWDLocation) {
        this.PWDLocation = PWDLocation;
    }

    public double getQztj() {
        return qztj;
    }

    public void setQztj(double qztj) {
        this.qztj = qztj;
    }

    public double getUpturnDepth() {
        return UpturnDepth;
    }

    public void setUpturnDepth(double upturnDepth) {
        UpturnDepth = upturnDepth;
    }

    public double getOperatorSchema() {
        return OperatorSchema;
    }

    public void setOperatorSchema(double operatorSchema) {
        OperatorSchema = operatorSchema;
    }

    public double getStandpipePressure() {
        return StandpipePressure;
    }

    public void setStandpipePressure(double standpipePressure) {
        StandpipePressure = standpipePressure;
    }

    public double getMeasurementOfBackPressure() {
        return MeasurementOfBackPressure;
    }

    public void setMeasurementOfBackPressure(double measurementOfBackPressure) {
        MeasurementOfBackPressure = measurementOfBackPressure;
    }

    public double getOutletFlow() {
        return OutletFlow;
    }

    public void setOutletFlow(double outletFlow) {
        OutletFlow = outletFlow;
    }

    public double getOutletDensity() {
        return OutletDensity;
    }

    public void setOutletDensity(double outletDensity) {
        OutletDensity = outletDensity;
    }

    public double getBackPressurePumpFlow() {
        return BackPressurePumpFlow;
    }

    public void setBackPressurePumpFlow(double backPressurePumpFlow) {
        BackPressurePumpFlow = backPressurePumpFlow;
    }

    public double getLoopBackPressure() {
        return LoopBackPressure;
    }

    public void setLoopBackPressure(double loopBackPressure) {
        LoopBackPressure = loopBackPressure;
    }

    public double getAdditionalBackPressure() {
        return AdditionalBackPressure;
    }

    public void setAdditionalBackPressure(double additionalBackPressure) {
        AdditionalBackPressure = additionalBackPressure;
    }

    public double getInletFlow() {
        return InletFlow;
    }

    public void setInletFlow(double inletFlow) {
        InletFlow = inletFlow;
    }

    public double getFixDepth() {
        return FixDepth;
    }

    public void setFixDepth(double fixDepth) {
        FixDepth = fixDepth;
    }

    public double getFixPointDownDeep() {
        return FixPointDownDeep;
    }

    public void setFixPointDownDeep(double fixPointDownDeep) {
        FixPointDownDeep = fixPointDownDeep;
    }

    public double getFixPointPressure() {
        return FixPointPressure;
    }

    public void setFixPointPressure(double fixPointPressure) {
        FixPointPressure = fixPointPressure;
    }

    public double getWellMouthAdjustment() {
        return WellMouthAdjustment;
    }

    public void setWellMouthAdjustment(double wellMouthAdjustment) {
        WellMouthAdjustment = wellMouthAdjustment;
    }

    public double getFixPointPressureLoss() {
        return FixPointPressureLoss;
    }

    public void setFixPointPressureLoss(double fixPointPressureLoss) {
        FixPointPressureLoss = fixPointPressureLoss;
    }

    public double getBoDongYL() {
        return BoDongYL;
    }

    public void setBoDongYL(double boDongYL) {
        BoDongYL = boDongYL;
    }

    public double getYaHaoXZ() {
        return YaHaoXZ;
    }

    public void setYaHaoXZ(double yaHaoXZ) {
        YaHaoXZ = yaHaoXZ;
    }

    public double getQiXiaZuanSD() {
        return QiXiaZuanSD;
    }

    public void setQiXiaZuanSD(double qiXiaZuanSD) {
        QiXiaZuanSD = qiXiaZuanSD;
    }

    public double getQiXiaZuanJSD() {
        return QiXiaZuanJSD;
    }

    public void setQiXiaZuanJSD(double qiXiaZuanJSD) {
        QiXiaZuanJSD = qiXiaZuanJSD;
    }

    public double getFixPointECD() {
        return FixPointECD;
    }

    public void setFixPointECD(double fixPointECD) {
        FixPointECD = fixPointECD;
    }

    public double getDrillECD() {
        return DrillECD;
    }

    public void setDrillECD(double drillECD) {
        DrillECD = drillECD;
    }

    public double getDrillStringPressureDrop() {
        return DrillStringPressureDrop;
    }

    public void setDrillStringPressureDrop(double drillStringPressureDrop) {
        DrillStringPressureDrop = drillStringPressureDrop;
    }

    public double getDrillBitPressureDrop() {
        return DrillBitPressureDrop;
    }

    public void setDrillBitPressureDrop(double drillBitPressureDrop) {
        DrillBitPressureDrop = drillBitPressureDrop;
    }

    public double getEnvironmentalControlPressureLoss() {
        return EnvironmentalControlPressureLoss;
    }

    public void setEnvironmentalControlPressureLoss(double environmentalControlPressureLoss) {
        EnvironmentalControlPressureLoss = environmentalControlPressureLoss;
    }

    public double getTargetBackPressure() {
        return TargetBackPressure;
    }

    public void setTargetBackPressure(double targetBackPressure) {
        TargetBackPressure = targetBackPressure;
    }

    public double getHydrostaticPressure() {
        return HydrostaticPressure;
    }

    public void setHydrostaticPressure(double hydrostaticPressure) {
        HydrostaticPressure = hydrostaticPressure;
    }

    public double getState_1() {
        return State_1;
    }

    public void setState_1(double state_1) {
        State_1 = state_1;
    }

    public double getState_2() {
        return State_2;
    }

    public void setState_2(double state_2) {
        State_2 = state_2;
    }

    public int getNew_column() {
        return new_column;
    }

    public void setNew_column(int new_column) {
        this.new_column = new_column;
    }
}
