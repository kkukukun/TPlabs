package org.example;

import org.example.entity.Gruppyi;
import org.example.entity.Studentyi;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        // Вывести таблицу ФИО студента, название группы.
        session.beginTransaction();
        /*String hql = "FROM Studentyi ";
        Query query = session.createQuery(hql);

        List<Studentyi> studentyi = query.list();
        studentyi.size();
        try {
            for (int i = 0; i <= studentyi.size(); i++) {
                System.out.println("\t" + studentyi.get(i).getFamiliya() + "\t"
                        + studentyi.get(i).getImya() + "\t"
                        + studentyi.get(i).getOtchestvo() + "\t"
                        + studentyi.get(i).getGruppyi().getNazvanie());
            }
        } catch (Exception e) {
           /* String hql1 = "FROM Gruppyi WHERE nazvanie like 'A-%' ";
            Query query11 = session.createQuery(hql1);
            List<Gruppyi> gr = query11.list();

            for(Gruppyi gru: gr){
                System.out.println("Группа " + gru.getNazvanie());

        }*/
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
