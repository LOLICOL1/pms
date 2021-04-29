package me.lolico.pms.service.impl;

import me.lolico.pms.domain.TBug;
import me.lolico.pms.mapper.TBugMapper;
import me.lolico.pms.service.ITBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 缺陷Service业务层处理
 *
 * @author lolico
 * @date 2021-04-24
 */
@Service
public class TBugServiceImpl implements ITBugService {
    @Autowired
    private TBugMapper tBugMapper;

    /**
     * 查询缺陷
     *
     * @param id 缺陷ID
     * @return 缺陷
     */
    @Override
    public TBug selectTBugById(Long id) {
        return tBugMapper.selectTBugById(id);
    }

    /**
     * 查询缺陷列表
     *
     * @param tBug 缺陷
     * @return 缺陷
     */
    @Override
    public List<TBug> selectTBugList(TBug tBug) {
        return tBugMapper.selectTBugList(tBug);
    }

    /**
     * 新增缺陷
     *
     * @param tBug 缺陷
     * @return 结果
     */
    @Override
    public int insertTBug(TBug tBug) {
        return tBugMapper.insertTBug(tBug);
    }

    /**
     * 修改缺陷
     *
     * @param tBug 缺陷
     * @return 结果
     */
    @Override
    public int updateTBug(TBug tBug) {
        return tBugMapper.updateTBug(tBug);
    }

    /**
     * 批量删除缺陷
     *
     * @param ids 需要删除的缺陷ID
     * @return 结果
     */
    @Override
    public int deleteTBugByIds(Long[] ids) {
        return tBugMapper.deleteTBugByIds(ids);
    }

    /**
     * 删除缺陷信息
     *
     * @param id 缺陷ID
     * @return 结果
     */
    @Override
    public int deleteTBugById(Long id) {
        return tBugMapper.deleteTBugById(id);
    }
}
