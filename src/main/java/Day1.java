import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Day1 {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(new File("Day1.txt").toPath());

        //part 1

        int mostCalories = 0;
        int calorieCounter = 0;
        ArrayList<Integer> listWithTotalAmountOfCaloriesPerElf = new ArrayList<>();
        for (String line : lines) {
            if (line.isEmpty()) {
                listWithTotalAmountOfCaloriesPerElf.add(calorieCounter);
                if (calorieCounter > mostCalories) {
                    mostCalories = calorieCounter;
                }
                calorieCounter = 0;
                continue;
            }
            calorieCounter += Integer.parseInt(line);
        }
        System.out.println("The most calories carried by an elf: " + mostCalories);

        //part 2

        Collections.sort(listWithTotalAmountOfCaloriesPerElf);
        int sizeOfCountingALlCalories = listWithTotalAmountOfCaloriesPerElf.size();
        int threeMaxSnacks = listWithTotalAmountOfCaloriesPerElf.get(sizeOfCountingALlCalories - 1) + listWithTotalAmountOfCaloriesPerElf.get(sizeOfCountingALlCalories - 2) + listWithTotalAmountOfCaloriesPerElf.get(sizeOfCountingALlCalories - 3);
        System.out.println("The sum of the 3 most calories carried by elfs: " + threeMaxSnacks);
    }
}