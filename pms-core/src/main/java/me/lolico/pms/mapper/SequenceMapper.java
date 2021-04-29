package me.lolico.pms.mapper;

import me.lolico.pms.domain.Sequence;

/**
 * @author lolico
 */
public interface SequenceMapper {

    int insertSequence(Sequence sequence);

    Sequence selectByPrimaryKey(String sequenceName);

    int updateSequenceValueWithOptimisticLock(Sequence sequence);
}
