package cn.deleiguo.issue.fastexcel.issue571;

import cn.deleiguo.issue.common.DemoData;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Issue571Test {

    @Test
    void readTest() {
        File testFile = TestFileUtil.readFile("issue/common/simple_formula.xlsx");
        FastExcel.read(testFile, DemoData.class, new Issue571ReadListener())
                .excelType(ExcelTypeEnum.XLSX)
                .sheet()
                .doReadSync();
    }
}
