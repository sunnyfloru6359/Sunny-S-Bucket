package Sunny;

import org.testng.annotations.Test;

@Test
public class trainglepattern {

	public void triangle() {

		int rows=5;

		for(int i=rows;i>=1;i--) {

			for(int j=1;j<=i;j++) {

			System.out.print(i);
			}
			System.out.println();
		}

	}


}
