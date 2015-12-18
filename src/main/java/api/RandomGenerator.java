package api;

import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class RandomGenerator {

	private List<Integer> numbers;

	public List<Integer> getNumbers() { return numbers; }

	public RandomGenerator(int numbers){

		this.numbers = new ArrayList<Integer>();

		Random random = new Random();

		for(int i=0;i<numbers;i++){
			this.numbers.add(random.nextInt(Integer.MAX_VALUE));
		}

	}
}