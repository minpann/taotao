package com.taotao.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemExample;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * Created by panmin on 16-8-27.
 */
public class PageHelperTest {

    @Test
    public void PageHelperTest() {
        //创建一个spring容器
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");

        //从spring容器中获取Mapper代理对象
        TbItemMapper mapper = applicationContext.getBean(TbItemMapper.class);

        //执行查询，分页
        TbItemExample example = new TbItemExample();

        PageHelper.startPage(1, 10);

        List<TbItem> tbItemList = mapper.selectByExample(example);

        //取商品列表
        for (TbItem item : tbItemList) {
            System.out.println(item.getTitle());
        }

        //取分页信息
        PageInfo<TbItem> pageInfo = new PageInfo<TbItem>(tbItemList);

        long total = pageInfo.getTotal();

        System.out.println(total);
    }
}
