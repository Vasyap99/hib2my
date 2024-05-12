package org.example;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration; //

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Throwable{
        // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
        System.out.printf("Hello and welcome!");

        // Press Shift+F10 or click the green arrow button in the gutter to run the code.
        for (int i = 1; i <= 5; i++) {

            // Press Shift+F9 to start debugging your code. We have set one breakpoint
            // for you, but you can always add more by pressing Ctrl+F8.
            System.out.println("i = " + i);
        }

        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                //
                .addPackage("org.example")
                .addAnnotatedClass(user.class)
                .addAnnotatedClass(message.class)
                .buildSessionFactory();/**/

        /*StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure() // configures settings from hibernate.cfg.xml
                .build();
            SessionFactory sessionFactory = new MetadataSources(registry)
                    .addAnnotatedClass(org.example.Monter.class)
                    .buildMetadata()
                    .buildSessionFactory();*/

        try {
            /*
            System.out.println(">>1");
            Session session = sessionFactory.openSession();
            Transaction transaction = session.getTransaction();
            System.out.println(">>2");
            tab1 t1=new tab1("lnk1");
            System.out.println(">>3");
            transaction.begin();
            System.out.println(">>4");
            session.persist(t1);
            System.out.println(">>5");
            transaction.commit();
            System.out.println(">>6");

            session.close();
            System.out.println(">>7");*/

            System.out.println(">>1");
            Session session = sessionFactory.openSession();
            chat c=new chat(session);
            Scanner s=new Scanner(System.in);
            String cmd="";
            final String CS="cmd(l-login,c-create new user)>";
            System.out.print(CS);
            while(!(cmd=s.nextLine()).equals("q")){
                //System.out.println("\n");
                //code
                switch(cmd.charAt(0)){
                    case 'l':c.login(s.nextLine(),s.nextLine());
                        break;
                    case 'c':c.createNewUser(s.nextLine(),s.nextLine(),s.nextLine());
                        break;
                }
                System.out.print(CS);
            }
            /*Transaction transaction = session.getTransaction();
            System.out.println(">>2");
            tab1 t1=session.get(tab1.class,2);
            t1.url+="x";//первый способ изменения объекта в базе

            session.evict(t1);//второй способ изменения объекта в базе
            t1.url+="y";
            t1=(tab1)session.merge(t1);

            tab2 t2;
            t1.s.add(t2=new tab2());//объект добавляется в базу автоматически
            System.out.println(">>3");
            transaction.begin();
            System.out.println(">>4");
            session.persist(t1);
            System.out.println(">>5");
            transaction.commit();
            System.out.println(">>6");

            //session.flush();
*/
            session.close();
            System.out.println(">>7");
            sessionFactory.close();
        } catch (Exception e) {
            System.out.println("exc");
            e.printStackTrace();
        }

    }
}