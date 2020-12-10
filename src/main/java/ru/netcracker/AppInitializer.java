package ru.netcracker;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppInitializer {
	Scanner scanner = new Scanner(System.in);

	public List<Integer> getValues(){
		ArrayList<Integer> list = new ArrayList<>();
		for(int i = 0;i<3;i++){
			try{
				int a = scanner.nextInt();
				while(!doCheck(a)){
					a = scanner.nextInt();
				}
				list.add(a);
			}
			catch (NumberFormatException e){
				e.printStackTrace();
			}
		}
		return list;
	}

	public boolean doCheck(int a){
			if (a<=0) {
				System.out.println("Illegal value. Try another one");
				return false;
			}
			return true;
	}
}
