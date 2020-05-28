
package com.wq.multicommon.utils;

import java.math.BigDecimal;

/**
 * 数值工具类
 */
public class NumberUtils {

	/**
	 * 加法运算(v1+v2)
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static Double add(double v1, double v2) {
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).doubleValue();
	}
	/**
	 * 加法运算(v1+v2)
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static Double add(Double v1, Double v2) {
		v1=null==v1?0.0d:v1;
		v2=null==v2?0.0d:v2;
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.add(b2).doubleValue();
	}

	/**
	 * 加法运算(v1+v2)
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static Integer add(int v1, int v2) {
		return v1+v2;
	}

	/**
	 * 反转整数值
	 * @param num
	 * @return -num
	 */
	public static Integer reversalInt(Integer num){
		if (null==num || 0==num){
			return num;
		}
		if (num>0){
			return Integer.valueOf("-"+num);
		}

		if(num<0){
			return Integer.valueOf(num.toString().substring(1));
		}
		return num;
	}
	/**
	 * 除法运算(v1/v2)
	 * @param v1
	 * @param v2
	 * @return
	 */
	public static Double intDivide(Integer v1,Integer v2) {
		if(null==v1 || null==v2 || 0==v2){
			return 0.0d;
		}
		BigDecimal b1 = new BigDecimal(v1);
		BigDecimal b2 = new BigDecimal(v2);
		return b1.divide(b2).doubleValue();
	}


}
