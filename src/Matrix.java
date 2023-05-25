import java.util.Random;

public class Matrix {
    private int row;
    private int column;
    private int[][] qmatrix;

    public Matrix() {
        this.row = 4;
        this.column = 4;
        this.qmatrix = new int[this.row][this.column];
        this.Randomizer();
    }

    public Matrix(int size) {
        this.row = size;
        this.column = size;
        this.qmatrix = new int[this.row][this.column];
        this.Randomizer();
    }



    public void Randomizer() {
        Random number = new Random();

        for(int i = 0; i < this.row; ++i) {
            for(int j = 0; j < this.column; ++j) {
                this.qmatrix[i][j] = number.nextInt(50) - 25;
            }
        }

    }
    public void FindCountPozOrNeg() {
        String answer = new String();
        int plus = 0;
        int minus = 0;

        for(int i = 0; i < this.row; ++i) {
            boolean signplus = true;
            boolean signminus = true;

            for(int j = 0; j < this.column; ++j) {
                if (this.qmatrix[i][j] >= 0) {
                    signminus = false;
                }

                if (this.qmatrix[i][j] <= 0) {
                    signplus = false;
                }
            }

            if (signplus) {
                ++plus;
                signplus = true;
            }

            if (signminus) {
                ++minus;
                signminus = true;
            }
        }

        if (plus > 0 & minus > 0) {
            answer = answer + "Количество положительных строк в матрице = " + plus + ", а отрицательных строк = " + minus;
        } else if (plus > 0 | minus > 0) {
            if (plus > 0) {
                answer = answer + "Количество положительных строк в матрице = " + plus;
            }

            if (minus > 0) {
                answer = answer + "Количество отрицательных строк в матрице = " + minus;
            }
        } else {
            answer = answer + "В матрице не существует только положительных или отрицательных строк";
        }

        System.out.println(answer);
    }

    public void determinator() {
        float deter = 0.0F;
        switch (this.row) {
            case 2:
                deter = (float)(this.qmatrix[0][0] * this.qmatrix[1][1] - this.qmatrix[0][1] * this.qmatrix[1][0]);
                break;
            case 3:
                deter = (float)(this.qmatrix[0][0] * this.qmatrix[1][1] * this.qmatrix[2][2] + this.qmatrix[0][1] * this.qmatrix[1][2] * this.qmatrix[2][0] + this.qmatrix[0][2] * this.qmatrix[1][0] * this.qmatrix[2][1] - this.qmatrix[0][2] * this.qmatrix[1][1] * this.qmatrix[2][0] - this.qmatrix[0][0] * this.qmatrix[1][2] * this.qmatrix[2][1] - this.qmatrix[0][1] * this.qmatrix[1][0] * this.qmatrix[2][2]);
                break;
            case 4:
                float var1 = (float)(this.qmatrix[0][0] * (this.qmatrix[1][1] * this.qmatrix[2][2] * this.qmatrix[3][3] + this.qmatrix[1][2] * this.qmatrix[2][3] * this.qmatrix[3][1] + this.qmatrix[1][3] * this.qmatrix[2][1] * this.qmatrix[3][2] - this.qmatrix[1][3] * this.qmatrix[2][2] * this.qmatrix[3][1] - this.qmatrix[2][1] * this.qmatrix[1][2] * this.qmatrix[3][3] - this.qmatrix[1][1] * this.qmatrix[2][3] * this.qmatrix[3][2]));
                float var2 = (float)(this.qmatrix[0][1] * (this.qmatrix[1][0] * this.qmatrix[2][2] * this.qmatrix[3][3] + this.qmatrix[1][2] * this.qmatrix[2][3] * this.qmatrix[3][0] + this.qmatrix[2][0] * this.qmatrix[3][2] * this.qmatrix[1][3] - this.qmatrix[1][3] * this.qmatrix[2][2] * this.qmatrix[3][0] - this.qmatrix[2][0] * this.qmatrix[1][2] * this.qmatrix[3][3] - this.qmatrix[1][0] * this.qmatrix[2][3] * this.qmatrix[3][2]));
                float var3 = (float)(this.qmatrix[0][2] * (this.qmatrix[1][0] * this.qmatrix[2][1] * this.qmatrix[3][3] + this.qmatrix[1][1] * this.qmatrix[2][3] * this.qmatrix[3][0] + this.qmatrix[1][3] * this.qmatrix[2][0] * this.qmatrix[3][1] - this.qmatrix[1][3] * this.qmatrix[2][1] * this.qmatrix[3][0] - this.qmatrix[1][1] * this.qmatrix[2][0] * this.qmatrix[3][3] - this.qmatrix[1][0] * this.qmatrix[3][1] * this.qmatrix[2][3]));
                float var4 = (float)(this.qmatrix[0][3] * (this.qmatrix[1][0] * this.qmatrix[2][1] * this.qmatrix[3][2] + this.qmatrix[1][1] * this.qmatrix[2][2] * this.qmatrix[3][0] + this.qmatrix[1][2] * this.qmatrix[2][0] * this.qmatrix[3][1] - this.qmatrix[1][2] * this.qmatrix[2][1] * this.qmatrix[3][0] - this.qmatrix[1][1] * this.qmatrix[2][0] * this.qmatrix[3][2] - this.qmatrix[1][0] * this.qmatrix[3][1] * this.qmatrix[2][2]));
                deter = var1 - var2 + var3 - var4;
                break;
            default:
                System.out.println("Число строк и столбоц превышает 5");
        }

        if (deter != 0.0F) {
            System.out.println("Определитель матрицы равен = " + deter);
        }

    }

    public void average() {
        int sum = 0;

        for(int i = 0; i < this.row; ++i) {
            for(int j = 0; j < this.column; ++j) {
                sum += this.qmatrix[i][j];
            }
        }

        System.out.println("Среднее арифмитическое значение = " + (float)(sum / (this.row * this.column)));
    }

    public void ShowMatrix()
    {
        for (int i=0; i<row; i++)
        {
            for(int j=0; j<row; j++)
            {
                System.out.print(qmatrix[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
