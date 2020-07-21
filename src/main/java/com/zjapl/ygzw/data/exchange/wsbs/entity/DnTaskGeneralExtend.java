package com.zjapl.ygzw.data.exchange.wsbs.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "DN_TASK_GENERAL_EXTEND")
public class DnTaskGeneralExtend {
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "ROWGUID")
    private String rowguid;

    @Column(name = "TASKCODE")
    private String taskcode;

    @Column(name = "ISENTRYCENTER")
    private String isentrycenter;

    @Column(name = "HANDLEAREA")
    private String handlearea;

    @Column(name = "OTHERDEPT")
    private String otherdept;

    @Column(name = "SERVICETYPE")
    private String servicetype;

    @Column(name = "RESULTTYPE")
    private String resulttype;

    @Column(name = "RESULTNAME")
    private String resultname;

    @Column(name = "ISSCHEDULE")
    private String isschedule;

    @Column(name = "ISPAYONLINE")
    private String ispayonline;

    @Column(name = "ISEXPRESS")
    private String isexpress;

    @Column(name = "ISSERVICETERMINALS")
    private String isserviceterminals;

    @Column(name = "LIMITSCENEEXPLAIN")
    private String limitsceneexplain;

    @Column(name = "TASKGUID")
    private String taskguid;

    @Column(name = "EXTENDFIELD")
    private String extendfield;

    @Column(name = "TASKHANDLEITEM")
    private String taskhandleitem;

    @Column(name = "DATASOURCE")
    private String datasource;

    @Column(name = "RESULTGUID")
    private String resultguid;

    @Column(name = "USERTOPICTYPE")
    private String usertopictype;

    @Column(name = "USERCHARACTERTOPICTYPE")
    private String usercharactertopictype;

    @Column(name = "CORPTOPICTYPE")
    private String corptopictype;

    @Column(name = "CORPCHARACTERTOPICTYPE")
    private String corpcharactertopictype;

    @Column(name = "TOWNNAME")
    private String townname;

    @Column(name = "TOWNCODE")
    private String towncode;

    @Column(name = "VILLAGENAME")
    private String villagename;

    @Column(name = "VILLAGECODE")
    private String villagecode;

    @Column(name = "CD_TIME")
    private Date cdTime;

    @Column(name = "ONLINEHANDLEDEPTH")
    private String onlinehandledepth;

    @Column(name = "ISONLINE")
    private String isonline;

    @Column(name = "SYNC_SIGN")
    private String syncSign;

    @Column(name = "CD_OPERATION")
    private String cdOperation;

    @Column(name = "CD_BATCH")
    private String cdBatch;

    @Column(name = "LIMITEXPLAIN")
    private String limitexplain;

    @Column(name = "ONLINEHANDLEURL")
    private String onlinehandleurl;

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
     * @return ISENTRYCENTER
     */
    public String getIsentrycenter() {
        return isentrycenter;
    }

    /**
     * @param isentrycenter
     */
    public void setIsentrycenter(String isentrycenter) {
        this.isentrycenter = isentrycenter;
    }

    /**
     * @return HANDLEAREA
     */
    public String getHandlearea() {
        return handlearea;
    }

    /**
     * @param handlearea
     */
    public void setHandlearea(String handlearea) {
        this.handlearea = handlearea;
    }

    /**
     * @return OTHERDEPT
     */
    public String getOtherdept() {
        return otherdept;
    }

    /**
     * @param otherdept
     */
    public void setOtherdept(String otherdept) {
        this.otherdept = otherdept;
    }

    /**
     * @return SERVICETYPE
     */
    public String getServicetype() {
        return servicetype;
    }

    /**
     * @param servicetype
     */
    public void setServicetype(String servicetype) {
        this.servicetype = servicetype;
    }

    /**
     * @return RESULTTYPE
     */
    public String getResulttype() {
        return resulttype;
    }

    /**
     * @param resulttype
     */
    public void setResulttype(String resulttype) {
        this.resulttype = resulttype;
    }

    /**
     * @return RESULTNAME
     */
    public String getResultname() {
        return resultname;
    }

    /**
     * @param resultname
     */
    public void setResultname(String resultname) {
        this.resultname = resultname;
    }

    /**
     * @return ISSCHEDULE
     */
    public String getIsschedule() {
        return isschedule;
    }

    /**
     * @param isschedule
     */
    public void setIsschedule(String isschedule) {
        this.isschedule = isschedule;
    }

    /**
     * @return ISPAYONLINE
     */
    public String getIspayonline() {
        return ispayonline;
    }

    /**
     * @param ispayonline
     */
    public void setIspayonline(String ispayonline) {
        this.ispayonline = ispayonline;
    }

    /**
     * @return ISEXPRESS
     */
    public String getIsexpress() {
        return isexpress;
    }

    /**
     * @param isexpress
     */
    public void setIsexpress(String isexpress) {
        this.isexpress = isexpress;
    }

    /**
     * @return ISSERVICETERMINALS
     */
    public String getIsserviceterminals() {
        return isserviceterminals;
    }

    /**
     * @param isserviceterminals
     */
    public void setIsserviceterminals(String isserviceterminals) {
        this.isserviceterminals = isserviceterminals;
    }

    /**
     * @return LIMITSCENEEXPLAIN
     */
    public String getLimitsceneexplain() {
        return limitsceneexplain;
    }

    /**
     * @param limitsceneexplain
     */
    public void setLimitsceneexplain(String limitsceneexplain) {
        this.limitsceneexplain = limitsceneexplain;
    }

    /**
     * @return TASKGUID
     */
    public String getTaskguid() {
        return taskguid;
    }

    /**
     * @param taskguid
     */
    public void setTaskguid(String taskguid) {
        this.taskguid = taskguid;
    }

    /**
     * @return EXTENDFIELD
     */
    public String getExtendfield() {
        return extendfield;
    }

    /**
     * @param extendfield
     */
    public void setExtendfield(String extendfield) {
        this.extendfield = extendfield;
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
     * @return RESULTGUID
     */
    public String getResultguid() {
        return resultguid;
    }

    /**
     * @param resultguid
     */
    public void setResultguid(String resultguid) {
        this.resultguid = resultguid;
    }

    /**
     * @return USERTOPICTYPE
     */
    public String getUsertopictype() {
        return usertopictype;
    }

    /**
     * @param usertopictype
     */
    public void setUsertopictype(String usertopictype) {
        this.usertopictype = usertopictype;
    }

    /**
     * @return USERCHARACTERTOPICTYPE
     */
    public String getUsercharactertopictype() {
        return usercharactertopictype;
    }

    /**
     * @param usercharactertopictype
     */
    public void setUsercharactertopictype(String usercharactertopictype) {
        this.usercharactertopictype = usercharactertopictype;
    }

    /**
     * @return CORPTOPICTYPE
     */
    public String getCorptopictype() {
        return corptopictype;
    }

    /**
     * @param corptopictype
     */
    public void setCorptopictype(String corptopictype) {
        this.corptopictype = corptopictype;
    }

    /**
     * @return CORPCHARACTERTOPICTYPE
     */
    public String getCorpcharactertopictype() {
        return corpcharactertopictype;
    }

    /**
     * @param corpcharactertopictype
     */
    public void setCorpcharactertopictype(String corpcharactertopictype) {
        this.corpcharactertopictype = corpcharactertopictype;
    }

    /**
     * @return TOWNNAME
     */
    public String getTownname() {
        return townname;
    }

    /**
     * @param townname
     */
    public void setTownname(String townname) {
        this.townname = townname;
    }

    /**
     * @return TOWNCODE
     */
    public String getTowncode() {
        return towncode;
    }

    /**
     * @param towncode
     */
    public void setTowncode(String towncode) {
        this.towncode = towncode;
    }

    /**
     * @return VILLAGENAME
     */
    public String getVillagename() {
        return villagename;
    }

    /**
     * @param villagename
     */
    public void setVillagename(String villagename) {
        this.villagename = villagename;
    }

    /**
     * @return VILLAGECODE
     */
    public String getVillagecode() {
        return villagecode;
    }

    /**
     * @param villagecode
     */
    public void setVillagecode(String villagecode) {
        this.villagecode = villagecode;
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
     * @return ONLINEHANDLEDEPTH
     */
    public String getOnlinehandledepth() {
        return onlinehandledepth;
    }

    /**
     * @param onlinehandledepth
     */
    public void setOnlinehandledepth(String onlinehandledepth) {
        this.onlinehandledepth = onlinehandledepth;
    }

    /**
     * @return ISONLINE
     */
    public String getIsonline() {
        return isonline;
    }

    /**
     * @param isonline
     */
    public void setIsonline(String isonline) {
        this.isonline = isonline;
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
     * @return LIMITEXPLAIN
     */
    public String getLimitexplain() {
        return limitexplain;
    }

    /**
     * @param limitexplain
     */
    public void setLimitexplain(String limitexplain) {
        this.limitexplain = limitexplain;
    }

    /**
     * @return ONLINEHANDLEURL
     */
    public String getOnlinehandleurl() {
        return onlinehandleurl;
    }

    /**
     * @param onlinehandleurl
     */
    public void setOnlinehandleurl(String onlinehandleurl) {
        this.onlinehandleurl = onlinehandleurl;
    }
}