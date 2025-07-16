package cn.deleiguo.issue.fastexcel.issue233;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

/**
 * @author deleiguo
 */
@Data
@NoArgsConstructor
public class Issue233Model {
    @ExcelProperty("字符串标题")
    private String string;
    @ExcelProperty("日期标题")
    private ZonedDateTime zonedDateTime;
}
