package com.helloword.util;

import java.util.Random;

public class RandomUtil {
	/**
	 * 随机产生0-3的一个排列
	 * @return 排列结果
	 * 算法思路见TAOCP
	 */
	public static int[] shuffle4() {
		final int FOUR = 4;
		int[] arry = { 0, 1, 2, 3 };
		Random r = new Random();
		for (int j = FOUR; j > 0; j--) {
			int index = r.nextInt(FOUR);
			//swap arry[index] and arry[j-1]
			int temp = arry[j-1];
			arry[j-1] = arry[index];
			arry[index] = temp;
		}
		return arry;
	}
}
