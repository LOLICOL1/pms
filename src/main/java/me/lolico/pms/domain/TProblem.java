package me.lolico.pms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import me.lolico.pms.annotation.Excel;
import me.lolico.pms.framework.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 问题管理对象 t_problem
 *
 * @author lolico
 * @date 2021-04-24
 */
public class TProblem extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 问题标题
     */
    @Excel(name = "问题标题")
    private String title;

    /**
     * 问题级别
     */
    @Excel(name = "问题级别")
    private String problemLevel;

    /**
     * 发生日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发生日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date appearDate;

    /**
     * 解决时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "解决时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date solveData;

    /**
     * 责任科室
     */
    @Excel(name = "责任科室")
    private String dutyDepartment;

    /**
     * 问题描述
     */
    private String problemInfo;

    /**
     * 问题影响
     */
    private String problemEffect;

    /**
     * 问题原因
     */
    private String problemCause;

    /**
     * 解决方案
     */
    private String solution;

    /**
     * 问题状态
     */
    @Excel(name = "问题状态")
    private Integer problemStatus;

    /**
     * 创建时间
     */
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getProblemLevel() {
        return problemLevel;
    }

    public void setProblemLevel(String problemLevel) {
        this.problemLevel = problemLevel;
    }

    public Date getAppearDate() {
        return appearDate;
    }

    public void setAppearDate(Date appearDate) {
        this.appearDate = appearDate;
    }

    public Date getSolveData() {
        return solveData;
    }

    public void setSolveData(Date solveData) {
        this.solveData = solveData;
    }

    public String getDutyDepartment() {
        return dutyDepartment;
    }

    public void setDutyDepartment(String dutyDepartment) {
        this.dutyDepartment = dutyDepartment;
    }

    public String getProblemInfo() {
        return problemInfo;
    }

    public void setProblemInfo(String problemInfo) {
        this.problemInfo = problemInfo;
    }

    public String getProblemEffect() {
        return problemEffect;
    }

    public void setProblemEffect(String problemEffect) {
        this.problemEffect = problemEffect;
    }

    public String getProblemCause() {
        return problemCause;
    }

    public void setProblemCause(String problemCause) {
        this.problemCause = problemCause;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public Integer getProblemStatus() {
        return problemStatus;
    }

    public void setProblemStatus(Integer problemStatus) {
        this.problemStatus = problemStatus;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("problemLevel", getProblemLevel())
                .append("appearDate", getAppearDate())
                .append("solveData", getSolveData())
                .append("dutyDepartment", getDutyDepartment())
                .append("problemInfo", getProblemInfo())
                .append("problemEffect", getProblemEffect())
                .append("problemCause", getProblemCause())
                .append("solution", getSolution())
                .append("problemStatus", getProblemStatus())
                .append("createBy", getCreateBy())
                .append("createDatetime", getCreateDatetime())
                .append("updateBy", getUpdateBy())
                .append("updateDatetime", getUpdateDatetime())
                .toString();
    }
}
