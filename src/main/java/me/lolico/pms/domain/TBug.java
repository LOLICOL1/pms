package me.lolico.pms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import me.lolico.pms.annotation.Excel;
import me.lolico.pms.framework.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 缺陷对象 t_bug
 *
 * @author lolico
 * @date 2021-04-24
 */
public class TBug extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Long id;

    /**
     * 缺陷标题
     */
    @Excel(name = "缺陷标题")
    private String title;

    /**
     * 需求编号
     */
    @Excel(name = "需求编号")
    private Integer requirementNo;

    /**
     * 严重级别
     */
    @Excel(name = "严重级别")
    private String bugLevel;

    /**
     * 状态
     */
    @Excel(name = "状态")
    private Integer status;

    /**
     * 提出人
     */
    @Excel(name = "提出人")
    private String proposer;

    /**
     * 负责人
     */
    @Excel(name = "负责人")
    private String sa;

    /**
     * 解决人
     */
    @Excel(name = "解决人")
    private String solutioner;

    /**
     * 解决时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "解决时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date solveDate;

    /**
     * 缺陷描述
     */
    @Excel(name = "缺陷描述")
    private String description;

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

    public Integer getRequirementNo() {
        return requirementNo;
    }

    public void setRequirementNo(Integer requirementNo) {
        this.requirementNo = requirementNo;
    }

    public String getBugLevel() {
        return bugLevel;
    }

    public void setBugLevel(String bugLevel) {
        this.bugLevel = bugLevel;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getProposer() {
        return proposer;
    }

    public void setProposer(String proposer) {
        this.proposer = proposer;
    }

    public String getSa() {
        return sa;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }

    public String getSolutioner() {
        return solutioner;
    }

    public void setSolutioner(String solutioner) {
        this.solutioner = solutioner;
    }

    public Date getSolveDate() {
        return solveDate;
    }

    public void setSolveDate(Date solveDate) {
        this.solveDate = solveDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
                .append("requirementNo", getRequirementNo())
                .append("bugLevel", getBugLevel())
                .append("status", getStatus())
                .append("proposer", getProposer())
                .append("sa", getSa())
                .append("solutioner", getSolutioner())
                .append("solveDate", getSolveDate())
                .append("description", getDescription())
                .append("createBy", getCreateBy())
                .append("createDatetime", getCreateDatetime())
                .append("updateBy", getUpdateBy())
                .append("updateDatetime", getUpdateDatetime())
                .toString();
    }
}
