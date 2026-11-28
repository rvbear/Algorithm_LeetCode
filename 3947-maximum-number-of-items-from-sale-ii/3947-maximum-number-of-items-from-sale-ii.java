class Solution {
    record Item(int price, int factor) implements Comparable<Item> {
        public int compareTo(Item other) {
            return Integer.compare(price, other.price);
        }
    }

    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int cheapest = Arrays.stream(items).mapToInt(item -> item[1]).min().getAsInt();
        int[] have = new int[n + 1], deals = new int[n + 1];

        for (int[] item : items) {
            have[item[0]]++;
        }

        Arrays.fill(deals, -1);

        for (int factor = 1; factor <= n; factor++) {
            for (int multiple = factor; multiple <= n; multiple += factor) {
                deals[factor] += have[multiple];
            }
        }

        List<Item> worth = Arrays.stream(items).filter(item -> item[1] < 2 * cheapest).map(item -> new Item(item[1], item[0])).sorted().toList();
        int copies = 0;

        for (Item item : worth) {
            int pairs = Math.min(deals[item.factor], budget / item.price);
            copies += 2 * pairs;
            budget -= pairs * item.price;
        }

        return copies + budget / cheapest;
    }
}
