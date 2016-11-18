package xyz.oldbad.obsdk.utils;

import java.util.Random;

public class MathUtils {
	private final static Random random = new Random(System.nanoTime());

	/**
	 * 包含min以及max之内的随机整数
	 * 
	 * @param min
	 * @param max
	 * @return
	 */
	public static int getRandom(int min, int max) {
		return min + random.nextInt(max - min + 1);
	}

}
