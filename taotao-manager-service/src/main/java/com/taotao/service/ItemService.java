package com.taotao.service;

import com.taotao.common.pojo.EUDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import org.springframework.stereotype.Service;

/**
 * Created by panmin on 16-8-27.
 */
@Service
public interface ItemService {
    TbItem getItemById(long itemId);

    EUDataGridResult getItemList(int page, int rows);

    TaotaoResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}
