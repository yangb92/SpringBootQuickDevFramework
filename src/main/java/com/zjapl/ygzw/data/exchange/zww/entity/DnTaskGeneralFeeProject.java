package com.zjapl.ygzw.data.exchange.zww.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "DN_TASK_GENERAL_FEE_PROJECT")
public class DnTaskGeneralFeeProject {
    @Id
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "ROWGUID")
    private String rowguid;

    @Column(name = "TASKCODE")
    private String taskcode;

    @Column(name = "TASKGUID")
    private String taskguid;

    @Column(name = "ORDERNUM")
    private Long ordernum;

    @Column(name = "FEENAME")
    private String feename;

    @Column(name = "ISDESC")
    private String isdesc;

    @Column(name = "TASKHANDLEITEM")
    private String taskhandleitem;

    @Column(name = "DATASOURCE")
    private String datasource;

    @Column(name = "CD_TIME")
    private Date cdTime;

    @Column(name = "SYNC_SIGN")
    private String syncSign;

    @Column(name = "CD_OPERATION")
    private String cdOperation;

    @Column(name = "CD_BATCH")
    private String cdBatch;

    @Column(name = "FEESTAND")
    private String feestand;

    @Column(name = "DESCEXPLAIN")
    private String descexplain;

    @Column(name = "BYLAW")
    private String bylaw;

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
     * @return REMARK
     */
    public String getRemark() {
        return remark;
    }

    /**
     * @param remark
     */
    public void setRemark(String remark) {
        this.remark = remark;
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
     * @return ORDERNUM
     */
    public Long getOrdernum() {
        return ordernum;
    }

    /**
     * @param ordernum
     */
    public void setOrdernum(Long ordernum) {
        this.ordernum = ordernum;
    }

    /**
     * @return FEENAME
     */
    public String getFeename() {
        return feename;
    }

    /**
     * @param feename
     */
    public void setFeename(String feename) {
        this.feename = feename;
    }

    /**
     * @return ISDESC
     */
    public String getIsdesc() {
        return isdesc;
    }

    /**
     * @param isdesc
     */
    public void setIsdesc(String isdesc) {
        this.isdesc = isdesc;
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
     * @return FEESTAND
     */
    public String getFeestand() {
        return feestand;
    }

    /**
     * @param feestand
     */
    public void setFeestand(String feestand) {
        this.feestand = feestand;
    }

    /**
     * @return DESCEXPLAIN
     */
    public String getDescexplain() {
        return descexplain;
    }

    /**
     * @param descexplain
     */
    public void setDescexplain(String descexplain) {
        this.descexplain = descexplain;
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
}