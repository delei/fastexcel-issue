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
                .withTemplate(templateFile)
                .inMemory(true)
                .build()) {

            List<String> sheets = Arrays.asList("Sheet1", "Sheet2", "Sheet3");
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            // 数据sheet
            int sheetNo = 0;
            for (String sheetName : sheets) {
                // 需要根据name来填充相应的数据
                WriteSheet writeSheet = FastExcel.writerSheet(sheetName)
                        // .sheetNo(sheetNo++)
                        .build();
                // 填充目录信息
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
