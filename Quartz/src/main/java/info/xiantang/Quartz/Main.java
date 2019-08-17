package info.xiantang.Quartz;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.Scanner;

/**
 * @Author: xiantang
 * @Date: 2019/8/16 18:13
 */
public class Main {
    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        String next = in.nextLine();
//        ArrayList<Character> integers = new ArrayList<>();
//        for (int i = 0; i < next.length(); i++) {
//            if (!Character.isAlphabetic(next.charAt(i))) {
//                integers.add(next.charAt(i));
//            }
//        }
//        integers.sort(new Comparator<Character>() {
//            @Override
//            public int compare(Character o1, Character o2) {
//                return o1 - o2;
//            }
//
//            @Override
//            public boolean equals(Object obj) {
//                return false;
//            }
//        });
//        StringBuilder stringBuffer = new StringBuilder();
//        if (integers.size() == 0) {
//            System.out.println(-1);
//            return;
//        }
//        for (int i = 0; i < integers.size(); i++) {
//            stringBuffer.append(integers.get(i));
//        }
//        System.out.println(Long.parseLong(stringBuffer.toString()));
        Scanner in = new Scanner(System.in);
        String next = in.nextLine();
        next = next.replace("{", "").replace("}", "");
        String[] nexts = next.split(",");

        int[] ints = new int[nexts.length];
        for (int i = 0; i < nexts.length; i++) {
            //{11,13,15,17,19,21}
            int res = Integer.parseInt(nexts[i]);
            ints[i] = res;
        }
        int res = find(ints, 11,0,ints.length-1);
        System.out.println(res+1);

    }

    private static int find(int[] next, int target, int lo, int hi) {
        if (lo >= hi) {
            return -1;
        }
        int mid = (lo + hi) / 2;
        if (next[mid] == target) {
            return mid;
        }
        if (next[mid] > target) {
            return find(next, target, lo, mid);
        } else {
            return find(next, target, mid, hi);
        }


    }
}
