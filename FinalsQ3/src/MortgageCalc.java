
public class MortgageCalc 
{
	public double HousePay1(double income)
	{
		double hp1 = (income / 12.0) * .18;
		hp1 = Math.round(hp1 * 100.00) / 100.00;
		return hp1;
	}
	
	public double HousePay2(double income, double debt)
	{
		double hp2 = (income / 12.0) * .36;
		hp2 = hp2 - debt;
		hp2 = Math.round(hp2 * 100.00) / 100.00;
		return hp2;
	}
	
	public double Max(double hp1, double hp2)
	{
		double max = 0.0;
		if(hp1 < hp2)
		{
			max = hp1;
		}
		else
			max = hp2;
		
		return max;
		
	}
	
	public double Mortgage(double hp, double iRate, double month)
	{
		double total = 0.0;
		total = hp * ((1 - Math.pow((1 + iRate), -month)) / iRate);
		
		total = Math.round(total * 100.00) / 100.00;
		return total;
	}

}
