package cn.deleiguo.issue.fastexcel.issue415;

import cn.idev.excel.annotation.ExcelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Data
public class ProductImportReqVO {
    /**
     * 产品编号
     */
    @ExcelProperty("产品编号")
    private Long id;

    /**
     * 产品名称
     */
    @NotBlank(message = "产品名称不能为空")
    @ExcelProperty("产品名称")
    private String name;

    /**
     * 产品条码
     */
    @NotBlank(message = "产品条码不能为空")
    @ExcelProperty("产品条码")
    private String barCode;

    /**
     * 产品分类编号
     */
    @NotNull(message = "产品分类编号不能为空")
    @ExcelProperty("产品分类编号")
    private Long categoryId;

    /**
     * 单位编号
     */
    @NotNull(message = "单位编号不能为空")
    @ExcelProperty("单位编号")
    private Long unitId;

    /**
     * 产品状态
     */
    @NotNull(message = "产品状态不能为空")
    @ExcelProperty("产品状态")
    private Integer status;

    /**
     * 产品规格
     */
    @NotBlank(message = "产品规格不能为空")
    @ExcelProperty("产品规格")
    private String standard;

    /**
     * 产品备注
     */
    @NotBlank(message = "产品备注不能为空")
    @ExcelProperty("产品备注")
    private String remark;

    /**
     * 保质期天数
     */
    @NotNull(message = "保质期天数不能为空")
    @ExcelProperty("保质期天数")
    private Integer expiryDay;

    /**
     * 基础重量（kg）
     */
    @NotNull(message = "基础重量（kg）不能为空")
    @ExcelProperty("基础重量（kg）")
    private BigDecimal weight;

    /**
     * 采购价格，单位：元
     */
    @NotNull(message = "采购价格，单位：元不能为空")
    @ExcelProperty("采购价格，单位：元")
    private BigDecimal purchasePrice;

    /**
     * 销售价格，单位：元
     */
    @NotNull(message = "销售价格，单位：元不能为空")
    @ExcelProperty("销售价格，单位：元")
    private BigDecimal salePrice;

    /**
     * 最低价格，单位：元
     */
    @NotNull(message = "最低价格，单位：元不能为空")
    @ExcelProperty("最低价格，单位：元")
    private BigDecimal minPrice;
}
