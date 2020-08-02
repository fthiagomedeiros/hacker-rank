import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class SolutionTests {

	@Test
	@DisplayName("Given nums = [2, 7, 11, 15], target = 9")
	void testBaseCase() {
		Solution s = new Solution();
		int[] response = s.twoSum(new int[] {2,7,11,15}, 9);
		assertArrayEquals(response, new int[]{0, 1});
	}

	@Test
	@DisplayName("Given nums = [2,5,7,11,15,22,33], target = 44")
	void testBaseCaseSecondTime() {
		Solution s = new Solution();
		int[] response = s.twoSum(new int[] {2,5,7,11,15,22,33}, 44);
		assertArrayEquals(response, new int[]{3, 6});
	}

	@Test
	@DisplayName("Given nums = [3,2,4], target = 6")
	void testBaseCaseThirdTime() {
		Solution s = new Solution();
		int[] response = s.twoSum(new int[] {3,2,4}, 6);
		assertArrayEquals(response, new int[]{1, 2});
	}
}