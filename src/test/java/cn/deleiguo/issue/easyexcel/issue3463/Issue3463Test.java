package cn.deleiguo.issue.easyexcel.issue3463;

import cn.deleiguo.issue.common.CustomReadListener;
import cn.deleiguo.issue.common.DemoData;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author deleiguo
 */
public class Issue3463Test {

    @Test
    void fileTest() throws Exception {
        String password = "123456";
        File testFile = TestFileUtil.createNewFile(TestFileUtil.getPath() + "/easyexcel/issue-3463.xlsx");
        FastExcel.write(Files.newOutputStream(testFile.toPath()), DemoData.class)
                .excelType(ExcelTypeEnum.XLSX)
                .password(password)
                .sheet()
                .doWrite(demoData(10));
        FastExcel.read(testFile, DemoData.class, new CustomReadListener())
                .excelType(ExcelTypeEnum.XLSX)
                .password(password)
                .sheet()
                .doReadSync();
    }

    @Test
    void fileStreamTest() throws Exception {
        String password = "123456";
        File testFile = TestFileUtil.createNewFile(TestFileUtil.getPath() + "/easyexcel/issue-3463.xlsx");
        FastExcel.write(Files.newOutputStream(testFile.toPath()), DemoData.class)
                .excelType(ExcelTypeEnum.XLSX)
                .password(password)
                .sheet()
                .doWrite(demoData(10));
        FastExcel.read(Files.newInputStream(testFile.toPath()), DemoData.class, new CustomReadListener())
                .excelType(ExcelTypeEnum.XLSX)
                .password(password)
                .sheet()
                .doReadSync();
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
