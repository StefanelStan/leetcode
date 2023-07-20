package com.ss.leetcode.LC2023.july;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class SmallestSufficientTeam {
    // https://leetcode.com/problems/smallest-sufficient-team
    /** Algorithm
        1. For highest efficiency, sort the people by skill length. You want to select the most skilled people first ["sk1","sk2","sk3"] will be selected before of ["sk4"]
        2. Create a class SkilledPerson (List<String> skills, int originalOrder), as the answer requires their original order/position in given people array. Skip the people with NO skills.
        3. Sort these people based on skills size();
        4. Map the given req_skills to a Map<String, Integer>. Each skill will be given an id (0..n)
        5. Using the Map, each SkilledPerson will be given an int[] of skills.
            EG: (Map)"ab" -> 0, "aa" -> 1, "cd" -> 2, "e" -> 3
            SkilledPerson["ab","e"] -> [1,0,0,1]
            SkilledPerson["cd",e] -> [0,0,1,1]
        6. Based on logic of #5, build an int[][] skilledPeople of all the List<SkilledPerson>.
            line[0] will contain highest skilled people will line[n-1] least skilled people
        7. Once you have the int[][] from #6, also build another int[][] presentSkills, starting from the back
            - starting from n to 0, mark each index IF the skill[x] if present in the remaining people.
            - thus, we can quickly check if skill[x] is present on the next group of remaining b people (0 <=b < n).
        8. Now you can begin the main selection algorithm: chose current person and move to next OR skip and move to next.
            - Add current person to team. If adding it covers a new skill, then select it and move to next.
            If it does not cover a new skill, do not select it and move to next
            - Do not select current person and move to next
        9. Be mindful to break (and not advance to next person)
            - If current selected team is > mostEfficientTeamSoFar
            - If the remaining people do not cover the missing skills (use presentSkills mapping that tells if a skill is present in remain people or not)
        10. Return the most efficient team.
     */
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        List<SkilledPerson> sortBySkills = getPeopleSortedBySkills(people);
        Map<String, Integer> skillMap = getReqSkillMap(req_skills);
        int[][] skilledPeople = getSkilledPeople(sortBySkills, skillMap);
        int[][] presentSkills = getPresentSkills(skilledPeople);
        SufficientTeam team = new SufficientTeam(skillMap.size(), sortBySkills);
        addMembers(0, team, skilledPeople, presentSkills, sortBySkills);
        return team.mostEfficientTeam;
    }

    private List<SkilledPerson> getPeopleSortedBySkills(List<List<String>> people) {
        List<SkilledPerson> sortBySkills = new ArrayList<>();
        int index = 0;
        for (List<String> person : people) {
            if (person.size() > 0) {
                sortBySkills.add(new SkilledPerson(person, index));
            }
            index++;
        }
        sortBySkills.sort((a,b) -> Integer.compare(b.skills.size(), a.skills.size()));
        return sortBySkills;
    }

    private int[][] getPresentSkills(int[][] skilledPeople) {
        int[][] presentSkills = new int[skilledPeople.length][skilledPeople[0].length];
        int[] prev = new int[presentSkills[0].length];
        for (int i = presentSkills.length - 1; i >= 0; i--) {
            for (int j = 0; j < presentSkills[i].length; j++) {
                presentSkills[i][j] = prev[j] + skilledPeople[i][j];
            }
            prev = presentSkills[i];
        }
        return presentSkills;
    }

    private void addMembers(int personIndex, SufficientTeam team, int[][] skilledPeople, int[][] presentSkills, List<SkilledPerson> sortBySkills) {
        if (!team.isFullTeam() && personIndex < skilledPeople.length &&  team.teamSize() < team.mostEfficientTeam.length &&  hasExistingSkills(team, personIndex, presentSkills)) {
            boolean memberAdded = team.addMember(sortBySkills.get(personIndex).originalOrder, skilledPeople[personIndex]);
            if (team.isFullTeam()) {
                if (team.teamSize() < team.mostEfficientTeamSize()) {
                    team.setMostEfficientTeam();
                }
                team.removeMember(skilledPeople[personIndex]);
                return;
            }
            if (memberAdded) {
                addMembers(personIndex + 1, team, skilledPeople, presentSkills, sortBySkills);
            }
            team.removeMember(skilledPeople[personIndex]);
            addMembers(personIndex + 1, team, skilledPeople, presentSkills, sortBySkills);
        }
    }

    private boolean hasExistingSkills(SufficientTeam team, int index, int[][] presentSkills) {
        for (int i = 0; i < team.skills.length; i++) {
            if (team.skills[i] == 0 && presentSkills[index][i] == 0) {
                return false;
            }
        }
        return true;
    }

    private int[][] getSkilledPeople(List<SkilledPerson> people, Map<String, Integer> skillMap) {
        int[][] skilledPeople = new int[people.size()][skillMap.size()];
        for (int i = 0; i < people.size(); i++) {
            for (String skill : people.get(i).skills) {
                skilledPeople[i][skillMap.get(skill)] = 1;
            }
        }
        return skilledPeople;
    }

    private Map<String, Integer> getReqSkillMap(String[] req_skills) {
        Map<String, Integer> skillMap = new HashMap<>();
        for(String skill : req_skills) {
            skillMap.putIfAbsent(skill, skillMap.size());
        }
        return skillMap;
    }

    private static class SkilledPerson {
        public List<String> skills;
        int originalOrder;

        public SkilledPerson(List<String> skills, int originalOrder) {
            this.skills = skills;
            this.originalOrder = originalOrder;
        }
    }

    private static class SufficientTeam {
        private final int[] skills;
        private final LinkedList<Integer> team;
        private int coveredSkills;
        private int[] mostEfficientTeam;

        public SufficientTeam(int numberOfSkills, List<SkilledPerson> sortBySkills) {
            skills = new int[numberOfSkills];
            mostEfficientTeam = new int[sortBySkills.size()];
            for (int i = 0; i < mostEfficientTeam.length; i++) {
                mostEfficientTeam[i] = sortBySkills.get(i).originalOrder;
            }
            team = new LinkedList<>();
        }

        public boolean isFullTeam() {
            return skills.length == coveredSkills;
        }

        public int teamSize() {
            return team.size();
        }

        public boolean addMember(int index, int[] person) {
            boolean newSkillAdded = false;
            team.addLast(index);
            for (int i = 0; i < person.length; i++) {
                if(person[i] == 1 && ++skills[i] == 1) {
                    newSkillAdded = true;
                    coveredSkills++;
                }
            }
            return newSkillAdded;
        }

        public void removeMember(int[] person) {
            for (int i = 0; i < person.length; i++) {
                if (person[i] == 1 && --skills[i] == 0) {
                    coveredSkills--;
                }
            }
            team.removeLast();
        }

        private int mostEfficientTeamSize() {
            return mostEfficientTeam.length;
        }

        public void setMostEfficientTeam() {
            mostEfficientTeam = new int[team.size()];
            int index = 0;
            for (int member : team) {
                mostEfficientTeam[index++] = member;
            }
        }
    }
}
