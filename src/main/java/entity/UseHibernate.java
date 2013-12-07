package entity;

import dao.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;


public class UseHibernate {
              static    int xz = 4;
    public void getClientsListFromDB(){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        String login = "LoginUserName-4";
        String password = "123789456";

        EnterService enterService = new EnterService();
        int id = enterService.autenticate(login,password);

        User user = (User) session.get(User.class,id);


        List<Client> usId =  session.createSQLQuery("select * from my_client where user_userid = "+ id).addEntity(Client.class).list();

        for(Client cl: usId){

            cl.getClientName();
            cl.getClientTelephone();

            System.out.println("ClientName(); = " + cl.getClientName());
            System.out.println("ClientTelephone(); = " +  cl.getClientTelephone());

        }

    }
    public void changeUserOrDellite(){
         /*   User user = (User) session.get(User.class,3);
      //session.delete(user);
        String name =  user.getUserName();
        String login = user.getLogin();
        System.out.println("Name is: "+ name +"  " + "Login is: "+ login);*/

       /* User user = new User();
        user.setUserName("User Name 5");
        user.setLogin("Login UserName 5");
        user.setEmail("123@123");
        user.setPassword("password-1");


     session.save(user);*/

    }
    public void faindById(){
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
          // найти по - id
        String login = "mylog-2";
        String password = "12569";

        EnterService enterService = new EnterService();
        int id = enterService.autenticate(login,password);

        System.out.println("ID  is: "+ id  );
        User user = (User) session.get(User.class,id);
        String em = user.getEmail();
        String log = user.getLogin();
        String pass = user.getPassword();

        System.out.println("Password  is: "+ pass +"  " + "Login is: "+ log );
        session.getTransaction().commit();
        session.close();
    }
    public void getInfoFromDataDase(){
        //SQL  ------------
  /*      List<User> us =  session.createSQLQuery("select * from my_users").addEntity(User.class).list();
        for(User u: us){
            String logg = u.getLogin();
            String nam = u.getUserName();
            int idd = u.getUserId();
            String passs = u.getPassword();

            if(login == logg || password == passs){
                System.out.println("ID ID ID  = " + u.getUserId());
            }
            System.out.println("login = " + logg+ "///" +"name = " + nam+"///" + "id = " + idd);
        }
*/
//HQL------------

     /*   List<User> studs = (List<User>)session.createQuery("from MY_USERS order by login").list();
        for(User u: studs){
           String log = u.getLogin();
            String nam = u.getUserName();
            int id = u.getUserId();
            System.out.println("login = " + log+ "///" +"name = " + nam+"///" + "id = " + id);
        }*/

// Criteria --------------
     /*   Criteria crit = session.createCriteria(User.class); //создаем критерий запроса
        crit.setMaxResults(50);//ограничиваем число результатов
        List<User> studss = crit.list();

        for(User u: studss){
         String log = u.getLogin();
            String nam = u.getUserName();
            int id = u.getUserId();
            System.out.println("login = " + log+ "///" +"name = " + nam+"///" + "id = " + id);
        }*/

    }
    public void addUserAndClients(){
        System.out.println("Start My_users");
        Session session = HibernateUtil.getSessionFactory().openSession();

        session.beginTransaction();

       // User user = (User) session.get(User.class,id);

        User user = new User();
        user.setUserName("UserName-4");
        user.setLogin("LoginUserName-4");
        user.setPassword("123789456");
        user.setEmail("em@em-4");

        Client client = new Client();
        client.setClientName("My7client");
        client.setClientTelephone("77777");

        Client client2 = new Client();
        client2.setClientName("My8client");
        client2.setClientTelephone("88888");

        user.getClient().add(client);    //   my_users_my_client проставляет индексы в users clients
        user.getClient().add(client2);

        client.setUser(user);   // проставляет индексы юзеров таблице  my_client
        client2.setUser(user);

        session.save(user);
        session.save(client);
        session.save(client2);

        session.getTransaction().commit();
        session.close();
    }

    public static void main (String[]args){
        System.out.println("Start My_users");

       UseHibernate usH = new UseHibernate();
       // usH.addUserAndClients();
        usH.getClientsListFromDB();
     /*   Session session = HibernateUtil.getSessionFactory().openSession();
          session.beginTransaction();*/







   /*    session.getTransaction().commit();
        session.close();*/









    }
}
