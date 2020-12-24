package sample.models;
import java.security.SecureRandom;
import java.util.UUID;

public  class UuidGenerator {

        public static String getUniqueId() {
            UUID idOne = UUID.randomUUID();
            UUID idTwo = UUID.randomUUID();
            UUID idThree = UUID.randomUUID();
            UUID idFour = UUID.randomUUID();

            String time = idOne.toString().replace("-", "");
            String time2 = idTwo.toString().replace("-", "");
            String time3 = idThree.toString().replace("-", "");
            String time4 = idFour.toString().replace("-", "");

            StringBuilder newData = new StringBuilder();
            newData.append(time);
            newData.append(time2);
            newData.append(time3);
            newData.append(time4);

            SecureRandom random = new SecureRandom();
            int beginIndex = random.nextInt(100);  //Begin index + length of your string < data length
            int endIndex = beginIndex + 10;     //Length of string which you want

            return newData.substring(beginIndex, endIndex);
        }

    }
