package com.cys.blog;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@RunWith(SpringRunner.class)
@SpringBootTest
public class BlogApplicationTests {

    @Test
    public void contextLoads() {

    }

}


class RandomTest {
    public static void main(String[] args) {
        // (10)获取一个随机数生成器
        ThreadLocalRandom random = ThreadLocalRandom.current();

        //(11)输出10个在0〜5 (包含0，不包含5)之间的随机数
        for (int i = 0; i < 10; ++i) {
            System.out.println(random.nextInt(5));
        }
    }
}

