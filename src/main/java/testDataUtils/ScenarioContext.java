package testDataUtils;

import java.util.HashMap;
import java.util.Map;

public class ScenarioContext {
    private Map<DataKey, Object> testData = new HashMap<>();

    public void saveTestData(DataKey dataKey, Object value) {
        testData.put(dataKey, value);
    }

    public Object getTestData(DataKey dataKey) {
        return testData.get(dataKey);
    }
}
