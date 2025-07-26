package cn.deleiguo.issue.common;

import cn.idev.excel.annotation.ExcelIgnore;
import cn.idev.excel.annotation.ExcelProperty;
import cn.idev.excel.annotation.format.NumberFormat;
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
    @ExcelProperty("StringTitle")
    private String string;

    @ExcelProperty("DateTitle")
    private Date date;

    @ExcelProperty("DoubleTitle")
    private Double doubleData;

    @ExcelProperty("BigDecimalTitle")
    @NumberFormat("#,##0.00")
    private BigDecimal bigDecimalData;

    @ExcelIgnore
    private String ignore;
}