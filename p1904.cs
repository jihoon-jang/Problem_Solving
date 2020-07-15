using System;

namespace ConsoleApp1
{
    class p1904
    {
		static void Main(String[] args)
		{
			int n = int.Parse(Console.ReadLine());
			int[] dp = new int[1000001];
			dp[1] = 1;
			dp[2] = 2;

			for (int i = 3; i <= n; i++)
				dp[i] = (dp[i - 1] + dp[i - 2]) %15746;

			Console.WriteLine(dp[n]);
	            
		}
	}
}
