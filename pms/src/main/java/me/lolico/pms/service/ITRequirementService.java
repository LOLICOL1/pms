package me.lolico.pms.service;

import me.lolico.pms.domain.TRequirement;

import java.util.List;

/**
 * 需求Service接口
 *
 * @author lolico
 * @date 2021-03-28
 */
public interface ITRequirementService {
    /**
     * 查询需求
     *
     * @param id 需求ID
     * @return 需求
     */
    TRequirement selectTRequirementById(Integer id);

    /**
     * 查询需求列表
     *
     * @param tRequirement 需求
     * @return 需求集合
     */
    List<TRequirement> selectTRequirementList(TRequirement tRequirement);

    /**
     * 新增需求
     *
     * @param tRequirement 需求
     * @return 结果
     */
    int insertTRequirement(TRequirement tRequirement);

    /**
     * 修改需求
     *
     * @param tRequirement 需求
     * @return 结果
     */
    int updateTRequirement(TRequirement tRequirement);

    /**
     * 批量删除需求
     *
     * @param ids 需要删除的需求ID
     * @return 结果
     */
    int deleteTRequirementByIds(Integer[] ids);

    /**
     * 删除需求信息
     *
     * @param id 需求ID
     * @return 结果
     */
    int deleteTRequirementById(Integer id);
}
