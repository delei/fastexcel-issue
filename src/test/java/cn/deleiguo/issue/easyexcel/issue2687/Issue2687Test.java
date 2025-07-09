package cn.deleiguo.issue.easyexcel.issue2687;

import cn.deleiguo.issue.common.DemoData;
import cn.deleiguo.issue.util.TestDataUtil;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.idev.excel.ExcelWriter;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import cn.idev.excel.write.metadata.WriteSheet;
import org.junit.jupiter.api.Test;

import java.io.File;

public class Issue2687Test {
    @Test
    void testWrite() throws Exception {
        File testFile = TestFileUtil.createNewFile("issue/easyexcel/2687.xlsx");
        try (ExcelWriter excelWriter = FastExcel.write(testFile, DemoData.class).excelType(ExcelTypeEnum.XLSX).build()) {
            WriteSheet writeSheet1 = FastExcel.writerSheet(0, "Sheet1").head(DemoData.class).build();
            WriteSheet writeSheet2 = FastExcel.writerSheet(1, "Sheet2").head(DemoData.class).build();
            excelWriter.write(TestDataUtil.demoData(2), writeSheet2);
            excelWriter.write(TestDataUtil.demoData(1), writeSheet1);
        }
    }
}
