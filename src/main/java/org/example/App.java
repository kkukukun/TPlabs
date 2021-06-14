package org.example;

import org.example.entity.Gruppyi;
import org.example.entity.Studentyi;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery("From Studentyi");
        Query query2 = session.createQuery("From Gruppyi");
        // 1.Вывести группы определённой специальности (A, It).
        // 2.Вывести таблицу: Группы, количество студентов
        // Добавить таблицу «Оценки», связанную с таблицей «Студенты» отношением многие-к-одному.
        List <Studentyi> stds = query.list();
        List <Gruppyi> grup = query2.list();
        System.out.println("Задание 1");
        for(Studentyi st: stds){
            System.out.println(st.getFamiliya() + " " + st.getImya() + " " + st.getOtchestvo() +
                    " учится в группе " + st.getGruppyi().getNazvanie());
        }
        System.out.println("-------------------------------------------");
        for(Gruppyi g: grup){
            System.out.println("Группа " + g.getNazvanie() + " имеет " + g.getStudentyis().size() + " студента(ов).");
        }

        System.out.println("\nЗадание 2 ");
        Query query11 = session.createQuery("FROM Gruppyi WHERE nazvanie like 'A-%' ");
        System.out.println("К специальности 'Автоматитизация' принадлежат группы:  ");
        List<Gruppyi> gr = query11.list();
        for(Gruppyi gru: gr){
            System.out.println("  " + gru.getNazvanie());
        }

        System.out.println("\nК специальности 'Информационные технологии' принадлежат группы:  ");
        Query query1 = session.createQuery("FROM Gruppyi WHERE nazvanie like 'It-%' ");
        List<Gruppyi> gr1 = query1.list();
        for(Gruppyi gru: gr1){
            System.out.println("  " + gru.getNazvanie());
        }

        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}
