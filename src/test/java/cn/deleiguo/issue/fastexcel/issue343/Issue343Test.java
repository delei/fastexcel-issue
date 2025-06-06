package cn.deleiguo.issue.fastexcel.issue343;

import cn.deleiguo.issue.util.TestFileUtil;
import cn.idev.excel.FastExcel;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author deleiguo
 */
public class Issue343Test {

    @Test
    void writeTest() {
        FastExcel.write(new File(TestFileUtil.getPath() + "issue-343.xlsx"))
                .head(head())
                .sheet()
                .doWrite(Collections.emptyList());
    }

    private List<List<String>> head() {
        List<List<String>> headers = new ArrayList<>();
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "所属二级", "所属二级"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "困难职工补助", "补助01"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "困难职工补助", "补助02"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "困难职工补助", "补助03"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "困难职工补助", "补助04"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "职工健康管理", "健康01"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "职工健康管理", "健康02"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "职工健康管理", "健康03"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "职工医疗互助计划", "互助01"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "职工医疗互助计划", "互助02"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "牵手行动", "牵手01"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "牵手行动", "牵手02"));
        headers.add(Arrays.asList("2021年", "开展职工多层次保障工作", "", "牵手03"));
        return headers;
    }

}
