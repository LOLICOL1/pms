package me.lolico.pms.service;

import me.lolico.pms.domain.Sequence;
import me.lolico.pms.mapper.SequenceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

/**
 * @author lolico
 */
@Service
public class SequenceService {

    private static final Logger log = LoggerFactory.getLogger(SequenceService.class);
    private static final int OPTIMISTIC_LOCK_MAX_RETRY_TIMES = 10;

    private final SequenceMapper sequenceMapper;

    public SequenceService(SequenceMapper sequenceMapper) {
        this.sequenceMapper = sequenceMapper;
    }

    /**
     * 获取序列的下一个序列值，乐观锁实现，默认重试十次。
     *
     * @param sequenceName 序列名
     * @return 序列值
     * @throws IllegalStateException 如果重试次数用尽还未获取到锁时抛出
     */
    public int getSequenceValue(String sequenceName) throws IllegalStateException {
        for (int i = 0; i < OPTIMISTIC_LOCK_MAX_RETRY_TIMES; i++) {
            Sequence sequence = sequenceMapper.selectByPrimaryKey(sequenceName);
            if (sequence != null) {
                int newSequenceValue = sequence.getSequenceValue() + sequence.getIncrement();
                sequence.setSequenceValue(newSequenceValue);
                if (sequenceMapper.updateSequenceValueWithOptimisticLock(sequence) == 1) {
                    // 获取锁并更新序列值成功，返回
                    return newSequenceValue;
                }
            } else {
                // 序列不存在，创建序列
                try {
                    Sequence newSequence = new Sequence();
                    newSequence.setSequenceName(sequenceName);
                    sequenceMapper.insertSequence(newSequence);
                } catch (Exception e) {
                    if (e instanceof DuplicateKeyException) {
                        continue;
                    }
                    log.error(String.format("添加序列：%s 失败！", sequenceName), e);
                }
            }
        }
        throw new IllegalStateException(String.format("获取 %s 序列值失败！", sequenceName));
    }
}
