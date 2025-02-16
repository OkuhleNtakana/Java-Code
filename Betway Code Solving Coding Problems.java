14. Magic Potion Identifier
import java.util.*;
public class main {

	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        long power = scanner.nextLong();
	        scanner.close();

	        long root = Math.round(Math.cbrt(power)); 
	        if (root * root * root == power) {
	            System.out.println("YES");
	        } else {
	            System.out.println("NO");
	        }
	    }

}

15. Sneaky outcomes
import java.util.*;
public class main {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String input = scanner.nextLine().trim();
	        scanner.close();

	        // Remove square brackets and split by commas
	        input = input.replaceAll("[\\[\\]]", ""); 
	        String[] tokens = input.split(",\\s*");

	        int[] outcomes = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();
	        Set<Integer> seen = new HashSet<>();
	        List<Integer> duplicates = new ArrayList<>();

	        for (int num : outcomes) {
	            if (!seen.add(num)) {
	                duplicates.add(num);
	            }
	        }

	        System.out.println(duplicates);
	    }
}

16. Reformat String to Alternating Case
import java.util.*;
public class main {

	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        String input = scanner.nextLine();
	        scanner.close();

	        System.out.println(alternateCase(input));
	    }

	    public static String alternateCase(String s) {
	        StringBuilder result = new StringBuilder();
	        boolean toUpper = true;

	        for (char c : s.toCharArray()) {
	            if (Character.isLetter(c)) {
	                result.append(toUpper ? Character.toUpperCase(c) : Character.toLowerCase(c));
	                toUpper = !toUpper; 
	            } else {
	                result.append(c); 
	            }
	        }
	        return result.toString();
	    }
}

17. Organizing Books into Identical Sets
import java.util.*;
public class main {

	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        scanner.close();
        input = input.replaceAll("[\\[\\]]", "").trim();
        String[] tokens = input.split(",\\s*");
        int[] shelf = Arrays.stream(tokens).mapToInt(Integer::parseInt).toArray();

        System.out.println(canOrganizeBooks(shelf));
    }

    public static String canOrganizeBooks(int[] shelf) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int book : shelf) {
            countMap.put(book, countMap.getOrDefault(book, 0) + 1);
        }
        int[] counts = countMap.values().stream().mapToInt(i -> i).toArray();

        int gcdValue = counts[0];
        for (int i = 1; i < counts.length; i++) {
            gcdValue = gcd(gcdValue, counts[i]);
            if (gcdValue == 1) return "NO"; 
        }

        return gcdValue > 1 ? "YES" : "NO";
    }

    
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}

