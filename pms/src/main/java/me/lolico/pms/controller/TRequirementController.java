package me.lolico.pms.controller;

import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.SecurityUtils;
import com.ruoyi.common.utils.poi.ExcelUtil;
import me.lolico.pms.domain.TRequirement;
import me.lolico.pms.service.ITRequirementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 需求Controller
 *
 * @author lolico
 * @date 2021-03-28
 */
@RestController
@RequestMapping("/project/requirement")
public class TRequirementController extends BaseController {
    @Autowired
    private ITRequirementService tRequirementService;

    /**
     * 查询需求列表
     */
    @PreAuthorize("@ss.hasPermi('project:requirement:list')")
    @GetMapping("/list")
    public TableDataInfo list(TRequirement tRequirement) {
        startPage();
        List<TRequirement> list = tRequirementService.selectTRequirementList(tRequirement);
        return getDataTable(list);
    }

    /**
     * 导出需求列表
     */
    @PreAuthorize("@ss.hasPermi('project:requirement:export')")
    @Log(title = "需求管理", businessType = BusinessType.EXPORT)
    @GetMapping("/export")
    public AjaxResult export(TRequirement tRequirement) {
        List<TRequirement> list = tRequirementService.selectTRequirementList(tRequirement);
        ExcelUtil<TRequirement> util = new ExcelUtil<TRequirement>(TRequirement.class);
        return util.exportExcel(list, "requirement");
    }

    /**
     * 获取需求详细信息
     */
    @PreAuthorize("@ss.hasPermi('project:requirement:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id) {
        return AjaxResult.success(tRequirementService.selectTRequirementById(id));
    }

    /**
     * 新增需求
     */
    @PreAuthorize("@ss.hasPermi('project:requirement:add')")
    @Log(title = "需求管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody TRequirement tRequirement) {
        String username = SecurityUtils.getUsername();
        tRequirement.setCreateBy(username);
        tRequirement.setUpdateBy(username);
        return toAjax(tRequirementService.insertTRequirement(tRequirement));
    }

    /**
     * 修改需求
     */
    @PreAuthorize("@ss.hasPermi('project:requirement:edit')")
    @Log(title = "需求管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody TRequirement tRequirement) {
        tRequirement.setUpdateBy(SecurityUtils.getUsername());
        return toAjax(tRequirementService.updateTRequirement(tRequirement));
    }

    /**
     * 删除需求
     */
    @PreAuthorize("@ss.hasPermi('project:requirement:remove')")
    @Log(title = "需求管理", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids) {
        return toAjax(tRequirementService.deleteTRequirementByIds(ids));
    }
}
