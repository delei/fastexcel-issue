package cn.deleiguo.issue.common;

import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author deleiguo
 */
@Data
@NoArgsConstructor
public class DemoData {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private Date date;
    @ExcelProperty("数字标题")
    private Double doubleData;
    @ExcelProperty("数值标题")
    private BigDecimal bigDecimalData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}