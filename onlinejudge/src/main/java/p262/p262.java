package p262;
// @JUDGE_ID:  1000AA  262  Java  "Transferable Voting"

import java.io.*;
import java.util.*;

class Main {
    static boolean readFromFile = true;
    static String filePath = "src/main/resources/p262_3.txt";

    static String ReadLn(int maxLg, InputStream inputStream) {
        byte lin[] = new byte[maxLg];
        int lg = 0, car = -1;

        try {
            while (lg < maxLg) {
                car = inputStream.read();
                if ((car < 0) || (car == '\n'))
                    break;
                lin[lg++] += car;
            }
        } catch (IOException e) {
            return (null);
        }

        if ((car < 0) && (lg == 0))
            return (null); // eof
        return (new String(lin, 0, lg));
    }

    public static void main(String args[]) // entry point from OS
    {
        Main myWork = new Main(); // create a dinamic instance
        myWork.Begin(); // the true entry point
    }

    void Begin() {
        String input;
        StringTokenizer idata;

        InputStream inputStream = System.in;
        FileInputStream fileInputStream;

        if (readFromFile) {
            try {
                fileInputStream = new FileInputStream(filePath);
                inputStream = fileInputStream;
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        input = Main.ReadLn(255, inputStream);
        idata = new StringTokenizer(input);
        Integer cases = Integer.parseInt(idata.nextToken());
        Main.ReadLn(255, inputStream);
        for (int caseNumber = 0; caseNumber < cases; caseNumber++) {
            try {
                if (caseNumber > 0) {
                    System.out.println("");
                }
                ArrayList<Ballot> ballots = new ArrayList<>();
                ArrayList<Candidate> orderedCandidates = new ArrayList<>();
                ArrayList<Candidate> candidates = new ArrayList<>();
                HashMap<Integer, Candidate> candidatesById = new HashMap<>();
                Integer spoiledBallots = 0;
                Integer candidateId = 0;
                for (;;) {
                    candidateId++;
                    input = Main.ReadLn(255, inputStream);
                    idata = new StringTokenizer(input);
                    if (!idata.hasMoreElements()) {
                        break;
                    }
                    String[] split = input.split("\\.");
                    String candidateName = split[1].trim();
                    //Integer id = Integer.parseInt(split[0]);
                    Candidate candidate = new Candidate(candidateId, candidateName);
                    candidates.add(candidate);
                    orderedCandidates.add(candidate);
                    candidatesById.put(candidateId, candidate);
                }
                for (;;) {
                    boolean ballotSpoiled = false;
                    input = Main.ReadLn(255, inputStream);
                    if (input == null) {
                        break;
                    }
                    idata = new StringTokenizer(input);
                    if (!idata.hasMoreElements()) {
                        break;
                    }
                    ArrayList<Integer> votes = new ArrayList<>();
                    HashMap<Integer, Integer> currentVotes = new HashMap<>();
                    while (idata.hasMoreTokens()) {
                        candidateId = Integer.parseInt(idata.nextToken());
                        if (candidatesById.containsKey(candidateId)) {
                            if (currentVotes.containsKey(candidateId)) {
                                spoiledBallots++;
                                ballotSpoiled = true;
                                break;
                            } else {
                                currentVotes.put(candidateId, candidateId);
                            }
                            votes.add(candidateId);
                        } else {
                            spoiledBallots++;
                            ballotSpoiled = true;
                            break;
                        }
                    }
                    if (ballotSpoiled) {
                        continue;
                    }
                    if (!votes.isEmpty()) {
                        Ballot ballot = new Ballot(votes);
                        ballots.add(ballot);
                    }
                }

                //double expectedNumber = ((double) ballots.size()) / 2;
                boolean definedElection = false;
                HashMap<Integer, Integer> eliminatedCandidates = new HashMap<>();
                while (!definedElection) {
                    double validSize = 0;
                    for (Ballot ballot2 : ballots) {
                        validSize++;
//                        if(ballot2.containsNonEliminatedCandidate(eliminatedCandidates)) {
//                            validSize++;
//                        }
                    }

                    double expectedNumber = validSize / 2;
                    
                    for (Candidate candidate : candidates) {
                        candidate.initVotes();
                    }
                    for (Ballot ballot : ballots) {
                        Integer vote = ballot.getVote(eliminatedCandidates);
                        if (vote != null) {
                            candidatesById.get(vote).incrementVotes();
                        }
                    }
                    Collections.sort(candidates, new Comparator<Candidate>() {
                        @Override
                        public int compare(Candidate c1, Candidate c2) {
                            return c2.getVotes().compareTo(c1.getVotes());
                        }
                    });
                    if (candidates.get(0).getVotes().doubleValue() > expectedNumber) {
                        System.out.println("The winner of the election is " + candidates.get(0).name + ".");
                        definedElection = true;
                    } else {
                        Candidate eliminatedCandidate = candidates.get(candidates.size() - 1);
                        int eliminationPoint = candidates.size() - 1;
                        HashMap<Integer, Candidate> eliminatedInRound = new HashMap<>();
                        while(eliminationPoint >=0 && candidates.get(eliminationPoint).votes == eliminatedCandidate.votes) {
                            eliminatedCandidate = candidates.get(eliminationPoint);
                            //System.out.println(eliminatedCandidate.name + " with " + eliminatedCandidate.votes + " votes is eliminated.");
                            eliminatedCandidates.put(eliminatedCandidate.id, eliminatedCandidate.id);
                            eliminatedInRound.put(eliminatedCandidate.id, eliminatedCandidate);
                            eliminationPoint--;
                        }

                        for (Candidate orderedCandidate : orderedCandidates) {
                            if(eliminatedInRound.containsKey(orderedCandidate.id)) {
                                System.out.println(orderedCandidate.name + " with " + orderedCandidate.votes + " votes is eliminated.");
                            }
                        }

                        eliminationPoint++;
                        if (eliminationPoint > 0) {
                            List<Candidate> subList = candidates.subList(0, eliminationPoint);
                            candidates = new ArrayList<>();
                            candidates.addAll(subList);
                        } else {
                            System.out.println("The election was indecisive.");
                            definedElection = true;
                        }
                    }
                }
                System.out.println(
                        "There were " + ballots.size() + " valid ballots and " + spoiledBallots + " spoiled ballots.");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public class Ballot {
        private ArrayList<Integer> votes;

        public Ballot(ArrayList<Integer> votes) {
            this.votes = votes;
        }

        public boolean containsNonEliminatedCandidate(HashMap<Integer, Integer> eliminatedCandidates) {
            for (Integer candidateId : votes) {
                if(!eliminatedCandidates.containsKey(candidateId)) {
                    return true;
                }
            }
            return false;
        }

        Integer getVote(HashMap<Integer, Integer> eliminatedCandidates) {
            for (Integer vote : votes) {
                if (!eliminatedCandidates.containsKey(vote)) {
                    return vote;
                }
            }
            return null;
        }

        @Override
        public String toString() {
            return "[votes=" + votes + "]";
        }
    }

    public class Candidate {
        private Integer id;
        private String name;
        private Integer votes;

        public Candidate(Integer id, String name) {
            this.id = id;
            this.name = name;
            votes = 0;
        }

        public void initVotes() {
            votes = 0;
        }

        public void incrementVotes() {
            votes++;
        }

        public Integer getVotes() {
            return votes;
        }

        public String getName() {
            return name;
        }

        public Integer getId() {
            return id;
        }

        @Override
        public String toString() {
            return "[id=" + id + ", name=" + name + ", votes=" + votes + "]";
        }
    }
}