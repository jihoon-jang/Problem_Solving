using System;
using System.Collections.Generic;
using System.Text;

namespace ConsoleApp4
{
    class p12791
    {
        static void Main()
        {
            String[,] array =
            {
                {"1967", "DavidBowie"},
                {"1969", "SpaceOddity"},
                {"1970", "TheManWhoSoldTheWorld"},
                {"1971", "HunkyDory"},
                {"1972", "TheRiseAndFallOfZiggyStardustAndTheSpidersFromMars"},
                {"1973", "AladdinSane"},
                {"1973", "PinUps"},
                {"1974", "DiamondDogs"},
                {"1975", "YoungAmericans"},
                {"1976", "StationToStation"},
                {"1977", "Low"},
                {"1977", "Heroes"},
                {"1979", "Lodger"},
                {"1980", "ScaryMonstersAndSuperCreeps"},
                {"1983", "LetsDance"},
                {"1984", "Tonight"},
                {"1987", "NeverLetMeDown"},
                {"1993", "BlackTieWhiteNoise"},
                {"1995", "1.Outside"},
                {"1997", "Earthling"},
                {"1999", "Hours"},
                {"2002", "Heathen"},
                {"2003", "Reality"},
                {"2013", "TheNextDay"},
                {"2016", "BlackStar"}
            };

            int n = int.Parse(Console.ReadLine());

            for (int i = 0; i < n; i++)
            {
                int count = 0;
                String[] s = (Console.ReadLine().Split(' '));
                int start = int.Parse(s[0]);
                int end = int.Parse(s[1]);
                StringBuilder sb = new StringBuilder();

                for (int j = 0; j <= 24; j++)
                {
                    if (int.Parse(array[j, 0]) >= start && int.Parse(array[j, 0]) <= end) {
                        sb.Append($"{array[j, 0]} {array[j, 1]}\n");
                        count++;
                    }
                }


                Console.Write($"{count} \n");
                if(count != 0)
                Console.Write(sb.ToString());
            }
            


        }
    }
}
