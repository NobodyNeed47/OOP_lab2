public class Main {
    public static void main(String[] args)
    {
        Matrix mat = new Matrix(4);
        mat.ShowMatrix();
        mat.FindCountPozOrNeg();
        mat.determinator();
        mat.average();

        //sentence words = new sentence("101, 101, 24 252, 194, 101 121");
        sentence words = new sentence("аhа бааб баа вваа гаяяаг даазаак икаал ааллаа ");
        words.split();
        words.PrintWord();
        words.CountPolidroms();
    }
}