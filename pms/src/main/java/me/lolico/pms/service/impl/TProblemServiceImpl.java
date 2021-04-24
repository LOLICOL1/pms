package me.lolico.pms.service.impl;

import me.lolico.pms.domain.TProblem;
import me.lolico.pms.mapper.TProblemMapper;
import me.lolico.pms.service.ITProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 问题管理Service业务层处理
 *
 * @author lolico
 * @date 2021-04-24
 */
@Service
public class TProblemServiceImpl implements ITProblemService {
    @Autowired
    private TProblemMapper tProblemMapper;

    /**
     * 查询问题管理
     *
     * @param id 问题管理ID
     * @return 问题管理
     */
    @Override
    public TProblem selectTProblemById(Long id) {
        return tProblemMapper.selectTProblemById(id);
    }

    /**
     * 查询问题管理列表
     *
     * @param tProblem 问题管理
     * @return 问题管理
     */
    @Override
    public List<TProblem> selectTProblemList(TProblem tProblem) {
        return tProblemMapper.selectTProblemList(tProblem);
    }

    /**
     * 新增问题管理
     *
     * @param tProblem 问题管理
     * @return 结果
     */
    @Override
    public int insertTProblem(TProblem tProblem) {
        return tProblemMapper.insertTProblem(tProblem);
    }

    /**
     * 修改问题管理
     *
     * @param tProblem 问题管理
     * @return 结果
     */
    @Override
    public int updateTProblem(TProblem tProblem) {
        return tProblemMapper.updateTProblem(tProblem);
    }

    /**
     * 批量删除问题管理
     *
     * @param ids 需要删除的问题管理ID
     * @return 结果
     */
    @Override
    public int deleteTProblemByIds(Long[] ids) {
        return tProblemMapper.deleteTProblemByIds(ids);
    }

    /**
     * 删除问题管理信息
     *
     * @param id 问题管理ID
     * @return 结果
     */
    @Override
    public int deleteTProblemById(Long id) {
        return tProblemMapper.deleteTProblemById(id);
    }
}
