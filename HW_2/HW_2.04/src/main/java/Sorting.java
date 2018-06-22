import java.util.Arrays;

public class Sorting {
    public static WritingTool[] sortByPrice(WritingTool[] tools) {
        WritingTool[] tempArr = tools;
        Arrays.sort(tempArr, WritingTool.priceComparator);
        return tempArr;
    }

    public static WritingTool[] sortByName(WritingTool[] tools) {
        WritingTool[] tempArr = tools;
        Arrays.sort(tempArr, WritingTool.nameComparator);
        return tempArr;
    }

    public static WritingTool[] sortByTwoParams(WritingTool[] tools) {
        WritingTool[] tempArr = tools;
        Arrays.sort(tempArr, WritingTool.twoParamsComparator);
        return tempArr;
    }
}
