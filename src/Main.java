import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Random;
import java.util.UUID;

public class Main {
    public static void main(String[] args) {

//        UUID uniqueID = UUID.randomUUID();
//        System.out.println("생성된 UUID : " + uniqueID.toString());

        // 확률이 낮지만 중복제거까지 하면 정말 고유한 식별자겠지?
        // ++ 전부 사용 X 16비트 + 16진수 + 날짜 카운터 (20230605)

        // 생성할 고유 값의 개수
        int numValues = 1;
        // 중복을 제거한 고유 값 저장
        HashSet<String> uniqueValues = new HashSet<>();
        String user1 = "Pinni";
        String user2 = "Oscar";

        // 이름을 덧붙히면 중복될 일이 없지 않을까?

        while (uniqueValues.size() < numValues) {
            // 16비트 랜덤 정수 생성
            int randomInt = new Random().nextInt(65536);
            // 정수를 16진수 문자열로 변환
            String hexString = String.format("%04X", randomInt);

            // 오늘 날짜 가져오기
            LocalDate today = LocalDate.now();
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd");
            String dateString = today.format(formatter);

            // 최종 고유 값 생성
            String uniqueValue = hexString + dateString + user1 + user2;

            // 생성된 고유 값을 HashSet에 추가 (중복 제거)
            uniqueValues.add(uniqueValue);
        } // while END

        // 생성된 고유 값 출력
        for (String value : uniqueValues) {
            System.out.println("생성된 고유 값 : " + value);
        } // for END
    } // Main Method END
} // MAIN CLASS END