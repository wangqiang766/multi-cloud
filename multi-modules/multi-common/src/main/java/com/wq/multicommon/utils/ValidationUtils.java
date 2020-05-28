package com.wq.multicommon.utils;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


/**
 * 检验工具类
 * @author liu
 * @create 
 */
public class ValidationUtils {

	private static Validator validator =  Validation.buildDefaultValidatorFactory().getValidator();
	
	public static <T> ValidationResult validateEntity(T obj){
		ValidationResult result = new ValidationResult();
		 Set<ConstraintViolation<T>> set = validator.validate(obj, Default.class);
		 if((null != set && !set.isEmpty())){
			 result.setHasErrors(true);
			 Map<String,String> errorMsg = new HashMap<String,String>();
			 for(ConstraintViolation<T> cv : set){
				 errorMsg.put(cv.getPropertyPath().toString(), cv.getMessage());
			 }
			 result.setErrorMsg(errorMsg);
		 }
		 return result;
	}
	
	public static <T> ValidationResult validateProperty(T obj,String propertyName){
		ValidationResult result = new ValidationResult();
		 Set<ConstraintViolation<T>> set = validator.validateProperty(obj,propertyName, Default.class);
		 if((null != set && !set.isEmpty())){
			 result.setHasErrors(true);
			 Map<String,String> errorMsg = new HashMap<String,String>();
			 for(ConstraintViolation<T> cv : set){
				 errorMsg.put(propertyName, cv.getMessage());
			 }
			 result.setErrorMsg(errorMsg);
		 }
		 return result;
	}

	public static String msg2Str(ValidationResult result) {
		if (result.isHasErrors()) {
			StringBuffer sb = new StringBuffer();
			Set<Map.Entry<String, String>> entries = result.getErrorMsg().entrySet();
			Iterator<Map.Entry<String, String>> iterator = entries.iterator();
			while (iterator.hasNext()) {
				Map.Entry<String, String> next = iterator.next();
				sb.append(next.getValue());
				sb.append(";");
			}
			return sb.substring(0, sb.length() - 1);
		}else{
			return "";
		}
	}

	//@AssertTrue //用于boolean字段，该字段只能为true
	//@AssertFalse//该字段的值只能为false
	//@CreditCardNumber//对信用卡号进行一个大致的验证
	//@DecimalMax//只能小于或等于该值
	//@DecimalMin//只能大于或等于该值
	//@Digits(integer=2,fraction=20)//检查是否是一种数字的整数、分数,小数位数的数字。
	//@Email//检查是否是一个有效的email地址
	//@Future//检查该字段的日期是否是属于将来的日期
	//@Length(min=,max=)//检查所属的字段的长度是否在min和max之间,只能用于字符串
	//@NotNull//不能为null
	//@NotBlank//不能为空，检查时会将空格忽略
	//@NotEmpty//不能为空，这里的空是指空字符串
	//@Null//检查该字段为空
	//@Past//检查该字段的日期是在过去
	//@Size(min=, max=)//检查该字段的size是否在min和max之间，可以是字符串、数组、集合、Map等
	//@URL(protocol=,host,port)//检查是否是一个有效的URL，如果提供了protocol，host等，则该URL还需满足提供的条件
	//@Valid//该注解只要用于字段为一个包含其他对象的集合或map或数组的字段，或该字段直接为一个其他对象的引用，这样在检查当前对象的同时也会检查该字段所引用的对象
	//@Min(value)	被注释的元素必须是一个数字，其值必须大于等于指定的最小值
	//@Max(value)	被注释的元素必须是一个数字，其值必须小于等于指定的最大值
	//@DecimalMin(value)	被注释的元素必须是一个数字，其值必须大于等于指定的最小值
	//@DecimalMax(value)	被注释的元素必须是一个数字，其值必须小于等于指定的最大值
	//@Size(max, min)	被注释的元素的大小必须在指定的范围内
	//@Digits (integer, fraction)	被注释的元素必须是一个数字，其值必须在可接受的范围内
	//@Past	被注释的元素必须是一个过去的日期
	//@Future	被注释的元素必须是一个将来的日期
	//@Pattern(value)	被注释的元素必须符合指定的正则表达式
}
