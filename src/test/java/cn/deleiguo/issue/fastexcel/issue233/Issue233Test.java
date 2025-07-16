package cn.deleiguo.issue.fastexcel.issue233;

import cn.deleiguo.issue.util.TestFileUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * @author deleiguo
 */
public class Issue233Test {
    @Test
    void writeTest() {
        FastExcel.write(TestFileUtil.createNewFile("issue/233-w.xlsx"), Issue233Model.class)
                .excelType(ExcelTypeEnum.XLSX)
                .registerConverter(new ZonedDateTimeStringConverter())
                .sheet()
                .doWrite(demoData(5));
    }

    private List<Issue233Model> demoData(int size) {
        List<Issue233Model> dataList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Issue233Model data = new Issue233Model();
            data.setString("String" + i);
            data.setZonedDateTime(ZonedDateTime.now());
            dataList.add(data);
        }
        return dataList;
    }
}
