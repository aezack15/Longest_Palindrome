//Grind 75 
//longest palindrome

import java.util.*;

class Longest_Palindrome{
	
	private class cell{
		public int count;
		public String c;
		public String ID;
		public cell(int count, String c){
			this.count = count;
			this.c = c;
			this.ID = c + count;
		}
		
		public String getID(){
			return this.ID;
		}
		
		public String getC(){
			return this.c;
		}
		
		public int getCount(){
			return this.count;
		}
		 
		public String toString(){
			return this.c + ":" + this.count;
		}
	}
	
	public static void main(String[] args){
		Longest_Palindrome ls = new Longest_Palindrome();
		Scanner in = new Scanner(System.in);
		System.out.print("Enter string > ");
		String s = in.nextLine();
		String[] sa = s.split("");
		ArrayList<String> list = new ArrayList<String>();
		for(int i=0; i<sa.length; i++){
				list.add(sa[i]);
		}
		Collections.sort(list);	
		ls.frequencies(list);
	}
	
	private void frequencies(ArrayList<String> list){
		ArrayList<cell> counts = new ArrayList<cell>();
		for(int i=0; i<list.size(); i++){
			cell temp = new cell(Collections.frequency(list, list.get(i)), list.get(i));
			if(i+1 < list.size()){
				if(!list.get(i).equals(list.get(i+1))){
					counts.add(temp);
				}
			}
		}
		cell last = new cell(Collections.frequency(list, list.get(list.size()-1)), list.get(list.size()-1));
		counts.add(last);
		System.out.println(counts.toString());
		int largestP = 0;
		for(int i=0; i<counts.size(); i++){
			if(counts.get(i).getCount()%2 == 0){
				largestP = largestP + counts.get(i).getCount();
			}
			if(counts.get(i).getCount()%2 != 0 && counts.get(i).getCount() >= 3){
				largestP = largestP + counts.get(i).getCount() - 1;
			}
		}
		
		System.out.println("Largest Palindrome is " + largestP);
	}
}




