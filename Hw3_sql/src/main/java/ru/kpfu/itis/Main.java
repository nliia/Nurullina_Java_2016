package ru.kpfu.itis;

import ru.kpfu.itis.dao.CommunityDao;
import ru.kpfu.itis.dao.NewsDao;
import ru.kpfu.itis.dao.RequestDao;
import ru.kpfu.itis.dao.UserDao;
import ru.kpfu.itis.dao.impl.CommunityDaoImpl;
import ru.kpfu.itis.dao.impl.NewsDaoImpl;
import ru.kpfu.itis.dao.impl.RequestDaoImpl;
import ru.kpfu.itis.dao.impl.UserDaoImpl;
import ru.kpfu.itis.model.Community;
import ru.kpfu.itis.model.Request;
import ru.kpfu.itis.model.User;

import java.sql.Timestamp;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;
        while (running) {
            System.out.println("Доступные команды: Добавить заявку(1), Добавить пользователя(2), " +
                    "Редактировать новость(3), Редактировать сообщество(4), " +
                    "Количество новостей сообществ одного основателя(5), Самый активный пользователь за сезон(6)," +
                    " Самый активный волонтер(7), Выход(8)");
            System.out.println("Введите номер команды:");
            String mainCommand = sc.nextLine();

            if (mainCommand.equals("1")) {
                Request newReq = new Request();
                RequestDao reqDao = new RequestDaoImpl();
                System.out.println("Ввeдите id нуждающегося");
                newReq.setNeedyId(Long.parseLong(sc.nextLine()));
                System.out.println("Введите адрес");
                newReq.setAddress(sc.nextLine());
                System.out.println("Введите широту");
                newReq.setLatitude(Float.parseFloat(sc.nextLine()));
                System.out.println("Введите долготу");
                newReq.setLongitude(Float.parseFloat(sc.nextLine()));
                System.out.println("Введите тип сервиса");
                newReq.setService_type(sc.nextLine());
                newReq.setStatus("PENDING");
                newReq.setCreatedAt(new Timestamp(System.currentTimeMillis()));
                reqDao.add(newReq);

            }
            if (mainCommand.equals("2")) {
                User newUser = new User();
                UserDao userDao = new UserDaoImpl();
                System.out.println("Введите имя");
                newUser.setName(sc.nextLine());
                System.out.println("Введите фамилию");
                newUser.setSurname(sc.nextLine());
                System.out.println("Введите email");
                newUser.setEmail(sc.nextLine());
                System.out.println("Введите пароль");
                newUser.setPassword(sc.nextLine());
                System.out.println("Введите 1, если пользователь - админ. Любое число, если нет");
                int role = sc.nextInt();
                if (role == 1)
                    newUser.setRole("ROLE_ADMIN");
                else {
                    newUser.setRole("ROLE_USER");
                }
                newUser.setStatus("ACTIVE");
                userDao.add(newUser);
            }
            if (mainCommand.equals("3")) {
                NewsDao newsDao = new NewsDaoImpl();
                System.out.println("Введите id новости, которую хотите изменить");
                Long id = Long.parseLong(sc.nextLine());
                System.out.println("Введите новый текст");
                String text = sc.nextLine();
                newsDao.update(text, id);
            }
            if (mainCommand.equals("4")) {
                CommunityDao communityDao = new CommunityDaoImpl();
                System.out.println("Введите название сообщества, которое вы хотите обновить");
                String name = sc.nextLine();
                Community community = communityDao.findByName(name);
                System.out.println("Введите новое название");
                community.setName(sc.nextLine());
                System.out.println("Ведите новое описание");
                community.setDescription(sc.nextLine());
                communityDao.update(community);
            }
            if (mainCommand.equals("5")) {
                NewsDao newsDao = new NewsDaoImpl();
                System.out.println("Введите id основателя");
                int result = newsDao.allMessagesByCommunityOfFounder(Long.parseLong(sc.nextLine()));
                if (result == -1)
                    System.out.println("Пользователь не основал ни одного сообщества");
                else
                    System.out.println("Кол-во сообщений:" + result);
            }
            if (mainCommand.equals("6")) {
                UserDao userDao = new UserDaoImpl();
                System.out.println("Введите сезон (зима/осень/весна/лето)");
                System.out.println(userDao.mostActiveRecipientOfSeason(sc.nextLine()));
            }
            if (mainCommand.equals("7")) {
                UserDao userDao = new UserDaoImpl();
                System.out.println("Будет выбраны самые активные волонтеры," +
                        " откликнувшиеся на заявки, которые были поданы по адресу, " +
                        "содержащему следующие символы (введите символы):");
                System.out.println(userDao.mostActiveVolunteerOfAddress(sc.nextLine()));
            }

            if (mainCommand.equals("8"))
                running = false;
        }
    }

}