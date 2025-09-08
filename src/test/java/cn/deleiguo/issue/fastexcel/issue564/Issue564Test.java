package cn.deleiguo.issue.fastexcel.issue564;

import cn.deleiguo.issue.common.DemoData;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.idev.excel.ExcelWriter;
import cn.idev.excel.FastExcel;
import cn.idev.excel.write.metadata.WriteSheet;
import cn.idev.excel.write.metadata.fill.FillConfig;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Issue564Test {

    @Test
    void testFill01() {
        File templateFile = TestFileUtil.readFile("issue/fastexcel/issue564/list.xlsx");

        try (ExcelWriter excelWriter = FastExcel.write(TestFileUtil.createNewFile("issue/result-564.xlsx"))
                // register a custom SheetWriteHandler
                .registerWriteHandler(new CustomSheetNoWriteHandler())
                .withTemplate(templateFile)
                .inMemory(true)
                .build()) {

            List<String> sheets = Arrays.asList("Sheet2", "Sheet3");

            WriteSheet customSheet = FastExcel.writerSheet(0, "Sheet1").build();
            excelWriter.fill(demoData(1), customSheet);

            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            // 数据sheet
            int sheetNo = 0;
            for (String sheetName : sheets) {
                // 根据 sheet name 来填充
                WriteSheet writeSheet = FastExcel.writerSheet(sheetName)
                        // .sheetNo(sheetNo++)
                        .build();
                excelWriter.fill(demoData(5), fillConfig, writeSheet);
            }
        }
    }

    private List<DemoData> demoData(int size) {
        List<DemoData> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            DemoData demoData = new DemoData();
            demoData.setString("String" + i);
            demoData.setDate(DateUtil.date());
            demoData.setDoubleData(RandomUtil.randomDouble());
            demoData.setBigDecimalData(new BigDecimal("1231111111" + i));
            dataList.add(demoData);
        }
        return dataList;
    }
}
