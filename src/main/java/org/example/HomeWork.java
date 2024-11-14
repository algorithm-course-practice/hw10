package org.example;


import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class HomeWork {

    /**
     * <h1>Задание 1.</h1>
     * Решить задачу <a href="https://codeforces.com/contest/356/problem/A">...</a>
     */
    @SneakyThrows
    public void championship(InputStream in, OutputStream out) {
        List<List<Integer>> tournamentDescription = new BufferedReader(new InputStreamReader(in, StandardCharsets.UTF_8)).lines()
                .map(val -> Arrays.stream(val.split(" ")).map(Integer::parseInt).collect(Collectors.toList())).collect(Collectors.toList());
        RedBlackBST<Integer> redBlackTree = new RedBlackBST<>();
        int[] res = new int[tournamentDescription.get(0).get(0)];
        for (int i = 1; i <= res.length; i++) {
            redBlackTree.put(i);
        }
        for (int i = 1; i < tournamentDescription.size(); i++) {
            List<Integer> roundDesc = tournamentDescription.get(i);
            for (int j = roundDesc.get(1); j >= roundDesc.get(0); j--) {
                if(j == roundDesc.get(2)) continue;
                if (redBlackTree.delete(j)) {
                    res[j - 1] = roundDesc.get(2);
                }
            }
        }

        String resStr = Arrays.stream(res).boxed().map(String::valueOf).collect(Collectors.joining(" "));
        out.write(resStr.getBytes(StandardCharsets.UTF_8));
    }


}
