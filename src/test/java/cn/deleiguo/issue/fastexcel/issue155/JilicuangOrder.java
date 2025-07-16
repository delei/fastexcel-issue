package cn.deleiguo.issue.fastexcel.issue155;

import cn.idev.excel.annotation.ExcelIgnoreUnannotated;
import cn.idev.excel.annotation.ExcelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@ExcelIgnoreUnannotated
public class JilicuangOrder implements Serializable {
    @ExcelProperty(value = "序号", order = 1)
    private Integer order;

    @ExcelProperty(value = "商品编号", order = 2)
    private String code;

    @ExcelProperty(value = "品牌", order = 3)
    private String pingpai;

    @ExcelProperty(value = "厂家型号", order = 4)
    private String xinhao;

    @ExcelProperty(value = "封装", order = 5)
    private String fengzhuan;

    @ExcelProperty(value = "商品名称", order = 6)
    private String minchen;

    @ExcelProperty(value = "订购数量（修改后）", order = 7)
    private String shuliang;

    @ExcelProperty(value = "是否不发此货", order = 8)
    private String fahuo;

    @ExcelProperty(value = "毛重（kg）", order = 9)
    private String maozong;

    @ExcelProperty(value = "商品单价", order = 10)
    private String danjia;

    @ExcelProperty(value = "商品金额", order = 11)
    private String jiner;
}
