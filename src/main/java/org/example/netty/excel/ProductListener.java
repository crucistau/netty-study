package org.example.netty.excel;

import cn.idev.excel.context.AnalysisContext;
import cn.idev.excel.read.listener.ReadListener;

public class ProductListener implements ReadListener<Product> {
    @Override
    public void invoke(Product product, AnalysisContext analysisContext) {
        System.out.println("解析到一条数据" +product);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        System.out.println("解析到一条数据" );
    }
}
