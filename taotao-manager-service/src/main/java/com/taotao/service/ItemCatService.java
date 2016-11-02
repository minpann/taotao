package com.taotao.service;

import com.taotao.pojo.TbItemCat;

import java.util.List;

/**
 * Created by panmin on 16-11-2.
 */
public interface ItemCatService {
    List<TbItemCat> getItemCatList(long parentId);
}
