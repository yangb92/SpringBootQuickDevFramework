package com.zjapl.ygzw.data.exchange.zww.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "DN_TASK_GENERAL_BASIC")
public class DnTaskGeneralBasic {
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "ROWGUID")
    private String rowguid;

    @Column(name = "CATALOGCODE")
    private String catalogcode;

    @Column(name = "TASKCODE")
    private String taskcode;

    @Column(name = "TASKNAME")
    private String taskname;

    @Column(name = "TASKTYPE")
    private String tasktype;

    @Column(name = "USELEVEL")
    private String uselevel;

    @Column(name = "DEPTTYPE")
    private String depttype;

    @Column(name = "DEPTNAME")
    private String deptname;

    @Column(name = "TASKSTATE")
    private String taskstate;

    @Column(name = "SERVERTYPE")
    private String servertype;

    @Column(name = "PROJECTTYPE")
    private String projecttype;

    @Column(name = "PROMISETYPE")
    private String promisetype;

    @Column(name = "PROMISEDAY")
    private Long promiseday;

    @Column(name = "DEPTCODE")
    private String deptcode;

    @Column(name = "ENTRUSTNAME")
    private String entrustname;

    @Column(name = "ANTICIPATEDAY")
    private Long anticipateday;

    @Column(name = "ANTICIPATETYPE")
    private String anticipatetype;

    @Column(name = "ISFEE")
    private String isfee;

    @Column(name = "PLANCANCELDATE")
    private Date plancanceldate;

    @Column(name = "PLANEFFECTIVEDATE")
    private Date planeffectivedate;

    @Column(name = "TRANSACTTIME")
    private String transacttime;

    @Column(name = "TRANSACTADDR")
    private String transactaddr;

    @Column(name = "ISSINGLELOGIN")
    private String issinglelogin;

    @Column(name = "HANDLETYPE")
    private String handletype;

    @Column(name = "POWERSOURCE")
    private String powersource;

    @Column(name = "TASKHANDLEITEM")
    private String taskhandleitem;

    @Column(name = "APPISSINGLELOGIN")
    private String appissinglelogin;

    @Column(name = "CD_TIME")
    private Date cdTime;

    @Column(name = "TASKVERSION")
    private Long taskversion;

    @Column(name = "SPECIALPROCEDURE")
    private String specialprocedure;

    @Column(name = "LIMITSCENENUM")
    private Long limitscenenum;

    @Column(name = "SYNC_SIGN")
    private String syncSign;

    @Column(name = "CD_OPERATION")
    private String cdOperation;

    @Column(name = "CD_BATCH")
    private String cdBatch;

    @Column(name = "DATASOURCE")
    private String datasource;

    @Column(name = "BELONG_AREA")
    private String belongArea;

    @Column(name = "STATUS")
    private Short status;

    @Column(name = "DEPT_NUMBER")
    private String deptNumber;

    @Column(name = "ACCEPTCONDITION")
    private String acceptcondition;

    @Column(name = "SUPERVISEWAY")
    private String superviseway;

    @Column(name = "LINKWAY")
    private String linkway;

    @Column(name = "MOBILETERMINALURL")
    private String mobileterminalurl;

    @Column(name = "BYLAW")
    private String bylaw;

    @Column(name = "HANDLEFLOW")
    private String handleflow;

    @Column(name = "FEEBASIS")
    private String feebasis;

    @Column(name = "LINKADDR")
    private String linkaddr;

    @Column(name = "ANTICIPATEEXPLAIN")
    private String anticipateexplain;

    @Column(name = "PROMISEEXPLAIN")
    private String promiseexplain;

    /**
     * @return ID
     */
    public BigDecimal getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(BigDecimal id) {
        this.id = id;
    }

    /**
     * @return ROWGUID
     */
    public String getRowguid() {
        return rowguid;
    }

    /**
     * @param rowguid
     */
    public void setRowguid(String rowguid) {
        this.rowguid = rowguid;
    }

    /**
     * @return CATALOGCODE
     */
    public String getCatalogcode() {
        return catalogcode;
    }

    /**
     * @param catalogcode
     */
    public void setCatalogcode(String catalogcode) {
        this.catalogcode = catalogcode;
    }

    /**
     * @return TASKCODE
     */
    public String getTaskcode() {
        return taskcode;
    }

    /**
     * @param taskcode
     */
    public void setTaskcode(String taskcode) {
        this.taskcode = taskcode;
    }

    /**
     * @return TASKNAME
     */
    public String getTaskname() {
        return taskname;
    }

    /**
     * @param taskname
     */
    public void setTaskname(String taskname) {
        this.taskname = taskname;
    }

    /**
     * @return TASKTYPE
     */
    public String getTasktype() {
        return tasktype;
    }

    /**
     * @param tasktype
     */
    public void setTasktype(String tasktype) {
        this.tasktype = tasktype;
    }

    /**
     * @return USELEVEL
     */
    public String getUselevel() {
        return uselevel;
    }

    /**
     * @param uselevel
     */
    public void setUselevel(String uselevel) {
        this.uselevel = uselevel;
    }

    /**
     * @return DEPTTYPE
     */
    public String getDepttype() {
        return depttype;
    }

    /**
     * @param depttype
     */
    public void setDepttype(String depttype) {
        this.depttype = depttype;
    }

    /**
     * @return DEPTNAME
     */
    public String getDeptname() {
        return deptname;
    }

    /**
     * @param deptname
     */
    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    /**
     * @return TASKSTATE
     */
    public String getTaskstate() {
        return taskstate;
    }

    /**
     * @param taskstate
     */
    public void setTaskstate(String taskstate) {
        this.taskstate = taskstate;
    }

    /**
     * @return SERVERTYPE
     */
    public String getServertype() {
        return servertype;
    }

    /**
     * @param servertype
     */
    public void setServertype(String servertype) {
        this.servertype = servertype;
    }

    /**
     * @return PROJECTTYPE
     */
    public String getProjecttype() {
        return projecttype;
    }

    /**
     * @param projecttype
     */
    public void setProjecttype(String projecttype) {
        this.projecttype = projecttype;
    }

    /**
     * @return PROMISETYPE
     */
    public String getPromisetype() {
        return promisetype;
    }

    /**
     * @param promisetype
     */
    public void setPromisetype(String promisetype) {
        this.promisetype = promisetype;
    }

    /**
     * @return PROMISEDAY
     */
    public Long getPromiseday() {
        return promiseday;
    }

    /**
     * @param promiseday
     */
    public void setPromiseday(Long promiseday) {
        this.promiseday = promiseday;
    }

    /**
     * @return DEPTCODE
     */
    public String getDeptcode() {
        return deptcode;
    }

    /**
     * @param deptcode
     */
    public void setDeptcode(String deptcode) {
        this.deptcode = deptcode;
    }

    /**
     * @return ENTRUSTNAME
     */
    public String getEntrustname() {
        return entrustname;
    }

    /**
     * @param entrustname
     */
    public void setEntrustname(String entrustname) {
        this.entrustname = entrustname;
    }

    /**
     * @return ANTICIPATEDAY
     */
    public Long getAnticipateday() {
        return anticipateday;
    }

    /**
     * @param anticipateday
     */
    public void setAnticipateday(Long anticipateday) {
        this.anticipateday = anticipateday;
    }

    /**
     * @return ANTICIPATETYPE
     */
    public String getAnticipatetype() {
        return anticipatetype;
    }

    /**
     * @param anticipatetype
     */
    public void setAnticipatetype(String anticipatetype) {
        this.anticipatetype = anticipatetype;
    }

    /**
     * @return ISFEE
     */
    public String getIsfee() {
        return isfee;
    }

    /**
     * @param isfee
     */
    public void setIsfee(String isfee) {
        this.isfee = isfee;
    }

    /**
     * @return PLANCANCELDATE
     */
    public Date getPlancanceldate() {
        return plancanceldate;
    }

    /**
     * @param plancanceldate
     */
    public void setPlancanceldate(Date plancanceldate) {
        this.plancanceldate = plancanceldate;
    }

    /**
     * @return PLANEFFECTIVEDATE
     */
    public Date getPlaneffectivedate() {
        return planeffectivedate;
    }

    /**
     * @param planeffectivedate
     */
    public void setPlaneffectivedate(Date planeffectivedate) {
        this.planeffectivedate = planeffectivedate;
    }

    /**
     * @return TRANSACTTIME
     */
    public String getTransacttime() {
        return transacttime;
    }

    /**
     * @param transacttime
     */
    public void setTransacttime(String transacttime) {
        this.transacttime = transacttime;
    }

    /**
     * @return TRANSACTADDR
     */
    public String getTransactaddr() {
        return transactaddr;
    }

    /**
     * @param transactaddr
     */
    public void setTransactaddr(String transactaddr) {
        this.transactaddr = transactaddr;
    }

    /**
     * @return ISSINGLELOGIN
     */
    public String getIssinglelogin() {
        return issinglelogin;
    }

    /**
     * @param issinglelogin
     */
    public void setIssinglelogin(String issinglelogin) {
        this.issinglelogin = issinglelogin;
    }

    /**
     * @return HANDLETYPE
     */
    public String getHandletype() {
        return handletype;
    }

    /**
     * @param handletype
     */
    public void setHandletype(String handletype) {
        this.handletype = handletype;
    }

    /**
     * @return POWERSOURCE
     */
    public String getPowersource() {
        return powersource;
    }

    /**
     * @param powersource
     */
    public void setPowersource(String powersource) {
        this.powersource = powersource;
    }

    /**
     * @return TASKHANDLEITEM
     */
    public String getTaskhandleitem() {
        return taskhandleitem;
    }

    /**
     * @param taskhandleitem
     */
    public void setTaskhandleitem(String taskhandleitem) {
        this.taskhandleitem = taskhandleitem;
    }

    /**
     * @return APPISSINGLELOGIN
     */
    public String getAppissinglelogin() {
        return appissinglelogin;
    }

    /**
     * @param appissinglelogin
     */
    public void setAppissinglelogin(String appissinglelogin) {
        this.appissinglelogin = appissinglelogin;
    }

    /**
     * @return CD_TIME
     */
    public Date getCdTime() {
        return cdTime;
    }

    /**
     * @param cdTime
     */
    public void setCdTime(Date cdTime) {
        this.cdTime = cdTime;
    }

    /**
     * @return TASKVERSION
     */
    public Long getTaskversion() {
        return taskversion;
    }

    /**
     * @param taskversion
     */
    public void setTaskversion(Long taskversion) {
        this.taskversion = taskversion;
    }

    /**
     * @return SPECIALPROCEDURE
     */
    public String getSpecialprocedure() {
        return specialprocedure;
    }

    /**
     * @param specialprocedure
     */
    public void setSpecialprocedure(String specialprocedure) {
        this.specialprocedure = specialprocedure;
    }

    /**
     * @return LIMITSCENENUM
     */
    public Long getLimitscenenum() {
        return limitscenenum;
    }

    /**
     * @param limitscenenum
     */
    public void setLimitscenenum(Long limitscenenum) {
        this.limitscenenum = limitscenenum;
    }

    /**
     * @return SYNC_SIGN
     */
    public String getSyncSign() {
        return syncSign;
    }

    /**
     * @param syncSign
     */
    public void setSyncSign(String syncSign) {
        this.syncSign = syncSign;
    }

    /**
     * @return CD_OPERATION
     */
    public String getCdOperation() {
        return cdOperation;
    }

    /**
     * @param cdOperation
     */
    public void setCdOperation(String cdOperation) {
        this.cdOperation = cdOperation;
    }

    /**
     * @return CD_BATCH
     */
    public String getCdBatch() {
        return cdBatch;
    }

    /**
     * @param cdBatch
     */
    public void setCdBatch(String cdBatch) {
        this.cdBatch = cdBatch;
    }

    /**
     * @return DATASOURCE
     */
    public String getDatasource() {
        return datasource;
    }

    /**
     * @param datasource
     */
    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    /**
     * @return BELONG_AREA
     */
    public String getBelongArea() {
        return belongArea;
    }

    /**
     * @param belongArea
     */
    public void setBelongArea(String belongArea) {
        this.belongArea = belongArea;
    }

    /**
     * @return STATUS
     */
    public Short getStatus() {
        return status;
    }

    /**
     * @param status
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * @return DEPT_NUMBER
     */
    public String getDeptNumber() {
        return deptNumber;
    }

    /**
     * @param deptNumber
     */
    public void setDeptNumber(String deptNumber) {
        this.deptNumber = deptNumber;
    }

    /**
     * @return ACCEPTCONDITION
     */
    public String getAcceptcondition() {
        return acceptcondition;
    }

    /**
     * @param acceptcondition
     */
    public void setAcceptcondition(String acceptcondition) {
        this.acceptcondition = acceptcondition;
    }

    /**
     * @return SUPERVISEWAY
     */
    public String getSuperviseway() {
        return superviseway;
    }

    /**
     * @param superviseway
     */
    public void setSuperviseway(String superviseway) {
        this.superviseway = superviseway;
    }

    /**
     * @return LINKWAY
     */
    public String getLinkway() {
        return linkway;
    }

    /**
     * @param linkway
     */
    public void setLinkway(String linkway) {
        this.linkway = linkway;
    }

    /**
     * @return MOBILETERMINALURL
     */
    public String getMobileterminalurl() {
        return mobileterminalurl;
    }

    /**
     * @param mobileterminalurl
     */
    public void setMobileterminalurl(String mobileterminalurl) {
        this.mobileterminalurl = mobileterminalurl;
    }

    /**
     * @return BYLAW
     */
    public String getBylaw() {
        return bylaw;
    }

    /**
     * @param bylaw
     */
    public void setBylaw(String bylaw) {
        this.bylaw = bylaw;
    }

    /**
     * @return HANDLEFLOW
     */
    public String getHandleflow() {
        return handleflow;
    }

    /**
     * @param handleflow
     */
    public void setHandleflow(String handleflow) {
        this.handleflow = handleflow;
    }

    /**
     * @return FEEBASIS
     */
    public String getFeebasis() {
        return feebasis;
    }

    /**
     * @param feebasis
     */
    public void setFeebasis(String feebasis) {
        this.feebasis = feebasis;
    }

    /**
     * @return LINKADDR
     */
    public String getLinkaddr() {
        return linkaddr;
    }

    /**
     * @param linkaddr
     */
    public void setLinkaddr(String linkaddr) {
        this.linkaddr = linkaddr;
    }

    /**
     * @return ANTICIPATEEXPLAIN
     */
    public String getAnticipateexplain() {
        return anticipateexplain;
    }

    /**
     * @param anticipateexplain
     */
    public void setAnticipateexplain(String anticipateexplain) {
        this.anticipateexplain = anticipateexplain;
    }

    /**
     * @return PROMISEEXPLAIN
     */
    public String getPromiseexplain() {
        return promiseexplain;
    }

    /**
     * @param promiseexplain
     */
    public void setPromiseexplain(String promiseexplain) {
        this.promiseexplain = promiseexplain;
    }
}