package sorenrahimi.g3s1m2;


import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import sorenrahimi.g3s1m2.entities.*;

@Profile("test")
@Component
public class OrdersRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(G3S1M2Application.class);
        try {
            Menu m = (Menu) ctx.getBean("menu");
            m.printMenu();
            Table t1 = (Table) ctx.getBean("Tavolo1");
            Order o1 = new Order(4, t1);
            o1.addMenuItem(ctx.getBean("pizza_margherita", Pizza.class));
            o1.addMenuItem(ctx.getBean("pizza_hawaiana", Pizza.class));
            o1.addMenuItem(ctx.getBean("pizza_salame_xl", Pizza.class));
            o1.addMenuItem(ctx.getBean("limonata", Beverage.class));
            o1.addMenuItem(ctx.getBean("limonata", Beverage.class));
            o1.addMenuItem(ctx.getBean("birra", Beverage.class));
            System.out.println("DETTAGLI TAVOLO 1:");
            o1.print();
            System.out.println("CONTO TAVOLO 1");
            System.out.println(o1.getTotal());
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        } finally {
            ctx.close();
        }

    }
}
