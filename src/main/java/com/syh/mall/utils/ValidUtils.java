package com.syh.mall.utils;


import com.syh.mall.exceptions.BusinessException;
import com.syh.mall.exceptions.VaildEx;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @date 2021/11/3 11:00
 */
public class ValidUtils {

	/**
	 * 主动去触发校验, 针对ob对象中加了校验注解的字段,统一处理异常
	 * 
	 * @param ob
	 */
	public static void valid(Object ob) {
		ValidatorFactory vf = Validation.buildDefaultValidatorFactory();
		Validator validator = vf.getValidator();
		Set<ConstraintViolation<Object>> set = validator.validate(ob);
		VaildEx vex = new VaildEx();
		vex.setErrCount(set.size());
		set.stream().map(item -> {
			vex.setErrs(item.getPropertyPath().toString(), item.getMessageTemplate(), item.getInvalidValue());
			return vex;
		}).collect(Collectors.toList());
		if (set.size() > 0) {
			throw new BusinessException(-99, "参数错误", vex);
		}
	}

}
