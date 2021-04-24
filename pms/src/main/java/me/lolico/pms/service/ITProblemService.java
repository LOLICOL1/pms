package me.lolico.pms.service;

import me.lolico.pms.domain.TProblem;

import java.util.List;

/**
 * 问题管理Service接口
 *
 * @author lolico
 * @date 2021-04-24
 */
public interface ITProblemService {
    /**
     * 查询问题管理
     *
     * @param id 问题管理ID
     * @return 问题管理
     */
    TProblem selectTProblemById(Long id);

    /**
     * 查询问题管理列表
     *
     * @param tProblem 问题管理
     * @return 问题管理集合
     */
    List<TProblem> selectTProblemList(TProblem tProblem);

    /**
     * 新增问题管理
     *
     * @param tProblem 问题管理
     * @return 结果
     */
    int insertTProblem(TProblem tProblem);

    /**
     * 修改问题管理
     *
     * @param tProblem 问题管理
     * @return 结果
     */
    int updateTProblem(TProblem tProblem);

    /**
     * 批量删除问题管理
     *
     * @param ids 需要删除的问题管理ID
     * @return 结果
     */
    int deleteTProblemByIds(Long[] ids);

    /**
     * 删除问题管理信息
     *
     * @param id 问题管理ID
     * @return 结果
     */
    int deleteTProblemById(Long id);
}
