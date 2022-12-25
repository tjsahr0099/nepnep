package com.nepnep.algorithm.jsw;

import java.util.ArrayList;
import java.util.List;

public class 햄버거만들기 {
    public static int solution2(int[] ingredient){
        int result = 0;
        List<Integer> list = new ArrayList<>();
        for (int a : ingredient){
            list.add(a);
        }

        while (list.size() >= 4) {
            int before = list.size();
            for (int i = 0; i < list.size(); i++) {
                if ((i + 3) < list.size()) {
                    if (list.get(i) == 1 && list.get(i + 1) == 2 && list.get(i + 2) == 3 && list.get(i + 3) == 1) {
                        result++;
                        for (int j = 0; j < 4; j++) {
                            list.remove(i);
                        }
                        if(i > 3){
                            i -= 3;
                            }
                    }
                }
            }
            int after = list.size();
            if (before == after){
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution2(new int[]{2, 1, 1, 2, 3, 1, 2, 3, 1}));
    }
}


//        Stack<Integer> stack = new Stack<>();
//        for(int a : list){
//            switch (a){
//                case 1: if(stack.isEmpty() || stack.peek() == 3){
//                }
//                    break;
//            }
//            if(a == 1 && stack.isEmpty()){
//                stack.push(a);
//            }
//        }

//    public static int solution(int[] ingredient){
//        int answer = 0;
//        Queue<Integer> queue = new LinkedList<>();
//        for(int i : ingredient){
//            queue.add(i);
//        }
//
//        Queue<Integer> queue1 = queue;
//        while (queue.size() >= 4){
//
//            int idx = 0;
//            while (true) {
//
//                if(queue1.poll() == 1 && queue1.poll() == 2 && queue1.poll() == 3 && queue1.poll() == 1){
//                    System.out.println("이얏호");
//                }else {
//                    queue1 = queue;
//                    queue1.poll();
//                }
//
//            }

//            Integer[] idxArr = {-1, -1, -1, -1};
//            List<Integer> idxList = new ArrayList<>();


//            for (int i = 0; i < queue.size(); i++){
//                if(queue.poll() == 1){
//                    if(queue.poll() == 2){
//                        if(queue.poll() == 3){
//                            if(queue.poll() == 1){
//                                System.out.println("욕갓다!");
//                            }
//                        }
//                    }else {
//
//                    }
//                }else {
//
//                }
//            }
//            Stack<Integer> stack = new Stack<>();
//
//            int last = 0;
//
//            for (int i = 0; i < list.size(); i++){
//                if(list.get(list.size()-1) == 1 && list.get(list.size()-2) == 2 && list.get(list.size()-3) == 3 && list.get(list.size()-4) == 1) {
//
//                    if (list.get(i) == 1 && idxList.isEmpty()) {
//                        idxList.add(i);
//                        last = 1;
//                        continue;
//                    }
//                    if (list.get(i) == 2 && last == 1 && idxList.size() == 1) {
//                        idxList.add(i);
//                        last = 2;
//                        continue;
//                    }
//                    if (list.get(i) == 3 && last == 2 && idxList.size() == 2) {
//                        idxList.add(i);
//                        last = 3;
//                        continue;
//                    }
//                    if (list.get(i) == 1 && last == 3 && idxList.size() == 3) {
//                        idxList.add(i);
//                        last = 4;
//                        break;
//                    }
//                }else{
//
//                }
//            }
//
//            if (last == 4){
//                last = 0;
//                answer ++;
//                for (int idx : idxList){
//                    list.remove(idx);
//                }
//            } else {
//                break;
//            }
//        }
//
//        return answer;
//    }
