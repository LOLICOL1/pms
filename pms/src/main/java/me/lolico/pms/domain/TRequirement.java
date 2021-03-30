package me.lolico.pms.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 需求对象 t_requirement
 *
 * @author lolico
 * @date 2021-03-28
 */
public class TRequirement extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    private Integer id;

    /**
     * 需求标题
     */
    @Excel(name = "需求标题")
    private String title;

    /**
     * 优先级
     */
    @Excel(name = "优先级")
    private Integer priority;

    /**
     * 需求当前状态
     */
    @Excel(name = "需求当前状态")
    private Integer status;

    /**
     * 负责人
     */
    @Excel(name = "负责人")
    private String sa;

    /**
     * 需求描述
     */
    @Excel(name = "需求描述")
    private String description;

    /**
     * 计划开始日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划开始日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planStartDate;

    /**
     * 计划上线日期
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "计划上线日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date planPublishDate;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date createDatetime;

    /**
     * 更新时间
     */
    private Date updateDatetime;

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }

    public void setSa(String sa) {
        this.sa = sa;
    }

    public String getSa() {
        return sa;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public void setPlanStartDate(Date planStartDate) {
        this.planStartDate = planStartDate;
    }

    public Date getPlanStartDate() {
        return planStartDate;
    }

    public void setPlanPublishDate(Date planPublishDate) {
        this.planPublishDate = planPublishDate;
    }

    public Date getPlanPublishDate() {
        return planPublishDate;
    }

    public void setCreateDatetime(Date createDatetime) {
        this.createDatetime = createDatetime;
    }

    public Date getCreateDatetime() {
        return createDatetime;
    }

    public void setUpdateDatetime(Date updateDatetime) {
        this.updateDatetime = updateDatetime;
    }

    public Date getUpdateDatetime() {
        return updateDatetime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("title", getTitle())
                .append("priority", getPriority())
                .append("status", getStatus())
                .append("sa", getSa())
                .append("description", getDescription())
                .append("planStartDate", getPlanStartDate())
                .append("planPublishDate", getPlanPublishDate())
                .append("createBy", getCreateBy())
                .append("createDatetime", getCreateDatetime())
                .append("updateBy", getUpdateBy())
                .append("updateDatetime", getUpdateDatetime())
                .toString();
    }
}
