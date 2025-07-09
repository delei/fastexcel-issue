package cn.deleiguo.issue.easyexcel.issue2346;

import cn.deleiguo.issue.common.NoModelDataListener;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Issue2346Test {
    @Test
    void testRead() throws Exception {
        File testFile = TestFileUtil.readFile("issue/easyexcel/2346.xlsx");
        FastExcel.read(testFile, new NoModelDataListener())
                .excelType(ExcelTypeEnum.XLSX)
                .sheet(2)
                .doRead();
    }
}
