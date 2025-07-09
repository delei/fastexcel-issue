package cn.deleiguo.issue.util;

import cn.deleiguo.issue.common.DemoData;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.RandomUtil;

import java.util.ArrayList;
import java.util.List;

public class TestDataUtil {
    public static List<DemoData> demoData(int size) {
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
