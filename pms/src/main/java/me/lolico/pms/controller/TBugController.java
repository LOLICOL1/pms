package me.lolico.pms.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import me.lolico.pms.annotation.AutoSet;
import me.lolico.pms.domain.TBug;
import me.lolico.pms.enums.OperationType;
import me.lolico.pms.service.ITBugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 缺陷Controller
 *
 * @author lolico
 * @date 2021-04-24
 */
@RestController
@RequestMapping("/project/bug")
public class TBugController extends BaseController {
    @Autowired
    private ITBugService tBugService;

    /**
     * 查询缺陷列表
     */
    @PreAuthorize("@ss.hasPermi('project:bug:list')")
    @GetMapping("/list")
    public TableDataInfo list(TBug tBug) {
        startPage();
        List<TBug> list = tBugService.selectTBugList(tBug);
        return getDataTable(list);
    }

    /**
     * 导出缺陷列表
     */
    @PreAuthorize("@ss.hasPermi('project:bug:export')")
    @Log(title = "缺陷", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TBug tBug) {
        List<TBug> list = tBugService.selectTBugList(tBug);
        ExcelUtil<TBug> util = new ExcelUtil<TBug>(TBug.class);
        return util.exportExcel(list, "bug");
    }

    /**
     * 获取缺陷详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:bug:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(tBugService.selectTBugById(id));
    }

    /**
     * 新增缺陷
     */
    @PreAuthorize("@ss.hasPermi('project:bug:add')")
    @Log(title = "缺陷", businessType = BusinessType.INSERT)
    @AutoSet(OperationType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TBug tBug) {
        return toAjax(tBugService.insertTBug(tBug));
    }

    /**
     * 修改缺陷
     */
    @PreAuthorize("@ss.hasPermi('project:bug:edit')")
    @Log(title = "缺陷", businessType = BusinessType.UPDATE)
    @AutoSet(OperationType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TBug tBug) {
        return toAjax(tBugService.updateTBug(tBug));
    }

    /**
     * 删除缺陷
     */
    @PreAuthorize("@ss.hasPermi('project:bug:remove')")
    @Log(title = "缺陷", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(tBugService.deleteTBugByIds(ids));
    }
}
