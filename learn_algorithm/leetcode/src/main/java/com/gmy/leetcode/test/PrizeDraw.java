package com.gmy.leetcode.test;

import java.util.Random;

/**
 * 必中抽奖：按权重抽中后扣减库存，库存为0的奖品自动排除，用剩余奖品权重重新计算。
 */
public class PrizeDraw {

    static class Prize {
        String name;
        int count;
        double weight;

        Prize(String name, int count, double weight) {
            this.name = name;
            this.count = count;
            this.weight = weight;
        }
    }

    /**
     * 单次抽奖，命中后扣减库存。
     *
     * @param prizes 奖品列表（会被修改库存）
     * @return 命中的奖品，若全部库存为0则返回null
     */
    public static Prize draw(Prize[] prizes) {
        // 计算剩余奖品的总权重
        double totalWeight = 0;
        for (Prize p : prizes) {
            if (p.count > 0) {
                totalWeight += p.weight;
            }
        }
        if (totalWeight == 0) {
            return null;
        }

        double r = new Random().nextDouble() * totalWeight;

        // 按累计权重定位命中奖品
        double cumulative = 0;
        for (Prize p : prizes) {
            if (p.count <= 0) {
                continue;
            }
            cumulative += p.weight;
            if (r < cumulative) {
                p.count--;
                return p;
            }
        }
        return null; // 不会走到这里
    }

    public static void main(String[] args) {
        Prize[] prizes = {
            new Prize("A", 5, 8.1),
            new Prize("B", 28, 5.1),
            new Prize("C", 30, 8.4),
            new Prize("D", 40, 15.4),
            new Prize("E", 100, 21.5),
            new Prize("F", 200, 49.5),
        };
        Prize hit = draw(prizes);
        System.out.println("抽中: " + hit.name + "，权重: " + hit.weight + "%");
    }
}
