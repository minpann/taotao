package com.taotao.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import com.taotao.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by panmin on 16-8-27.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    TbItemMapper itemMapper;

    @Override
    public TbItem getItemById(long itemId) {
        TbItemExample example = new TbItemExample();
        TbItemExample.Criteria criteria = example.createCriteria();
        criteria.andIdEqualTo(itemId);
        List<TbItem> list = itemMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            TbItem item = list.get(0);
            return item;
        }
        return null;
    }

    /**
     * 商品列表查询
     *
     * @param page
     * @param rows
     * @return
     */
    @Override
    public EUDataGridResult getItemList(int page, int rows) {
        //查询商品列表
        TbItemExample example = new TbItemExample();

        //分页处理
        PageHelper.startPage(page, rows);
        List<TbItem> tbItemList = itemMapper.selectByExample(example);

        //创建一个返回对象
        EUDataGridResult result = new EUDataGridResult();
        result.setRows(tbItemList);

        //取出总记录数
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(tbItemList);
        result.setTotal(pageInfo.getTotal());

        return result;
    }

    @Override
    public TaotaoResult createItem(TbItem item) {
        Long itemId = IDUtils.genItemId();
        item.setId(itemId);
        item.setStatus((byte) 1);
        item.setCreated(new Date());
        item.setUpdated(new Date());

        //插入到数据库
        itemMapper.insert(item);
        return TaotaoResult.ok();
    }
}
