package com.taotao.controller;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * Created by panmin on 16-8-27.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @RequestMapping("/item/{itemId}")
    @ResponseBody
    public TbItem getItemById(@PathVariable Long itemId) {
        TbItem tbItem = itemService.getItemById(itemId);
        return tbItem;
    }

    @RequestMapping("/item/list")
    @ResponseBody
    public EUDataGridResult getItemList(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "30") Integer rows) {
        EUDataGridResult result = itemService.getItemList(page, rows);
        return result;
    }

    @RequestMapping(value="/item/save", method=RequestMethod.POST)
    @ResponseBody
    private TaotaoResult createItem(TbItem item, String desc, String itemParams) throws Exception {
        TaotaoResult result = itemService.createItem(item, desc, itemParams);
        return result;
    }
}
