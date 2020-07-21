package com.zjapl.ygzw.data.exchange.zww.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "DN_TASK_GENERAL_MATERIAL_SZ")
public class DnTaskGeneralMaterialSz {
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "ROWGUID")
    private String rowguid;

    @Column(name = "TASKCODE")
    private String taskcode;

    @Column(name = "TASKGUID")
    private String taskguid;

    @Column(name = "MATERIALNAME")
    private String materialname;

    @Column(name = "MATERIALTYPE")
    private String materialtype;

    @Column(name = "ISNEED")
    private String isneed;

    @Column(name = "SOURCEEXPLAIN")
    private String sourceexplain;

    @Column(name = "PAGENUM")
    private Long pagenum;

    @Column(name = "PAGEFORMAT")
    private String pageformat;

    @Column(name = "FILLEXPLAIN")
    private String fillexplain;

    @Column(name = "ORDERNUM")
    private Long ordernum;

    @Column(name = "SOURCETYPE")
    private String sourcetype;

    @Column(name = "MATERIALFORMAT")
    private String materialformat;

    @Column(name = "TASKHANDLEITEM")
    private String taskhandleitem;

    @Column(name = "DATASOURCE")
    private String datasource;

    @Column(name = "FORMGUID")
    private String formguid;

    @Column(name = "EXAMPLEGUID")
    private String exampleguid;

    @Column(name = "CD_TIME")
    private Date cdTime;

    @Column(name = "SYNC_SIGN")
    private String syncSign;

    @Column(name = "CD_OPERATION")
    private String cdOperation;

    @Column(name = "CD_BATCH")
    private String cdBatch;

    @Column(name = "REMARK")
    private String remark;

    @Column(name = "ACCEPTSTAND")
    private String acceptstand;

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
     * @return MATERIALNAME
     */
    public String getMaterialname() {
        return materialname;
    }

    /**
     * @param materialname
     */
    public void setMaterialname(String materialname) {
        this.materialname = materialname;
    }

    /**
     * @return MATERIALTYPE
     */
    public String getMaterialtype() {
        return materialtype;
    }

    /**
     * @param materialtype
     */
    public void setMaterialtype(String materialtype) {
        this.materialtype = materialtype;
    }

    /**
     * @return ISNEED
     */
    public String getIsneed() {
        return isneed;
    }

    /**
     * @param isneed
     */
    public void setIsneed(String isneed) {
        this.isneed = isneed;
    }

    /**
     * @return SOURCEEXPLAIN
     */
    public String getSourceexplain() {
        return sourceexplain;
    }

    /**
     * @param sourceexplain
     */
    public void setSourceexplain(String sourceexplain) {
        this.sourceexplain = sourceexplain;
    }

    /**
     * @return PAGENUM
     */
    public Long getPagenum() {
        return pagenum;
    }

    /**
     * @param pagenum
     */
    public void setPagenum(Long pagenum) {
        this.pagenum = pagenum;
    }

    /**
     * @return PAGEFORMAT
     */
    public String getPageformat() {
        return pageformat;
    }

    /**
     * @param pageformat
     */
    public void setPageformat(String pageformat) {
        this.pageformat = pageformat;
    }

    /**
     * @return FILLEXPLAIN
     */
    public String getFillexplain() {
        return fillexplain;
    }

    /**
     * @param fillexplain
     */
    public void setFillexplain(String fillexplain) {
        this.fillexplain = fillexplain;
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
     * @return SOURCETYPE
     */
    public String getSourcetype() {
        return sourcetype;
    }

    /**
     * @param sourcetype
     */
    public void setSourcetype(String sourcetype) {
        this.sourcetype = sourcetype;
    }

    /**
     * @return MATERIALFORMAT
     */
    public String getMaterialformat() {
        return materialformat;
    }

    /**
     * @param materialformat
     */
    public void setMaterialformat(String materialformat) {
        this.materialformat = materialformat;
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
     * @return FORMGUID
     */
    public String getFormguid() {
        return formguid;
    }

    /**
     * @param formguid
     */
    public void setFormguid(String formguid) {
        this.formguid = formguid;
    }

    /**
     * @return EXAMPLEGUID
     */
    public String getExampleguid() {
        return exampleguid;
    }

    /**
     * @param exampleguid
     */
    public void setExampleguid(String exampleguid) {
        this.exampleguid = exampleguid;
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
     * @return ACCEPTSTAND
     */
    public String getAcceptstand() {
        return acceptstand;
    }

    /**
     * @param acceptstand
     */
    public void setAcceptstand(String acceptstand) {
        this.acceptstand = acceptstand;
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