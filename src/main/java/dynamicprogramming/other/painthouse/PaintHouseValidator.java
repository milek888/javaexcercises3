package dynamicprogramming.other.painthouse;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Stream;

public interface PaintHouseValidator extends Function<int[][], ValidaionResult> {

    static PaintHouseValidator isCostNotNull() {
        return costs -> costs == null ? ValidaionResult.SUCCESS : ValidaionResult.NULL_COSTS;
    }

    static PaintHouseValidator isCostNotEmpty() {
        return costs -> costs.length != 0 ? ValidaionResult.SUCCESS : ValidaionResult.EMPTY_COSTS;
    }

    static PaintHouseValidator hasCostsAllRowsNotEmpty() {
        return costs -> {
            if(costs.length == 0) return ValidaionResult.EMPTY_COSTS_ROW;
            boolean hasEmptyrow = Stream.of(costs).anyMatch((int[] row) -> row.length == 0);
            return hasEmptyrow ? ValidaionResult.EMPTY_COSTS_ROW : ValidaionResult.SUCCESS;
        };
    }

    static PaintHouseValidator noNegativeCosts() {
        return costs -> {
            boolean hasNegativeCost = Stream.of(costs)
                    .flatMapToInt(Arrays::stream)
                    .anyMatch(x -> x <0);
            return hasNegativeCost ? ValidaionResult.NEGATIVE_COSTS : ValidaionResult.SUCCESS;
        };
    }

    default PaintHouseValidator and(PaintHouseValidator other) {
        return costs -> {
            ValidaionResult result = this.apply(costs);
            return result == ValidaionResult.SUCCESS ? result : other.apply(costs);
        };
    }
}
