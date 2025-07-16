package cn.deleiguo.issue.fastexcel.issue237;

import cn.deleiguo.issue.common.DemoData;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.idev.excel.ExcelWriter;
import cn.idev.excel.FastExcel;
import cn.idev.excel.write.metadata.WriteSheet;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author deleiguo
 */
public class Issue237Test {

    @Test
    public void listFill() {
        File templateFile = TestFileUtil.readFile("issue/fastexcel/issue237/fill-list.xlsx");

        String fileName = TestFileUtil.getPath() + "listFill" + System.currentTimeMillis() + ".xlsx";
        try (ExcelWriter excelWriter = FastExcel.write(fileName).withTemplate(templateFile)
                .registerWriteHandler(new Issue237WriteHandler()).build()) {
            WriteSheet writeSheet = FastExcel.writerSheet().build();
            excelWriter.fill(demoData(5), writeSheet);
        }
    }

    private List<DemoData> demoData(int size) {
        List<DemoData> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            DemoData demoData = new DemoData();
            demoData.setString("String" + i);
            demoData.setDate(DateUtil.date());
            demoData.setDoubleData(RandomUtil.randomDouble(-10.00D, 10.00D));
            dataList.add(demoData);
        }
        return dataList;
    }
}
