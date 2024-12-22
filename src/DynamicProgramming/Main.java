package DynamicProgramming;

import java.util.Arrays;

class MinimumCostForTickets{
    public int getNextIndexByDay(int index,int pass,int[] days){
        int lastValidDay = 0;
        switch (pass) {
            case 1 :
                lastValidDay = Arrays.binarySearch(days,days[index]+1);
                break;
            case 7 :
                lastValidDay = Arrays.binarySearch(days,days[index]+7);
                break;
            case 30:
                lastValidDay = Arrays.binarySearch(days,days[index]+30);
        }
        return lastValidDay < 0 ? Math.abs(lastValidDay+1) : lastValidDay + 1;

    }
    private static int[] memoization;
    public int minCostHelper(int[] days,int[] costs,int index){
        if(index >= days.length ) return 0;
        if(memoization[index] !=  0) return memoization[index];
        int OneDayPass = costs[0] + minCostHelper(days,costs,getNextIndexByDay(index,1,days));
        int SevenDayPass = costs[1] + minCostHelper(days,costs,getNextIndexByDay(index,7,days));
        int ThirtyDayPass = costs[2] + minCostHelper(days,costs,getNextIndexByDay(index,30,days));
        memoization[index] = Math.min(OneDayPass,Math.min(SevenDayPass,ThirtyDayPass));
        return memoization[index];
    }
    public int minCostTickets(int[] days, int[] costs) {
        memoization = new int[days.length];
        return minCostHelper(days, costs,0);
    }
    public static void main(String[] args){
        int[] costs = new int[]{2,7,15};
        int[] days = new int[]{1,4,6,7,8,20};
        days = new int[]{1,2,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,20,21,24,25,27,28,29,30,31,34,37,38,39,41,43,44,45,47,48,49,54,57,60,62,63,66,69,70,72,74,76,78,80,81,82,83,84,85,88,89,91,93,94,97,99};
        costs = new int[]{9,38,134};
        MinimumCostForTickets solution = new MinimumCostForTickets();
        System.out.println(solution.minCostTickets(days,costs));
    }
}