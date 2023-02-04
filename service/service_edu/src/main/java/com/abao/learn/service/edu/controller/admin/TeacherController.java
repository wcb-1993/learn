package com.abao.learn.service.edu.controller.admin;


import com.abao.learn.common.base.result.R;
import com.abao.learn.service.edu.entity.Teacher;
import com.abao.learn.service.edu.service.TeacherService;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author abao
 * @since 2023-01-31
 */
@RestController
@RequestMapping("/admin/edu/teacher")
public class TeacherController {

    @Autowired
    private TeacherService teacherService;

    @ApiOperation("所有讲师列表")
    @GetMapping("list")
    public R listAll() {
        List<Teacher> list = teacherService.list();
        return R.ok().data("items", list);
    }

    @ApiOperation(value = "根据ID删除讲师", notes = "根据讲师ID逻辑删除讲师")
    @DeleteMapping("remove/{id}")
    public boolean removeById(@PathVariable String id) {
        return teacherService.removeById(id);
    }

    @ApiOperation("分页讲师列表")
    @GetMapping("list/{page}/{limit}")
    public R listPage(@ApiParam(value = "当前页码", required = true) @PathVariable Long page,
                      @ApiParam(value = "每页记录数", required = true) @PathVariable Long limit) {

        Page<Teacher> pageParam = new Page<>(page, limit);
        IPage<Teacher> pageModel = teacherService.page(pageParam);
        List<Teacher> records = pageModel.getRecords();
        long total = pageModel.getTotal();
        return R.ok().data("total", total).data("rows", records);
    }
}

