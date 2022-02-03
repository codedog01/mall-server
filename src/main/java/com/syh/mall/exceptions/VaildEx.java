
package com.syh.mall.exceptions;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@ApiModel(value = "@valid 拦截返回值")
public class VaildEx {
	@ApiModelProperty(value = "校验不通过总数")
	private int errCount;
	final List<FiledInfo> errs = new ArrayList<>();

	public void setErrs(String filed, String errInfo, Object currentValue) {
		errs.add(new FiledInfo(filed, errInfo, currentValue));
	}

}

@Setter
@Getter
@AllArgsConstructor
@ApiModel(value = "错误集合")
class FiledInfo {
	@ApiModelProperty(value = "字段名称")
	private String filed;
	@ApiModelProperty(value = "错误信息")
	private String errInfo;
	@ApiModelProperty(value = "当前值")
	private Object currentValue;

}
