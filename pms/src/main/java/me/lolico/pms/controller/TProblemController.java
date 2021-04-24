package me.lolico.pms.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import me.lolico.pms.annotation.AutoSet;
import me.lolico.pms.domain.TProblem;
import me.lolico.pms.enums.OperationType;
import me.lolico.pms.service.ITProblemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 问题管理Controller
 *
 * @author lolico
 */
@RestController
@RequestMapping("/project/problem")
public class TProblemController extends BaseController {
    @Autowired
    private ITProblemService tProblemService;

    /**
     * 查询问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('project:problem:list')")
    @GetMapping("/list")
    public TableDataInfo list(TProblem tProblem) {
        startPage();
        List<TProblem> list = tProblemService.selectTProblemList(tProblem);
        return getDataTable(list);
    }

    /**
     * 导出问题管理列表
     */
    @PreAuthorize("@ss.hasPermi('project:problem:export')")
    @Log(title = "问题管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TProblem tProblem) {
        List<TProblem> list = tProblemService.selectTProblemList(tProblem);
        ExcelUtil<TProblem> util = new ExcelUtil<>(TProblem.class);
        return util.exportExcel(list, "problem");
    }

    /**
     * 获取问题管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:problem:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(tProblemService.selectTProblemById(id));
    }

    /**
     * 新增问题管理
     */
    @PreAuthorize("@ss.hasPermi('project:problem:add')")
    @Log(title = "问题管理", businessType = BusinessType.INSERT)
    @AutoSet(OperationType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TProblem tProblem) {
        return toAjax(tProblemService.insertTProblem(tProblem));
    }

    /**
     * 修改问题管理
     */
    @PreAuthorize("@ss.hasPermi('project:problem:edit')")
    @Log(title = "问题管理", businessType = BusinessType.UPDATE)
    @AutoSet(OperationType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TProblem tProblem) {
        return toAjax(tProblemService.updateTProblem(tProblem));
    }

    /**
     * 删除问题管理
     */
    @PreAuthorize("@ss.hasPermi('project:problem:remove')")
    @Log(title = "问题管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tProblemService.deleteTProblemByIds(ids));
    }
}
