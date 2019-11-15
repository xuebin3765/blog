package com.xblog.open.controller.admin;

import com.xblog.open.common.base.BaseController;
import com.xblog.open.dto.menu.MenuAddDTO;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin/menu")
public class MenuController extends BaseController {

    @GetMapping("/add")
    public String add(@RequestBody MenuAddDTO menuAddDTO){

        return "";
    }

}
