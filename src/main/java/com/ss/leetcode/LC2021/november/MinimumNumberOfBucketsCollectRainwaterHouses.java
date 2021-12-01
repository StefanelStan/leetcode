package com.ss.leetcode.LC2021.november;

public class MinimumNumberOfBucketsCollectRainwaterHouses {
    // https://leetcode.com/contest/biweekly-contest-66/problems/minimum-number-of-buckets-required-to-collect-rainwater-from-houses/
    public int minimumBuckets(String street) {
        int minBuckets =0;
        if (street.length() == 1) {
            return street.equals(".") ? 0 : -1;
        }
        char[] places = street.toCharArray();
        int startIndex = 0, endIndex = places.length - 1;


        if(places[0] == 'H' && places[1] == '.') {
            places[1] = 'B';
            minBuckets++;
            startIndex += 2;
        }

        if (places.length > 4) {
            if (places[places.length -2] == 'H' && places[places.length-4] == 'H' && places[places.length -3] == '.') {
                places[places.length-3] = 'B';
                minBuckets++;
            }
        }

        if (places.length > 4) {
            if (places[places.length -2] == 'H' && places[places.length-4] == '.' && places[places.length -3] == '.') {
                places[places.length-3] = 'B';
                minBuckets++;
            }
        }

//        if (places[places.length -2] == 'H' && places[places.length -1] == '.') {
//            places[places.length -1] = 'B';
//            endIndex = Math.max(0, endIndex -2);
//            minBuckets++;
//        }
        if (places[places.length -2] == '.' && places[places.length -1] == 'H') {
            places[places.length -2] = 'B';
            minBuckets++;
            endIndex = Math.max(0, endIndex -2);
        }

        for (int i = startIndex; i <= endIndex; i++) {
            if (places[i] == 'H' && hasConsecutiveHouses(places, i)) {
                return -1;
            }

            if (places[i] == 'H' && placeABucket(i, places)) {
                minBuckets++;
            }
        }

        return minBuckets;
    }

    private boolean hasConsecutiveHouses(char[] places, int i) {
        if (i == places.length -1) {
            return false;
        }
        if (i == 1 && places[0] == 'H') {
            return true;
        }
        if (i == places.length - 2) {
            return places[places.length -1] == 'H';
        } else {
            return places[i+1] == 'H' && places[i+2] == 'H';
        }
    }


    private boolean placeABucket(int i, char[] places) {
        if (i == 0 && places[i+1] == '.') {
            places[i+1] = 'B';
            return true;
        }

        if (places[Math.max(0, i-1)] == 'B' || places[Math.min(places.length -1, i +1)] == 'B') {
            return false;
        }

        if (i > 0 && i < places.length -1) {
            if (places[i-1] == '.' && places[i+1] == 'H') {
                places[i-1] = 'B';
                return true;
            }
            if (places[i-1] == 'H' && places[i+1] == '.') {
                places[i+1] = 'B';
                return true;
            }

            if(places[i-1] == '.' && places[i+1] == '.') {
                places[i+1] = 'B';
                return true;
            }
        }


        if (i <= places.length -3 && places[i+1] == '.' && (places[i+2] == 'H' || places[i+2] == '.')) {
            places[i+1] = 'B';
            return true;
        }

        if (i == places.length -1 && places[i-1] == '.') {
            places[i-1] = 'B';
            return true;
        }

        return false;
    }
}
