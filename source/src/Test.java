import java.util.*;

public class Test {

    public static void main(String[] args) {
        Test test = new Test();
        String[] bank = new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"};
        int result = test.minMutation("AACCTTGG", "AATTCCGG", bank);
        System.out.println(result);
    }


    public int minMutation(String start, String end, String[] bank) {
        if (bank == null || bank.length == 0) return -1;
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) return -1;
        set.remove(start);
        Set<String> visitedSet = new HashSet<>();
        visitedSet.add(start);
        Queue<String> q = new LinkedList<>();
        q.add(start);
        int step = 0;
        char[] base = new char[]{'A', 'C', 'G', 'T'};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                String current = q.poll();
                char[] array = current.toCharArray();
                for (int k = 0; k < array.length; ++k) {
                    char org = array[k];
                    for (char c : base) {
                        if (array[k] == c) continue;
                        array[k] = c;
                        String newStr = String.valueOf(array);
                        if (newStr.equals(end)) return step + 1;
                        if (visitedSet.contains(newStr)) continue;
                        if (set.contains(newStr)) {
                            q.add(newStr);
                            visitedSet.add(newStr);
                        }
                    }
                    array[k] = org;
                }

            }
            ++step;
        }
        return -1;
    }


}
