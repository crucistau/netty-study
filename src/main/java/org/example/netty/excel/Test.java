package org.example.netty.excel;

import cn.idev.excel.FastExcel;

public class Test {
    public static void main(String[] args) {
        String filePath = "C:\\Users\\moon\\Desktop\\1.xlsx";
        FastExcel.read(filePath, Product.class, new ProductListener()).sheet().headRowNumber(3).doRead();
    }
}
