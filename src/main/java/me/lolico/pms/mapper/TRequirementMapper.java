package me.lolico.pms.mapper;

import me.lolico.pms.domain.TRequirement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 需求Mapper接口
 *
 * @author lolico
 * @date 2021-03-28
 */
public interface TRequirementMapper {
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
    @Transactional
    int insertTRequirement(TRequirement tRequirement);

    /**
     * 修改需求
     *
     * @param tRequirement 需求
     * @return 结果
     */
    @Transactional
    int updateTRequirement(TRequirement tRequirement);

    /**
     * 删除需求
     *
     * @param id 需求ID
     * @return 结果
     */
    @Transactional
    int deleteTRequirementById(Integer id);

    /**
     * 批量删除需求
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Transactional
    int deleteTRequirementByIds(Integer[] ids);
}
