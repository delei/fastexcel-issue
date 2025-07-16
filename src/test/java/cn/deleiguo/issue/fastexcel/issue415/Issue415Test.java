package cn.deleiguo.issue.fastexcel.issue415;

import cn.deleiguo.issue.util.TestFileUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Issue415Test {

    @Test
    void testRead() throws Exception {
        File testFile = TestFileUtil.readFile("issue/fastexcel/issue415/test-415.xlsx");
        FastExcel.read(testFile, ProductImportReqVO.class, new Issue415ReadListener())
                .excelType(ExcelTypeEnum.XLSX)
                .sheet()
                .doReadSync();
    }
}
