package com.ss.leetcode.LC2024.november;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class PeopleWhoseListOfFavoriteCompaniesIsNotASubsetOfAnotherList {
    // https://leetcode.com/problems/people-whose-list-of-favorite-companies-is-not-a-subset-of-another-list
    /** Algorithm
        1. Create a mapping of companyName - index of people: which company is liked by which people: eg: FB -> [0,2,6] AM -> [0,1,2] etc
        2. For each fav company of each person, try to mark/count which others like that company.
        3. EG:  person[i] = "AM, FB".
            - use the mapping for each company, fetch the list of people that like it and mark them on an int[maxPeople].
            - If another person than current one likes ALL these companies as well, their count[] will = person[i].size().
            - this means the current person is a sublist of another person and should not be added.
     */
    public List<Integer> peopleIndexes(List<List<String>> favoriteCompanies) {
        Map<String, List<Integer>> companyIndex = getCompanyIndex(favoriteCompanies);
        List<Integer> answer = new ArrayList<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            if (favoriteCompanies.get(i).size() != findMatchingCompanyIndex(i, favoriteCompanies.get(i), companyIndex, favoriteCompanies.size())) {
                answer.add(i);
            }
        }
        return answer;
    }

    private Map<String, List<Integer>> getCompanyIndex(List<List<String>> favoriteCompanies) {
        Map<String, List<Integer>> companyIndex = new HashMap<>();
        for (int i = 0; i < favoriteCompanies.size(); i++) {
            for (String company : favoriteCompanies.get(i)) {
                companyIndex.computeIfAbsent(company, l -> new ArrayList<>()).add(i);
            }
        }
        return companyIndex;
    }

    private int findMatchingCompanyIndex(int person, List<String> companies, Map<String, List<Integer>> companyIndex, int maxPeople) {
        int[] peopleCount = new int[maxPeople];
        int maxMatch = 0;
        for (String company : companies) {
            for (int favPersonCompany : companyIndex.get(company)) {
                if (favPersonCompany != person) {
                    peopleCount[favPersonCompany]++;
                    maxMatch = Math.max(maxMatch, peopleCount[favPersonCompany]);
                }
            }
        }
        return maxMatch;
    }
}
