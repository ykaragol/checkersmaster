# checkersmaster
Checkers Game Implementation, runs on Java Desktop Environment (Swing Application)

Implementation includes:
1. Greedy Algorithm
2. Min-Max Algorithm
3. Min-Max Algorithm with Alpha-Beta Pruning

Various evaluation methods are presented such as:
1. Men Count Evaluation: This evaluation type basically evaluates which player has most men and kings.
Score = (owner men count + owner kings count) - (opponent's men count + opponent's kings count)

2. Weightened Men Count Evaluation: Men and kings have different weights.
Score = (owner men count + (owner kings count) * weight) - (opponent's men count + (opponent's kings count) * weight)

3. Playable Weightened Men Count Evaluation: If a man of king cannot play, it is not counted.
Score = (owner playable men count + (owner playable kings count) * weight) - (opponent's playable men count + (opponent's playable kings count) * weight)

4. Ratio Weightened Men Count Evaluation: Compares not the count of men or kings, but ratio of count.
Score = (owner men count + (owner kings count) * weight) / (opponent's men count + (opponent's kings count) * weight)
