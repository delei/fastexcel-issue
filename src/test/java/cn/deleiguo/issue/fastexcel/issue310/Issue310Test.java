package cn.deleiguo.issue.fastexcel.issue310;

import cn.deleiguo.issue.common.DemoData;
import cn.deleiguo.issue.util.TestFileUtil;
import cn.idev.excel.FastExcel;
import org.junit.jupiter.api.Test;

import java.util.Collections;

public class Issue310Test {
    @Test
    void writeTest() {
        FastExcel.write(TestFileUtil.createNewFile("issue/issue-310.xlsx"), DemoData.class)
                .sheet()
                .doWrite(Collections.emptyList());
    }
}
