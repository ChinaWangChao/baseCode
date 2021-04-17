package Guava;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ListsTest {

    @Test
    public void testPartition(){
        List<Integer> list = new ArrayList<>();
        for (int i = 0;i<101;i++){
            list.add(i);
        }
        List<List<Integer>> partitions = Lists.partition(list, 100);
        for (List<Integer> partition : partitions){
            System.out.println(partition.toString());
        }
    }
}
