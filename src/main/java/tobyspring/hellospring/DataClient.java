package tobyspring.hellospring;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;
import tobyspring.hellospring.data.OrderRepository;
import tobyspring.hellospring.order.Order;

import java.math.BigDecimal;

public class DataClient {

    @Autowired
    SimpleService service;

    public static void main(String[] args) {
        service.sendMessage(message);

        BeanFactory beanFactory = new AnnotationConfigApplicationContext(DataConfig.class);
        OrderRepository repository = beanFactory.getBean(OrderRepository.class);
        JpaTransactionManager transactionManager = beanFactory.getBean(JpaTransactionManager.class);

        new TransactionTemplate(transactionManager).execute(status -> {
            Order order = new Order("100", BigDecimal.TEN);
            repository.save(order);
            System.out.println(order);
            Order order2 = new Order("100", BigDecimal.TEN);
            repository.save(order2);
            return null;
        });

    }
}
