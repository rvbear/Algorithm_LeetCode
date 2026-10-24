class Solution {
    private static final int[] before = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static {
        Arrays.parallelPrefix(before, Integer::sum);
    }

    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        String arrive = arriveAlice.compareTo(arriveBob) > 0 ? arriveAlice : arriveBob;
        String leave = leaveAlice.compareTo(leaveBob) < 0 ? leaveAlice : leaveBob;

        return Math.max(0, day(leave) - day(arrive) + 1);
    }

    private static int day(String mmdd) {
        return before[Integer.parseInt(mmdd.substring(0, 2)) - 1] + Integer.parseInt(mmdd.substring(3));
    }
}
