package me.lolico.pms.mapper;

import me.lolico.pms.domain.TBug;

import java.util.List;

/**
 * 缺陷Mapper接口
 *
 * @author lolico
 * @date 2021-04-24
 */
public interface TBugMapper {
    /**
     * 查询缺陷
     *
     * @param id 缺陷ID
     * @return 缺陷
     */
    TBug selectTBugById(Long id);

    /**
     * 查询缺陷列表
     *
     * @param tBug 缺陷
     * @return 缺陷集合
     */
    List<TBug> selectTBugList(TBug tBug);

    /**
     * 新增缺陷
     *
     * @param tBug 缺陷
     * @return 结果
     */
    int insertTBug(TBug tBug);

    /**
     * 修改缺陷
     *
     * @param tBug 缺陷
     * @return 结果
     */
    int updateTBug(TBug tBug);

    /**
     * 删除缺陷
     *
     * @param id 缺陷ID
     * @return 结果
     */
    int deleteTBugById(Long id);

    /**
     * 批量删除缺陷
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    int deleteTBugByIds(Long[] ids);
}
