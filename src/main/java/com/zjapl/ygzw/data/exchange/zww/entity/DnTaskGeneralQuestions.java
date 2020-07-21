package com.zjapl.ygzw.data.exchange.zww.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "DN_TASK_GENERAL_QUESTIONS")
public class DnTaskGeneralQuestions {
    @Id
    @Column(name = "ID")
    private BigDecimal id;

    @Column(name = "ROWGUID")
    private String rowguid;

    @Column(name = "TASKCODE")
    private String taskcode;

    @Column(name = "TASKGUID")
    private String taskguid;

    @Column(name = "ORDERNUM")
    private Long ordernum;

    @Column(name = "QUESTION")
    private String question;

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

    @Column(name = "ANSWER")
    private String answer;

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
     * @return QUESTION
     */
    public String getQuestion() {
        return question;
    }

    /**
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
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
     * @return ANSWER
     */
    public String getAnswer() {
        return answer;
    }

    /**
     * @param answer
     */
    public void setAnswer(String answer) {
        this.answer = answer;
    }
}