package me.lolico.pms.domain;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author lolico
 */
public class Sequence implements Serializable {
    private static final long serialVersionUID = 3828970208616080332L;

    /**
     * 序列名
     */
    private String sequenceName;

    /**
     * 序列当前值
     */
    private Integer sequenceValue;

    /**
     * 增量
     */
    private Integer increment;

    /**
     * 版本号
     */
    private Integer version;

    /**
     * 创建时间
     */
    private LocalDateTime createDatetime;

    /**
     * 更新时间
     */
    private LocalDateTime updateDatetime;

    public String getSequenceName() {
        return sequenceName;
    }

    public void setSequenceName(String sequenceName) {
        this.sequenceName = sequenceName;
    }

    public Integer getSequenceValue() {
        return sequenceValue;
    }

    public void setSequenceValue(Integer sequenceValue) {
        this.sequenceValue = sequenceValue;
    }

    public Integer getIncrement() {
        return increment;
    }

    public void setIncrement(Integer increment) {
        this.increment = increment;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public LocalDateTime getCreateDatetime() {
        return createDatetime;
    }

    public void setCreateDatetime(LocalDateTime createDatetime) {
        this.createDatetime = createDatetime;
    }

    public LocalDateTime getUpdateDatetime() {
        return updateDatetime;
    }

    public void setUpdateDatetime(LocalDateTime updateDatetime) {
        this.updateDatetime = updateDatetime;
    }
}
