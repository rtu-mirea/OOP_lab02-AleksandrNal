package com.code;
import java.util.Scanner;

public class Main {

    public static void main(String[] args)
    {
        String text_for_1_2 = "tomato 11;meat 55;salad 6;fish 43;candy 50;eggplant 0;apple 49";
        String text_for_3 = "22:33 00:01 21:40 12:40 02:00 11:00 01:55 16:47 00:00 21:21";
        Scanner in = new Scanner(System.in);
        boolean c = true;
        int check;
        System.out.println("1:Задание 1\n2:Задание 2\n3:Задание 3");
        check = in.nextInt();
        switch (check){
            case 1:
                System.out.println("1:Ввод\n2:Вывод\n3:Найти сумму всех продаж\n" +
                        "4:Отредактировать текст: название товара  должно начинаться с прописной буквы\n" +
                        "5:Сформировать рейтинг товаров, учтенных в продажах\n" +
                        "6:Показать информацию по заданной по номеру продаже\n" + "7:Выход");
                Task1 text1 = new Task1();
                while (c){
                    System.out.println("Выберите действие\n");
                    check = in.nextInt();

                    switch (check){
                        case 1:
                            System.out.println("1:Готовый текст\n2:Самостоятельно");
                            check = in.nextInt();
                            switch (check){
                                case 1:
                                    try {
                                        text1 = new Task1(text_for_1_2);
                                    }catch (Exception e) {
                                    text1 = new Task1();
                                    System.out.println("Ошибка ввода");
                                }
                                    break;
                                case 2:
                                    System.out.println("Формат: <название> <сумма>;(...);<название> <сумма>\n");
                                    String text_for_1_user = in.nextLine();
                                    text_for_1_user = in.nextLine();
                                    try {
                                        text1 = new Task1(text_for_1_user);
                                    }catch (Exception e) {
                                        text1 = new Task1();
                                        System.out.println("Ошибка ввода");
                                    }
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println(text1);
                            break;
                        case 3:
                            System.out.println(text1.found_sum());
                            break;
                        case 4:
                            text1.first_to_upper();
                            System.out.println(text1);
                            break;
                        case 5:
                            System.out.println(text1.rating());
                            break;
                        case 6:
                            System.out.println("Под каким номером в рейтинге вывести элемент?");
                            check = in.nextInt();
                            System.out.println(text1.show_by_rating(check));
                            break;
                        case 7:
                            c = false;
                            break;
                    }
                }
                break;
            case 2:
                System.out.println("1:Ввод\n2:Вывод\n3:Удалить из текста сведения о продажах с суммой равной 0\n" +
                        "4:Найти информацию о продаже, имеющей наименьшую длину. " +
                        "Заменить эту  продажу на продажу наибольшего размера\n" +
                        "5:Добавить новую продажу  в текст\n6:Выход");
                Task2 text2 = new Task2();
                while(c){
                    System.out.println("Выберите действие\n");
                    check = in.nextInt();

                    switch (check){
                        case 1:
                            System.out.println("1:Готовый текст\n2:Самостоятельно");
                            check = in.nextInt();
                            switch (check){
                                case 1:
                                    text2 = new Task2(text_for_1_2);
                                    break;
                                case 2:
                                    System.out.println("Формат: <название> <сумма>;(...);<название> <сумма>\n");
                                    String text_for_2_user = in.nextLine();
                                    text_for_2_user = in.nextLine();
                                    text2 = new Task2(text_for_2_user);
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println(text2);
                            break;
                        case 3:
                            text2.del_0();
                            break;
                        case 4:
                            text2.replace_shortest();
                            break;
                        case 5:
                            System.out.println("Введите новую продажу");
                            System.out.println("Формат: <название> <сумма>\n");
                            String to_end = in.nextLine();
                            to_end = in.nextLine();
                            if (text2.toString().compareTo("") != 0 && to_end.compareTo("") != 0)
                                text2.add(";");
                            text2.add(to_end);
                            break;
                        case 6:
                            c = false;
                            break;
                    }
                }
                break;
            case 3:
                System.out.println("1:Определите, что переданная строка является корректным временем\n" +
                        "2:Удалите из текста все значения времени из промежутка 00:00 до 02:00\n3:Выход");
                Task3 text3 = new Task3();
                while (c){
                    System.out.println("Выберите действие\n");
                    check = in.nextInt();

                    switch (check) {
                        case 1:
                            System.out.println("Введите значение\n");
                            String entered_time = in.nextLine();
                            entered_time = in.nextLine();
                            text3 = new Task3(entered_time);
                            System.out.println(text3.check());
                            break;
                        case 2:
                            System.out.println("1:Готовый текст\n2:Самостоятельно");
                            check = in.nextInt();
                            switch (check) {
                                case 1:
                                    text3 = new Task3(text_for_3);
                                    text3.delete();
                                    System.out.println(text3);
                                    break;
                                case 2:
                                    System.out.println("Введите текст\n");
                                    System.out.println("Формат: <Время1> <Время2> (...) <ВремяN>\n");
                                    String entered_text = in.nextLine();
                                    entered_text = in.nextLine();
                                    text3 = new Task3(entered_text);
                                    text3.delete();
                                    System.out.println(text3);
                                    break;
                            }
                            break;
                        case 3:
                            c = false;
                            break;
                    }
                }
                break;
        }

    }
}
