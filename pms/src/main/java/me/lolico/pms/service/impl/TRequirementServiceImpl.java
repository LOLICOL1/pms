package me.lolico.pms.service.impl;

import me.lolico.pms.domain.TRequirement;
import me.lolico.pms.mapper.TBugMapper;
import me.lolico.pms.mapper.TRequirementMapper;
import me.lolico.pms.service.ITRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * 需求Service业务层处理
 *
 * @author lolico
 * @date 2021-03-28
 */
@Service
public class TRequirementServiceImpl implements ITRequirementService {
    @Autowired
    private TRequirementMapper tRequirementMapper;
    @Autowired
    private TBugMapper tBugMapper;

    /**
     * 查询需求
     *
     * @param id 需求ID
     * @return 需求
     */
    @Override
    public TRequirement selectTRequirementById(Integer id) {
        return tRequirementMapper.selectTRequirementById(id);
    }

    /**
     * 查询需求列表
     *
     * @param tRequirement 需求
     * @return 需求
     */
    @Override
    public List<TRequirement> selectTRequirementList(TRequirement tRequirement) {
        return tRequirementMapper.selectTRequirementList(tRequirement);
    }

    /**
     * 新增需求
     *
     * @param tRequirement 需求
     * @return 结果
     */
    @Override
    public int insertTRequirement(TRequirement tRequirement) {
        return tRequirementMapper.insertTRequirement(tRequirement);
    }

    /**
     * 修改需求
     *
     * @param tRequirement 需求
     * @return 结果
     */
    @Override
    public int updateTRequirement(TRequirement tRequirement) {
        return tRequirementMapper.updateTRequirement(tRequirement);
    }

    /**
     * 批量删除需求
     *
     * @param ids 需要删除的需求ID
     * @return 结果
     */
    @Override
    public int deleteTRequirementByIds(Integer[] ids) {
        String[] array = (String[]) Arrays.stream(ids).map(String::valueOf).toArray();
        tBugMapper.deleteTBugByRequirementNos(array);
        return tRequirementMapper.deleteTRequirementByIds(ids);
    }

    /**
     * 删除需求信息
     *
     * @param id 需求ID
     * @return 结果
     */
    @Override
    public int deleteTRequirementById(Integer id) {
        return tRequirementMapper.deleteTRequirementById(id);
    }
}
