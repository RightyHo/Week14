import java.util.ArrayList;
import java.util.List;

public class Anagrams {
	public static void main(String[] ars){
		Anagrams a = new Anagrams();
		a.launch();
	}
	public void launch(){
/*		List<String> iterativeList = iterativeAnagram("sword");
		if(!iterativeList.isEmpty()){
			//print out list of strings
		}
*/		System.out.println("Printing list of anagrams for the word abc:");
		List<String> recursiveList = recursiveAnagram("abc");
		if(!recursiveList.isEmpty()){
			for(int i=0;i<recursiveList.size();i++){
				String output = recursiveList.get(i);
				System.out.println(output);
			}
		}
	}
/*	public static List<String> iterativeAnagram(String s){
		//method
	}
*/	public static List<String> recursiveAnagram(String s){
		List<String> result = new ArrayList<String>();
		if(s.length() == 1){
			result.add(s);
			return result;
		} else {
			for(int i=0;i<s.length();i++){
				String removedChar = Character.toString(s.charAt(i));
				if(i==0){
					List<String> interimResult = recursiveAnagram(s.substring(i+1));
					for(int j=0;j<interimResult.size();j++){
						String concatString = removedChar + interimResult.get(j);
						result.add(concatString);
					}
				} else {
					String sub1 = s.substring(0,i-1);
					String sub2 = s.substring(i+1,s.length());
					String reducedString = sub1 + sub2;
					List<String> interimResult = recursiveAnagram(reducedString);
					for(int j=0;j<interimResult.size();j++){
						String concatString = removedChar + interimResult.get(j);
						result.add(concatString);
					}
				}
			}
		}
		return result;
	}
}