package cau1;

import java.util.Scanner;

public class cau1 {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        int so_le = scanner.nextInt();
	        for (int i = 1; i <= so_le; i += 2) 
	            System.out.println(" ".repeat((so_le - i) / 2) + "*".repeat(i));
	      
	    }
}
