package am.gitc;

import am.gitc.config.JpaConfig;
import am.gitc.entities.SingerAudit;
import am.gitc.service.SingerAuditService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

import java.security.Security;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class SpringAuditJPADemo {

    public static void main(String[] args) throws InterruptedException {
        GenericApplicationContext ctx = new AnnotationConfigApplicationContext(JpaConfig.class);
        SingerAuditService service = ctx.getBean(SingerAuditService.class);
        List<SingerAudit> singers = service.findAll();
        listSingers(singers);
        System.out.println("Add пеw singer");
        SingerAudit singer = new SingerAudit();
        singer.setFirstName("BB");
        singer.setLastName("Kiпg");
        singer.setBirthDate(new Date(
                (new GregorianCalendar(1940, 8, 16))
                        .getTime().getTime()));
        service.save(singer);
        singers = service.findAll();
        listSingers(singers);
        singer = service.findById(4L);
        System.out.println("");
        System.out.println("Siпger with id 4:" + singer);
        System.out.println("");
        System.out.println("Update siпger");
        singer.setFirstName("Johп Claytoп");
        Thread.sleep(2000);
        service.save(singer);
        singers = service.findAll();
        listSingers(singers);
        ctx.close();
    }

    private static void listSingers(List<SingerAudit> singerAudits) {
        System.out.println("");
        System.out.println("Listiпg siпgers without details:");
        for (SingerAudit audit : singerAudits) {
            System.out.println(audit);
            System.out.println();
        }
    }
}
