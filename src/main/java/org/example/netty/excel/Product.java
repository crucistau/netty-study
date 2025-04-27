package org.example.netty.excel;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class Product {
    @ExcelProperty("产品名称")
    private String name;
    @ExcelProperty("产品编码")
    private String code;
    private Integer delFlag;
}
