import com.org.base.service.impl.Magician;
import com.org.base.service.impl.Volunteer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class WebApplication {
    public static void main(String[] args) {

/*       ApplicationContext context = new ClassPathXmlApplicationContext("beanannotation.xml");
        Arrays.asList(context.getBeanDefinitionNames()).stream().forEach(System.out::println);
        PlayBiz playBiz = (PlayBiz) context.getBean("playBiz");
        playBiz.play();

        Juggler juggler = (Juggler) context.getBean("juggler");
        juggler.perform();*/

/*        ApplicationContext context = new ClassPathXmlApplicationContext("aopBean.xml");
        Play play = (Play) context.getBean("play");
        play.play();*/

        ApplicationContext context = new ClassPathXmlApplicationContext("aopBean.xml");
        Volunteer volunteer = (Volunteer) context.getBean("volunteer");
        Magician magician = (Magician) context.getBean("magic");
        volunteer.thinkOfSomething("我在思考");
        System.out.println("Quee of Hearts  " + magician.getThoughts());

    }
}
