package newCar.event_page.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import newCar.event_page.model.dto.EventTimeDTO;
import newCar.event_page.model.dto.PersonalityTestDTO;
import newCar.event_page.model.dto.UserQuizDTO;
import newCar.event_page.model.entity.event.EventId;
import newCar.event_page.service.EventService;
import newCar.event_page.service.QuizService;
import newCar.event_page.service.RacingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/main")
@Tag(name = "Main API", description = "Main 이벤트 페이지 API 설계입니다")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class MainController {

    private final EventService eventService;
    private final QuizService quizService;
    private final RacingService racingService;

    @GetMapping("/event-time")
    @Operation(summary = "이벤트 진행 기간을 startTime, endTime 으로 반환한다")
    public ResponseEntity<EventTimeDTO> getEventTime(){
        return ResponseEntity.ok(eventService.getEventTime());
    }

    @GetMapping("/personality-test-list")
    @Operation(summary = "레이싱 게임 유형검사")
    public ResponseEntity<List<PersonalityTestDTO>> getPersonalities() {
        return ResponseEntity.ok(racingService.getPersonalityTestList());
    }

    @GetMapping("/quiz")
    @Operation(summary = "해당하는 날짜에 맞는 선착순 퀴즈 정보를 Get 한다")
    public ResponseEntity<UserQuizDTO> getQuiz(){
        return ResponseEntity.ok(quizService.getQuiz(EventId.Quiz.getValue()));
    }
}
