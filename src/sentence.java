public class sentence
{
    private String line;
    private String[] cash;

    public sentence()
    {
        line = "Сегодня хороший день, будет солнечно и ясно, неплохо бы прогуляться";
    }

    public sentence(String any)
    {
        line = any;
    }

    public void split()
    {
        cash = line.split(", | ", 0);
    }
    public void PrintWord()
    {
        System.out.println("Наше предложение выглядит так: " + line);
        System.out.println("В нём присутствуют такие слова как:");
        for (int i = 0; i < cash.length; i++)
        {
            if (cash[i] != "") System.out.println(i+1 + ")" + cash[i]);
        }
    }

    public void CountPolidroms()
    {
        String polidroms = "";
        for (int i = 0; i < cash.length; i++)
        {
            boolean mayPolidroms = true;
            boolean isPolidrom = true;
            if (cash[i] != " ")
            {
                if (polidroms != "")
                {
                    String[] cashpolidroms = polidroms.split(" ");

                    for (int j = 0; j < cashpolidroms.length; j++)
                    {
                        if (cash[i].equals(cashpolidroms[j])) mayPolidroms = false;
                    }
                }

                if (mayPolidroms)
                {
                    char [] cashletter = cash[i].toCharArray();
                    for (int j = 0; j < cashletter.length / 2; j++)
                    {
                        if (cashletter[j] != cashletter[(cashletter.length) - j - 1]) isPolidrom = false;
                    }
                }

                if (isPolidrom & mayPolidroms)
                {
                    polidroms += cash[i] + " ";
                }
            }
        }
        if (polidroms != null) System.out.println("Полидромы: " + polidroms);
        else System.out.println("Полидромов нет");
    }
}
