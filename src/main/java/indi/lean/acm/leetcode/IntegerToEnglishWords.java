package indi.lean.acm.leetcode;

public class IntegerToEnglishWords {
    private static final String[] numbers = {
            "Zero", "One ", "Two ", "Three ", "Four ", "Five ", "Six ", "Seven ", "Eight ", "Nine ", "Ten ",
            "Eleven ", "Twelve ", "Thirteen ", "Fourteen ", "Fifteen ", "Sixteen ", "Seventeen ", "Eighteen ", "Nineteen "
    };

    private static final String[] weights = {
            "", "", "Twenty ", "Thirty ", "Forty ", "Fifty ", "Sixty ", "Seventy ", "Eighty ", "Ninety "
    };

    private static final int hundred = 100;

    private static final int thousand = 1000;

    private static final int million = 1000000;

    private static final int billion = 1000000000;

    private void numberToWords(StringBuilder builder, int num) {
        if(num < hundred) {
            if(num == 0) {
                if(builder.length() == 0) {
                    builder.append(numbers[num]);
                }
            } else if(num < 20) {
                builder.append(numbers[num]);
            } else if(num % 10 == 0) {
                builder.append(weights[num / 10]);
            } else {
                builder.append(weights[num / 10]);
                builder.append(numbers[num % 10]);
            }
            return;
        }

        if(num >= billion) {
            numberToWords(builder, num / billion);
            builder.append("Billion").append(" ");
            numberToWords(builder, num % billion);
        } else if(num >= million) {
            numberToWords(builder, num / million);
            builder.append("Million").append(" ");
            numberToWords(builder, num % million);
        } else if(num >= thousand) {
            numberToWords(builder, num / thousand);
            builder.append("Thousand").append(" ");
            numberToWords(builder, num % thousand);
        } else if(num >= hundred) {
            numberToWords(builder, num / hundred);
            builder.append("Hundred").append(" ");
            numberToWords(builder, num % hundred);
        }
    }

    public String numberToWords(int num) {
        StringBuilder builder = new StringBuilder();
        numberToWords(builder, num);
        return builder.toString().trim();
    }

    public static void main(String ... args) {
//        System.out.println(new IntegerToEnglishWords().numberToWords(Integer.MAX_VALUE));
        System.out.println(new IntegerToEnglishWords().numberToWords(29));
//        System.out.println(Integer.MAX_VALUE);
    }

}
