import java.util.*;

public class Main {
    public static void main(String[] args) {
        String input = new Scanner(System.in).nextLine();
        Deque<Character> deque = new ArrayDeque<>();
        Deque<Integer> openIndexDeque = new ArrayDeque<>();
        Map<Integer, Character> map = new HashMap<>();
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char c = chars[i];
            if (c == '(') {
                deque.push(c);
                openIndexDeque.push(i);
            } else if (c == ')' && !deque.isEmpty()) {
                map.put(openIndexDeque.pop(), deque.pop());
                map.put(i, c);
            }
        }
        System.out.print(map.size() + " - ");
        map.entrySet()
                .stream()
                .sorted(Comparator.comparingInt(Map.Entry::getKey))
                .map(Map.Entry::getValue)
                .forEach(System.out::print);
    }
}