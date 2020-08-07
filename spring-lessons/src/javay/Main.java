package javay;

import javay.main.config.AppConfig;
import javay.main.dao.AccountDao;
import javay.main.model.Acount;
import javay.main.model.Amount;
import javay.main.scopes.MyBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javay.main.service.TransferService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

//@ComponentScan
//@Configuration
//@EnableAspectJAutoProxy
public class Main {
    public static void main(String[] args) {
        ConfigurableApplicationContext cntx = new AnnotationConfigApplicationContext(AppConfig.class);
//        ConfigurableApplicationContext cntx = new ClassPathXmlApplicationContext("javay/applicationContext.xml");
        TransferService service = cntx.getBean(TransferService.class);
        service.transferAmount(1000L, 2000L, new Amount(23.9));
        service.transfer("from", "to", 1000L);
        AccountDao dao = cntx.getBean(AccountDao.class);
//        dao.saveAccount(new Acount("john",  "first"));
        List<Acount> acounts = dao.findAllAccountInBranch("first");
        System.out.println(acounts);
        for (int i = 1; i <= acounts.size(); i++) {
            Acount acount = dao.findOne(1);
            System.out.println(acount);
        }
        cntx.close();
    }
}
