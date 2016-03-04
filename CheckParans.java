import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class CheckParans {

	static HashMap<Character,Character> parens = new HashMap();
	static HashSet<Character> paranSet = new HashSet();
	
	static{
		parens.put('}', '{');
		parens.put(']', '[');
		parens.put(')', '(');
		paranSet = new HashSet(parens.values());
	}
	
	public static void main(String args[])throws Exception{
		
		String input = "[ABC]{PQR(XYZ)}";
		if(countParens(input)){
			System.out.println("True");
		}
		
	}
	
	public static boolean countParens(String input){
		Stack parenStack = new Stack();
				
		
		try{
			for(int i = 0; i<input.length(); i++){
		
				Character curr = input.charAt(i);
				if(paranSet.contains(curr)){
					parenStack.push(curr);
				}
				
				if(parens.containsKey(curr)){
					Object top = parenStack.pop();
					if(parens.get(curr) != top){
						return false;
					}
				}
			}
			if(parenStack.isEmpty()){
				return true;
			}
			else{
				return false;
			}
		}
		catch(Exception e){
			return false;
		}
	}
}
