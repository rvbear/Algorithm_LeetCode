class Solution {
    private int calFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < landStartTime.length; i++) {
            min = Math.min(min, landStartTime[i] + landDuration[i]);
        }

        int answer = Integer.MAX_VALUE;

        for (int i = 0; i < waterStartTime.length; i++) {
            answer = Math.min(answer, Math.max(min, waterStartTime[i]) + waterDuration[i]);
        }

        return answer;
    }

    public int earliestFinishTime(int[] landStartTime, int[] landDuration, int[] waterStartTime, int[] waterDuration) {
        return Math.min(calFinishTime(landStartTime, landDuration, waterStartTime, waterDuration), calFinishTime(waterStartTime, waterDuration, landStartTime, landDuration));
    }
}
