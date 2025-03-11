package Ch17;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class C04Ex {
	
	public static void sortNumber(Set<Integer> sets) {
		List<Integer> sort1 = sets.stream().sorted().collect(Collectors.toList());
		System.out.println(sort1);
		
//		Set<Integer> sort2 = new TreeSet<Integer>();
//		for (Integer el : sets) {
//			sort2.add(el);
//		}
//		System.out.println(sort2);
	}
	
	public static void main(String[] args) {
		// 1) 1~45 까지 숫자 6개를 랜덤으로 받아(Random클래스를 이용) set에 저장 및 출력
		Set<Integer> lotteryNumber = new HashSet();
		while (lotteryNumber.size()<6) {
			lotteryNumber.add((int) (Math.random() * 100) % 45 + 1);
		}		
		System.out.println(lotteryNumber);
		// 2) [추가] 저장된 set의 오름차순 정렬(stream 함수 사용)
		
		sortNumber(lotteryNumber);
		
	}

}
