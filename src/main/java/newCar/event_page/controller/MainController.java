package newCar.event_page.controller;

import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import newCar.event_page.model.dto.EventTimeDTO;
import newCar.event_page.service.EventService;
import newCar.event_page.service.QuizService;
import newCar.event_page.service.RacingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/main")
@RequiredArgsConstructor
public class MainController {

    private final EventService eventService;
    private final QuizService quizService;
    private final RacingService racingService;

    @GetMapping("/event-time")
    @Operation(summary = "이벤트 진행 기간 카운터")
    public ResponseEntity<EventTimeDTO> getEventTime(){
        return ResponseEntity.ok(eventService.getEventTime());
    }

}
