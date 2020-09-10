import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StringValidator {
    private static final Logger logger = LogManager.getLogger(StringValidator.class);

    public boolean validateString(String input) {
        Map<String, Integer> lettersFrequency = calculateLettersFrequency(input);
        Map<Integer, Integer> frequencyDistribution = calculateDistribution(lettersFrequency);
        boolean validation = calculateValidation(frequencyDistribution);
        return validation;
    }

    private Map<String, Integer> calculateLettersFrequency(String input) {
        Map<String, Integer> lettersFrequency = new HashMap<>();
        Arrays.asList(input.split(""))
                .forEach(letter -> lettersFrequency.merge(letter, 1, (oldVal, val) -> oldVal + 1));

        logger.debug(lettersFrequency.toString());
        return lettersFrequency;
    }

    private Map<Integer, Integer> calculateDistribution(Map<String, Integer> lettersFrequency) {
        Map<Integer, Integer> frequencyDistribution = new HashMap<>();
        lettersFrequency.forEach((k, v) -> frequencyDistribution.merge(v, 1, (oldVal, val) -> oldVal + 1));

        logger.debug(frequencyDistribution.toString());
        return frequencyDistribution;
    }

    private boolean calculateValidation(Map<Integer, Integer> frequencyDistribution) {
        boolean result = true;
        if (frequencyDistribution.size() == 1) {
            result = true;
        }
        if (frequencyDistribution.size() > 2) {
            result = false;
        }
        if (frequencyDistribution.size() == 2) {
            List<Integer> values = frequencyDistribution.entrySet().stream()
                    .map(Map.Entry::getValue)
                    .collect(Collectors.toList());
            int valuesDiff = Math.abs(values.get(0) - values.get(1));
            List<Integer> keys = frequencyDistribution.entrySet().stream()
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());
            int keysDiff = Math.abs(keys.get(0) - keys.get(1));

          /*  Optional<Integer> valueJeden = values.stream().filter(v -> v == 1).findFirst();

            result =  (frequencyDistribution.getOrDefault(1, 0) == 1);
                    (frequencyDistribution.containsKey(1) && (Math.abs(dupa) == 1))*/

        }
        return result;
    }

}
