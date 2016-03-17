import java.util.ArrayList;
import java.util.Arrays;

public class minHopArray {

	public static void main(String[] args) {
		ArrayList<Integer> array = new ArrayList<Integer>(Arrays.asList());
		System.out.println(findHopsHelper(array));
	}
	
	private static String findHopsHelper(ArrayList<Integer> array) {
		
		boolean isLastZero = false;
        if(array.size() == 0 || array == null)
            return "failure";
        if(array.size() == 1)
            return "0, out";
        if(array.get(array.size() - 1) == 0 ) {
        	array.add(1); 
        	isLastZero =true;
        }
		ArrayList<String> hops = new ArrayList<String>();
		int lReach = 0, curReach = 0, selIndex = 0;
		int i;
		for (i = 0; i < array.size(); i++) {
			if (i > curReach) break;    
			if (i > lReach) {
				lReach = curReach;    
				hops.add(String.valueOf(selIndex));
			}
			int sum = i + array.get(i);    
			if (sum > curReach) selIndex = i;
			curReach = Math.max(curReach, sum);
		}
		if ((i > lReach) && (hops.size() > 0) && (Integer.parseInt(hops.get(hops.size() - 1)) != selIndex)) {
			hops.add(String.valueOf(selIndex));
		}
		String path = hops.toString();
		if(isLastZero && path.contains("" + (array.size() - 1)))
			path = path.substring(1, path.length() - 4) + ", out";
		else
			path = path.substring(1, path.length() - 1) + ", out";
		
//		if(lReach == array.size() - 1 && array.get(array.size() - 1) == 0)
//			return "failure";
		
		if (lReach >= array.size() - 1)    
			return path;
		else
			return "failure";
	}
	
}