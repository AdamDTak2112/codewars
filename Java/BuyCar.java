public class BuyCar {

	public static int[] nbMonths(int startPriceOld, int startPriceNew, int savingperMonth, double percentLossByMonth) {
    // your code
        int totalSavings = 0;
        int monthCount = 0;
        double priceOld = (double) startPriceOld;
        double priceNew = (double) startPriceNew;
        while ((totalSavings + priceOld) < priceNew){
            monthCount++;
            totalSavings += savingperMonth;
            if (monthCount % 2 == 0){
                percentLossByMonth += 0.5;
            }
            priceOld -= (priceOld * (percentLossByMonth / 100));
            priceNew -= (priceNew * (percentLossByMonth / 100));

        }
        return new int[] {monthCount, (int) Math.round(totalSavings + priceOld - priceNew) };
    }

    public static void main(String[] args){
        int oldPrice = 2000;
        int newPrice = 8000;
        int savingsPerMonth = 1000;
        double percentLossByMonth = 1.5;
        int [] answer = nbMonths(oldPrice, newPrice, savingsPerMonth, percentLossByMonth);
        for(int i = 0; i < answer.length; i++){
            System.out.println(answer[i]);
        }
    }

}