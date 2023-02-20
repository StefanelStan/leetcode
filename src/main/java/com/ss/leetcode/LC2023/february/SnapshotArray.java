package com.ss.leetcode.LC2023.february;

import java.util.ArrayList;
import java.util.List;

public class SnapshotArray {
    // https://leetcode.com/problems/snapshot-array/
    List[] snapshots;
    int version;
    public SnapshotArray(int length) {
        snapshots = new List[100];
        version = 0;
    }

    public void set(int index, int val) {
        if (snapshots[index] == null) {
            List<Snapshot> versions = new ArrayList<Snapshot>();
            versions.add(new Snapshot(val, version));
            snapshots[index] = versions;
        } else {
            List<Snapshot> versions = snapshots[index];
            Snapshot snap = versions.get(versions.size() - 1);
            if (snap.version == version) {
                snap.value = val;
            } else {
                versions.add(new Snapshot(val, version));
            }
        }
    }

    public int snap() {
        return version++;
    }

    public int get(int index, int snap_id) {
        List<Snapshot> versions = snapshots[index];
        if (versions == null) {
            return 0;
        } else {
            return binarySearch(versions, snap_id);
        }
    }

    private int binarySearch(List<Snapshot> versions, int snap_id) {
        int low = 0, high = versions.size() - 1;
        int pivot;
        if (versions.get(low).version > snap_id) {
            return 0;
        } else if (versions.get(high).version <= snap_id) {
            return versions.get(high).value;
        }
        while (low < high) {
            pivot = low + (high - low) / 2;
            if (high - low == 1) {
                return versions.get(low).value;
            } else if (versions.get(pivot).version == snap_id) {
                return versions.get(pivot).value;
            } else if (versions.get(pivot).version < snap_id) {
                low = pivot;
            } else {
                high = pivot;
            }
        }
        return -1;
    }

    private static class Snapshot {
        int value;
        int version;

        public Snapshot(int value, int version) {
            this.value = value;
            this.version = version;
        }
    }
}
