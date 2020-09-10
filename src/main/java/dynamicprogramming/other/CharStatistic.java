package dynamicprogramming.other;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
public class CharStatistic {

    public CharStatistic(char character) {
        this.character = character;
    }

    private char character;
    private int minIndex;
    private int lastIndex;
}
