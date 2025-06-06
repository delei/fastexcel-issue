package cn.deleiguo.issue.fastexcel.issue359;

import cn.deleiguo.issue.fastexcel.common.CustomReadListener;
import cn.deleiguo.issue.fastexcel.common.DemoData;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.idev.excel.FastExcel;
import cn.idev.excel.support.ExcelTypeEnum;
import org.junit.jupiter.api.Test;

import java.io.File;
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
        dataList.forEach(System.out::println);
    }
}
