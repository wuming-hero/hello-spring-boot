package com.wuming.spring.cglig;



import java.util.Random;

/**
 *
 * 普通领导类，没有继承任何类
 *
 * @author manji
 * Created on 2025/4/17 16:51
 */
public class Leader {

    public void meeting() {
        System.out.println("领导早上要组织会议");
    }

    public int evaluate(String name) {
        int score = new Random(System.currentTimeMillis()).nextInt(20) + 80;
        System.out.println(String.format("领导给%s的考评为%s分", name, score));
        return score;
    }
}
