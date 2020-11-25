package com.neusoft.redbag;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LuckyMoneyRepositoryTests {
    //在有Spring的地方这样创建对象 不用new
    @Autowired
    private LuckyMoneyRepository repository;

    @Test
    public void listAll(){
        List<LuckyMoney> list = repository.findAll();
        for(LuckyMoney luckyMoney: list){
            System.out.println(luckyMoney);
        }
     }

     @Test
    public void getById(){
         Optional<LuckyMoney> optional = repository.findById(1);
         System.out.println(optional);
     }

     @Test
    public void save(){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("zs");
        luckyMoney.setMoney(new BigDecimal(12));
        luckyMoney.setProducer("sg");
//      repository.save(luckyMoney);
         // save 正常的保存
         // saveAndFlush 是 在同一事物下提交前就保存
        repository.saveAndFlush(luckyMoney);
    }

    @Test
    public void delete(){
        repository.deleteById(6);
    }

    @Test
    public void update(){
        LuckyMoney luckyMoney = new LuckyMoney();
        luckyMoney.setConsumer("lk");
        luckyMoney.setMoney(new BigDecimal(12));
        luckyMoney.setProducer("mm");
        luckyMoney.setId(1);
        repository.save(luckyMoney);
    }
}
