package cn.deleiguo.issue.fastexcel.issue359;

import cn.deleiguo.issue.common.CustomReadListener;
import cn.deleiguo.issue.common.DemoData;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author deleiguo
 */
public class Issue359Test {
    @Test
    void readTest() {
        File file = new File(TestFileUtil.getPath() + "issue/fastexcel/issue359/test_01.xlsx");
        List<DemoData> dataList = FastExcel.read(file, DemoData.class, new CustomReadListener())
                .excelType(ExcelTypeEnum.XLSX)
                .doReadAllSync();
        Assertions.assertEquals(10, dataList.size());
        dataList.forEach(System.out::println);
    }

    @Test
    void writeTest() {
        File file = new File(TestFileUtil.getPath() + "issue-359-write.xlsx");
        FastExcel.write(file, DemoData.class)
                .sheet()
                .doWrite(demoData(10));
    }

    private List<DemoData> demoData(int size) {
        List<DemoData> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            DemoData demoData = new DemoData();
            demoData.setString("String" + i);
            demoData.setDate(DateUtil.date());
            demoData.setDoubleData(RandomUtil.randomDouble());
            dataList.add(demoData);
        }
        return dataList;
    }
}
