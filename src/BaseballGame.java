import com.sun.tools.javac.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * You're now a baseball game point recorder.
 * Given a list of strings, each string can be one of the 4 following types:
 * <p>
 * Integer (one round's score): Directly represents the number of points you get in this round.
 * <br>"+" (one round's score): Represents that the points you get in this round are the sum of the last two valid round's points.
 * <br>"D" (one round's score): Represents that the points you get in this round are the doubled data of the last valid round's points.
 * <br>"C" (an operation, which isn't a round's score): Represents the last valid round's points you get were invalid and should be removed.
 * <br>Each round's operation is permanent and could have an impact on the round before and the round after.
 * </p>
 * You need to return the sum of the points you could get in all the rounds.
 *
 * Example 1:
 * <br>Input: ["5","2","C","D","+"]
 * <br>Output: 30
 * <br>Explanation:
 * <br>Round 1: You could get 5 points. The sum is: 5.
 * <br>Round 2: You could get 2 points. The sum is: 7.
 * <br>Operation 1: The round 2's data was invalid. The sum is: 5.
 * <br>Round 3: You could get 10 points (the round 2's data has been removed). The sum is: 15.
 * <br>Round 4: You could get 5 + 10 = 15 points. The sum is: 30.
 */
public class BaseballGame {
    public int calPoints(String[] ops) {
        return solution1(ops);
    }

    private int solution1(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for (String score : ops) {
            if ("+".equals(score)) {
                scores.add(scores.get(scores.size() - 1) + scores.get(scores.size() - 2));
            } else if ("D".equals(score)) {
                scores.add(scores.get(scores.size() - 1) * 2);
            } else if ("C".equals(score)) {
                scores.remove(scores.size() - 1);
            } else {
                scores.add(Integer.parseInt(score));
            }
        }
        int result = 0;
        for (int i : scores) {
            result += i;
        }
        return result;
    }

    private int solution2(String[] ops) {
        int result = 0;
        LinkedList<Integer> scores = new LinkedList<>();
        for (String score : ops) {
            if ("+".equals(score)) {
                scores.add(scores.peekLast() + scores.get(scores.size() - 2));
                result += scores.peekLast();
            } else if ("D".equals(score)) {
                scores.add(scores.peekLast() * 2);
                result += scores.peekLast();
            } else if ("C".equals(score)) {
                result -= scores.removeLast();
            } else {
                scores.addLast(Integer.parseInt(score));
                result += scores.peekLast();
            }
        }
        return result;
    }

}
