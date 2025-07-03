package codingTest.src.defaultQuestions;

public class FindNotRepeatingFirstCharacter {
    public static void main(String[] args) {
        System.out.println(findNotRepeatingFirstCharacter("abadabac"));
        System.out.println(findNotRepeatingFirstCharacter("aabbcddd"));
        System.out.println(findNotRepeatingFirstCharacter("aaaaaaaa"));
    }

    public static char findNotRepeatingFirstCharacter(String n) {
        CharInfo[] checkCharArr = new CharInfo[36];
        for (int i = 0; i < 36; i++) {
            checkCharArr[i] = new CharInfo();
        }
        char result = '_';
        int placeNum = 0;
        char[] charArray = n.toCharArray();
        for (char x : charArray) {
            placeNum++;
            if (checkCharArr[x - 'a'].hasRepeated) { // 이미 이전에 출연한 적이 있음
                continue;
            } else if (checkCharArr[x - 'a'].firstPlace != -100) { // 이미 이전에 출연한 적이 있음
                checkCharArr[x - 'a'].hasRepeated = true;
                continue;
            } else {
                checkCharArr[x - 'a'].firstPlace = placeNum;
            }
        }

        int minPlaceNum = 100;
        for (int i = 0; i < 36; i++) {
            CharInfo charInfo = checkCharArr[i];
            if (charInfo.firstPlace != -100 && !charInfo.hasRepeated) {
                if(charInfo.firstPlace<minPlaceNum){
                    minPlaceNum=charInfo.firstPlace;
                    result = (char)(i+'a');
                }
            }
        }

        return result;
    }
}

class CharInfo {
    int firstPlace = -100;
    boolean hasRepeated = false;
}
