package com.ss.leetcode.LC2022.october;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TimeBasedKeyValueStore {
    // https://leetcode.com/problems/time-based-key-value-store/
    private final Map<String, List<TimeValue>> timeMap;
    public TimeBasedKeyValueStore() {
        timeMap = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        timeMap.computeIfAbsent(key, k -> new ArrayList<>()).add(new TimeValue(value, timestamp));
    }

    public String get(String key, int timestamp) {
        List<TimeValue> values = timeMap.get(key);
        if (values == null) {
            return "";
        } else {
            return findKeyByTimestamp(values, timestamp);
        }
    }

    private String findKeyByTimestamp(List<TimeValue> values, int timestamp) {
        int low = 0, high = values.size() - 1, pivot;
        TimeValue temp;
        if (values.get(low).timestamp > timestamp) {
            return "";
        }
        while (low < high) {
            pivot = low + (high - low) / 2;
            temp = values.get(pivot);
            if (temp.timestamp == timestamp) {
                return temp.value;
            } else if (high - low == 1) {
                if (values.get(low).timestamp == timestamp) {
                    return values.get(low).value;
                } else if(values.get(high).timestamp == timestamp) {
                    return  values.get(high).value;
                } else return timestamp > values.get(high).timestamp ? values.get(high).value : values.get(low).value;
            } else if (timestamp > pivot) {
                low = pivot;
            } else {
                high = pivot;
            }
        }
        return values.get(low).value;
    }

    private static class TimeValue {
        int timestamp;
        String value;

        public TimeValue( String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
