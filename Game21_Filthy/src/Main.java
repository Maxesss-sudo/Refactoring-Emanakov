// В игре показывют одну а потом вторую карту
// потом спрашивают хочет еще
// если 21 - выиграл, больше - проиграл, меньше - еще тянет
public class Main {
    public static void main(String[] args) {
        // Есть ли карта в колоде или её уже достали
        // 1 - если етсь
        boolean[] a0 = new boolean[36];

        // Заполняем
        for (int i = 0; i < 36; i++) {
            a0[i] = true;
        }

        // Массив атчков карт
        int[] a1 = {
                6, 7, 8, 9, 10, 4, 3, 2, 1,
                6, 7, 8, 9, 10, 4, 3, 2, 1,
                6, 7, 8, 9, 10, 4, 3, 2, 1,
                6, 7, 8, 9, 10, 4, 3, 2, 1
        };

        // Массив имён карт
        String[] a2 = {
                "6 очков, шесть, крести",
                "7 очков, семь, крести",
                "8 очков, восемь, крести",
                "9 очков, девять, крести",
                "10 очков, десять, крести",
                "4 очков, король, крести",
                "3 очков, дама, крести",
                "2 очков, валет, крести",
                "1 очков, туз, крести",

                "6 очков, шесть, треф",
                "7 очков, семь, треф",
                "8 очков, восемь, треф",
                "9 очков, девять, треф",
                "10 очков, десять, треф",
                "4 очков, король, треф",
                "3 очков, дама, треф",
                "2 очков, валет, треф",
                "1 очков, туз, треф",

                "6 очков, шесть, буби",
                "7 очков, семь, буби",
                "8 очков, восемь, буби",
                "9 очков, девять, буби",
                "10 очков, десять, буби",
                "4 очков, король, буби",
                "3 очков, дама, буби",
                "2 очков, валет, буби",
                "1 очков, туз, буби",

                "6 очков, шесть, пики",
                "7 очков, семь, пики",
                "8 очков, восемь, пики",
                "9 очков, девять, пики",
                "10 очков, десять, пики",
                "4 очков, король, пики",
                "3 очков, дама, пики",
                "2 очков, валет, пики",
                "1 очков, туз, пики",
        };

        // Сканнер чтобы читать данные пользователя с клавиатуры
        // ему надо передать поток который с клавиатуры
        // поток находится в классе System
        // поэтому надо написать имя класса и потом io
        // Можно так не писать но тогда надо импрортировать System.*
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        // Есть другие способы прочитать клавиатуру, но этот самый простой
        // Тебе надо научиться читать клавиатуру обязательно а то ты ЛОХ!!!!

        int sum = 0;
        int id1 = -1;

        // одна
        java.util.Random rand1 = new java.util.Random();
        while (id1 < 0) {
            int i = rand1.nextInt(0, 37);
            if (a0[i]) {
                a0[i] = false;
                id1 = i;
            }
        }

        sum += a1[id1];
        System.out.println(a2[id1]);

        // too
        int id2 = -1;
        java.util.Random rand2 = new java.util.Random();
        while (id2 < 0) {
            int i = rand1.nextInt(0, 37);
            if (a0[i]) {
                a0[i] = false;
                id2 = i;
            }
        }

        sum += a1[id2];
        System.out.println(a2[id2]);

        // третья

        System.out.println("очков = " + sum);
        System.out.println("Ещё?");
        java.util.Scanner scanner1 = new java.util.Scanner(System.in);
        String otvet1 = scanner1.nextLine();
        if (otvet1.charAt(0) == 'y') {
            int id3 = -1;
            java.util.Random rand3 = new java.util.Random();
            while (id3 < 0) {
                int i = rand1.nextInt(0, 37);
                if (a0[i]) {
                    a0[i] = false;
                    id3 = i;
                }
            }
            System.out.println(a2[id3]);
            sum += a1[id3];
            if (sum == 21)
                System.out.println("ТЫ выиграл!");
            else if (sum > 21)
                System.out.println("Ты проиграл!!!!!!!!!!!!");
            else {
                // 4-я

                System.out.println("очков = " + sum);
                System.out.println("Ещё?");
                java.util.Scanner scanner2 = new java.util.Scanner(System.in);
                String otvet2 = scanner1.nextLine();
                if (otvet2.charAt(0) == 'y') {
                    int id4 = -1;
                    java.util.Random rand4 = new java.util.Random();
                    while (id4 < 0) {
                        int i = rand1.nextInt(0, 37);
                        if (a0[i]) {
                            a0[i] = false;
                            id4 = i;
                        }
                    }
                    System.out.println(a2[id4]);
                    sum += a1[id4];
                    if (sum == 21)
                        System.out.println("ТЫ выиграл!");
                    else if (sum > 21)
                        System.out.println("Ты проиграл!!!!!!!!!!!!");
                    else {
                        // 5-я

                        System.out.println("очков = " + sum);
                        System.out.println("Ещё?");
                        java.util.Scanner scanner3 = new java.util.Scanner(System.in);
                        String otvet3 = scanner1.nextLine();
                        if (otvet3.charAt(0) == 'y') {
                            int id5 = -1;
                            java.util.Random rand5 = new java.util.Random();
                            while (id5 < 0) {
                                int i = rand2.nextInt(0, 37);
                                if (a0[i]) {
                                    a0[i] = false;
                                    id5 = i;
                                }
                            }
                            System.out.println(a2[id5]);
                            sum += a1[id5];

                            if (sum == 21)
                                System.out.println("ТЫ выиграл!");
                            else if (sum > 21)
                                System.out.println("Ты проиграл!!!!!!!!!!!!");
                            else {
                                // 6-я

                                System.out.println("очков = " + sum);
                                System.out.println("Ещё?");
                                java.util.Scanner scanner4 = new java.util.Scanner(System.in);
                                String otvet4 = scanner1.nextLine();
                                if (otvet4.charAt(0) == 'y') {
                                    int id6 = -1;
                                    java.util.Random rand6 = new java.util.Random();
                                    while (id6 < 0) {
                                        int i = rand2.nextInt(0, 37);
                                        if (a0[i]) {
                                            a0[i] = false;
                                            id6 = i;
                                        }
                                    }
                                    System.out.println(a2[id6]);
                                    sum += a1[id6];

                                    System.out.println("Ты проиграл!!!!!!!!!!!!");
                                }
                            }
                        }
                    }
                }


//        int point = Deck1.getName(2);
            }
        }
    }
}

