# checkersmaster
Checkers Game Implementation, runs on Java Desktop Environment (Swing Application)

Implementation includes:
1. Greedy Algorithm
2. Min-Max Algorithm
3. Min-Max Algorithm with Alpha-Beta Pruning

Various evaluation methods are presented such as:
1. Men Count Evaluation: This evaluation type basically evaluates which player has most men and kings.
Score = (#owner men + #owner kings) - (#opponent's men + #opponent's kings)

2. Weightened Men Count Evaluation: Men and kings have different weights.
Score = (#owner men + (#owner kings) * weight) - (#opponent's men + (#opponent's kings) * weight)

3. Playable Weightened Men Count Evaluation: If a man of king cannot play, it is not counted.
Score = (#owner playable men + (#owner playable kings) * weight) - (#opponent's playable men  + (#opponent's playable kings) * weight)

4. Ratio Weightened Men Count Evaluation: Compares not the count of men or kings, but ratio of count.
Score = (#owner men + (#owner kings) * weight) / (#opponent's men + (#opponent's kings) * weight)
